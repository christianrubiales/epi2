package epi2._10sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RenderCalendar {
	
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
	
	static class Entry {
		boolean start;
		int time;
		
		Entry(boolean start, int time) {
			this.start = start;
			this.time = time;
		}
	}
	
	static int getMaxConcurrent(List<Event> events) {
		
		List<Entry> entries = new ArrayList<>();
		for (Event event : events) {
			entries.add(new Entry(true, event.start));
			entries.add(new Entry(false, event.end));
		}
		
		Collections.sort(entries, new Comparator<Entry>() {
			@Override
			public int compare(Entry e1, Entry e2) {
				if (e1.time != e2.time) {
					return e1.time - e2.time;
				}
				
				if (e1.start && !e2.start) {
					return -1;
				} else if (!e1.start && e2.start) {
					return 1;
				}
				
				return 0;
			}
		});
		
		int maxConcurrent = 0;
		int x = 0;
		for (Entry entry : entries) {
			if (entry.start) {
				maxConcurrent = Math.max(maxConcurrent, ++x);
			} else {
				x--;
			}
		}
		
		return maxConcurrent;
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
		
		System.out.println(getMaxConcurrent(events)); // 3
	}

}
