package datastructure.iterator;

import java.util.Iterator;

public class PeekingIterator {
	// Java Iterator interface reference:
	// https://docs.oracle.com/javase/8/docs/api/java/util/Iterator.html
	class PeekingIterator2 implements Iterator<Integer> {
	    int next;
	    boolean hasNext;
	    Iterator<Integer> iter;
		public PeekingIterator2(Iterator<Integer> iterator) {
		    // initialize any member here.
		    iter = iterator;
		    hasNext = false;
		    if (iter.hasNext()) {
		        next = iter.next();
		        hasNext = true;
		    }
		}

	    // Returns the next element in the iteration without advancing the iterator.
		public Integer peek() {
	        if (hasNext) {
	            return next;
	        }
	        return 0;
		}

		// hasNext() and next() should behave the same as in the Iterator interface.
		// Override them if needed.
		@Override
		public Integer next() {
		    if (hasNext) {
		        int temp = next;
		        if (iter.hasNext()) {
		            next = iter.next();
		            hasNext = true;
		        } else {
		            hasNext = false;
		        }
		        return temp;
		    }
		    return 0;
		}

		@Override
		public boolean hasNext() {
		    return hasNext;
		}

		@Override
		public void remove() {
			// TODO Auto-generated method stub
			
		}
	}
}
