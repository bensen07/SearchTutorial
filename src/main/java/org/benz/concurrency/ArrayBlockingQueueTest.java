package org.benz.concurrency;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class ArrayBlockingQueueTest {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(50);

		BlockingQueue<String> queue = new ArrayBlockingQueue<String>(5);

		IntStream.range(0, 100).forEach(i -> {
			exe.submit(() -> {
				try {
					queue.offer("TestString" + i, 2, TimeUnit.SECONDS);
					System.out.println("Write " + "TestString" + i);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		});

		IntStream.range(0, 50).forEach(i -> {
			exe.submit(() -> {
				try {
					System.out.println("Read:" + queue.take());
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		});

		exe.shutdown();
		try {
			exe.awaitTermination(1, TimeUnit.SECONDS);
			System.out.println("Exe Shutdown");
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
