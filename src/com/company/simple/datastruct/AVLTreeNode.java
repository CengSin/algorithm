package com.company.simple.datastruct;

/**
 * @description: AVLTreeNode
 * @author: 15262
 * @date: 2020/3/30
 */

public class AVLTreeNode {

    private String key;
    private Object value;
    private int height;
    private AVLTreeNode left, right;

    public AVLTreeNode(String key, Object value) {
        this.key = key;
        this.value = value;
        this.height = 0;
    }

    public AVLTreeNode() {
    }

    /**
     * 获取树节点的高度
     *
     * @param root 根节点
     * @return 节点高度
     */
    private int getTreeNodeHeight(AVLTreeNode root) {
        if (root == null) return 0;
        else return Math.max(getTreeNodeHeight(root.left), getTreeNodeHeight(root.right)) + 1;
    }

    /**
     * 计算节点的平衡因子
     *
     * @param root 根节点
     * @return 节点平衡因子
     */
    private int treeGetBalanceFactor(AVLTreeNode root) {
        if (root == null) return 0;
        return Math.abs(getTreeNodeHeight(root.left) - getTreeNodeHeight(root.right));
    }

    /**
     * 树右旋操作
     *
     * @param root 树的根节点
     * @return root 右旋树后的根节点
     */
    private AVLTreeNode treeRotateRight(AVLTreeNode root) {
        AVLTreeNode left = root.left;
        root.left = left.right;
        left.right = root;

        left.height = getTreeNodeHeight(left);
        root.height = getTreeNodeHeight(root);
        return left;
    }

    /**
     * 树左旋操作
     *
     * @param root 树的根节点
     * @return root 左旋树后的根节点
     */
    private AVLTreeNode treeRotateLeft(AVLTreeNode root) {
        AVLTreeNode right = root.right;
        root.right = right.left;
        right.left = root;

        right.height = getTreeNodeHeight(right);
        root.height = getTreeNodeHeight(root);
        return right;
    }

    /**
     * 树的平衡操作
     *
     * @param root 根节点
     * @return 平衡之后树的根节点
     */
    private AVLTreeNode treeBalance(AVLTreeNode root) {
        int factor = treeGetBalanceFactor(root); // 根节点的平衡因子
        if (factor > 1) {
            int leftFactor = treeGetBalanceFactor(root.left);
            int rightFactor = treeGetBalanceFactor(root.right);
            if (leftFactor > 0) { // LL
                return treeRotateRight(root);   // 右旋
            } else if (rightFactor > 0) { // RR
                return treeRotateLeft(root);    // 左旋
            } else if (leftFactor <= 0) {  //LR
                root.left = treeRotateLeft(root.left);
                return treeRotateRight(root);
            } else if (rightFactor <= 0) { // RL
                root.right = treeRotateRight(root.right);
                return treeRotateLeft(root);
            }
        }
        return root;
    }

    /**
     * 向AVL树插入值
     *
     * @param key   值的key
     * @param value 值的value
     */
    public AVLTreeNode insert(String key, Object value) {
        int compareVal = this.key.compareTo(key);
        if (compareVal < 0) {
            if (this.right == null) {
                this.right = new AVLTreeNode(key, value);
            } else {
                this.right.insert(key, value);
            }
        } else if (compareVal > 0) {
            if (this.left == null) {
                this.left = new AVLTreeNode(key, value);
            } else {
                this.left.insert(key, value);
            }
        } else {
            this.value = value;
        }
        return treeBalance(this);
    }

    /**
     * 向AVL树中删除节点的值
     *
     * @param key 要删除的节点的key
     */
    public AVLTreeNode delete(String key) {
        int compareVal = this.key.compareTo(key);
        if (compareVal < 0) {
            if (this.right != null) {
                this.right.delete(key);
            }
        } else if (compareVal > 0) {
            if (this.left != null) {
                this.left.delete(key);
            }
        } else {
            this.value = null;
        }
        return treeBalance(this);
    }

    /**
     * 查询AVL树中节点的值
     *
     * @param key 节点的key
     * @return 节点的值
     */
    public Object query(String key) {
        int compareVal = this.key.compareTo(key);
        if (compareVal < 0) {
            if (this.right != null) {
                return this.right.query(key);
            }
            return null;
        } else if (compareVal > 0) {
            if (this.left != null) {
                return this.left.query(key);
            }
            return null;
        }
        return this.value;
    }
}
