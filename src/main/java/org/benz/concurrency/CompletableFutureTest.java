package org.benz.concurrency;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureTest {

	public static void main(String[] args) {
		CompletableFuture<Integer> comp = CompletableFuture.supplyAsync(() -> {
			try {
				Thread.sleep(500l);
				System.out.println("CompletableFuture done");
			} catch (Exception e) {
				e.printStackTrace();
			}
			return 20;
		}).thenApply((count) -> {
			System.out.println("Executing callback");
			return count * 15;
		});

		try {
			int count = comp.get();
			System.out.println("Count " + count);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
