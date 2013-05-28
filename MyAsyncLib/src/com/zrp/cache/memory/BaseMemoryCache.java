package com.zrp.cache.memory;

import java.lang.ref.Reference;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public abstract class BaseMemoryCache<K,V> implements MemoryCacheAware<K, V>{

	private final Map<K,Reference<V>> softMap = Collections.synchronizedMap(new HashMap<K, Reference<V>>());

	@Override
	public boolean put(K key, V value) {
		softMap.put(key,createReference(value));
		return true;
	}

	@Override
	public V get(K key) {
		// TODO Auto-generated method stub
		V result = null;
		Reference<V> reference = softMap.get(key);
		if(reference !=null)
		{
			result = reference.get();
		}
		return result;
	}

	@Override
	public void remove(K key) {
		// TODO Auto-generated method stub
		softMap.remove(key);
	}

	@Override
	public Collection<K> keys() {
		// TODO Auto-generated method stub
		synchronized (softMap) {
			return new HashSet<K>(softMap.keySet());
		}
	}

	@Override
	public void clear() {
		softMap.clear();
	}
	
	protected abstract Reference<V> createReference(V value);
	
	
	
}
