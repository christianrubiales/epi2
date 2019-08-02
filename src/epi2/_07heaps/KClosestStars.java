package epi2._07heaps;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestStars {
	
	static class Star {
		Double x;
		Double y;
		Double z;
		
		Star(Double x, Double y, Double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
		
		Double distance() {
			return Math.sqrt(x*x + y*y + z*z);
		}
		
		@Override
		public String toString() {
			return String.format("[%f,%f,%f]", x, y, z);
		}
	}
	
	static List<Star> getKClosestStars(List<Star> stars, int k) {
		List<Star> closest = new ArrayList<>();

		PriorityQueue<Star> maxHeap = new PriorityQueue<>(new Comparator<Star>() {
			@Override
			public int compare(Star s1, Star s2) {
				return s2.distance().compareTo(s1.distance());
			}
		});

		for (int i = 0; i < k; i++) {
			maxHeap.offer(stars.get(i));
		}
		
		for (int i = k; i < stars.size(); i++) {
			Star next = stars.get(i);
			if (next.distance() < maxHeap.peek().distance()) {
				maxHeap.poll();
				maxHeap.offer(next);
			}
		}

		while (!maxHeap.isEmpty()) {
			closest.add(maxHeap.poll());
		}

		return closest;
	}

	public static void main(String[] args) {
		List<Star> stars = new ArrayList<>();
		stars.add(new Star(6d,6d,6d));
		stars.add(new Star(5d,5d,5d));
		stars.add(new Star(4d,4d,4d));
		stars.add(new Star(3d,3d,3d));
		stars.add(new Star(2d,2d,2d));
		stars.add(new Star(1d,1d,1d));
		System.out.println(getKClosestStars(stars, 3));
	}

}
