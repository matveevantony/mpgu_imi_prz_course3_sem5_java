import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class pract_03_01 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Мессенджер");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(null);
        
        // Текстовое поле первого полученного сообщения
        JLabel firstInputMessenge = new JLabel("Привет!");
        firstInputMessenge.setBounds(10, 10, 200, 40);
        firstInputMessenge.setBackground(Color.WHITE);
        firstInputMessenge.setOpaque(true);
        mainFrame.add(firstInputMessenge);

        // Текстовое поле второго полученного сообщения
        JLabel secondInputMessenge = new JLabel("Как дела?");
        secondInputMessenge.setBounds(10, 60, 200, 40);
        secondInputMessenge.setBackground(Color.WHITE);
        secondInputMessenge.setOpaque(true);
        mainFrame.add(secondInputMessenge);

        // Текстовое поле первого отправленного сообщения
        JLabel firstSentMessenge = new JLabel();
        firstSentMessenge.setBounds(140, 110, 250, 40);
        firstSentMessenge.setBackground(Color.GREEN);
        firstSentMessenge.setOpaque(true);
        firstSentMessenge.setVisible(false);
        mainFrame.add(firstSentMessenge);

        // Текстовое поле второго отправленного сообщения
        JLabel secondSentMessenge = new JLabel();
        secondSentMessenge.setBounds(140, 160, 250, 40);
        secondSentMessenge.setBackground(Color.GREEN);
        secondSentMessenge.setOpaque(true);
        secondSentMessenge.setVisible(false);
        mainFrame.add(secondSentMessenge);

        // Поле для ввода сообщений
        JTextField inputTextField = new JTextField();
        inputTextField.setBounds(10, 210, 250, 40);
        mainFrame.add(inputTextField);

        // Кнопка "Отправить"
        JButton sendButton = new JButton("Отправить");
        sendButton.setBounds(270, 210, 120, 40);
        sendButton.setBackground(Color.GREEN);
        mainFrame.add(sendButton);

        // Обработчик события нажатия на кнопку "Отправить"
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = inputTextField.getText();
                if (inputText.length() != 0) {
                    if (firstSentMessenge.isVisible()) {
                        secondSentMessenge.setText(inputText);
                        secondSentMessenge.setVisible(true);
                        inputTextField.setText("");
                        sendButton.setEnabled(false);
                        sendButton.setBackground(Color.GRAY);
                    }
                    else {
                        firstSentMessenge.setText(inputText);
                        firstSentMessenge.setVisible(true);
                        inputTextField.setText("");
                    }
                }
            }
        });

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}
