package example;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 0:22
 */
public class Demo1 {
    public static void main(String[] args) {
        // 一个window对象
        // 因为，panel以及其他容器，不能独立存在，必须依附于 Window 而存在
        Frame frame = new Frame();

        Panel panel = new Panel();

        // 将文本框和按钮放入panel容器中
        panel.add(new TextField("text filed"));
        panel.add(new Button("button 按钮"));

        // 将panel放入window中
        frame.add(panel);
        // 设置window的位置和大小
        frame.setBounds(100, 100, 400, 300);
        // 设置window可见
        frame.setVisible(true);
    }
}
