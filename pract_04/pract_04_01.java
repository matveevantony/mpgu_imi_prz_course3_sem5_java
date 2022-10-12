import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class pract_04_01 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Переводчик");
        mainFrame.setSize(1000, 500);
        mainFrame.setLayout(new BorderLayout());

        // Создание верхней панели с логотипом
        JPanel upperLogoPanel = new JPanel();
        upperLogoPanel.setLayout(new BoxLayout(upperLogoPanel, BoxLayout.X_AXIS));
        mainFrame.add(upperLogoPanel, BorderLayout.NORTH);

        // Добавление кнопки с логотипом
        JButton logoButton = new JButton();
        // logoButton.setBounds(0, 0, 102, 40);
        logoButton.setIcon(new ImageIcon("google_logo.png"));
        logoButton.setBorderPainted(false);
        logoButton.setContentAreaFilled(false);
        upperLogoPanel.add(logoButton);

        // Добавление надписи в заголовок
        JLabel titleLabel = new JLabel("Переводчик");
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 18));
        upperLogoPanel.add(titleLabel);

        // Добавление основной панели интерфейса
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainFrame.add(mainPanel, BorderLayout.CENTER);

        // Добавление верхней панели выбора режима
        JPanel modeSetPanel = new JPanel();
        modeSetPanel.setLayout(new BorderLayout());
        mainPanel.add(modeSetPanel, BorderLayout.NORTH);

        // Добавление панели компановки кнопок выбора режима
        JPanel buttonModeSetPanel = new JPanel();
        buttonModeSetPanel.setLayout(new FlowLayout());
        modeSetPanel.add(buttonModeSetPanel, BorderLayout.WEST);

        // Добавление кнопок переключения режима
        JButton textButton = new JButton("Текст");
        textButton.setIcon(new ImageIcon("textbtn_logo.png"));
        textButton.setBackground(Color.WHITE);
        buttonModeSetPanel.add(textButton);
        JButton docButton = new JButton("Документы");
        docButton.setIcon(new ImageIcon("docbtn_logo.png"));
        docButton.setBackground(Color.WHITE);
        buttonModeSetPanel.add(docButton);
        JButton siteButton = new JButton("Сайты");
        siteButton.setIcon(new ImageIcon("sitebtn_logo.png"));
        siteButton.setBackground(Color.WHITE);
        buttonModeSetPanel.add(siteButton);

        // Добавление панели области перевода
        JPanel translatePanel = new JPanel();
        translatePanel.setLayout(new GridLayout(1,2));
        mainPanel.add(translatePanel, BorderLayout.CENTER);

        // Добавление панели области ввода текста
        JPanel inputTextPanel = new JPanel();
        inputTextPanel.setLayout(new BorderLayout());
        translatePanel.add(inputTextPanel);

        // Добавление панели области вывода текста
        JPanel outputTextPanel = new JPanel();
        outputTextPanel.setLayout(new BorderLayout());
        translatePanel.add(outputTextPanel);

        // Добавление панели выбора языка ввода
        JPanel inputLanguagePanel = new JPanel();
        inputLanguagePanel.setLayout(new FlowLayout());
        inputTextPanel.add(inputLanguagePanel, BorderLayout.NORTH);

        // Добавление панели выбора языка вывода
        JPanel outputLanguagePanel = new JPanel();
        outputLanguagePanel.setLayout(new FlowLayout());
        outputTextPanel.add(outputLanguagePanel, BorderLayout.NORTH);

        // Добавление кнопок выбора языка ввода
        Color selectedLanguageColor = new Color(0, 134, 248);
        JButton engInputLang = new JButton("АНГЛИЙСКИЙ");
        engInputLang.setBackground(selectedLanguageColor);
        inputLanguagePanel.add(engInputLang);
        JButton ruInputLang = new JButton("РУССКИЙ");
        ruInputLang.setBackground(Color.WHITE);
        inputLanguagePanel.add(ruInputLang);
        JButton deInputLang = new JButton("НЕМЕЦКИЙ");
        deInputLang.setBackground(Color.WHITE);
        inputLanguagePanel.add(deInputLang);
        JButton moreInputLang = new JButton("v");
        moreInputLang.setBackground(Color.WHITE);
        inputLanguagePanel.add(moreInputLang);

        // Добавление кнопок выбора языка вывода
        JButton engOutputLang = new JButton("АНГЛИЙСКИЙ");
        engOutputLang.setBackground(Color.WHITE);
        outputLanguagePanel.add(engOutputLang);
        JButton ruOutputLang = new JButton("РУССКИЙ");
        ruOutputLang.setBackground(selectedLanguageColor);
        outputLanguagePanel.add(ruOutputLang);
        JButton deOutputLang = new JButton("НЕМЕЦКИЙ");
        deOutputLang.setBackground(Color.WHITE);
        outputLanguagePanel.add(deOutputLang);
        JButton moreOutputLang = new JButton("v");
        moreOutputLang.setBackground(Color.WHITE);
        outputLanguagePanel.add(moreOutputLang);

        // Добавление текстовых полей ввода и вывода текста
        JTextField inputTextField = new JTextField();
        inputTextPanel.add(inputTextField, BorderLayout.CENTER);
        JTextField outputTextField = new JTextField();
        outputTextPanel.add(outputTextField, BorderLayout.CENTER);

        // Добавление нижней панели кнопок
        JPanel southBtnPanel = new JPanel();
        southBtnPanel.setLayout(new FlowLayout());
        mainPanel.add(southBtnPanel, BorderLayout.SOUTH);

        // Добавление кнопки "Перевести"
        JButton translateButton = new JButton("Перевести");
        translateButton.setBackground(selectedLanguageColor);
        southBtnPanel.add(translateButton);

        // Обработчик события нажатия на кнопку "Перевести"
        Color emptyInputColor = new Color(255, 102, 102);
        translateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputTexString = inputTextField.getText();
                if (inputTexString.length() == 0) {
                    inputTextField.setBackground(emptyInputColor);
                }
                else {
                    inputTextField.setBackground(Color.WHITE);
                }
            }
        });

        // Обработчики событий нажатия на кнопки выбора языка
        engInputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (engOutputLang.getBackground() == selectedLanguageColor) {
                    engOutputLang.setBackground(Color.WHITE);
                    ruOutputLang.setBackground(selectedLanguageColor);
                }
                engInputLang.setBackground(selectedLanguageColor);
                ruInputLang.setBackground(Color.WHITE);
                deInputLang.setBackground(Color.WHITE);
            }
        });
        engOutputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (engInputLang.getBackground() == selectedLanguageColor) {
                    engInputLang.setBackground(Color.WHITE);
                    ruInputLang.setBackground(selectedLanguageColor);
                }
                engOutputLang.setBackground(selectedLanguageColor);
                ruOutputLang.setBackground(Color.WHITE);
                deOutputLang.setBackground(Color.WHITE);
            }
        });
        ruInputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ruOutputLang.getBackground() == selectedLanguageColor) {
                    ruOutputLang.setBackground(Color.WHITE);
                    engOutputLang.setBackground(selectedLanguageColor);
                }
                ruInputLang.setBackground(selectedLanguageColor);
                engInputLang.setBackground(Color.WHITE);
                deInputLang.setBackground(Color.WHITE);
            }
        });
        ruOutputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (ruInputLang.getBackground() == selectedLanguageColor) {
                    ruInputLang.setBackground(Color.WHITE);
                    engInputLang.setBackground(selectedLanguageColor);
                }
                ruOutputLang.setBackground(selectedLanguageColor);
                engOutputLang.setBackground(Color.WHITE);
                deOutputLang.setBackground(Color.WHITE);
            }
        });
        deInputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deOutputLang.getBackground() == selectedLanguageColor) {
                    deOutputLang.setBackground(Color.WHITE);
                    ruOutputLang.setBackground(selectedLanguageColor);
                }
                deInputLang.setBackground(selectedLanguageColor);
                engInputLang.setBackground(Color.WHITE);
                ruInputLang.setBackground(Color.WHITE);
            }
        });
        deOutputLang.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (deInputLang.getBackground() == selectedLanguageColor) {
                    deInputLang.setBackground(Color.WHITE);
                    ruInputLang.setBackground(selectedLanguageColor);
                }
                deOutputLang.setBackground(selectedLanguageColor);
                engOutputLang.setBackground(Color.WHITE);
                ruOutputLang.setBackground(Color.WHITE);
            }
        });

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}
