package leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 序列化是将一个数据结构或者对象转换为连续的比特位的操作，进而可以将转换后的数据存储在一个文件或者内存中，同时也可以通过网络传输到另一个计算机环境，采取相反方式重构得到原数据。
 * <p>
 * 请设计一个算法来实现二叉树的序列化与反序列化。这里不限定你的序列 / 反序列化算法执行逻辑，你只需要保证一个二叉树可以被序列化为一个字符串并且将这个字符串反序列化为原始的树结构。
 * <p>
 * 提示: 输入输出格式与 LeetCode 目前使用的方式一致，详情请参阅LeetCode 序列化二叉树的格式。你并非必须采取这种方式，你也可以采用其他的方法解决这个问题。
 * <p>
 *
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：root = [1,2,3,null,null,4,5]
 * 输出：[1,2,3,null,null,4,5]
 * 示例 2：
 * <p>
 * 输入：root = []
 * 输出：[]
 * 示例 3：
 * <p>
 * 输入：root = [1]
 * 输出：[1]
 * 示例 4：
 * <p>
 * 输入：root = [1,2]
 * 输出：[1,2]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/serialize-and-deserialize-binary-tree
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author: Adam
 * @create: 2022/05/13 16:11
 */
public class Codec297 {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "#";
        }

        int val = root.val;
        String l = serialize(root.left);
        String r = serialize(root.right);

        return String.join(",", String.valueOf(val), l, r);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] split = data.split(",");
        Queue<String> queue = new LinkedList<>(Arrays.asList(split));
        return deserialize(queue);
    }

    private TreeNode deserialize(Queue<String> queue) {
        String data = queue.poll();
        if ("#".equals(data)) {
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(data));
        node.left = deserialize(queue);
        node.right = deserialize(queue);

        return node;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l1 = new TreeNode(2);
        TreeNode r1 = new TreeNode(3);
        TreeNode r2 = new TreeNode(4);
        TreeNode r3 = new TreeNode(5);

        root.left = l1;
        root.right = r1;
        r1.left = r2;
        r1.right = r3;
        Codec297 code = new Codec297();
        String serialize = code.serialize(root);
        System.out.println(serialize);


        TreeNode result = code.deserialize(serialize);
        System.out.println();
    }
}
