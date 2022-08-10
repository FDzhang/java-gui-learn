package demoswing.tree;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

/**
 * ### 创建树
 * <p>
 * Swing 使用 JTree 对 象来代表一棵树，JTree 树中结点可以使用 TreePath 来标识，该对象封装了当前结点及其所有的父结点。
 * <p>
 * **当一个结点具有子结点时，该结点有两种状态：**
 * <p>
 * ​	展开状态:当父结点处于展开状态时，其子结点是可见的；
 * <p>
 * ​	折叠状态: 当父结点处于折叠状态时，其子结点都是不可见的 。
 * <p>
 * 如果某个结点是可见的，则该结点的父结点(包括直接的、间接的父结点)都必须处于展开状态，只要有任意一个父结点处于折叠状态，该结点就是不可见的 。
 * <p>
 * JTree常用构造方法：
 * JTree(TreeModel newModel):使用指定 的数据模型创建 JTree 对象，它默认显示根结点。
 * JTree(TreeNode root): 使用 root 作为根节 点创建 JTree 对象，它默认显示根结点 。
 * JTree(TreeNode root, boolean asksAllowsChildren):
 * 使用root作为根结点创建JTree对象，它默认显示根结点。
 * asksAllowsChildren 参数控制怎样的结点才算叶子结点，
 * 如果该参数为 true ，则只有当程序使用 setAllowsChildren(false)显式设置某个结点不允许添加子结点时(以后也不会拥有子结点) ，该结点才会被 JTree 当成叶子结点:如果该参数为 false ，则只要某个结点当时没有子结点(不管以后是否拥有子结点) ，该结点都会被 JTree 当成叶子结点。
 *
 * @author : zxq
 * @create : 2022/8/11 0:03
 */
public class SimpleJTree {
    JFrame jf = new JFrame("简单树");

    public void init() {
        //创建DefaultMutableTreeNode对象代表结点
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("中国");
        DefaultMutableTreeNode guangDong = new DefaultMutableTreeNode("广东");
        DefaultMutableTreeNode guangXi = new DefaultMutableTreeNode("广西");
        DefaultMutableTreeNode foShan = new DefaultMutableTreeNode("佛山");
        DefaultMutableTreeNode shanTou = new DefaultMutableTreeNode("汕头");
        DefaultMutableTreeNode guiLin = new DefaultMutableTreeNode("桂林");
        DefaultMutableTreeNode nanNing = new DefaultMutableTreeNode("南宁");

        //组装结点之间的关系
        root.add(guangDong);
        root.add(guangXi);

        guangDong.add(foShan);
        guangDong.add(shanTou);

        guangXi.add(guiLin);
        guangXi.add(nanNing);

        //创建JTree对象
        JTree tree = new JTree(root);
        // tree.putClientProperty("JTree.lineStyle", "Horizontal"); //设置结点之间只有水平分割线
        tree.putClientProperty("JTree.lineStyle", "none"); //设置结点之间没有连接线
        // tree.setShowsRootHandles(true); // 设置根结点有"展开、折叠"图标
        // tree.setRootVisible(false); // 隐藏根结点
        //把JTree放入到窗口中进行展示
        jf.add(tree);


        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.pack();
        jf.setLocation(500, 500);
        jf.setVisible(true);

    }

    public static void main(String[] args) {
        new SimpleJTree().init();
    }
}
