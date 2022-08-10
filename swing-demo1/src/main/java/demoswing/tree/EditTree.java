package demoswing.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * JTree 生成的树默认是不可编辑的，不可以添加、删除结点，也不可以改变结点数据
 * :如果想让某个 JTree 对象变成可编辑状态，
 * 则可以调用 JTree 的setEditable(boolean b)方法，传入 true 即可把这棵树变成可编辑的树(可以添加、删除结点，也可以改变结点数据) 。
 * <p>
 * **编辑树结点的步骤：**
 * 获取当前被选中的结点，会有两种方式：
 * 一：
 * 通过JTree对象的某些方法，例如 TreePath getSelectionPath()等，得到一个TreePath对象，包含了从根结点到当前结点路径上的所有结点；
 * 调用TreePath对象的 Object getLastPathComponent()方法，得到当前选中结点
 * 二：
 * 调用JTree对象的 Object getLastSelectedPathComponent() 方法获取当前被选中的结点
 * <p>
 * 调用DefaultTreeModel数据模型有关增删改的一系列方法完成编辑，方法执行完后，会自动重绘JTree
 * <p>
 * 1. 获取当前被选中的结点：
 *
 * @author : zxq
 * @create : 2022/8/11 0:08
 */
public class EditTree {
    JFrame jf = new JFrame("可编辑结点的树");

    //定义几个初始结点
    DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
    DefaultMutableTreeNode guangdong = new DefaultMutableTreeNode("广东");
    DefaultMutableTreeNode guangxi = new DefaultMutableTreeNode("广西");
    DefaultMutableTreeNode foshan = new DefaultMutableTreeNode("佛山");
    DefaultMutableTreeNode shantou = new DefaultMutableTreeNode("汕头");
    DefaultMutableTreeNode guilin = new DefaultMutableTreeNode("桂林");
    DefaultMutableTreeNode nanning = new DefaultMutableTreeNode("南宁");

    //定义按钮，完成操作
    JButton addSiblingBtn = new JButton("添加兄弟结点");
    JButton addChildBtn = new JButton("添加子结点");
    JButton deleteBtn = new JButton("删除结点");
    JButton editBtn = new JButton("编辑当前结点");


    public void init() {

        //通过add()方法建立父子层级关系
        guangdong.add(foshan);
        guangdong.add(shantou);
        guangxi.add(guilin);
        guangxi.add(nanning);
        root.add(guangdong);
        root.add(guangxi);

        JTree tree = new JTree(root);

        //完成输的结点编辑的代码
        tree.setEditable(true);
        DefaultTreeModel model = (DefaultTreeModel) tree.getModel();

        //处理添加
        addSiblingBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // 添加兄弟节点
                // 1、获取当前选中的节点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) {
                    return;
                }
                //2.获取当前结点的父结点
                DefaultMutableTreeNode parentNode = (DefaultMutableTreeNode) selectedNode.getParent();
                if (parentNode == null) {
                    return;
                }
                //3.创建新结点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

                //4.把新结点通过父结点进行添加
                int index = parentNode.getIndex(selectedNode);
                model.insertNodeInto(newNode, parentNode, index);

                //5.显示新结点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);

                //6.重绘tree
                tree.updateUI();
            }
        });

        addChildBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //为选中结点添加子节点
                //1.获取选中结点
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();
                if (selectedNode == null) {
                    return;
                }

                //2.创建新结点
                DefaultMutableTreeNode newNode = new DefaultMutableTreeNode("新结点");

                //3.把新结点添加到当前结点中
                selectedNode.add(newNode);

                //4.显示新结点
                TreeNode[] pathToRoot = model.getPathToRoot(newNode);
                TreePath treePath = new TreePath(pathToRoot);
                tree.scrollPathToVisible(treePath);

                //5.重绘UI
                tree.updateUI();
            }
        });


        //处理删除
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) tree.getLastSelectedPathComponent();

                if (selectedNode != null && selectedNode.getParent() != null) {
                    model.removeNodeFromParent(selectedNode);
                }
            }
        });

        //处理编辑
        editBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取当前选中结点的路径
                TreePath selectionPath = tree.getSelectionPath();

                //判断如果路径不为空，则设置该路径的最后一个结点可编辑
                if (selectionPath != null) {
                    tree.startEditingAtPath(selectionPath);
                }
            }
        });

        Box hb = Box.createVerticalBox();
        hb.add(new JScrollPane(tree));

        jf.add(hb);

        JPanel panel = new JPanel();
        panel.add(addSiblingBtn);
        panel.add(addChildBtn);
        panel.add(deleteBtn);
        panel.add(editBtn);

        jf.add(panel, BorderLayout.SOUTH);

        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocation(500, 500);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new EditTree().init();
    }


}
