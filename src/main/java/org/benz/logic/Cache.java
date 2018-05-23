package org.benz.logic;

import java.util.HashMap;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Cache {

	private static Cache instance;
	private Boolean stop;
	private Map<String, Object> cache;
	private int loadTime = 0;

	private Cache() {
		cache = new HashMap<String, Object>();
		stop = false;
		TimerTask timerTask = new TimerTask() {

			@Override
			public void run() {
				System.out.println("Timer task");
				if (!stop) {
					loadCache();
					loadTime++;
					System.out.println("Icrementing LoadTime " + loadTime);
				}

			}
		};

		Timer timer = new Timer("LoadingCache");
		timer.scheduleAtFixedRate(timerTask, 0L, 600L);

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {

				System.out.println("LoadTime " + loadTime);
				while (true) {
					if (loadTime == 10) {
						System.out.println("Stopping LoadCache");
						timer.cancel();
						break;
					} else {
						try {
							Thread.sleep(600L);
						} catch (InterruptedException e) {
							break;
						}
					}
				}

			}
		}, "LoadCacheStopper");
		t.start();

	}

	public static Cache getInstance() {
		if (null == instance) {
			instance = new Cache();
		}
		return instance;
	}

	public void put(String key, Object val) {
		cache.put(key, val);
	}

	public Object get(String key) {
		return this.cache.get(key);
	}

	public void loadCache() {
		System.out.println("Loading Cache");
		this.cache.put("Ben", 34);
		this.cache.put("Jny", 31);
		this.cache.put("Blessy", 34);
		this.cache.put("Blessen", 38);
	}

}
