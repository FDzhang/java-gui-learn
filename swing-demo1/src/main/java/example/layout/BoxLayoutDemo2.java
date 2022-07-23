package example.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class BoxLayoutDemo2 {
    public static void main(String[] args) {
        Frame frame = new Frame("box layout");

        // 创建水平box
        // 添加两个按钮
        Box bBox = Box.createHorizontalBox();
        bBox.add(new Button("h 001"));
        bBox.add(new Button("h 002"));
        // 创建垂直box
        // 添加两个按钮
        Box vBox = Box.createVerticalBox();
        vBox.add(new Button("v 001"));
        vBox.add(new Button("v 002"));

        // 将2两个box添加到 frame中
        frame.add(bBox, BorderLayout.NORTH);
        frame.add(vBox);

        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
