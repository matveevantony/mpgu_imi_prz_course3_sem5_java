import javax.swing.*;
import java.awt.Color;
import java.awt.Font;

public class pract_02_02 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Калькулятор");
        mainFrame.setSize(275, 510);
        mainFrame.setLayout(null);
        
        // Добавление кнопки с логотипом
        JButton logoButton = new JButton();
        logoButton.setBounds(10, 10, 48, 48);
        logoButton.setIcon(new ImageIcon("calculator_icon.png"));
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        mainFrame.add(logoButton);
        
        // Добавление надписи "Калькулятор" на фрейм
        JLabel titleLabel = new JLabel("Калькулятор");
        titleLabel.setBounds(65, 22, 200, 25);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainFrame.add(titleLabel);

        // Добавление текстового поля ввода
        JTextField inputTextField = new JTextField();
        inputTextField.setBounds(10, 70, 255, 50);
        mainFrame.add(inputTextField);

        // Добавление кнопок
        int sizeOfButton = 60;                              // размер кнопок
        Color buttonColor = new Color(212, 208, 214);       // основной цвет кнопок
        Color blueButtonColor = new Color(182, 225, 252);   // голубой цвет кнопок
        Color greenButtonColor = new Color(119, 212, 151);  // зелёный цвет кнопок

        JButton acButton = new JButton("AC");
        acButton.setBounds(10, 130, sizeOfButton, sizeOfButton);
        acButton.setBorderPainted(false);
        acButton.setBackground(greenButtonColor);
        mainFrame.add(acButton);

        JButton brButton = new JButton("()");
        brButton.setBounds(75, 130, sizeOfButton, sizeOfButton);
        brButton.setBorderPainted(false);
        brButton.setBackground(blueButtonColor);
        mainFrame.add(brButton);

        JButton procButton = new JButton("%");
        procButton.setBounds(140, 130, sizeOfButton, sizeOfButton);
        procButton.setBorderPainted(false);
        procButton.setBackground(blueButtonColor);
        mainFrame.add(procButton);

        JButton divButton = new JButton("/");
        divButton.setBounds(205, 130, sizeOfButton, sizeOfButton);
        divButton.setBorderPainted(false);
        divButton.setBackground(blueButtonColor);
        mainFrame.add(divButton);
        
        JButton Button7 = new JButton("7");
        Button7.setBounds(10, 200, sizeOfButton, sizeOfButton);
        Button7.setBorderPainted(false);
        Button7.setBackground(buttonColor);
        mainFrame.add(Button7);

        JButton Button8 = new JButton("8");
        Button8.setBounds(75, 200, sizeOfButton, sizeOfButton);
        Button8.setBorderPainted(false);
        Button8.setBackground(buttonColor);
        mainFrame.add(Button8);

        JButton Button9 = new JButton("9");
        Button9.setBounds(140, 200, sizeOfButton, sizeOfButton);
        Button9.setBorderPainted(false);
        Button9.setBackground(buttonColor);
        mainFrame.add(Button9);

        JButton prodButton = new JButton("x");
        prodButton.setBounds(205, 200, sizeOfButton, sizeOfButton);
        prodButton.setBorderPainted(false);
        prodButton.setBackground(blueButtonColor);
        mainFrame.add(prodButton);
        
        JButton Button4 = new JButton("7");
        Button4.setBounds(10, 270, sizeOfButton, sizeOfButton);
        Button4.setBorderPainted(false);
        Button4.setBackground(buttonColor);
        mainFrame.add(Button4);

        JButton Button5 = new JButton("8");
        Button5.setBounds(75, 270, sizeOfButton, sizeOfButton);
        Button5.setBorderPainted(false);
        Button5.setBackground(buttonColor);
        mainFrame.add(Button5);

        JButton Button6 = new JButton("6");
        Button6.setBounds(140, 270, sizeOfButton, sizeOfButton);
        Button6.setBorderPainted(false);
        Button6.setBackground(buttonColor);
        mainFrame.add(Button6);

        JButton difButton = new JButton("-");
        difButton.setBounds(205, 270, sizeOfButton, sizeOfButton);
        difButton.setBorderPainted(false);
        difButton.setBackground(blueButtonColor);
        mainFrame.add(difButton);

        JButton Button1 = new JButton("1");
        Button1.setBounds(10, 340, sizeOfButton, sizeOfButton);
        Button1.setBorderPainted(false);
        Button1.setBackground(buttonColor);
        mainFrame.add(Button1);

        JButton Button2 = new JButton("2");
        Button2.setBounds(75, 340, sizeOfButton, sizeOfButton);
        Button2.setBorderPainted(false);
        Button2.setBackground(buttonColor);
        mainFrame.add(Button2);

        JButton Button3 = new JButton("3");
        Button3.setBounds(140, 340, sizeOfButton, sizeOfButton);
        Button3.setBorderPainted(false);
        Button3.setBackground(buttonColor);
        mainFrame.add(Button3);

        JButton plusButton = new JButton("+");
        plusButton.setBounds(205, 340, sizeOfButton, sizeOfButton);
        plusButton.setBorderPainted(false);
        plusButton.setBackground(blueButtonColor);
        mainFrame.add(plusButton);

        JButton Button0 = new JButton("0");
        Button0.setBounds(10, 410, sizeOfButton, sizeOfButton);
        Button0.setBorderPainted(false);
        Button0.setBackground(buttonColor);
        mainFrame.add(Button0);

        JButton commaButton = new JButton(",");
        commaButton.setBounds(75, 410, sizeOfButton, sizeOfButton);
        commaButton.setBorderPainted(false);
        commaButton.setBackground(buttonColor);
        mainFrame.add(commaButton);

        JButton delButton = new JButton("⌫");
        delButton.setBounds(140, 410, sizeOfButton, sizeOfButton);
        delButton.setBorderPainted(false);
        delButton.setBackground(buttonColor);
        mainFrame.add(delButton);

        JButton eqButton = new JButton("=");
        eqButton.setBounds(205, 410, sizeOfButton, sizeOfButton);
        eqButton.setBorderPainted(false);
        eqButton.setBackground(blueButtonColor);
        mainFrame.add(eqButton);

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}