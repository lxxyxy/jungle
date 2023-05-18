package view;

import controller.GameController;
import model.Chessboard;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartFrame extends JFrame{
    private final int WIDTH;
    private final int HEIGTH;
    public StartFrame(int width, int height) {
        setTitle("开始界面"); //设置标题
        this.WIDTH = width;
        this.HEIGTH = height;

        setSize(WIDTH, HEIGTH);
        setLocationRelativeTo(null); // Center the window.
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        setLayout(null);

        addImage();
        addStartButton();
    }

    private void addStartButton() {
        JButton button1 = new JButton("开始游戏");
        button1.setBackground(Color.YELLOW); // 设置按钮的背景色为红色
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 关闭当前界面
                setVisible(false);
                dispose(); // 释放界面资源

                // 打开新界面
                ChessGameFrame mainFrame = new ChessGameFrame(1100, 810);
                GameController gameController = new GameController(mainFrame.getChessboardComponent(), new Chessboard());
                mainFrame.setVisible(true);
            }
        });
        button1.setLocation(150,470 );
        button1.setSize(200, 60);
        button1.setFont(new Font("Rockwell", Font.BOLD, 20));
        add(button1);

    }

    private void addImage() {
        ImageIcon icon1 = new ImageIcon("D:\\java\\FirstDemo\\resource\\sbg.jpg");
        //创建一个JLabel的对象（管理容器）
        JLabel jLabel1 = new JLabel(icon1);
        //图片位置
        jLabel1.setBounds(0, 0, 480, 720);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); //设置程序关闭按键，如果点击右上方的叉就游戏全部关闭了
        this.add(jLabel1);
        this.getContentPane().add(jLabel1);

    }

}
