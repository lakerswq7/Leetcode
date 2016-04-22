package datastructure.iterator;

import java.util.Iterator;
import java.util.List;

/**
 * Implement an iterator to flatten a 2d vector.

For example,
Given 2d vector =

[
  [1,2],
  [3],
  [4,5,6]
]
By calling next repeatedly until hasNext returns false, the order of elements returned by next should be: [1,2,3,4,5,6].

Hint:

How many variables do you need to keep track?
Two variables is all you need. Try with x and y.
Beware of empty rows. It could be the first few rows.
To write correct code, think about the invariant to maintain. What is it?
The invariant is x and y must always point to a valid point in the 2d vector. Should you maintain your invariant ahead of time or right when you need it?
Not sure? Think about how you would implement hasNext(). Which is more complex?
Common logic in two different places should be refactored into a common method.
Follow up:
As an added challenge, try to code it using only iterators in C++ or iterators in Java.
 */
public class Flatten2DVector {
	public class Vector2D implements Iterator<Integer> {
	    Iterator<List<Integer>> iterator1;
	    Iterator<Integer> iterator2;
	    public Vector2D(List<List<Integer>> vec2d) {
	        iterator1 = vec2d.iterator();
	        iterator2 = null;
	    }

	    @Override
	    public Integer next() {
	        if (hasNext()) {
	            return iterator2.next();
	        }
	        return -1;
	    }

	    @Override
	    public boolean hasNext() {
	        while ((iterator2 == null || !iterator2.hasNext()) && iterator1.hasNext()) {
	            iterator2 = iterator1.next().iterator();
	        }
	        return iterator2 != null && iterator2.hasNext();
	    }

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}

/**
 * Your Vector2D object will be instantiated and called as such:
 * Vector2D i = new Vector2D(vec2d);
 * while (i.hasNext()) v[f()] = i.next();
 */