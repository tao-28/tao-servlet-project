package com.tao.cache;

import java.util.HashSet;
import java.util.Set;

public class UserIdCache {

	public static Set<String> userIdSet = null;

	public static Set<String> getInstance() {
		if (userIdSet == null) {
			userIdSet = new HashSet<>();
		}
		return userIdSet;
	}
}
