package example.menu;

import java.awt.*;
import java.awt.event.*;

/**
 * @author : zxq
 * @create : 2022/7/31 19:06
 */
public class PopupMenuTest {
    // 窗口
    private Frame frame = new Frame("popup menu test");


    // 文本区域
    private TextArea text = new TextArea();

    // panel
    private Panel panel = new Panel();

    // popup menu
    private PopupMenu popupMenu = new PopupMenu("test");

    private MenuItem comment = new MenuItem("comment");
    private MenuItem cancelComment = new MenuItem("cancelComment");
    private MenuItem copy = new MenuItem("copy");
    private MenuItem save = new MenuItem("save");


    public void init() {
        // 菜单事件监听
        ActionListener listener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String actionCommand = e.getActionCommand();
                text.append(actionCommand + " click\n");
            }
        };
        comment.addActionListener(listener);
        cancelComment.addActionListener(listener);
        copy.addActionListener(listener);
        save.addActionListener(listener);

        // 组装
        popupMenu.add(comment);
        popupMenu.add(cancelComment);
        popupMenu.add(copy);
        popupMenu.add(save);

        // panel
        panel.setPreferredSize(new Dimension(400, 300));
        panel.add(popupMenu);
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseReleased(MouseEvent e) {
                boolean trigger = e.isPopupTrigger();
                if (trigger) {
                    // 显示 popup menu
                    popupMenu.show(panel, e.getX(), e.getY());
                }
            }
        });

        frame.add(text);
        frame.add(panel, BorderLayout.SOUTH);

        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new PopupMenuTest().init();
    }
}
