import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.event.*;
import java.util.Date;

public class pract_05_01 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Отправка электронного письма");
        mainFrame.setSize(850, 600);
        mainFrame.setLayout(new BorderLayout());

        // Создание верхней панели
        JPanel upperPanel = new JPanel();
        upperPanel.setLayout(new BorderLayout());
        mainFrame.add(upperPanel, BorderLayout.NORTH);

        // Создание панели параметров письма
        JPanel paramPanel = new JPanel();
        paramPanel.setLayout(new BorderLayout());
        upperPanel.add(paramPanel, BorderLayout.CENTER);

        // Создание панели подписей к полям ввода параметров письма
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        paramPanel.add(labelPanel, BorderLayout.WEST);

        // Создание панели полей ввода параметров письма
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        paramPanel.add(textFieldPanel, BorderLayout.CENTER);

        // Создание нижней панели
        JPanel lowerPanel = new JPanel();
        lowerPanel.setLayout(new BorderLayout());
        mainFrame.add(lowerPanel, BorderLayout.SOUTH);
        
        // Создание панели кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        lowerPanel.add(buttonPanel, BorderLayout.WEST);

        // Создание панели текстовых сообщений системы
        JPanel sysMsgPanel = new JPanel();
        sysMsgPanel.setLayout(new BoxLayout(sysMsgPanel, BoxLayout.X_AXIS));
        lowerPanel.add(sysMsgPanel, BorderLayout.SOUTH);

        // Создание кнопки с аватаром отправителя
        JButton avatarButton = new JButton();
        avatarButton.setIcon(new ImageIcon("avatar.jpg"));
        avatarButton.setBorderPainted(false);
        avatarButton.setContentAreaFilled(false);
        upperPanel.add(avatarButton, BorderLayout.WEST);

        // Создание текстовых полей параметров письма и подписей к ним
        JButton destLabel = new JButton("Кому");
        destLabel.setBorderPainted(false);
        destLabel.setContentAreaFilled(false);
        destLabel.setEnabled(false);
        labelPanel.add(destLabel);
        JTextField destTextField = new JTextField();
        textFieldPanel.add(destTextField);
        JButton copyLabel = new JButton("Копия");
        copyLabel.setBorderPainted(false);
        copyLabel.setContentAreaFilled(false);
        copyLabel.setEnabled(false);
        labelPanel.add(copyLabel);
        JTextField copyTextField = new JTextField();
        textFieldPanel.add(copyTextField);
        JButton titleLabel = new JButton("Тема");
        titleLabel.setBorderPainted(false);
        titleLabel.setContentAreaFilled(false);
        titleLabel.setEnabled(false);
        labelPanel.add(titleLabel);
        JTextField titleTextField = new JTextField();
        textFieldPanel.add(titleTextField);

        // Создание текстового поля для ввода текста письма
        JTextArea msgTextArea = new JTextArea();
        mainFrame.add(msgTextArea, BorderLayout.CENTER);

        // Создание кнопок нижней панели
        JButton sendButton = new JButton("Отправить");
        sendButton.setBackground(Color.BLUE);
        sendButton.setForeground(Color.WHITE);
        buttonPanel.add(sendButton);
        JButton saveButton = new JButton("Сохранить");
        buttonPanel.add(saveButton);
        JButton cancelButton = new JButton("Отменить");
        buttonPanel.add(cancelButton);

        // Добавление системного сообщения
        JLabel sysMsgLabel = new JLabel("");
        sysMsgPanel.add(sysMsgLabel);

        // Добавление дополнительного цвета
        Color emptyInputColor = new Color(255, 102, 102);

        // Обработчик события нажатия на кнопку "Отправить"
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String destStr = destTextField.getText();
                String copyStr = copyTextField.getText();
                String titleStr = titleTextField.getText();
                String msgStr = msgTextArea.getText();
                boolean checker = true;
                if (destStr.length() == 0) {
                    destTextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    destTextField.setBackground(Color.WHITE);
                }
                if (copyStr.length() == 0) {
                    copyTextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    copyTextField.setBackground(Color.WHITE);
                }
                if (titleStr.length() == 0) {
                    titleTextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    titleTextField.setBackground(Color.WHITE);
                }
                if (msgStr.length() == 0) {
                    msgTextArea.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    msgTextArea.setBackground(Color.WHITE);
                }
                if (checker) {
                    sysMsgLabel.setText("Ваше письмо успешно отправлено");
                    sendButton.setEnabled(false);
                }
            }
        });

        // Создание объекта текущей даты
        Date date = new Date();

        // Обработчик события нажатия на кнопку "Сохранить"
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sysMsgLabel.setText("Изменения успешно сохранены (" + date + ")");
            }
        });

        // Обработчик события нажатия на кнопку "Отменить"
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                destTextField.setText("");
                copyTextField.setText("");
                titleTextField.setText("");
                msgTextArea.setText("");
                sysMsgLabel.setText("");
                destTextField.setBackground(Color.WHITE);
                copyTextField.setBackground(Color.WHITE);
                titleTextField.setBackground(Color.WHITE);
                msgTextArea.setBackground(Color.WHITE);
                sendButton.setEnabled(true);
            }
        });

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}
