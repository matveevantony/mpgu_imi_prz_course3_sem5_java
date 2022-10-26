import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class pract_06_01 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Клавиатура");
        mainFrame.setSize(400, 250);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание текстового поля
        JTextField txtField = new JTextField();
        txtField.setBounds(50, 50, 300, 30);
        mainFrame.add(txtField);

        // Создание надписи
        JLabel lbl = new JLabel();
        lbl.setBounds(50, 120, 300, 30);
        lbl.setBackground(Color.CYAN);
        lbl.setOpaque(true);
        mainFrame.add(lbl);

        // Вывод фрейма на экран
        mainFrame.setVisible(true);

        // История нажатых клавиш
        class InputKeyListener extends KeyAdapter {
            private int pressedBtnCounter = 0;
            private int pressedSpaceCounter = 0;
            public void keyPressed(KeyEvent e) {
                pressedBtnCounter++;
                String lblString = lbl.getText();
                if (e.getKeyCode() == KeyEvent.VK_SPACE) {
                    pressedSpaceCounter++;
                }
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    lblString = "<html>Нажато клавиш: " + pressedBtnCounter + "<br>Написано слов: " + pressedSpaceCounter + "</html>";
                }
                else {
                    if (lblString.indexOf("Нажато клавиш") != -1) {
                        lblString = "";
                    }
                    lblString = e.getKeyText(e.getKeyCode()) + " " + lblString;
                }
                lbl.setText(lblString);
            }
        }
        txtField.addKeyListener(new InputKeyListener());
    }
}
