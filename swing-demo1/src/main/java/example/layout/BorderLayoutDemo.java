package example.layout;

import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class BorderLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame();


        frame.setLayout(new BorderLayout(30, 10));

        frame.add(new Button("NORTH"), BorderLayout.NORTH);
        frame.add(new Button("SOUTH"), BorderLayout.SOUTH);
        frame.add(new Button("EAST"), BorderLayout.EAST);
        frame.add(new Button("WEST"), BorderLayout.WEST);
        frame.add(new Button("CENTER"), BorderLayout.CENTER);

        // 同一区域重复添加，会直接覆盖
        frame.add(new Button("CENTER1"), BorderLayout.CENTER);
        // 不指定区域，默认center
        frame.add(new Button("CENTER2"));


        // pack 设置最佳大小
        frame.pack();

        frame.setVisible(true);
    }
}
