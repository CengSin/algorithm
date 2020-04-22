package lintcode.chapter2;

import com.company.simple.datastruct.TreeNode;

import java.util.ArrayList;
import java.util.List;

class LintCode_7_Solution {

    public static final String EMPTY_TREE = "{}";

    /**
     * This method will be invoked first, you should design your own algorithm
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(final TreeNode root) {
        if (root == null) return EMPTY_TREE;
        // write your code here

        List<TreeNode> queue = new ArrayList<>();
        queue.add(root);
        for (int i = 0; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (null == node) continue;
            queue.add(node.left);
            queue.add(node.right);
        }

        // 删除queue结尾的空节点
        while (queue.get(queue.size() - 1) == null) {
            queue.remove(queue.size() - 1);
        }

        StringBuilder sb = new StringBuilder("{");
        sb.append(queue.get(0).val);
        for (int i = 1; i < queue.size(); i++) {
            TreeNode node = queue.get(i);
            if (node == null) {
                sb.append(",#");
            } else {
                sb.append(",").append(node.val);
            }
        }
        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in
     * "serialize" method.
     */
    public TreeNode deserialize(final String data) {
        if (data == null || data.length() == 0 || EMPTY_TREE.equals(data)) return null;
        // write your code here
        String nodeStr = data.substring(1, data.length() - 1);
        String[] vals = nodeStr.split(",");
        ArrayList<TreeNode> queue = new ArrayList<>();
        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        int index = 0;
        boolean isLeft = true;
        queue.add(root);
        for (int i = 1; i < vals.length; i++) {
            String val = vals[i];
            if (!"#".equals(val)) {
                TreeNode treeNode = new TreeNode(Integer.parseInt(val));
                if (isLeft) {
                    queue.get(index).left = treeNode;
                } else {
                    queue.get(index).right = treeNode;
                }
                queue.add(treeNode);
            }
            if (!isLeft) {
                index++;
            }
            isLeft = !isLeft;
        }
        return root;
    }

}

public class LintCode_7_SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        LintCode_7_Solution solution = new LintCode_7_Solution();
        String str = "{3,9,20,#,#,15,7}";
        TreeNode root = solution.deserialize(str);
        assert solution.serialize(root).equals(str);
    }

}
