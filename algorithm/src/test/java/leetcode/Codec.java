package leetcode;

/**
 * 序列化是将数据结构或对象转换为一系列位的过程，以便它可以存储在文件或内存缓冲区中，或通过网络连接链路传输，以便稍后在同一个或另一个计算机环境中重建。
 * <p>
 * 设计一个算法来序列化和反序列化 二叉搜索树 。 对序列化/反序列化算法的工作方式没有限制。 您只需确保二叉搜索树可以序列化为字符串，并且可以将该字符串反序列化为最初的二叉搜索树。
 * <p>
 * 编码的字符串应尽可能紧凑。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * 输入：root = [2,1,3]
 * 输出：[2,1,3]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-bst
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/12 14:32
 */
public class Codec {
    /**
     * 考察的是搜索二叉树的后序遍历
     * 递归方案
     */

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        String l = serialize(root.left);
        String r = serialize(root.right);

        String val = String.valueOf(root.val);

        if (l != null && r != null) {
            return String.join(",", l, r, val);
        } else if (l == null && r != null) {
            return String.join(",", r, val);
        } else if (r == null && l != null) {
            return String.join(",", l, val);
        }
        return val;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()) {
            return null;
        }
        String[] split = data.split(",");
        return deserialize(split, 0, split.length);
    }

    private TreeNode deserialize(String[] datas, int start, int end) {
        if (start >= end) {
            return null;
        }

        int root = Integer.parseInt(datas[end - 1]);
        TreeNode node = new TreeNode(root);

        int i = start;
        for (; i < end - 1; i++) {
            int val = Integer.parseInt(datas[i]);
            if (val > root) {
                break;
            }
        }

        node.left = deserialize(datas, start, i);
        node.right = deserialize(datas, i, end - 1);
        return node;
    }

    public static void main(String[] args) {
        String data = "2,1,3";

        Codec codec = new Codec();
        TreeNode node = codec.deserialize(data);

        String serialize = codec.serialize(node);
        System.out.println(serialize);
    }
}


