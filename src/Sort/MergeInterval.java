package Sort;

import java.util.*;

public class MergeInterval {
	 public class Interval {
		     int start;
		     int end;
		     Interval() { start = 0; end = 0; }
		     Interval(int s, int e) { start = s; end = e; }
		 }
	 
	

	    public List<Interval> merge(List<Interval> intervals) {
	    	
	    	if (intervals == null || intervals.size() == 0) {
	    		return intervals;
	    	}
	    	//sort intervals according Interval.start
	        Collections.sort(intervals, new Comparator<Interval>() {
				public int compare(Interval o1, Interval o2) {
					return o1.start - o2.start;
				}
	        });
	        Interval pre = intervals.get(0);
	        Interval current = null;
	        //merge
	       for (int i = 1; i < intervals.size(); i++) {
	    	   current = intervals.get(i);
	    	   //merge
	    	   if (current.start  <= pre.end) {
	    		   Interval mergeInterval = new Interval(pre.start, Math.max(pre.end, current.end));
	    		   //remove pre and current
	    		   intervals.remove(i - 1);
	    		   intervals.remove(i - 1);
	    		   intervals.add(i - 1, mergeInterval);
	    		   i = i - 1;
	    		   pre = intervals.get(i);
	    	   } else {
	    		   pre = current;
	    	   }
	       }
	       
	       return intervals;    
	    }
}
