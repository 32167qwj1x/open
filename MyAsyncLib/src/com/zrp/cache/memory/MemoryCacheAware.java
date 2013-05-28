package com.zrp.cache.memory;

import java.util.Collection; 

public interface MemoryCacheAware<K,V> {
	
	boolean put(K key,V value);
	
	V get(K key);
	
	void remove(K key);
	
	Collection<K> keys();
	
	void clear();
	
}
