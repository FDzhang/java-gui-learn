package demoswing.tree;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

/**
 * 监听结点事件
 * JTree 专门提供了 一个 TreeSelectionModel 对象来保存该 JTree 选中状态的信息 。 也就是说，JTree组件背后隐藏了两个 model 对象 ， 其中TreeModel 用于保存该 JTree 的所有节点数据 ， 而TreeSelectionModel 用于保存该 JTree的所有选中状态的信息
 * 程序可以改变 JTree 的选择模式 ， 但必须先获取该 JTree 对应的 TreeSelectionMode1 对象 ， 再调用该对象的 setSelectionMode(int mode);方法来设置该JTree的选择模式 ，其中model可以有如下3种取值：
 *
 * 1. TreeSelectionModel.CONTIGUOUS_TREE_SELECTION: 可 以连续选中多个 TreePath 。
 * 2. TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION : 该选项对于选择没有任何限制 。
 * 3. TreeSelectionModel.SINGLE_TREE_SELECTION: 每次只能选择一个 TreePath 。
 *
 * **为JTree添加监听器:**
 *
 * 1. addTreeExpansionListener(TreeExpansionListener tel) : 添加树节点展开/折叠事件的监听器。
 * 2. addTreeSelectionListener(TreeSelectionListener tsl) : 添加树节点选择事件的监听器。
 *
 * @author : zxq
 * @create : 2022/8/11 0:28
 */
public class SelectJTree {
    JFrame jf = new JFrame("监听树的选择事件");
    JTree tree;

    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    JTextArea eventTxt = new JTextArea(5, 20);


    private void init() {
        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        tree = new JTree(root);
        //TODO 设置选择模式
        TreeSelectionModel selectionModel = tree.getSelectionModel();
        selectionModel.setSelectionMode(TreeSelectionModel.DISCONTIGUOUS_TREE_SELECTION);

        //TODO 设置监听器
        tree.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent e) {
                //把当前选中结点的路径显示到文本域中
                TreePath newLeadSelectionPath = e.getNewLeadSelectionPath();

                eventTxt.append(newLeadSelectionPath.toString()+"\n");
            }
        });

        Box box = Box.createHorizontalBox();
        box.add(new JScrollPane(tree));
        box.add(new JScrollPane(eventTxt));

        jf.add(box);
        jf.pack();
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new SelectJTree().init();
    }


}
