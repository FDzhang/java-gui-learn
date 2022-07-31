package example.listener;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : zxq
 * @create : 2022/7/30 0:09
 */
public class ListenerDemo1 {

    private Frame frame;


    public void init(){
        frame = new Frame("test listener");
        System.out.println();

        // 文本 + 按钮
        TextField textField = new TextField(50);
        Button button = new Button("ok");

        // 绑定事件监听
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("ok click");
                textField.setText("hello world");
            }
        });

        frame.add(textField, BorderLayout.NORTH);
        frame.add(button);


        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new ListenerDemo1().init();
    }
}
