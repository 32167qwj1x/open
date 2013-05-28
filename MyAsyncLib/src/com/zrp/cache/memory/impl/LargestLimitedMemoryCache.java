package com.zrp.cache.memory.impl;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import android.graphics.Bitmap;

import com.zrp.cache.memory.LimitedMemoryCache;

public class LargestLimitedMemoryCache extends LimitedMemoryCache<String,Bitmap>{

	private final Map<Bitmap,Integer> valueSizes= Collections.synchronizedMap(new HashMap<Bitmap, Integer>());
	
	public LargestLimitedMemoryCache(int sizeLimit)
	{
		super(sizeLimit);
	}

	
	public void remove(String key)
	{
		Bitmap value = super.get(key);
		if(value != null)
		{
			valueSizes.remove(value);
		}
		super.remove(key);
	}
	
	
	@Override
	public boolean put(String key, Bitmap value) {
		if(super.put(key, value))
		{
			valueSizes.put(value, getSize(value));
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	protected int getSize(Bitmap value) {
		return value.getRowBytes() * value.getHeight();
	}
	
	

	@Override
	protected Bitmap removeNext() {
		Integer maxSize = null;
		Bitmap largestValue = null;
		Set<Entry<Bitmap,Integer>> entries = valueSizes.entrySet();
		synchronized (valueSizes) {
			for(Entry<Bitmap,Integer> entry : entries)
			{
				 if(largestValue ==null ){
					 largestValue = entry.getKey();
					 maxSize = entry.getValue();
				 }else
				 {
					 Integer size = entry.getValue();
					 if(size > maxSize)
					 {
						 maxSize = size;
						 largestValue = entry.getKey();
					 }
				 }
					 
			}
		}
		valueSizes.remove(largestValue);
		return largestValue;
	}

	@Override
	protected Reference<Bitmap> createReference(Bitmap value) {
		return new WeakReference<Bitmap>(value);
	}
	
	@Override
	public void clear(){
		valueSizes.clear();
		super.clear();
	}
}
