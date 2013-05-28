package com.zrp.cache.memory.impl;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import android.graphics.Bitmap;

import com.zrp.cache.memory.LimitedMemoryCache;

public class LRULimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>{
	
	private static final int INITIAL_CAPACITY = 10;
	private static final float LOAD_FACTOR = 1.1f;
	
	private final Map<String,Bitmap> lruCache = Collections.synchronizedMap(new HashMap<String, Bitmap>());
	

	public LRULimitedMemoryCache(int maxSize)
	{
		super(maxSize);
	}
	
	@Override
	public boolean put(String key, Bitmap value)
	{
		if(super.put(key, value))
		{
			lruCache.put(key, value);
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public Bitmap get(String key)
	{
		lruCache.get(key);
		return super.get(key);
	}
	
	@Override
	public void remove(String key)
	{
		lruCache.remove(key);
		super.remove(key);
	}
	
	@Override
	public void clear()
	{
		lruCache.clear();
		super.clear();
	}
	
	@Override
	protected int getSize(Bitmap value)
	{
		return value.getRowBytes()*value.getHeight();
	}
	
	@Override
	protected Bitmap removeNext()
	{
		Bitmap mostLongUsedValue = null;
		synchronized (lruCache) {
			Iterator<Entry<String, Bitmap>> it = lruCache.entrySet().iterator();
			if(it.hasNext())
			{
				Entry<String, Bitmap> entry = it.next();
				mostLongUsedValue = entry.getValue();
			}
		}
		return mostLongUsedValue;
	}
	
	@Override
	protected Reference<Bitmap> createReference(Bitmap value)
	{
		return new WeakReference<Bitmap>(value);
		
	}
}
