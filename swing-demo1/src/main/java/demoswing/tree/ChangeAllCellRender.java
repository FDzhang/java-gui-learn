package demoswing.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

/**
 * ### 使用DefaultTreeCellRenderer改变结点外观
 * <p>
 * JTree默认的外观是比较单一的，它提供了如下几种改变结点外观的方式：
 * <p>
 * 1. 使用 DefaultTreeCellRenderer 直接改变节点的外观，这种方式可 以 改变整棵树所有节点 的字体、颜色和图标 。
 * 2. 为 JTree 指定 DefaultTreeCellRenderer 的扩展类对象作为 JTree 的节点绘制器，该绘制器负责为不同节点使用不同的字体、颜色和图标。通常使用这种方式来改变节点的外观 。
 * 3. 为 JTree 指定一个实现 TreeCellRenderer 接口的节点绘制器，该绘制器可以为不同的节点自由绘制任意内容，这是最复杂但最灵活的节点绘制器 。
 * 第 一种方式最简单 ， 但灵活性最差 ，因为它会改变整棵树所有节点的外观 。 在这种情况下 ， Jtree的所有节点依然使用相同的图标 ，相当于整体替换了 Jtree 中 节点的所有默认图标 。 用户指定 的节点图标未必就比 JTree 默认的图标美观 。
 * DefaultTreeCellRenderer 提供了如下几个方法来修改节点的外观：
 * setBackgroundNonSelectionColor(Color newColor): 设置用于非选定节点的背景颜色 。
 * setBackgroundSelectionColor(Color newColor): 设置节点在选中状态下的背景颜色 。
 * setBorderSelectionColor(Color newColor): 设置选中状态下节点的边框颜色 。
 * setClosedIcon(Icon newIcon): 设置处于折叠状态下非叶子节点的图标 。
 * setFont(Font font) : 设置节点文本 的 字体。
 * setLeaflcon(Icon newIcon): 设置叶子节点的图标 。
 * setOpenlcon(Icon newlcon): 设置处于展开状态下非叶子节 点的图标。
 * setTextNonSelectionColor(Color newColor): 设置绘制非选中状态下节点文本的颜色 。
 * setTextSelectionColor(Color newColor): 设置绘制选中状态下节点文本的颜色 。
 *
 * @author : zxq
 * @create : 2022/8/12 0:10
 */
public class ChangeAllCellRender {
    JFrame jf = new JFrame("改变所有结点外观");
    JTree tree;
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    public void init(){
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);


        tree = new JTree(root);
        DefaultTreeCellRenderer renderer = new DefaultTreeCellRenderer();
        //设置非选定结点的背景颜色
        renderer.setBackgroundNonSelectionColor(new Color(220,220,220));
        //设置选中结点的背景色
        renderer.setBackgroundSelectionColor(new Color(140,140,140));

        //设置选中状态下结点的边框颜色
        renderer.setBorderSelectionColor(Color.BLACK);

        //设置处于折叠状态下非叶子结点的图标
        renderer.setClosedIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/close.gif")));
        //设置处于展开状态下非叶子结点图标
        renderer.setOpenIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/open.gif")));

        //设置结点文本的字体
        renderer.setFont(new Font("StSong",Font.BOLD,16));
        //设置叶子结点图标
        renderer.setOpenIcon(new ImageIcon(this.getClass().getClassLoader().getResource("img/leaf.png")));

        //设置绘制非选中状态下结点文本颜色
        renderer.setTextNonSelectionColor(new Color(255,0,0));
        //设置选中状态下结点的文本颜色
        renderer.setTextSelectionColor(new Color(0,0,255));

        //把结点绘制器设置给树对象
        tree.setCellRenderer(renderer);

        jf.add(new JScrollPane(tree));
        jf.pack();
        jf.setLocation(500, 500);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }
    public static void main(String[] args) {
        new ChangeAllCellRender().init();
    }
}
