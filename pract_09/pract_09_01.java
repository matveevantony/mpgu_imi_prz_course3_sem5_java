import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class pract_09_01 {
    private static String[] listLst = {"сыр", "сок", "хлеб", "мак", "чай", "суп"};

    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Элементы интерфейса");
        mainFrame.setSize(360, 590);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Заголовок фрейма
        JLabel titleLbl = new JLabel("Элементы интерфейса");
        titleLbl.setBounds(20, 15, 320, 30);
        titleLbl.setHorizontalAlignment(SwingConstants.CENTER);
        titleLbl.setFont(new Font("Arial", Font.PLAIN, 18));
        mainFrame.add(titleLbl);

        // Выпадающий список JComboBox и надпись JLabel, демонстрирующая его работу
        JLabel titleCBoxLbl = new JLabel("Выпадающий список");
        titleCBoxLbl.setBounds(20, 60, 320,20);
        titleCBoxLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(titleCBoxLbl);
        String[] listCBox = {"Элемент 1", "Элемент 2", "Элемент 3", "Элемент 4", "Элемент 5"};
        JComboBox<String> cBox = new JComboBox<String>(listCBox);
        cBox.setBounds(20, 80, 320, 25);
        mainFrame.add(cBox);
        JLabel cBoxLbl = new JLabel("Выбранный элемент: " + '"' + cBox.getSelectedItem() + '"');
        cBoxLbl.setBounds(20, 105, 320, 20);
        mainFrame.add(cBoxLbl);

        // Группа радио-кнопок JRadioButton и надпись JLabel, демонстрирующая их работу
        JLabel titleRBtnLbl = new JLabel("Радио-кнопки");
        titleRBtnLbl.setBounds(20, 140, 320, 20);
        titleRBtnLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(titleRBtnLbl);
        JRadioButton rBtn1 = new JRadioButton("красный");
        JRadioButton rBtn2 = new JRadioButton("зелёный");
        JRadioButton rBtn3 = new JRadioButton("синий");
        ButtonGroup clrChsrBtnGrp = new ButtonGroup();
        clrChsrBtnGrp.add(rBtn1);
        clrChsrBtnGrp.add(rBtn2);
        clrChsrBtnGrp.add(rBtn3);
        rBtn1.setSelected(true);
        rBtn1.setBounds(20, 160, 320, 20);
        rBtn2.setBounds(20, 180, 320, 20);
        rBtn3.setBounds(20, 200, 320, 20);
        mainFrame.add(rBtn1);
        mainFrame.add(rBtn2);
        mainFrame.add(rBtn3);
        JLabel rBtnLbl = new JLabel("Надпись выбранного цвета");
        rBtnLbl.setForeground(Color.RED);
        rBtnLbl.setBounds(20, 220, 320, 20);
        mainFrame.add(rBtnLbl);

        // Список JList и надпись JLabel, демонстрирующая его работу
        JLabel titleLstLbl = new JLabel("Список");
        titleLstLbl.setBounds(20, 260, 320, 20);
        titleLstLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(titleLstLbl);
        JList<String> lst = new JList<String>(listLst);
        lst.setBounds(20, 280, 320, 50);
        lst.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        lst.setVisibleRowCount(3);
        mainFrame.add(lst);
        JLabel lstLbl = new JLabel("Список продуктов пока что пуст");
        lstLbl.setBounds(20, 330, 320, 20);
        mainFrame.add(lstLbl);

        // Галочки JCheckBox и надпись JLabel, демонстрирующая их работу
        JLabel titleChckBoxLbl = new JLabel("Галочки");
        titleChckBoxLbl.setBounds(20, 365, 320, 20);
        titleChckBoxLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(titleChckBoxLbl);
        JCheckBox chckBox1 = new JCheckBox("полужирный");
        JCheckBox chckBox2 = new JCheckBox("курсив");
        chckBox1.setBounds(20, 385, 320, 20);
        chckBox2.setBounds(20, 405, 320, 20);
        mainFrame.add(chckBox1);
        mainFrame.add(chckBox2);
        JLabel chckBoxLbl = new JLabel("Текст с выбранным оформлением");
        chckBoxLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        chckBoxLbl.setBounds(20, 425, 320, 20);
        mainFrame.add(chckBoxLbl);

        // Текстовое поле JTextField и надпись JLabel, демонстрирующая его работу
        JLabel titleTxtFieldLbl = new JLabel("Текстовое поле");
        titleTxtFieldLbl.setBounds(20, 465, 320, 20);
        titleTxtFieldLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(titleTxtFieldLbl);
        JTextField txtField = new JTextField();
        txtField.setBounds(20, 485, 320, 25);
        mainFrame.add(txtField);
        JLabel preTxtFieldLbl = new JLabel("Сообщение пусто");
        preTxtFieldLbl.setBounds(20, 510, 320, 20);
        mainFrame.add(preTxtFieldLbl);
        JLabel txtFieldLbl = new JLabel();
        txtFieldLbl.setBounds(20, 530, 320, 20);
        mainFrame.add(txtFieldLbl);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Обработчик выбора значения выпадающего списка
        cBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cBoxLbl.setText("Выбранный элемент: " + '"' + cBox.getSelectedItem() + '"');
            }
        });

        // Обработчики выбора значения группы радио-кнопок
        rBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rBtnLbl.setForeground(Color.RED);
            }
        });
        rBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rBtnLbl.setForeground(Color.GREEN);
            }
        });
        rBtn3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rBtnLbl.setForeground(Color.BLUE);
            }
        });

        // Обработчик выбора значений из списка
        lst.addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (lst.isSelectionEmpty()) {
                    lstLbl.setText("Список продуктов пока что пуст");
                }
                else {
                    String lstLblStr = "Список продуктов: ";
                    int[] selectedElementsLst = lst.getSelectedIndices();
                    for (int i = 0; i < selectedElementsLst.length - 1; i++) {
                        lstLblStr += (listLst[selectedElementsLst[i]] + ", ");
                    }
                    lstLblStr += (listLst[selectedElementsLst[selectedElementsLst.length - 1]] + ".");
                    lstLbl.setText(lstLblStr);
                }
            }
        });

        // Обработчик выбора значений галочек
        chckBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chckBox1.isSelected()) {
                    if (chckBox2.isSelected()) {
                        chckBoxLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
                    }
                    else {
                        chckBoxLbl.setFont(new Font("Arial", Font.BOLD, 12));
                    }
                }
                else {
                    if (chckBox2.isSelected()) {
                        chckBoxLbl.setFont(new Font("Arial", Font.ITALIC, 12));
                    }
                    else {
                        chckBoxLbl.setFont(new Font("Arial", Font.PLAIN, 12));
                    }
                }
            }
        });
        chckBox2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (chckBox2.isSelected()) {
                    if (chckBox1.isSelected()) {
                        chckBoxLbl.setFont(new Font("Arial", Font.BOLD | Font.ITALIC, 12));
                    }
                    else {
                        chckBoxLbl.setFont(new Font("Arial", Font.ITALIC, 12));
                    }
                }
                else {
                    if (chckBox1.isSelected()) {
                        chckBoxLbl.setFont(new Font("Arial", Font.BOLD, 12));
                    }
                    else {
                        chckBoxLbl.setFont(new Font("Arial", Font.PLAIN, 12));
                    }
                }
            }
        });

        // Обработчик нажатия клавиши Enter в текстовом поле
        txtField.addKeyListener(new KeyListener() {
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    txtFieldLbl.setText(txtField.getText());
                    if (txtField.getText().length() > 0) {
                        preTxtFieldLbl.setText("Введённое сообщение:");
                    }
                    else {
                        preTxtFieldLbl.setText("Сообщение пусто");
                    }
                }
            }
            public void keyReleased(KeyEvent e) {}
            public void keyTyped(KeyEvent e) {}
        });
    }
}
