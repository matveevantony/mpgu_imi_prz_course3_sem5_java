import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class pract_03_02 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame loginFrame = new JFrame("Вход ВКонтакте");
        loginFrame.setSize(400, 500);
        loginFrame.setLayout(null);

        // Добавление кнопки с логотипом
        JButton logoButton = new JButton();
        logoButton.setBounds(168, 20, 64, 64);
        logoButton.setIcon(new ImageIcon("vk_logo.png"));
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        loginFrame.add(logoButton);

        // Добавление надписи "Вход ВКонтакте" на фрейм
        JLabel titleLoginLabel = new JLabel("Вход ВКонтакте");
        titleLoginLabel.setBounds(10, 90, 380, 25);
        titleLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLoginLabel.setFont(new Font("Arial", Font.BOLD, 18));
        loginFrame.add(titleLoginLabel);

        // Добавление текстового поля для ввода логина
        JTextField loginTextField = new JTextField("Телефон или почта");
        loginTextField.setBounds(10, 125, 380, 35);
        Color greenTextFieldColor = new Color(119, 212, 151);
        Color redTextFieldColor = new Color(255, 102, 102);
        loginTextField.setBackground(Color.lightGray);
        loginFrame.add(loginTextField);

        // Добавление кнопки "Войти"
        JButton loginButton = new JButton("Войти");
        loginButton.setBounds(10, 170, 380, 35);
        Color vkBlueColor = new Color(39, 135, 245);
        Color blueButtonColor = new Color(182, 225, 252); 
        loginButton.setBackground(vkBlueColor);
        loginButton.setForeground(Color.WHITE);
        loginButton.setBorderPainted(false);
        loginFrame.add(loginButton);

        // Добавление надписи "или" на фрейм
        JLabel orLabel = new JLabel("Или");
        orLabel.setBounds(10, 215, 380, 25);
        orLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orLabel.setForeground(Color.GRAY);
        loginFrame.add(orLabel);

        // Добавление кнопки "QR-код"
        JButton qrButton = new JButton("QR-код");
        qrButton.setBounds(10, 250, 380, 35);
        qrButton.setIcon(new ImageIcon("qrcode_icon.png"));
        qrButton.setBackground(Color.WHITE);
        loginFrame.add(qrButton);

        // Добавление кнопки "Зарегистрироваться"
        JButton regButton = new JButton("Зарегистрироваться");
        regButton.setBounds(10, 350, 380, 35);
        Color vkGreenColor = new Color(75, 179, 75);
        regButton.setBackground(vkGreenColor);
        regButton.setForeground(Color.WHITE);
        regButton.setBorderPainted(false);
        loginFrame.add(regButton);

        // Добавление информационной надписи
        JLabel infoLabel = new JLabel("<html><p align = center>После регистрации вы получите доступ<br>ко всем возможностям VK ID</p></html>");
        infoLabel.setBounds(10, 390, 380, 50);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        infoLabel.setForeground(Color.GRAY);
        loginFrame.add(infoLabel);

        // Добавление надписи "Узнать больше"
        JLabel moreInfoLabel = new JLabel("Узнать больше");
        moreInfoLabel.setBounds(10, 432, 380, 25);
        moreInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        moreInfoLabel.setForeground(Color.BLUE);
        loginFrame.add(moreInfoLabel);
        
        // Обработчик события нажатия на кнопку "Войти"
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (loginTextField.getText().length() != 0) {
                    loginButton.setEnabled(false);
                    loginButton.setBackground(blueButtonColor);
                    loginTextField.setBackground(greenTextFieldColor);
                }
                else {
                    loginTextField.setBackground(redTextFieldColor);
                }
            }
        });

        // Вывод фрейма на экран
        loginFrame.setVisible(true);
    }
}