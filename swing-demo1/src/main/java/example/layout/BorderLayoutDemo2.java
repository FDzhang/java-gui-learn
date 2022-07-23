package example.layout;

import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class BorderLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame();

        // 设置布局器
        frame.setLayout(new BorderLayout(30, 10));

        frame.add(new Button("NORTH"), BorderLayout.NORTH);
        frame.add(new Button("SOUTH"), BorderLayout.SOUTH);

        Panel panel = new Panel();
        panel.add(new Button("test button"));
        panel.add(new TextField("test field"));

        frame.add(panel);

        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
