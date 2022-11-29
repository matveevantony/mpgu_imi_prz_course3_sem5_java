import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class control_02_01 {
    private static double exch = 61.07;

    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Калькулятор валют");
        mainFrame.setSize(630, 380);
        mainFrame.setLayout(null);
        mainFrame.getContentPane().setBackground(Color.WHITE);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Текстовые поля
        JTextField usdTxtFld = new JTextField();
        usdTxtFld.setBounds(10, 10, 195, 50);
        usdTxtFld.setFont(new Font("Arial", Font.PLAIN, 18));
        usdTxtFld.setHorizontalAlignment(SwingConstants.RIGHT);
        usdTxtFld.setBackground(Color.WHITE);
        mainFrame.add(usdTxtFld);
        JTextField rubTxtFld = new JTextField();
        rubTxtFld.setBounds(335, 10, 195, 50);
        rubTxtFld.setFont(new Font("Arial", Font.PLAIN, 18));
        rubTxtFld.setHorizontalAlignment(SwingConstants.RIGHT);
        rubTxtFld.setBackground(Color.WHITE);
        mainFrame.add(rubTxtFld);

        // Изображения валют
        JButton usdBtn = new JButton("USD");
        usdBtn.setBounds(205, 10, 90, 49);
        usdBtn.setIcon(new ImageIcon("flag_usa.png"));
        usdBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        usdBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        usdBtn.setBackground(Color.WHITE);
        mainFrame.add(usdBtn);
        JButton rubBtn = new JButton("RUB");
        rubBtn.setBounds(530, 10, 90, 49);
        rubBtn.setIcon(new ImageIcon("flag_rus.png"));
        rubBtn.setVerticalTextPosition(AbstractButton.BOTTOM);
        rubBtn.setHorizontalTextPosition(AbstractButton.CENTER);
        rubBtn.setBackground(Color.WHITE);
        mainFrame.add(rubBtn);

        // Кнопка обмена значениями
        JButton switchBtn = new JButton();
        switchBtn.setBounds(295, 15, 40, 40);
        switchBtn.setIcon(new ImageIcon("switch.png"));
        switchBtn.setDisabledIcon(new ImageIcon("switch.png"));
        switchBtn.setBorderPainted(false);
        switchBtn.setContentAreaFilled(false);
        switchBtn.setEnabled(false);
        mainFrame.add(switchBtn);

        // Надписи
        JLabel exchLbl = new JLabel("1 Доллар США = " + Double.toString(exch) + " Российского рубля");
        exchLbl.setBounds(10, 65, 400, 30);
        exchLbl.setFont(new Font("Arial", Font.PLAIN, 14));
        mainFrame.add(exchLbl);
        String datePtrn = "dd.MM.yyyy";
        DateFormat dateFrmt = new SimpleDateFormat(datePtrn);
        Date date = new Date();
        JLabel dateLbl = new JLabel("ЦБ РФ • " + dateFrmt.format(date));
        dateLbl.setBounds(10, 95, 400, 20);
        dateLbl.setFont(new Font("Arial", Font.PLAIN, 11));
        dateLbl.setForeground(Color.GRAY);
        mainFrame.add(dateLbl);

        // Кнопки переключения графиков
        JButton monthBtn = new JButton("Месяц");
        monthBtn.setBounds(10, 130, 80, 30);
        monthBtn.setBorderPainted(false);
        monthBtn.setContentAreaFilled(false);
        monthBtn.setForeground(Color.BLACK);
        mainFrame.add(monthBtn);
        JButton yearBtn = new JButton("Год");
        yearBtn.setBounds(90, 130, 60, 30);
        yearBtn.setBorderPainted(false);
        yearBtn.setContentAreaFilled(false);
        yearBtn.setForeground(Color.GRAY);
        mainFrame.add(yearBtn);
        JButton alltimeBtn = new JButton("Всё время");
        alltimeBtn.setBounds(150, 130, 100, 30);
        alltimeBtn.setBorderPainted(false);
        alltimeBtn.setContentAreaFilled(false);
        alltimeBtn.setForeground(Color.GRAY);
        mainFrame.add(alltimeBtn);

        // Изображение графика курса
        JButton graphBtn = new JButton();
        graphBtn.setBounds(9, 165, 611, 176);
        graphBtn.setIcon(new ImageIcon("graphic_month.png"));
        graphBtn.setBorderPainted(false);
        graphBtn.setContentAreaFilled(false);
        mainFrame.add(graphBtn);

        // Дополнительные цвета
        Color emptyInputColor = new Color(255, 102, 102);
        Color okColor = new Color(168, 255, 210);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Обработчики нажатия на клавиши Enter и Backspace
        usdTxtFld.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String usdStr = usdTxtFld.getText();
                    if (usdStr.length() > 0) {
                        usdTxtFld.setBackground(okColor);
                        rubTxtFld.setText(Double.toString(Double.parseDouble(usdStr) * exch));
                    }
                    else {
                        usdTxtFld.setBackground(emptyInputColor);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    usdTxtFld.setText("");
                    rubTxtFld.setText("");
                    usdTxtFld.setBackground(Color.WHITE);
                    rubTxtFld.setBackground(Color.WHITE);
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
        rubTxtFld.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String rubStr = rubTxtFld.getText();
                    if (rubStr.length() > 0) {
                        rubTxtFld.setBackground(okColor);
                        usdTxtFld.setText(Double.toString(Double.parseDouble(rubStr) / exch));
                    }
                    else {
                        rubTxtFld.setBackground(emptyInputColor);
                    }
                }
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    usdTxtFld.setText("");
                    rubTxtFld.setText("");
                    usdTxtFld.setBackground(Color.WHITE);
                    rubTxtFld.setBackground(Color.WHITE);
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });

        // Обработчики нажатия на кнопки смены графиков
        monthBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monthBtn.setForeground(Color.BLACK);
                yearBtn.setForeground(Color.GRAY);
                alltimeBtn.setForeground(Color.GRAY);
                graphBtn.setIcon(new ImageIcon("graphic_month.png"));
            }
        });
        yearBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                yearBtn.setForeground(Color.BLACK);
                monthBtn.setForeground(Color.GRAY);
                alltimeBtn.setForeground(Color.GRAY);
                graphBtn.setIcon(new ImageIcon("graphic_year.png"));
            }
        });
        alltimeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                alltimeBtn.setForeground(Color.BLACK);
                monthBtn.setForeground(Color.GRAY);
                yearBtn.setForeground(Color.GRAY);
                graphBtn.setIcon(new ImageIcon("graphic_alltime.png"));
            }
        });
    }
}
