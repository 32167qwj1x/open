package com.zrp.core.assist;

import java.io.File;

import com.zrp.cache.disc.DiscCacheAware;

public class DiscCacheUtil {

	private DiscCacheUtil()
	{
		
	}
	
	public static File findInCache(String imageUri,DiscCacheAware discCache)
	{
		File image =discCache.get(imageUri);
		return image.exists() ? image : null;
	}
	
	
	public static boolean removeFromCache(String imageUri,DiscCacheAware discCache)
	{
		File image = discCache.get(imageUri);
		return image.delete();
	}
	
	
}
