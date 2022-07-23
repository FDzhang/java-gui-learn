package example.container;

import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:20
 */
public class ScrollPaneDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();

        ScrollPane sp = new ScrollPane();
        sp.add(new TextField("text filed"));
        sp.add(new Button("button 按钮"));

        frame.add(sp);
        frame.setBounds(100, 100, 400, 300);
        frame.setVisible(true);
    }
}
