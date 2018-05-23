package org.benz.concurrency;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
	ReentrantLock lock = new ReentrantLock();
	int count = 0;

	public static void main(String[] args) {
		ReentrantLockTest test = new ReentrantLockTest();
		test.incrementCount();
		System.out.println(test.getCurrentCount());
	}

	void incrementCount() {
		lock.lock();
		try {
			count++;
			Thread.sleep(6000L);
			System.out.println("Count Incremented " + count);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	int getCurrentCount() {
		return count;
	}

}
