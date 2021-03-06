package com.zrp.core.assist;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import android.graphics.Bitmap;

import com.zrp.cache.memory.MemoryCacheAware;


public class MemoryCacheUtil {

	private static final String URI_AND_SIZE_SEPARATOR = "_";
	private static final String WIDTH_AND_HEIGHT_SEPARATOR = "x";
	
	private MemoryCacheUtil()
	{
	}
	
	public static String generateKey(String imageUri, ImageSize targetSize) {
		return new StringBuilder(imageUri).append(URI_AND_SIZE_SEPARATOR).append(targetSize.getWidth()).append(WIDTH_AND_HEIGHT_SEPARATOR)
				.append(targetSize.getHeight()).toString();
	}
	
	public static Comparator<String> createFuzzyKeyComparator()
	{
		return new Comparator<String>(){

			public int compare(String key1, String key2) {
				String imageUri1 = key1.substring(0, key1.lastIndexOf(URI_AND_SIZE_SEPARATOR));
				String imageUri2 = key2.substring(0, key2.lastIndexOf(URI_AND_SIZE_SEPARATOR));
				return imageUri1.compareTo(imageUri2);
			}
		};
	}
	
	public static List<Bitmap> findCachedBitmapsForImageUri(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache)
	{
		List<Bitmap> values = new ArrayList<Bitmap>();
		for(String key : memoryCache.keys())
		{
			if(key.startsWith(imageUri))
			{
				values.add(memoryCache.get(key));
			}
		}
		return values;
	}
	
	public static List<String> findCacheKeysForImageUri(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache)
	{
		List<String> values = new ArrayList<String>();
		for(String key : memoryCache.keys())
		{
			if(key.startsWith(imageUri))
			{
				values.add(key);
			}
		}
		return values;
	}
	
	public static void removeFromCache(String imageUri, MemoryCacheAware<String, Bitmap> memoryCache) {
		List<String> keysToRemove = new ArrayList<String>();
		for (String key : memoryCache.keys()) {
			if (key.startsWith(imageUri)) {
				keysToRemove.add(key);
			}
		}
		for (String keyToRemove : keysToRemove) {
			memoryCache.remove(keyToRemove);
		}
	}
}
