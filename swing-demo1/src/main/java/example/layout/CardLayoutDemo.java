package example.layout;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : zxq
 * @create : 2022/7/23 10:33
 */
public class CardLayoutDemo {
    public static void main(String[] args) {
        Frame frame = new Frame("card layout");


        // panel1
        // 设置卡片布局
        // 五张卡片， 001， 002， 003， 004， 005
        // frame.add panel1
        Panel panel1 = new Panel();
        CardLayout cardLayout = new CardLayout();
        panel1.setLayout(cardLayout);

        String[] cards = {"001", "002", "003", "004", "005"};
        for (int i = 0; i < cards.length; i++) {
            panel1.add(cards[i] + i, new Button(cards[i]));
        }
        frame.add(panel1);

        // panel2
        // 五个按钮  pre, next, first, last, third
        // 创建事件监听
        // 五个按钮绑定事件监听
        // frame.add panel2
        Panel panel2 = new Panel();
        String[] buttons = {"pre", "next", "first", "last", "third"};
        for (String button : buttons) {
            panel2.add(new Button(button));
        }
        ActionListener actionListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                if ("pre".equals(actionCommand)) {
                    cardLayout.previous(panel1);
                } else if ("next".equals(actionCommand)) {
                    cardLayout.next(panel1);
                } else if ("first".equals(actionCommand)) {
                    cardLayout.first(panel1);
                } else if ("last".equals(actionCommand)) {
                    cardLayout.last(panel1);
                } else if ("third".equals(actionCommand)) {
                    cardLayout.show(panel1, "003");
                }
            }
        };
        for (Component component : panel2.getComponents()) {
            ((Button) component).addActionListener(actionListener);
        }
        frame.add(panel2, BorderLayout.SOUTH);


        // pack 设置最佳大小
        frame.pack();
        frame.setVisible(true);
    }
}
