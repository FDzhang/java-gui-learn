package example.layout;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class BoxLayoutDemo3 {
    public static void main(String[] args) {
        Frame frame = new Frame("box layout");

        // 水平box
        // 水平按钮1，水平间隔1，水平按钮2，固定长度水平间隔2，水平按钮3
        Box hBox = Box.createHorizontalBox();
        hBox.add(new Button("h 001"));
        hBox.add(Box.createHorizontalGlue());
        hBox.add(new Button("h 002"));
        hBox.add(Box.createHorizontalStrut(20));
        hBox.add(new Button("h 003"));

        // 垂直box
        // 垂直按钮1，垂直间隔1，垂直按钮2，固定长度垂直间隔2，垂直按钮3
        Box vBox = Box.createVerticalBox();
        vBox.add(new Button("v 001"));
        vBox.add(Box.createVerticalGlue());
        vBox.add(new Button("v 002"));
        vBox.add(Box.createVerticalStrut(20));
        vBox.add(new Button("v 003"));

        // 放入frame
        frame.add(hBox, BorderLayout.NORTH);
        frame.add(vBox);

        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
