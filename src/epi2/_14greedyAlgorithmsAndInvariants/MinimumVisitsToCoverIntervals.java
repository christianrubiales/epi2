package epi2._14greedyAlgorithmsAndInvariants;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MinimumVisitsToCoverIntervals {
	
	static class Interval {
		int start;
		int end;
		
		public Interval(int start, int end) {
			this.start = start;
			this.end = end;
		}
	}
	
	static List<Integer> getMinimumVisitsToCoverIntervals(List<Interval> intervals) {
		List<Integer> visits = new ArrayList<>();
		
		if (intervals != null && !intervals.isEmpty()) {
			Collections.sort(intervals, new Comparator<Interval>() {
				@Override
				public int compare(Interval i1, Interval i2) {
					return i1.end - i2.end;
				}
			});
	//		Collections.sort(intervals, (i1, i2) -> i1.end - i2.end);
			
			int lastVisit = intervals.get(0).end;
			visits.add(lastVisit);
			
			for (Interval interval : intervals) {
				if (interval.start > lastVisit) {
					lastVisit = interval.end;
					visits.add(lastVisit);
				}
			}
		}
		
		return visits;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(0, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(3, 4));
		intervals.add(new Interval(6, 9));
		System.out.println(getMinimumVisitsToCoverIntervals(intervals)); //3, 9

		intervals = new ArrayList<>();
		intervals.add(new Interval(1,2));
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(3,4));
		intervals.add(new Interval(2,3));
		intervals.add(new Interval(3,4));
		intervals.add(new Interval(4,5));
		System.out.println(getMinimumVisitsToCoverIntervals(intervals)); //2, 4
		
		System.out.println(getMinimumVisitsToCoverIntervals(new ArrayList<>()));
	}

}
