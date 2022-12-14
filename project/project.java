import java.io.IOException;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.io.File;
import java.io.FileWriter;

public class project {
    // Моноширный шрифт по умолчанию
    private static Font mono = new Font("Courier New", Font.PLAIN, 12);

    // Начало файла
    private static String startString = "";

    // Задания
    private static String[][] tasks = new String[100][25];

    // Конец файла
    private static String endString = "";

    public static void main(String[] Args) {
        // Присвоение начальных пустых значений заданий
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 25; j++) {
                tasks[i][j] = "";
            }
        }

        // Создание главного фрейма
        JFrame mainFrame = new JFrame("Генератор контрольных работ");
        mainFrame.setSize(400, 300);
        mainFrame.setLayout(new BorderLayout());
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Панель информации
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 1));
        mainFrame.add(infoPanel, BorderLayout.CENTER);

        // Заголовок
        JPanel topTitlePnl = new JPanel();
        topTitlePnl.setLayout(new BorderLayout());
        JButton logo = new JButton();
        logo.setIcon(new ImageIcon("latex_logo.png"));
        logo.setIcon(new ImageIcon("latex_logo.png"));
        logo.setDisabledIcon(new ImageIcon("latex_logo.png"));
        logo.setBorderPainted(false);
        logo.setContentAreaFilled(false);
        logo.setSelected(false);
        topTitlePnl.add(logo, BorderLayout.WEST);
        JLabel titleLbl = new JLabel("<html><center>Генератор контрольных<br>работ</center></html>");
        titleLbl.setForeground(Color.BLACK);
        titleLbl.setFont(new Font("Arial", Font.BOLD, 16));
        topTitlePnl.add(titleLbl, BorderLayout.CENTER);
        infoPanel.add(topTitlePnl);

        // Информационные сообщения
        JLabel startDoneLbl = new JLabel("Начало файла не задано");
        startDoneLbl.setToolTipText("Настраивается в разделе: Правка -> Настроить начало файла");
        startDoneLbl.setForeground(Color.RED);
        startDoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(startDoneLbl);
        JLabel tasksLbl = new JLabel("Не задано ни одного задания");
        tasksLbl.setToolTipText("Настраивается в разделе: Правка -> Настроить задания");
        tasksLbl.setForeground(Color.RED);
        tasksLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(tasksLbl);
        JLabel endDoneLbl = new JLabel("Конец файла не задан");
        endDoneLbl.setToolTipText("Настраивается в разделе: Правка -> Настроить конец файла");
        endDoneLbl.setForeground(Color.RED);
        endDoneLbl.setHorizontalAlignment(SwingConstants.CENTER);
        infoPanel.add(endDoneLbl);

        // Главное меню
        JMenuBar menuBar = new JMenuBar();
        JMenu fileMenu = new JMenu("Файл");
        JMenu editMenu = new JMenu("Правка");
        JMenu helpMenu = new JMenu("Справка");
        JMenuItem exportMenuItem = new JMenuItem("Экспортировать");
        JMenuItem exitMenuItem = new JMenuItem("Выйти");
        JMenuItem startSetMenuItem = new JMenuItem("Настроить начало файла");
        JMenuItem tasksSetMenuItem = new JMenuItem("Настроить задания");
        JMenuItem endSetMenuItem = new JMenuItem("Настроить конец файла");
        JMenuItem aboutMenuItem = new JMenuItem("О программе");
        fileMenu.add(exportMenuItem);
        fileMenu.add(exitMenuItem);
        editMenu.add(startSetMenuItem);
        editMenu.add(tasksSetMenuItem);
        editMenu.add(endSetMenuItem);
        helpMenu.add(aboutMenuItem);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(helpMenu);
        mainFrame.setJMenuBar(menuBar);

        // Вывод главного фрейма на экран
        mainFrame.setVisible(true);

        // Фрейм настройки начала файла
        JFrame startSetFrame = new JFrame("Начало файла");
        startSetFrame.setSize(600, 400);
        startSetFrame.setLayout(new BorderLayout());
        JTextArea startTxtArea = new JTextArea();
        startTxtArea.setFont(mono);
        JScrollPane startTxtAreaPane = new JScrollPane(startTxtArea);
        startSetFrame.add(startTxtAreaPane, BorderLayout.CENTER);
        JPanel startBtnPnl = new JPanel();
        startBtnPnl.setLayout(new FlowLayout());
        startSetFrame.add(startBtnPnl, BorderLayout.SOUTH);
        JButton startSave = new JButton("Сохранить");
        startSave.setToolTipText("Сохранить изменения и закрыть окно");
        startBtnPnl.add(startSave);
        JButton cancelStartSave = new JButton("Отмена");
        cancelStartSave.setToolTipText("Отменить изменения и закрыть окно");
        startBtnPnl.add(cancelStartSave);

        // Фрейм настройки заданий
        JFrame tasksSetFrame = new JFrame("Задания");
        tasksSetFrame.setSize(600, 400);
        tasksSetFrame.setLayout(new BorderLayout());
        JTextArea taskTxtArea = new JTextArea();
        taskTxtArea.setFont(mono);
        JScrollPane taskTxtAreaPane = new JScrollPane(taskTxtArea);
        tasksSetFrame.add(taskTxtAreaPane, BorderLayout.CENTER);
        JPanel tasksSpinPnl = new JPanel();
        tasksSpinPnl.setLayout(new FlowLayout());
        tasksSetFrame.add(tasksSpinPnl, BorderLayout.NORTH);
        JLabel taskNumLbl = new JLabel("Задание:");
        tasksSpinPnl.add(taskNumLbl);
        SpinnerModel taskNumSpinMdl = new SpinnerNumberModel(1, 1, 100, 1);
        JSpinner taskNumSpin = new JSpinner(taskNumSpinMdl);
        tasksSpinPnl.add(taskNumSpin);
        JLabel varNumLbl = new JLabel("Вариант:");
        tasksSpinPnl.add(varNumLbl);
        SpinnerModel varNumSpinMdl = new SpinnerNumberModel(1, 1, 25, 1);
        JSpinner varNumSpin = new JSpinner(varNumSpinMdl);
        tasksSpinPnl.add(varNumSpin);
        JPanel tasksBtnPnl = new JPanel();
        tasksBtnPnl.setLayout(new FlowLayout());
        tasksSetFrame.add(tasksBtnPnl, BorderLayout.SOUTH);
        JButton tasksSave = new JButton("Сохранить");
        tasksSave.setToolTipText("Сохранить изменения в задании");
        tasksBtnPnl.add(tasksSave);
        JButton cancelTasksSave = new JButton("Отмена");
        cancelTasksSave.setToolTipText("Отменить изменения и закрыть окно");
        tasksBtnPnl.add(cancelTasksSave);

        // Фрейм настройки конца файла
        JFrame endSetFrame = new JFrame("Конец файла");
        endSetFrame.setSize(600, 400);
        endSetFrame.setLayout(new BorderLayout());
        JTextArea endTxtArea = new JTextArea();
        endTxtArea.setFont(mono);
        JScrollPane endTxtAreaPane = new JScrollPane(endTxtArea);
        endSetFrame.add(endTxtAreaPane, BorderLayout.CENTER);
        JPanel endBtnPnl = new JPanel();
        endBtnPnl.setLayout(new FlowLayout());
        endSetFrame.add(endBtnPnl, BorderLayout.SOUTH);
        JButton endSave = new JButton("Сохранить");
        endSave.setToolTipText("Сохранить изменения и закрыть окно");
        endBtnPnl.add(endSave);
        JButton cancelEndSave = new JButton("Отмена");
        cancelEndSave.setToolTipText("Отменить изменения и закрыть окно");
        endBtnPnl.add(cancelEndSave);

        // Фрейс "О приложении"
        JFrame infoFrame = new JFrame("О приложении");
        infoFrame.setSize(250, 200);
        infoFrame.setLayout(new BorderLayout());
        infoFrame.setResizable(false);
        JButton logoInfo = new JButton();
        logoInfo.setIcon(new ImageIcon("latex_logo.png"));
        logoInfo.setIcon(new ImageIcon("latex_logo.png"));
        logoInfo.setDisabledIcon(new ImageIcon("latex_logo.png"));
        logoInfo.setBorderPainted(false);
        logoInfo.setContentAreaFilled(false);
        logoInfo.setSelected(false);
        infoFrame.add(logoInfo, BorderLayout.NORTH);
        JLabel appNameLbl = new JLabel("    Генератор контрольных работ    ");
        appNameLbl.setForeground(Color.BLACK);
        appNameLbl.setFont(new Font("Arial", Font.BOLD, 14));
        appNameLbl.setHorizontalTextPosition(AbstractButton.CENTER);
        infoFrame.add(appNameLbl, BorderLayout.CENTER);
        JLabel authorLbl = new JLabel("                      © Матвеев А.С., 2022");
        authorLbl.setForeground(Color.BLACK);
        authorLbl.setFont(new Font("Arial", Font.PLAIN, 12));
        appNameLbl.setHorizontalTextPosition(AbstractButton.CENTER);
        infoFrame.add(authorLbl, BorderLayout.SOUTH);

        // Обработчики кнопок главного меню
        exportMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChsr = new JFileChooser();
                fileChsr.showSaveDialog(null);
                File exportFile = fileChsr.getSelectedFile();
                if (exportFile != null) {
                    try {
                        exportFile.createNewFile();
                        FileWriter exportFileWriter = new FileWriter(exportFile, false);
                        exportFileWriter.write(startString);
                        for (int i = 0; i < 100; i++) {
                            String[] tasksOutput = new String[25];
                            int count = 0;
                            for (int j = 0; j < 25; j++) {
                                if (tasks[i][j].length() > 0) {
                                    tasksOutput[count] = tasks[i][j];
                                    count++;
                                }
                            }
                            if (count != 0) {
                                int randomVarNum = (int)(Math.random() * count);
                                exportFileWriter.write(tasks[i][randomVarNum]);
                            }
                        }
                        exportFileWriter.write(endString);
                        exportFileWriter.flush();
                        exportFileWriter.close();
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                    try {
                        String command = "pdflatex -synctex=1 -interaction=nonstopmode --shell-escape " + exportFile.getPath();
                        Process child = Runtime.getRuntime().exec(command);
                    }
                    catch(IOException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }
        });
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        startSetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startTxtArea.setText(startString);
                startSetFrame.setVisible(true);
            }
        });
        tasksSetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                taskNumSpin.setValue(1);
                varNumSpin.setValue(1);
                taskTxtArea.setText(tasks[0][0]);
                tasksSetFrame.setVisible(true);
            }
        });
        endSetMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endTxtArea.setText(endString);
                endSetFrame.setVisible(true);
            }
        });
        aboutMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                infoFrame.setVisible(true);
            }
        });

        // Обработчики кнопок настройки начала файла
        startSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startString = startTxtArea.getText();
                startSetFrame.setVisible(false);
                if (startString.length() > 0) {
                    startDoneLbl.setText("Начало файла задано");
                    startDoneLbl.setForeground(Color.BLACK);
                }
                else {
                    startDoneLbl.setText("Начало файла не задано");
                    startDoneLbl.setForeground(Color.RED);
                }
            }
        });
        cancelStartSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                startSetFrame.setVisible(false);
            }
        });

        // Обработчики кнопок настройки заданий
        tasksSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tasks[(int)(taskNumSpin.getValue()) - 1][(int)(varNumSpin.getValue()) - 1] = taskTxtArea.getText();
                int count = 0;
                for (int i = 0; i < 100; i++) {
                    boolean taskDone = false;
                    for (int j = 0; j < 25; j++) {
                        if (tasks[i][j].length() > 0) {
                            taskDone = true;
                        }
                    }
                    if (taskDone) {
                        count++;
                    }
                }
                if (count == 0) {
                    tasksLbl.setText("Не задано ни одного задания");
                    tasksLbl.setForeground(Color.RED);
                }
                else {
                    tasksLbl.setText("Задано заданий: " + count);
                    tasksLbl.setForeground(Color.BLACK);
                }
            }
        });
        cancelTasksSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tasksSetFrame.setVisible(false);
            }
        });
        taskNumSpin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                taskTxtArea.setText(tasks[(int)(taskNumSpin.getValue()) - 1][(int)(varNumSpin.getValue()) - 1]);
                varNumSpin.setValue(1);
            }
        });
        varNumSpin.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                taskTxtArea.setText(tasks[(int)(taskNumSpin.getValue()) - 1][(int)(varNumSpin.getValue()) - 1]);
            }
        });


        // Обработчики кнопок настройки конца файла
        endSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endString = endTxtArea.getText();
                endSetFrame.setVisible(false);
                if (endString.length() > 0) {
                    endDoneLbl.setText("Конец файла задан");
                    endDoneLbl.setForeground(Color.BLACK);
                }
                else {
                    endDoneLbl.setText("Конец файла не задан");
                    endDoneLbl.setForeground(Color.RED);
                }
            }
        });
        cancelEndSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                endSetFrame.setVisible(false);
            }
        });
    }
}
