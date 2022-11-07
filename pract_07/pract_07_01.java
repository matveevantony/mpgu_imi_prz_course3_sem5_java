import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class pract_07_01 {
    public static void main(String[] args) {
        // Основной цвет темы
        Color themeBlueColor = new Color(31, 149, 242);

        // Создание главного фрейма
        JFrame mainFrame = new JFrame("Мой умный город");
        mainFrame.setSize(360, 640);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Кнопка меню
        JButton menuBtn = new JButton();
        menuBtn.setBounds(0, 0, 40, 40);
        menuBtn.setIcon(new ImageIcon("menu_icon.png"));
        menuBtn.setContentAreaFilled(false);
        menuBtn.setBorderPainted(false);
        mainFrame.add(menuBtn);

        // Кнопка информации
        JButton infoBtn = new JButton();
        infoBtn.setBounds(320, 0, 40, 40);
        infoBtn.setIcon(new ImageIcon("info_icon.png"));
        infoBtn.setContentAreaFilled(false);
        infoBtn.setBorderPainted(false);
        mainFrame.add(infoBtn);

        // Заголовок главного фрейма
        JLabel mainLbl = new JLabel("МОЙ УМНЫЙ ГОРОД");
        mainLbl.setBounds(0, 0, 360, 40);
        mainLbl.setBackground(themeBlueColor);
        mainLbl.setForeground(Color.WHITE);
        mainLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainLbl.setOpaque(true);
        mainFrame.add(mainLbl);

        // Номер карты
        JLabel cardNumLbl = new JLabel("Номер карты: 0014 982 457");
        cardNumLbl.setBounds(0, 50, 360, 30);
        cardNumLbl.setForeground(Color.GRAY);
        cardNumLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(cardNumLbl);

        // Информационные сообщения
        JLabel cngCardLbl = new JLabel("<html><center>Для чтения другой карты<br>приложите её к задней крышке телефона</center></html>");
        cngCardLbl.setBounds(0, 80, 360, 50);
        cngCardLbl.setForeground(Color.GRAY);
        cngCardLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(cngCardLbl);
        JLabel buyLbl = new JLabel("<html><center>или нажмите КУПИТЬ для покупки<br>и записи билета на данную<br>транспортную карту</center></html>");
        buyLbl.setBounds(0, 480, 360, 50);
        buyLbl.setForeground(Color.GRAY);
        buyLbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(buyLbl);

        // Отображение текущей карты
        JLabel balanceLbl = new JLabel("<html><div align=right>Остаток:<br>100.00 ₽</div></html>");
        balanceLbl.setFont(new Font("Arial", Font.PLAIN, 18));
        balanceLbl.setHorizontalAlignment(SwingConstants.RIGHT);
        balanceLbl.setForeground(Color.WHITE);
        balanceLbl.setBounds(85, 310, 190, 50);
        mainFrame.add(balanceLbl);
        JButton currentCardIcon = new JButton();
        currentCardIcon.setBounds(20, 140, 320, 320);
        currentCardIcon.setIcon(new ImageIcon("balance.png"));
        currentCardIcon.setContentAreaFilled(false);
        currentCardIcon.setBorderPainted(false);
        mainFrame.add(currentCardIcon);

        // Кнопка пополнения карты
        JButton buyBtn = new JButton();
        buyBtn.setBounds(310, 560, 50, 50);
        buyBtn.setIcon(new ImageIcon("buy_icon.png"));
        buyBtn.setContentAreaFilled(false);
        buyBtn.setBorderPainted(false);
        mainFrame.add(buyBtn);

        // Создание фрейма экрана пополнения
        JFrame buyFrame = new JFrame("Покупка билета");
        buyFrame.setSize(360, 640);
        buyFrame.setLayout(null);
        buyFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Кнопка возвращения на главный фрейм
        JButton returnBtn = new JButton();
        returnBtn.setBounds(0, 0, 40, 40);
        returnBtn.setIcon(new ImageIcon("return_icon.png"));
        returnBtn.setContentAreaFilled(false);
        returnBtn.setBorderPainted(false);
        buyFrame.add(returnBtn);

        // Кнопка информации фрейма экрана пополнения
        JButton buyInfoBtn = new JButton();
        buyInfoBtn.setBounds(320, 0, 40, 40);
        buyInfoBtn.setIcon(new ImageIcon("info_icon.png"));
        buyInfoBtn.setContentAreaFilled(false);
        buyInfoBtn.setBorderPainted(false);
        buyFrame.add(buyInfoBtn);

        // Заголовок фрейма экрана заполнения
        JLabel buyMainLbl = new JLabel("ПОКУПКА БИЛЕТА");
        buyMainLbl.setBounds(0, 0, 360, 40);
        buyMainLbl.setBackground(themeBlueColor);
        buyMainLbl.setForeground(Color.WHITE);
        buyMainLbl.setHorizontalAlignment(SwingConstants.CENTER);
        buyMainLbl.setOpaque(true);
        buyFrame.add(buyMainLbl);

        // Информационные сообщения экрана пополнения
        JLabel chooseLbl = new JLabel("Выберите тип билета");
        chooseLbl.setBounds(0, 50, 360, 50);
        chooseLbl.setForeground(Color.GRAY);
        chooseLbl.setHorizontalAlignment(SwingConstants.CENTER);
        buyFrame.add(chooseLbl);

        // Отображение выбранного типа билета
        JButton typeIcon = new JButton();
        typeIcon.setBounds(20, 140, 320, 320);
        typeIcon.setIcon(new ImageIcon("type1_icon.png"));
        typeIcon.setContentAreaFilled(false);
        typeIcon.setBorderPainted(false);
        buyFrame.add(typeIcon);

        // Кнопка переключения билетов
        JButton type1Btn = new JButton();
        type1Btn.setBounds(155, 480, 10, 10);
        type1Btn.setIcon(new ImageIcon("selecteddot.png"));
        type1Btn.setContentAreaFilled(false);
        type1Btn.setBorderPainted(false);
        buyFrame.add(type1Btn);
        JButton type2Btn = new JButton();
        type2Btn.setBounds(175, 480, 10, 10);
        type2Btn.setIcon(new ImageIcon("unselecteddot.png"));
        type2Btn.setContentAreaFilled(false);
        type2Btn.setBorderPainted(false);
        buyFrame.add(type2Btn);
        JButton type3Btn = new JButton();
        type3Btn.setBounds(195, 480, 10, 10);
        type3Btn.setIcon(new ImageIcon("unselecteddot.png"));
        type3Btn.setContentAreaFilled(false);
        type3Btn.setBorderPainted(false);
        buyFrame.add(type3Btn);

        // Кнопка продолжения
        JButton nextBtn = new JButton();
        nextBtn.setBounds(310, 560, 50, 50);
        nextBtn.setIcon(new ImageIcon("next_icon.png"));
        nextBtn.setContentAreaFilled(false);
        nextBtn.setBorderPainted(false);
        buyFrame.add(nextBtn);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Обработчик нажания кнопки пополнения карты
        buyBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                buyFrame.setVisible(true);
            }
        });

        // Обработчик нажания кнопки возвращения на главный фрейм
        returnBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                buyFrame.setVisible(false);
                mainFrame.setVisible(true);
            }
        });

        // Обработчики нажания кнопок выбора типа билета
        type1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeIcon.setIcon(new ImageIcon("type1_icon.png"));
                type1Btn.setIcon(new ImageIcon("selecteddot.png"));
                type2Btn.setIcon(new ImageIcon("unselecteddot.png"));
                type3Btn.setIcon(new ImageIcon("unselecteddot.png"));
            }
        });
        type2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeIcon.setIcon(new ImageIcon("type2_icon.png"));
                type1Btn.setIcon(new ImageIcon("unselecteddot.png"));
                type2Btn.setIcon(new ImageIcon("selecteddot.png"));
                type3Btn.setIcon(new ImageIcon("unselecteddot.png"));
            }
        });
        type3Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                typeIcon.setIcon(new ImageIcon("type3_icon.png"));
                type1Btn.setIcon(new ImageIcon("unselecteddot.png"));
                type2Btn.setIcon(new ImageIcon("unselecteddot.png"));
                type3Btn.setIcon(new ImageIcon("selecteddot.png"));
            }
        });
    }
}
