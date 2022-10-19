import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class control_01_01 {
    public static void main(String[] args) {
        JFrame myFrame = new JFrame("Русограм");
        myFrame.setSize(250, 370);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setLayout(null);

        JButton btnAva = new JButton();
        btnAva.setBounds(5, 5, 30, 30);
        btnAva.setIcon(new ImageIcon("avatar.jpg"));
        btnAva.setBorderPainted(false);
        btnAva.setContentAreaFilled(false);
        myFrame.add(btnAva);

        JLabel lblName = new JLabel("matveevantony");
        lblName.setBounds(40, 5, 150, 15);
        myFrame.add(lblName);

        JLabel lblLocation = new JLabel("MPSU");
        lblLocation.setBounds(40, 20, 150, 15);
        lblLocation.setFont(new Font("Arial", Font.ITALIC, 12));
        myFrame.add(lblLocation);

        JButton btnPhoto = new JButton();
        btnPhoto.setBounds(5, 45, 240, 150);
        btnPhoto.setIcon(new ImageIcon("photo.jpg"));
        btnPhoto.setBorderPainted(false);
        btnPhoto.setContentAreaFilled(false);
        myFrame.add(btnPhoto);

        JButton btnLike = new JButton();
        btnLike.setBounds(5, 200, 25, 25);
        btnLike.setIcon(new ImageIcon("like.png"));
        btnLike.setBorderPainted(false);
        btnLike.setContentAreaFilled(false);
        myFrame.add(btnLike);

        JButton btnComment = new JButton();
        btnComment.setBounds(35, 200, 25, 25);
        btnComment.setIcon(new ImageIcon("comment.png"));
        btnComment.setBorderPainted(false);
        btnComment.setContentAreaFilled(false);
        myFrame.add(btnComment);

        JLabel lblLikeCount = new JLabel("Количество лайков");
        lblLikeCount.setBounds(5, 230, 150, 15);
        lblLikeCount.setText("Нравится: " + ((int)(Math.random() * 100)));
        myFrame.add(lblLikeCount);

        JLabel lblCommentAuthor = new JLabel("Автор комментария");
        lblCommentAuthor.setBounds(5, 250, 200, 15);
        lblCommentAuthor.setFont(new Font("Arial", Font.BOLD, 14));
        lblCommentAuthor.setVisible(false);
        myFrame.add(lblCommentAuthor);

        JLabel lblMyComment = new JLabel("Комментарий");
        lblMyComment.setBounds(5, 265, 200, 15);
        lblMyComment.setVisible(false);
        myFrame.add(lblMyComment);

        JTextField txtComment = new JTextField();
        txtComment.setBounds(5, 300, 180, 30);
        txtComment.setVisible(false);
        myFrame.add(txtComment);

        JButton btnSend = new JButton("OK");
        btnSend.setBounds(190, 300, 55, 30);
        Color vkBlueColor = new Color(39, 135, 245);
        btnSend.setBackground(vkBlueColor);
        btnSend.setForeground(Color.WHITE);
        btnSend.setBorderPainted(false);
        btnSend.setVisible(false);
        myFrame.add(btnSend);

        btnLike.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String likeInfo = lblLikeCount.getText();
                likeInfo = likeInfo.replace("Нравится: ", "");
                int likeCount = Integer.parseInt(likeInfo);
                likeCount++;
                lblLikeCount.setText("Нравится: " + likeCount);
            }
        });

        btnPhoto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount() == 2) {
                    String likeInfo = lblLikeCount.getText();
                    likeInfo = likeInfo.replace("Нравится: ", "");
                    int likeCount = Integer.parseInt(likeInfo);
                    likeCount++;
                    lblLikeCount.setText("Нравится: " + likeCount);
                }
            }
        });

        btnComment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txtComment.isVisible() == false) {
                    txtComment.setVisible(true);
                    btnSend.setVisible(true);
                }
                else {
                    txtComment.setVisible(false);
                    btnSend.setVisible(false);
                }
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputComment = txtComment.getText();
                if (inputComment.length() != 0) {
                    lblCommentAuthor.setText("matveevantony");
                    lblMyComment.setText(inputComment);
                    lblCommentAuthor.setVisible(true);
                    lblMyComment.setVisible(true);
                    txtComment.setText("");
                }
                txtComment.setVisible(false);
                btnSend.setVisible(false);
            }
        });
        
        myFrame.setVisible(true);
    }
}