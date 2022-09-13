import javax.swing.*;

public class pract_01_01 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame loginFrame = new JFrame("Вход ВКонтакте");
        loginFrame.setSize(400, 320);
        loginFrame.setLayout(null);

        // Добавление надписи "Вход ВКонтакте" на фрейм
        JLabel titleLoginLabel = new JLabel("Вход ВКонтакте");
        titleLoginLabel.setBounds(10, 10, 380, 25);
        titleLoginLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginFrame.add(titleLoginLabel);

        // Добавление текстового поля для ввода логина
        JTextField loginTextField = new JTextField("Телефон или почта");
        loginTextField.setBounds(10, 40, 380, 25);
        loginFrame.add(loginTextField);

        // Добавление кнопки "Войти"
        JButton loginButton = new JButton("Вход");
        loginButton.setBounds(10, 70, 380, 30);
        loginFrame.add(loginButton);

        // Добавление надписи "или" на фрейм
        JLabel orLabel = new JLabel("Или");
        orLabel.setBounds(10, 100, 380, 25);
        orLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginFrame.add(orLabel);

        // Добавление кнопки "QR-код"
        JButton qrButton = new JButton("QR-код");
        qrButton.setBounds(10, 125, 380, 30);
        loginFrame.add(qrButton);

        // Добавление кнопки "Зарегистрироваться"
        JButton regButton = new JButton("Зарегистрироваться");
        regButton.setBounds(10, 190, 380, 30);
        loginFrame.add(regButton);

        // Добавление информационной надписи
        JLabel infoLabel = new JLabel("<html><p align = center>После регистрации вы получите доступ<br>ко всем возможностям VK ID</p></html>");
        infoLabel.setBounds(10, 220, 380, 50);
        infoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginFrame.add(infoLabel);

        // Добавление надписи "Узнать больше"
        JLabel moreInfoLabel = new JLabel("Узнать больше");
        moreInfoLabel.setBounds(10, 260, 380, 25);
        moreInfoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        loginFrame.add(moreInfoLabel);
        
        // Вывод фрейма на экран
        loginFrame.setVisible(true);
    }
}