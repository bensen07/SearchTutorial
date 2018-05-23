package org.benz.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class CallableExample {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(10);
		List<Future<Boolean>> futureTasks = new ArrayList<Future<Boolean>>();

		for (int i = 0; i < 100; i++) {
			int count = i;
			futureTasks.add(exe.submit(() -> {
				System.out.println("Task[" + count + "]");
				try {

					Thread.sleep(5000L);
					System.out.println("Waking Task[" + count + "]");

				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return true;
			}));

		}

		exe.shutdown();

		boolean running = false;
		while (running) {
			running = false;
			for (int i = 0; i < futureTasks.size(); i++) {
				if (!futureTasks.get(i).isDone()) {
					running = true;
					break;
				}
			}

		}
		
		try {
			exe.awaitTermination(600, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
