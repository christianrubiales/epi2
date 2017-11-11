package epi2._10sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaximumNonOverlappingEvents {
	
	static class Event {
		int id;
		int start;
		int end;

		Event(int id, int start, int end) {
			this.id = id;
			this.start = start;
			this.end = end;
		}
		
		@Override
		public String toString() {
			return "" + this.id;
		}
	}
	
	static List<Event> getMaxNonOverlapping(List<Event> events) {
		List<Event> nonOverlapping = new ArrayList<>();
		
		// sort descending
		Collections.sort(events, new Comparator<Event>() {
			@Override
			public int compare(Event e1, Event e2) {
				if (e1.end != e2.end) {
					return e1.end - e2.end;
				}
				return e1.start - e2.start;
			}
		});
		
		for (Event event : events) {
			if (nonOverlapping.isEmpty() 
					|| nonOverlapping.get(nonOverlapping.size()-1).end < event.start) {
				nonOverlapping.add(event);
			}
		}
		
		return nonOverlapping;
	}

	public static void main(String[] args) {
		List<Event> events = Arrays.asList(
			new Event(1, 1, 5),
			new Event(2, 6, 10),
			new Event(3, 11, 13),
			new Event(4, 14, 15),
			new Event(5, 2, 7),
			new Event(6, 8, 9),
			new Event(7, 12, 15),
			new Event(8, 4, 5),
			new Event(9, 9, 17)
		);
		
		System.out.println(getMaxNonOverlapping(events));
	}

}
