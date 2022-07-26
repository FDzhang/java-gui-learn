package example.component;

import javax.swing.*;
import java.awt.*;

/**
 * @author : zxq
 * @create : 2022/7/27 0:52
 */
public class BasicComponentDemo {

    TextArea textField = new TextArea(5, 20);

    Choice choice = new Choice();

    CheckboxGroup cbg = new CheckboxGroup();
    Checkbox male = new Checkbox("男", cbg, true);
    Checkbox female = new Checkbox("女", cbg, true);

    Checkbox isMarried = new Checkbox("是否已婚");

    TextField tf = new TextField(40);
    Button ok = new Button("确认");

    List colorList = new List(6, true);

    public void init(){
        // 界面

        // 底部
        Box hBox = Box.createHorizontalBox();
        hBox.add(tf);
        hBox.add(ok);

        // 选择的部分
        choice.add("红色");
        choice.add("blue");
        choice.add("green");

        Box cBox = Box.createHorizontalBox();
        cBox.add(choice);
        cBox.add(male);
        cBox.add(female);
        cBox.add(isMarried);

        // 文本框和选择的部分
        Box vBox = Box.createVerticalBox();
        vBox.add(textField);
        vBox.add(cBox);

        // 组装顶部左边和列表框
        colorList.add("red");
        colorList.add("blue");
        colorList.add("green");

        Box top = Box.createHorizontalBox();
        top.add(vBox);
        top.add(colorList);

        // 放入frame
        Frame frame = new Frame();
        frame.add(hBox, BorderLayout.SOUTH);
        frame.add(top);

        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new BasicComponentDemo().init();
    }
}
