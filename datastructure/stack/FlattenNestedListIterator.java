package datastructure.stack;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

/*
 * 也有另外一种写法，就是从后往前把元素放入stack，
 * 然后拿出来取，如果是数，就返回true，
 * 如果不是就递归把元素加入stack
 * 原则就是不断循环直到找到一个数为止
 */
public class FlattenNestedListIterator {
	public class NestedIterator implements Iterator<Integer> {
	    Stack<List<NestedInteger>> stack1;
	    Stack<Integer> stack2;
	    int pos;
	    List<NestedInteger> cur;
	    public NestedIterator(List<NestedInteger> nestedList) {
	        stack1 = new Stack<List<NestedInteger>>();
	        stack2 = new Stack<Integer>();
	        cur = nestedList;
	        pos = 0;
	    }

	    @Override
	    public Integer next() {
	        int val = 0;
	        if (hasNext()) {
	            val = cur.get(pos).getInteger();
	            pos++;
	        }
	        return val;
	    }

	    @Override
	    public boolean hasNext() {
	        while ((pos == cur.size() && !stack1.empty()) || (pos != cur.size() && !cur.get(pos).isInteger())) {
	            if (pos == cur.size()) {
	                cur = stack1.pop();
	                pos = stack2.pop();
	            } else {
	                stack1.push(cur);
	                stack2.push(pos + 1);
	                cur = cur.get(pos).getList();
	                pos = 0;
	            }
	        }
	        return pos != cur.size();
	    }

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
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
/**
 * Your NestedIterator object will be instantiated and called as such:
 * NestedIterator i = new NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack;
    Integer cur;
    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new Stack<Iterator<NestedInteger>>();
        stack.push(nestedList.iterator());
        cur = null;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            return null;
        }
        Integer tmp = cur;
        cur = null;
        return tmp;
    }

    @Override
    public boolean hasNext() {
        if (cur != null) {
            return true;
        }
        while (!stack.empty()) {
            Iterator<NestedInteger> tmpIterator = stack.peek();
            if (tmpIterator.hasNext()) {
                NestedInteger tmp = (NestedInteger)tmpIterator.next();
                if (tmp.isInteger()) {
                    cur = tmp.getInteger();
                    return true;
                } else {
                    stack.push(tmp.getList().iterator());
                }
            } else {
                stack.pop();
            }
        }
        return false;
    }

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
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