import javax.swing.*;
import java.awt.Font;
import java.awt.Color;
import java.awt.BorderLayout;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.Point;
import java.awt.Graphics;

public class control_02_02 {
    // Статические переменные режима работы приложения
    private static boolean drawMode = true;
    private static boolean textMode = false;

    // Статические переменные размера холста
    private static int width = 500;
    private static int height = 500;

    // Статические переменные цвета
    private static Color brushColor = Color.BLACK;
    private static Color textColor = Color.BLACK;

    // Статические объекты точек
    private static Point p1 = null;
    private static Point p2 = null;

    // Статический объект графики на фрейме
    private static Graphics g;

    // Статический объект шрифта текстового поля
    private static Font txtFldFont = new Font("Arial", Font.PLAIN, 14);

    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Рисовалка");
        mainFrame.setSize(640, 640);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Панель инструментов
        JPanel toolPnl = new JPanel();
        toolPnl.setLayout(new BoxLayout(toolPnl, BoxLayout.Y_AXIS));
        mainFrame.add(toolPnl, BorderLayout.WEST);

        // Панель рабочий области
        JPanel workspacePnl = new JPanel();
        workspacePnl.setLayout(null);
        mainFrame.add(workspacePnl, BorderLayout.CENTER);

        // Панель области рисования
        JPanel drawPnl = new JPanel();
        drawPnl.setBounds(5, 5, width, height);
        drawPnl.setBackground(Color.WHITE);
        drawPnl.setLayout(null);
        workspacePnl.add(drawPnl);

        // Инструменты
        JButton brushBtn = new JButton();
        brushBtn.setIcon(new ImageIcon("brush.png"));
        toolPnl.add(brushBtn);
        JButton textBtn = new JButton();
        textBtn.setIcon(new ImageIcon("text.png"));
        toolPnl.add(textBtn);

        // Главное меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu colorMenu = new JMenu("Цвет");
        JMenuItem resizeFileMenuItem = new JMenuItem("Изменить размер холста");
        JMenuItem colorBrushMenuItem = new JMenuItem("Выбрать цвет кисти");
        JMenuItem colorTextMenuItem = new JMenuItem("Выбрать цвет текста");
        fileMenu.add(resizeFileMenuItem);
        colorMenu.add(colorBrushMenuItem);
        colorMenu.add(colorTextMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(colorMenu);
        mainFrame.setJMenuBar(menuBar);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Активация области рисования
        g = drawPnl.getGraphics();
        //g.setClip(-5, 5, width, height);
        g.setColor(brushColor);

        // Обработчики кнопок на панели инструментов
        brushBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawMode = true;
                textMode = false;
            }
        });
        textBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                drawMode = false;
                textMode = true;
            }
        });

        // Обработчики действий мыши в области рисования
        drawPnl.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {}
            @Override
            public void mousePressed(MouseEvent e) {
                p1 = e.getPoint();
                p1.x -= 5;
                p1.y += 5;
                if (textMode) {
                    JTextField txtFld = new JTextField();
                    txtFld.setOpaque(false);
                    txtFld.setBounds(p1.x, p1.y - 20, 500, 20);
                    txtFld.setFont(txtFldFont);
                    txtFld.setForeground(textColor);
                    drawPnl.add(txtFld);
                    txtFld.requestFocus();
                    txtFld.addKeyListener(new KeyListener() {
                        public void keyPressed(KeyEvent e) {
                            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                                txtFld.setBorder(null);
                                txtFld.setEditable(false);
                            }
                        }
                        public void keyReleased(KeyEvent e) {}
                        public void keyTyped(KeyEvent e) {}
                    });
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {}
            @Override
            public void mouseEntered(MouseEvent e) {}
            @Override
            public void mouseExited(MouseEvent e) {}
        });
        drawPnl.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e){}
            @Override
            public void mouseDragged(MouseEvent e){
                if (drawMode) {
                    p2 = e.getPoint();
                    p2.x -= 5;
                    p2.y += 5;
                    g.drawLine(p1.x, p1.y, p2.x, p2.y);
                    p1=p2;
                }
            }
        });

        // Обработчики нажатия пунктов меню
        colorBrushMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                brushColor = JColorChooser.showDialog(null, "Выберите цвет кисти", brushColor);
                g.setColor(brushColor);
            }
        });
        colorTextMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textColor = JColorChooser.showDialog(null, "Выберите цвет текста", textColor);
            }
        });

        // Фрейм изменения размера холста
        JFrame sizeFrame = new JFrame("Изменение размеров холста");
        sizeFrame.setSize(200, 200);
        sizeFrame.setLayout(null);
        sizeFrame.setResizable(false);

        // Счётчики размера холста
        JLabel widthLbl = new JLabel("Ширина");
        JLabel heightLbl = new JLabel("Высота");
        JSpinner widthSpnr = new JSpinner();
        JSpinner heightSpnr = new JSpinner();
        widthLbl.setBounds(60, 20, 80, 20);
        heightLbl.setBounds(60, 90, 80, 20);
        widthSpnr.setBounds(60, 40, 80, 30);
        heightSpnr.setBounds(60, 110, 80, 30);
        widthSpnr.setValue(width);
        heightSpnr.setValue(height);
        sizeFrame.add(widthLbl);
        sizeFrame.add(heightLbl);
        sizeFrame.add(widthSpnr);
        sizeFrame.add(heightSpnr);

        // Обработчик нажания пункта меню (основного фрейма)
        resizeFileMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeFrame.setVisible(true);
            }
        });

        // Обработчики взаимодействия со счётчиками (на дополнительном фрейме)
        widthSpnr.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                width = (int)widthSpnr.getValue();
                drawPnl.setBounds(5, 5, width, height);
                g = drawPnl.getGraphics();
            }
        });
        heightSpnr.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                height = (int)heightSpnr.getValue();
                drawPnl.setBounds(5, 5, width, height);
                g = drawPnl.getGraphics();
            }
        });
    }
}
