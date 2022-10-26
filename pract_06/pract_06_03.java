import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;

public class pract_06_03 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("MouseListener");
        mainFrame.setSize(400, 250);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание кнопки
        JButton btn = new JButton("Нажми меня");
        btn.setBounds(50, 50, 300, 30);
        mainFrame.add(btn);

        // Добавление надписи
        JLabel lbl = new JLabel("Что произошло");
        lbl.setBounds(50, 100, 300, 30);
        lbl.setHorizontalAlignment(SwingConstants.CENTER);
        mainFrame.add(lbl);

        // Добавление надписей для счетчиков
        JLabel clickedLbl = new JLabel("Кнопка нажата раз: 0");
        clickedLbl.setBounds(50, 135, 300, 30);
        mainFrame.add(clickedLbl);
        JLabel enteredLbl = new JLabel("Курсор наведен раз: 0");
        enteredLbl.setBounds(50, 155, 300, 30);
        mainFrame.add(enteredLbl);
        JLabel exitedLbl = new JLabel("Курсор отведен раз: 0");
        exitedLbl.setBounds(50, 175, 300, 30);
        mainFrame.add(exitedLbl);

        // Вывод фрейма на экран
        mainFrame.setVisible(true);

        // Обработчики событий взаимодействия с мышью
        btn.addMouseListener(new MouseListener() {
            private int clickedCounter = 0;
            private int enteredCounter = 0;
            private int exitedCounter = 0;
            @Override
            public void mouseClicked(MouseEvent e) {
                clickedCounter++;
                lbl.setText("Кнопка мыши нажата и отпущена");
                lbl.setForeground(Color.RED);
                clickedLbl.setText("Кнопка нажата раз: " + clickedCounter);
            }
            @Override
            public void mousePressed(MouseEvent e) {
                lbl.setText("Кнопка мыши нажата и удерживается");
                lbl.setForeground(Color.GREEN);
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                lbl.setText("Кнопка мыши отпущена");
                lbl.setForeground(Color.BLUE);
            }
            @Override
            public void mouseEntered(MouseEvent e) {
                enteredCounter++;
                lbl.setText("Курсор мыши наведен");
                lbl.setForeground(Color.CYAN);
                enteredLbl.setText("Курсор наведен раз: " + enteredCounter);
            }
            @Override
            public void mouseExited(MouseEvent e) {
                exitedCounter++;
                lbl.setText("Курсор мыши отведен");
                lbl.setForeground(Color.WHITE);
                exitedLbl.setText("Курсор отведен раз: " + exitedCounter);
            }
        });
    }
}
