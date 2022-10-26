import javax.swing.*;
import java.awt.Color;
import java.awt.event.*;
import java.awt.Point;
import java.awt.Graphics;

public class pract_06_04 {
    public static Point p1 = null;
    public static Point p2 = null;

    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Mouse Painter");
        mainFrame.setSize(500, 350);
        mainFrame.setLayout(null);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Создание кнопок смены цвета
        JButton whiteBtn = new JButton("Белый");
        whiteBtn.setBounds(10, 10, 100, 30);
        whiteBtn.setBackground(Color.WHITE);
        whiteBtn.setForeground(Color.BLACK);
        whiteBtn.setBorderPainted(false);
        mainFrame.add(whiteBtn);
        JButton blueBtn = new JButton("Синий");
        blueBtn.setBounds(10, 50, 100, 30);
        blueBtn.setBackground(Color.BLUE);
        blueBtn.setForeground(Color.WHITE);
        blueBtn.setBorderPainted(false);
        mainFrame.add(blueBtn);
        JButton redBtn = new JButton("Красный");
        redBtn.setBounds(10, 90, 100, 30);
        redBtn.setBackground(Color.RED);
        redBtn.setForeground(Color.WHITE);
        redBtn.setBorderPainted(false);
        mainFrame.add(redBtn);

        // Вывод фрейма на экран
        mainFrame.setVisible(true);

        // Обработчики события нажатия кнопок мыши
        mainFrame.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                p1 = e.getPoint();
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });

        // Объект графики на фрейме
        Graphics g = mainFrame.getGraphics();

        // Обработчики движений курсора мыши
        mainFrame.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){}
            @Override
            public void mouseDragged(MouseEvent e){
                p2 = e.getPoint();
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
                p1=p2;
            }
        });

        // Обработчики нажатия на кнопки
        whiteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setColor(Color.WHITE);
            }
        });
        blueBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setColor(Color.BLUE);
            }
        });
        redBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                g.setColor(Color.RED);
            }
        });
    }
}
