import javax.swing.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

public class pract_03_03 {
    public static void main(String[] args) {
        // Создание фрейма
        JFrame mainFrame = new JFrame("Доходность вклада");
        mainFrame.setSize(500, 325);
        mainFrame.setLayout(null);

        // Объявление дополнительного цвета
        Color redTextFieldColor = new Color(255, 102, 102);

        // Заголовочная надпись
        JLabel titleLabel = new JLabel("Рассчёт доходности вклада");
        titleLabel.setBounds(10, 10, 480, 40);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
        mainFrame.add(titleLabel);

        // Надпись "Первоначальная сумма вклада"
        JLabel startSumLabel = new JLabel("Первоначальная сумма вклада");
        startSumLabel.setBounds(10, 70, 250, 30);
        mainFrame.add(startSumLabel);

        // Поле для ввода первоначальной суммы вклада
        JTextField startSumTField = new JTextField();
        startSumTField.setBounds(260, 70, 230, 30);
        mainFrame.add(startSumTField);

        // Надпись "Годовая ставка (%)"
        JLabel procLabel = new JLabel("Годовая ставка (%)");
        procLabel.setBounds(10, 105, 250, 30);
        mainFrame.add(procLabel);

        // Поле для ввода годовой ставки в процентах
        JTextField procTField = new JTextField();
        procTField.setBounds(260, 105, 230, 30);
        mainFrame.add(procTField);

        // Надпись "Срок вклада (в днях)"
        JLabel periodLabel = new JLabel("Срок вклада (в днях)");
        periodLabel.setBounds(10, 140, 250, 30);
        mainFrame.add(periodLabel);

        // Поля для ввода срока вклада
        JTextField periodTField = new JTextField();
        periodTField.setBounds(260, 140, 230, 30);
        mainFrame.add(periodTField);

        // Надпись "Количество дней в году"
        JLabel yearLabel = new JLabel("Количество дней в году");
        yearLabel.setBounds(10, 175, 250, 30);
        mainFrame.add(yearLabel);

        // Поле для ввода количества дней в году
        JTextField yearTField = new JTextField();
        yearTField.setBounds(260, 175, 230, 30);
        mainFrame.add(yearTField);

        // Надпись "Сумма выплаченных процентов"
        JLabel sumLabel = new JLabel("Сумма выплаченных процентов");
        sumLabel.setBounds(10, 210, 250, 30);
        mainFrame.add(sumLabel);

        // Поле для вывода суммы выплаченных процентов
        JTextField sumTField = new JTextField();
        sumTField.setBounds(260, 210, 230, 30);
        sumTField.setEditable(false);
        mainFrame.add(sumTField);

        // Кнопка "Рассчитать ..."
        JButton calcButton = new JButton("Рассчитать сумму выплаченных процентов");
        calcButton.setBounds(10, 255, 480, 30);
        mainFrame.add(calcButton);

        // Обработчик события нажатия на кнопку "Рассчитать..."
        calcButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                boolean checked = true;
                int startSum = 0;
                int proc = 0;
                int period = 0;
                int year = 0;
                if (startSumTField.getText().length() == 0) {
                    checked = false;
                    startSumTField.setBackground(redTextFieldColor);
                }
                else {
                    startSum = Integer.parseInt(startSumTField.getText());
                    startSumTField.setBackground(Color.WHITE);
                }
                if (procTField.getText().length() == 0) {
                    checked = false;
                    procTField.setBackground(redTextFieldColor);
                }
                else {
                    proc = Integer.parseInt(procTField.getText());
                    procTField.setBackground(Color.WHITE);
                }
                if (periodTField.getText().length() == 0) {
                    checked = false;
                    periodTField.setBackground(redTextFieldColor);
                }
                else {
                    period = Integer.parseInt(periodTField.getText());
                    periodTField.setBackground(Color.WHITE);
                }
                if (yearTField.getText().length() == 0) {
                    checked = false;
                    yearTField.setBackground(redTextFieldColor);
                }
                else {
                    year = Integer.parseInt(yearTField.getText());
                    yearTField.setBackground(Color.WHITE);
                }
                if (!((proc > 0) && (proc < 20))) {
                    checked = false;
                    procTField.setBackground(redTextFieldColor);
                }
                if ((year != 355) && (year != 356)) {
                    checked = false;
                    yearTField.setBackground(redTextFieldColor);
                }
                if (checked) {
                    double sum = (startSum * proc * period / year) / 100.0;
                    sumTField. setText(String.valueOf(sum));
                }
            }
        });

        // Вывод фрейма на экран
        mainFrame.setVisible(true);
    }
}
