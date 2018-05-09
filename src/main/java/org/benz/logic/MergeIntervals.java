package org.benz.logic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MergeIntervals {

	public static void main(String[] args) {

		List<Interval> intervals = new ArrayList<Interval>();
		intervals.add(new Interval(2, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(6, 10));
		intervals.add(new Interval(10, 18));
		List<Interval> result = new ArrayList<Interval>();

		Collections.sort(intervals, new Comparator<Interval>() {
			@Override
			public int compare(Interval o1, Interval o2) {
				if (o1.getStart() != o2.getStart()) {
					return o1.getStart() - o2.getStart();
				} else {
					return o1.getEnd() - o2.getEnd();
				}
			}
		});
		System.out.println("Start " + intervals);
		Interval pre = intervals.get(0);
		for (int i = 0; i < intervals.size(); i++) {
			Interval curr = intervals.get(i);
			if (curr.getStart() > pre.getEnd()) {
				System.out.println("Adding:" + curr);
				result.add(pre);
				pre = curr;
			} else {
				Interval merged = new Interval(pre.getStart(), Math.max(curr.getEnd(), pre.getEnd()));
				System.out.println("Merged " + merged);
				pre = merged;
			}

		}
		System.out.println("Finally Adding " + pre);
		result.add(pre);

		System.out.println("Final Result:" + result);
	}

}
