import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class pract_05_02 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Вычисление силы притяжения между двумя телами");
        mainFrame.setSize(450, 235);
        mainFrame.setLayout(new BorderLayout());

        // Создание панели компановки
        JPanel companePanel = new JPanel();
        companePanel.setLayout(new BorderLayout());
        mainFrame.add(companePanel, BorderLayout.NORTH);

        // Создание заголовка
        JLabel titleLabel = new JLabel("<html><center>Вычисление силы притяжения<br>между двумя телами</center></html>");
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        companePanel.add(titleLabel, BorderLayout.NORTH);

        // Создание панели тектовых полей
        JPanel textFieldPanel = new JPanel();
        textFieldPanel.setLayout(new BoxLayout(textFieldPanel, BoxLayout.Y_AXIS));
        companePanel.add(textFieldPanel, BorderLayout.CENTER);

        // Создание панели подписей текстовых полей
        JPanel labelPanel = new JPanel();
        labelPanel.setLayout(new BoxLayout(labelPanel, BoxLayout.Y_AXIS));
        companePanel.add(labelPanel, BorderLayout.WEST);

        // Создание панели кнопок
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        companePanel.add(buttonPanel, BorderLayout.SOUTH);

        // Создание тектовых полей и подписей к ним
        JButton gButton = new JButton("G (Н * м^2 / кг^2)");
        gButton.setBorderPainted(false);
        gButton.setContentAreaFilled(false);
        gButton.setEnabled(false);
        labelPanel.add(gButton);
        JTextField gTextField = new JTextField();
        textFieldPanel.add(gTextField);
        JButton m1Button = new JButton("m_1 (кг)");
        m1Button.setBorderPainted(false);
        m1Button.setContentAreaFilled(false);
        m1Button.setEnabled(false);
        labelPanel.add(m1Button);
        JTextField m1TextField = new JTextField();
        textFieldPanel.add(m1TextField);
        JButton m2Button = new JButton("m_2 (кг)");
        m2Button.setBorderPainted(false);
        m2Button.setContentAreaFilled(false);
        m2Button.setEnabled(false);
        labelPanel.add(m2Button);
        JTextField m2TextField = new JTextField();
        textFieldPanel.add(m2TextField);
        JButton rButton = new JButton("R (м)");
        rButton.setBorderPainted(false);
        rButton.setContentAreaFilled(false);
        rButton.setEnabled(false);
        labelPanel.add(rButton);
        JTextField rTextField = new JTextField();
        textFieldPanel.add(rTextField);
        JButton fButton = new JButton("F (Н)");
        fButton.setBorderPainted(false);
        fButton.setContentAreaFilled(false);
        fButton.setEnabled(false);
        labelPanel.add(fButton);
        JTextField fTextField = new JTextField();
        fTextField.setEditable(false);
        textFieldPanel.add(fTextField);

        // Создание кнопки "Вычислить"
        JButton calcButton = new JButton("Вычислить");
        buttonPanel.add(calcButton);

        // Добавление дополнительного цвета
        Color emptyInputColor = new Color(255, 102, 102);

        // Обработчик события нажатия на кнопку "Вычислить"
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checker = true;
                String gStr = gTextField.getText();
                String m1Str = m1TextField.getText();
                String m2Str = m2TextField.getText();
                String rStr = rTextField.getText();
                if (gStr.length() == 0) {
                    gTextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    gTextField.setBackground(Color.WHITE);
                }
                if (m1Str.length() == 0) {
                    m1TextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    m1TextField.setBackground(Color.WHITE);
                }
                if (m2Str.length() == 0) {
                    m2TextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    m2TextField.setBackground(Color.WHITE);
                }
                if (rStr.length() == 0) {
                    rTextField.setBackground(emptyInputColor);
                    checker = false;
                }
                else {
                    rTextField.setBackground(Color.WHITE);
                }
                if (checker) {
                    double g = Double.parseDouble(gStr);
                    double m1 = Double.parseDouble(m1Str);
                    double m2 = Double.parseDouble(m2Str);
                    double r = Double.parseDouble(rStr);
                    double f = g * m1 * m2 / (r * r);
                    fTextField.setText(String.valueOf(f));
                }
            }
        });

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}
