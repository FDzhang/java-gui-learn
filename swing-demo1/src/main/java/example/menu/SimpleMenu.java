package example.menu;

import java.awt.*;
import java.awt.event.*;

/**
 * @author : zxq
 * @create : 2022/7/31 19:06
 */
public class SimpleMenu {
    // 窗口
    private Frame frame = new Frame("menu test");

    // 菜单条
    private MenuBar menuBar = new MenuBar();

    // 菜单
    private Menu file = new Menu("file");
    private Menu edit = new Menu("edit");
    private Menu format = new Menu("format");


    // 菜单项
    private MenuItem autoWrap = new MenuItem("auto wrap");
    private MenuItem copy = new MenuItem("copy");
    private MenuItem paste = new MenuItem("paste");
    private MenuItem comment = new MenuItem("comment", new MenuShortcut(KeyEvent.VK_Q, true));
    private MenuItem cancelComment = new MenuItem("cancelComment");

    // 文本区域
    private TextArea text = new TextArea();


    public void init() {
        // 菜单事件监听
        comment.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.append("click comment");
            }
        });

        // 组装
        menuBar.add(file);
        menuBar.add(edit);

        edit.add(autoWrap);
        edit.add(comment);
        edit.add(paste);
        edit.add(format);

        format.add(comment);
        format.add(cancelComment);


        frame.setMenuBar(menuBar);
        frame.add(text);


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
        new SimpleMenu().init();
    }
}
