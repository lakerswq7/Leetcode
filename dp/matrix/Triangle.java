package dp.matrix;
import java.util.List;
/*
 * matrix dp往往能通过优化扫描顺序减小空间的使用
 * 0. 不能排序, 找最短路径, matrix -> dp
 * 1. f[i] -> 每一层第i个节点到底部的最短路径
 * 2. f[i] = min(f[i] + f[i - 1]) + x[i] -> 等于前下面一层的第i个节点和第i + 1个节点中小的那个加上这个节点自己的值
 * 3. 在最底层, f[i] = x[i] -> 初始化为，所有底层节点的值为它节点本身的值
 * 4. 第一层，返回f[0] -> 答案为第一层的时候，唯一一个节点的值
 * 
 * 只用O(n)的空间，一个数组复用，因为扫描的顺序，f[i] = f[i] + f[i + 1], f[i + 1] = f[i + 1] + f[i + 2]
 * 每次只会修改前一个位置，当下一个位置扫描的时候，只需要后一个位置的值，所以不会冲突，这里从底向上比从上向下要好
 * 如果用递归的方法，则需要开辟O(n^2)的空间，因为需要给每一个元素都开辟一个空间，存储从这个元素到底部的最小路径
 */

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size();
        int[] hash = new int[len];
        List<Integer> row;
        for (int i = len - 1; i >= 0; i--) {
            row = triangle.get(i);
            for (int j = 0; j < row.size(); j++) {
                if (i == len - 1) {
                    hash[j] = row.get(j);
                } else {
                    hash[j] = Math.min(hash[j], hash[j + 1]) + row.get(j);
                }
            }
        }
        return hash[0];
    }
}
