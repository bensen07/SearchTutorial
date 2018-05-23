package org.benz.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class SemaphoresTest {

	public static void main(String[] args) {
		ExecutorService exe = Executors.newFixedThreadPool(10);

		Semaphore sem = new Semaphore(5);

		Runnable run = () -> {
			boolean permit = false;
			try {
				permit = sem.tryAcquire(1, TimeUnit.SECONDS);
				if (permit) {
					System.out.println("Semaphore Permit acquired " + sem.availablePermits());
					Thread.sleep(6000L);
				} else {
					System.out.println("Semaphore Permit Not acquired " + sem.availablePermits());
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} finally {
				if (permit) {
					sem.release();
				}
			}

		};

		IntStream.range(0, 10).forEach((i) -> {
			exe.submit(run);
		});

		exe.shutdown();

		try {
			exe.awaitTermination(1, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
