import javax.swing.*;
import java.awt.event.*;

public class pract_01_example {
    public static void main(String[] args) {
        // Создаем элемент интерфейса - фрейм, называем его myFrame
        JFrame myFrame = new JFrame("Мой фрейм");
        // Задаем размер фрема (ширина, высота)
        myFrame.setSize(400, 200);
        // задаем шаблон фрейма (пустой)
        myFrame.setLayout(null);
        // Делаем фрейм видимым (видимость - true)
        myFrame.setVisible(true);

        // Создаем элемент интерфейса - надпись (в скобках - текст)
        JLabel myLabel = new JLabel("Какой-то текст");
        // Задаем координатные привязки
        myLabel.setBounds(80, 10, 250, 40);
        // Добавляем надпись на фрейм (чтобы она отобразилась)
        myFrame.add(myLabel);

        // Создаем элемент интерфейса - поля для ввода текста
        JTextField myText = new JTextField();
        // Задаем координатные привязки
        myText.setBounds(80, 50, 250, 40);
        // Добавляем поле на фрейм (чтобы оно отобразилось)
        myFrame.add(myText);

        // Создаем элемент интерфейса - кнопку (в скобках - название)
        JButton myButton = new JButton("Кнопка");
        // Задаем координатные привязки
        myButton.setBounds(80, 100, 250, 40);
        // Добавляем кнопку на фрейм (чтобы она отобразилась)
        myFrame.add(myButton);
    }
}
