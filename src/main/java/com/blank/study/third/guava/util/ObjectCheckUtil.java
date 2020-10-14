package com.blank.study.third.guava.util;

import org.checkerframework.checker.nullness.qual.NonNull;

/**
 * Check Object Something
 * @author wudc
 * @date 2020/10/12 12:08
 */
public class ObjectCheckUtil {

	/**
	 * Check not null
	 */
	public static <T extends @NonNull Object> T checkNotNull(T object) {
		if (object instanceof String) {
			if (((String) object).isEmpty()) {
				object = null;
			}
		}
		if (object == null) {
			throw new NullPointerException();
		}
		return object;
	}
}
