package 二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author 张业荣
 * @Description https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * @Date 2020/1/26
 */
public class _102_二叉树的层次遍历 {


    /**
     * 使用迭代方式打印层序遍历
     *
     * @param root
     * @return
     */
    // 总结：首先是迭代的层序遍历思想 然后叠加层的记录 考虑深度的计算
    public List<List<Integer>> levelOrder(TreeNode root) {
        /**
         * 思路:
         *      1.先默写层序遍历
         *      2.关键点在于1层1层需要记录
         */
        List<List<Integer>> list = new ArrayList<>();

        if (root == null) return list;

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);
        // 这个是记录1层有多少个数据
        Integer levelNum = 1;

        List<Integer> levelList = new ArrayList<>();

        while (!queue.isEmpty()) {

            TreeNode node = queue.poll();

            // 操作
            levelList.add(node.val);
            levelNum--;

            // 入队
            if (node.left != null) {
                queue.offer(node.left);
            }

            if (node.right != null) {
                queue.offer(node.right);
            }

            // 检测levelNum是否为0
            if (levelNum == 0) {
                list.add(levelList);
                levelList = new ArrayList<>();

                levelNum = queue.size();

            }

        }

        return list;

    }

}
