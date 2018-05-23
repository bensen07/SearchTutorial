package org.benz.concurrency;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteLockTest {

	public static void main(String[] args) {
		ReadWriteLock lock = new ReentrantReadWriteLock();
		Map<String, String> cache = new ConcurrentHashMap<>();
		ExecutorService exe = Executors.newFixedThreadPool(2);

		exe.submit(() -> {
			lock.writeLock().lock();
			try {
				cache.put("test1", "Benson");
				Thread.sleep(6000L);
				System.out.println("Done inserting val");
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.writeLock().unlock();
			}
		});

		Runnable run = () -> {
			lock.readLock().lock();
			try {
				System.out.println(cache.get("test1"));
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				lock.readLock().unlock();
			}
		};
		exe.submit(run);
		exe.submit(run);

		exe.shutdown();
		try {
			exe.awaitTermination(500, TimeUnit.MILLISECONDS);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
