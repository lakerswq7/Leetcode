package array;
import java.util.LinkedList;
import java.util.Queue;
/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.

Each element is either an integer, or a list -- whose elements may also be integers or other lists.

Example 1:
Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)

Example 2:
Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at depth 3; 1 + 4*2 + 6*3 = 27)
 */
import java.util.List;

/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedListWeightSum {
	/*
	 * 这里实际上是DFS的解法，如果不想用递归的话，也可以用BFS的解法，那样需要用到queue，每碰到nestedlist就把他
	 * 加入queue， 碰到整数，就计算并加到结果里，注意维护depth的值
	 */
    public int depthSum(List<NestedInteger> nestedList) {
        return getSum(nestedList, 1);
    }
    private int getSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (NestedInteger n : nestedList) {
            if (n.isInteger()) {
                sum += depth * n.getInteger();
            } else {
                sum += getSum(n.getList(), depth + 1);
            }
        }
        return sum;
    }
    
    /*
     * Iteration
     */
	public int depthSum2(List<NestedInteger> nestedList) {
		Queue<NestedInteger> queue = new LinkedList<NestedInteger>();
		int sum = 0, depth = 1;
		for (NestedInteger n : nestedList){
			if (n.isInteger()) {
				sum += n.getInteger();
			} else {
				queue.offer(n);
			}
		}
		while (!queue.isEmpty()) {
			int size = queue.size();
			depth++;
			for (int i = 0; i < size; i++) {
				NestedInteger cur =  queue.poll();
				for (NestedInteger n : cur.getList()) {
					if (n.isInteger()) {
						sum += n.getInteger() * depth;
					} else {
						queue.offer(n);
					}
				}
			}
		}
		return sum;
	}
    public interface NestedInteger {
    	// @return true if this NestedInteger holds a single integer, rather than a nested list.
    	public boolean isInteger();
    	
    	// @return the single integer that this NestedInteger holds, if it holds a single integer
    	// Return null if this NestedInteger holds a nested list
    	public Integer getInteger();
    	
    	// @return the nested list that this NestedInteger holds, if it holds a nested list
    	// Return null if this NestedInteger holds a single integer
    	public List<NestedInteger> getList();
    }
}
