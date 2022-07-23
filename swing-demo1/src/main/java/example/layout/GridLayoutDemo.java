package example.layout;

import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class GridLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("calc");

        // pane1
        // textFiled
        Panel panel = new Panel();
        panel.add(new TextField(30));
        frame.add(panel, BorderLayout.NORTH);

        // panel2
        // 数字1~9
        Panel panel2 = new Panel(new GridLayout(3, 5, 4, 4));
        for (int i = 0; i < 10; i++) {
            panel2.add(new Button(String.valueOf(i)));
        }
        // 加减乘除
        String[] ff = {"+", "-", "*", "/", "."};
        for (String f : ff) {
            panel2.add(new Button(f));
        }
        panel2.add(new Button("out size"));
        panel2.add(new Button("out size"));
        panel2.add(new Button("out size"));
        panel2.add(new Button("out size"));
        frame.add(panel2);


        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
