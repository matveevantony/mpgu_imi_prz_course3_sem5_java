import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;

public class pract_09_02 {
    private static int[] discounts = {5, 10, 15, 20, 25, 30, 35, 40, 45, 50};

    private static double calcSum(double price, int count, double discount) {
        return (price * count * (1 - discount));
    }

    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Калькулятор заказа");
        mainFrame.setSize(300, 450);
        mainFrame.setLayout(null);
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Выбор товара (выпадающий список)
        JLabel goodChsLbl = new JLabel("Товар");
        goodChsLbl.setBounds(10, 10, 280, 20);
        mainFrame.add(goodChsLbl);
        String[] goodsLstStr = {"Кроссовки", "Куртка", "Джинсы", "Футболка", "Худи"};
        JComboBox<String> goodsLst = new JComboBox<String>(goodsLstStr);
        goodsLst.setBackground(Color.WHITE);
        goodsLst.setBounds(10, 30, 280, 20);
        mainFrame.add(goodsLst);

        // Указание цены (текстовое поле)
        JLabel priceLbl = new JLabel("Цена");
        priceLbl.setBounds(10, 55, 280, 20);
        mainFrame.add(priceLbl);
        JTextField priceTxtFld = new JTextField();
        priceTxtFld.setBounds(10, 75, 280, 20);
        mainFrame.add(priceTxtFld);

        // Указание количества товара (текстовое поле)
        JLabel countLbl = new JLabel("Количество");
        countLbl.setBounds(10, 100, 280, 20);
        mainFrame.add(countLbl);
        JTextField countTxtFld = new JTextField();
        countTxtFld.setBounds(10, 120, 280, 20);
        mainFrame.add(countTxtFld);

        // Радио-кнопки указания наличия/отсутствия скидки
        JLabel discLbl = new JLabel("Наличие скидки");
        discLbl.setBounds(10, 145, 280, 20);
        mainFrame.add(discLbl);
        JRadioButton discRBtn1 = new JRadioButton("есть");
        JRadioButton discRBtn2 = new JRadioButton("нет");
        discRBtn1.setBounds(10, 165, 280, 20);
        discRBtn1.setBackground(Color.WHITE);
        discRBtn2.setBounds(10, 185, 280, 20);
        discRBtn2.setBackground(Color.WHITE);
        ButtonGroup discBtn = new ButtonGroup();
        discBtn.add(discRBtn1);
        discBtn.add(discRBtn2);
        mainFrame.add(discRBtn1);
        mainFrame.add(discRBtn2);

        // Указание размера скидки
        JLabel discSizeLbl = new JLabel("Размер скидки");
        discSizeLbl.setBounds(10, 210, 280, 20);
        discSizeLbl.setVisible(false);
        mainFrame.add(discSizeLbl);
        String[] discSizeLstStr = new String[discounts.length];
        for (int i = 0; i < discounts.length; i++) {
            discSizeLstStr[i] = Integer.toString(discounts[i]) + "%";
        }
        JComboBox<String> discSizeLst = new JComboBox<String>(discSizeLstStr);
        discSizeLst.setBackground(Color.WHITE);
        discSizeLst.setBounds(10, 230, 280, 20);
        discSizeLst.setVisible(false);
        mainFrame.add(discSizeLst);

        // Кнопка "Рассчитать"
        JButton calcBtn = new JButton("Рассчитать");
        calcBtn.setBounds(10, 290, 280, 30);
        calcBtn.setToolTipText("Рассчитать итоговую сумму, исходя из введённых выше данных");
        mainFrame.add(calcBtn);

        // Текстовое поле для вывода итоговой суммы заказа
        JLabel sumLbl = new JLabel("Итоговая сумма заказа");
        sumLbl.setBounds(10, 360, 280, 20);
        sumLbl.setVisible(false);
        mainFrame.add(sumLbl);
        JTextField sumTxtFld = new JTextField();
        sumTxtFld.setEditable(false);
        sumTxtFld.setBackground(Color.WHITE);
        sumTxtFld.setBounds(10, 380, 280, 20);
        sumTxtFld.setVisible(false);
        mainFrame.add(sumTxtFld);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Обработчик нажатия на радио-кнопки наличия скидки
        discRBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discSizeLbl.setVisible(true);
                discSizeLst.setVisible(true);
            }
        });
        discRBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                discSizeLbl.setVisible(false);
                discSizeLst.setVisible(false);
            }
        });

        // Цвет выделения пустого текстового поля
        Color emptyInputColor = new Color(255, 102, 102);

        // Обработчик нажатия на кнопку "Рассчитать"
        calcBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String priceStr = priceTxtFld.getText();
                String countStr = countTxtFld.getText();
                if (priceStr.length() == 0) {
                    priceLbl.setForeground(Color.RED);
                    priceTxtFld.setBackground(emptyInputColor);
                }
                else {
                    priceLbl.setForeground(Color.DARK_GRAY);
                    priceTxtFld.setBackground(Color.WHITE);
                }
                if (countStr.length() == 0) {
                    countLbl.setForeground(Color.RED);
                    countTxtFld.setBackground(emptyInputColor);
                }
                else {
                    countLbl.setForeground(Color.DARK_GRAY);
                    countTxtFld.setBackground(Color.WHITE);
                }
                if (priceStr.length() != 0 && countStr.length() != 0) {
                    double price = Double.parseDouble(priceStr);
                    int count = Integer.parseInt(countStr);
                    double discount = 0;
                    if (discRBtn1.isSelected()) {
                        discount = discounts[discSizeLst.getSelectedIndex()] / 100.0;
                    }
                    sumTxtFld.setText(Double.toString(calcSum(price, count, discount)));
                    sumLbl.setVisible(true);
                    sumTxtFld.setVisible(true);
                }
            }
        });
    }
}
