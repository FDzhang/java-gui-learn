package example.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class BoxLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("box layout");

        // 创建BoxLayout
        // BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.Y_AXIS);
        BoxLayout boxLayout = new BoxLayout(frame, BoxLayout.X_AXIS);

        // frame 设置 boxLayout
        frame.setLayout(boxLayout);

        // frame添加组件
        frame.add(new Button("001"));
        frame.add(new Button("002"));

        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
