package example.layout;

import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class FlowLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        //frame.setLayout(new FlowLayout(FlowLayout.LEFT, 20, 20));
         frame.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        // frame.setLayout(new FlowLayout(FlowLayout.RIGHT, 20, 20));

        for (int i = 0; i < 100; i++) {
            frame.add(new Button("button" + i));
        }

        // pack 设置最佳大小
        frame.pack();

        frame.setVisible(true);
    }
}
