package org.benz.logic;

public class CacheUser {

	public static void main(String[] args) {
		Cache dbCache = Cache.getInstance();
		System.out.println(dbCache.get("Ben"));

	}

}
