package com.zrp.cache.memory.impl;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import com.zrp.cache.memory.MemoryCacheAware;

public class LimitedAgeMemoryCache<K,V> implements MemoryCacheAware<K, V> {

	private final MemoryCacheAware<K, V> cache;
	
	private final long maxAge;
	private final Map<K,Long> loadingDates = Collections.synchronizedMap(new HashMap<K, Long>());
	
	public LimitedAgeMemoryCache(MemoryCacheAware<K,V> cache,Long maxAge)
	{
		this.cache = cache;
		this.maxAge = maxAge * 1000;
	}
	
	public boolean put(K key,V value)
	{
		boolean putSuccesfully  = cache.put(key, value);
		if(putSuccesfully)
		{
			loadingDates.put(key, System.currentTimeMillis());
		}
		return putSuccesfully;
	}
	
	public V get(K key)
	{
		Long loadingDate = loadingDates.get(key);
		if(loadingDate != null && System.currentTimeMillis() - loadingDate > maxAge)
		{
			cache.remove(key);
			loadingDates.remove(key);
		}
		return cache.get(key);
	}
	
	public void remove(K key)
	{
		cache.remove(key);
		loadingDates.remove(key);
	}
	
	public Collection<K> keys()
	{
		return cache.keys();
	}
	
	public void clear()
	{
		 cache.clear();
		 loadingDates.clear();
	}
	
	
}
