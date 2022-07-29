package example.component;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author : zxq
 * @create : 2022/7/27 0:52
 */
public class FileDialogTest {



    public static void main(String[] args) {
        Frame frame = new Frame("file dialog test");

        // 两个file Dialog
        FileDialog f1 = new FileDialog(frame, "open file", FileDialog.LOAD);
        FileDialog f2 = new FileDialog(frame, "save file", FileDialog.SAVE);


        // 创建两个按钮
        Button b1 = new Button("open file");
        Button b2 = new Button("save file");


        // 设置按钮触发file dialog
        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f1.setVisible(true); // 代码会阻塞到这里

                // 获取选择的路径以及文件名称
                String directory = f1.getDirectory();
                String file = f1.getFile();
                System.out.println("open file path : " + directory);
                System.out.println("open file name : " + file);
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f2.setVisible(true); // 代码会阻塞到这里

                // 获取选择的路径以及文件名称
                String directory = f2.getDirectory();
                String file = f2.getFile();
                System.out.println("save file path : " + directory);
                System.out.println("save file name : " + file);
            }
        });

        frame.add(b1, BorderLayout.SOUTH);
        frame.add(b2, BorderLayout.NORTH);


        frame.pack();
        frame.setLocation(500, 500);
        frame.setVisible(true);
    }
}
