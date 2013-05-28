package com.zrp.cache.memory.impl;

import java.lang.ref.Reference;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.graphics.Bitmap;

import com.zrp.cache.memory.LimitedMemoryCache;

public class FIFOLimitedMemoryCache extends LimitedMemoryCache<String, Bitmap>{

	private final List<Bitmap> queue = Collections.synchronizedList(new LinkedList<Bitmap>());
	
	public FIFOLimitedMemoryCache(int sizeLimit)
	{
		super(sizeLimit);
	}
	
	@Override
	protected int getSize(Bitmap value) {
		// TODO Auto-generated method stub
		return value.getRowBytes() * value.getHeight();
	}

	@Override
	protected Bitmap removeNext() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Reference<Bitmap> createReference(Bitmap value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean put(String key, Bitmap value) {
		// TODO Auto-generated method stub
		if(super.put(key, value)){
			queue.add(value);
			return true;
		}else
		{
			return false;
		}
	}

	@Override
	public void remove(String key) {
		// TODO Auto-generated method stub
		Bitmap value = super.get(key);
		if(value!=null)
		{
			queue.remove(value);
		}
		super.remove(key);
	}

	@Override
	public void clear() {
		queue.clear();
		super.clear();
	}

	

}
