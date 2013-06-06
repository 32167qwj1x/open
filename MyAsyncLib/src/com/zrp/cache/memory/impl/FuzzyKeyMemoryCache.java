package com.zrp.cache.memory.impl;

import java.util.Collection;
import java.util.Comparator;

import com.zrp.cache.memory.MemoryCacheAware;

public class FuzzyKeyMemoryCache<K,V> implements MemoryCacheAware<K, V> {

	private final MemoryCacheAware<K,V> cache;
	private final Comparator<K> keyComparator;
	
	public FuzzyKeyMemoryCache(MemoryCacheAware<K,V> cache,Comparator<K> keyComparator)
	{
		this.cache = cache;
		this.keyComparator = keyComparator;
	}
	
	public boolean put(K key, V value) {
		// TODO Auto-generated method stub
		synchronized (cache) {
			K keyToRemove =null;
			for(K cacheKey : cache.keys())
			{
				if(keyComparator.compare(key, cacheKey) ==0 )
				{
					keyToRemove = cacheKey;
					break;
				}
			}
			if(keyToRemove != null)
			{
				cache.remove(keyToRemove);
			}
		}
		return cache.put(key, value);
	}

	public V get(K key) {
		return cache.get(key);
	}

	public void remove(K key) {
		cache.remove(key);
	}

	public Collection<K> keys() {
		return cache.keys();
	}

	public void clear() {
		// TODO Auto-generated method stub
		cache.clear();
	}
	
}
