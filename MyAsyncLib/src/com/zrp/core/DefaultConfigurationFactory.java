package com.zrp.core;

import java.io.File;
import java.util.concurrent.Executor;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;

import com.zrp.cache.disc.DiscCacheAware;
import com.zrp.cache.disc.impl.FileCountLimitedDiscCache;
import com.zrp.cache.disc.impl.TotalSizeLimitedDiscCache;
import com.zrp.cache.disc.impl.UnlimitedDiscCache;
import com.zrp.cache.disc.naming.FileNameGenerator;
import com.zrp.cache.disc.naming.HashCodeFileNameGenerator;
import com.zrp.cache.memory.MemoryCacheAware;
import com.zrp.cache.memory.impl.LRULimitedMemoryCache;
import com.zrp.cache.memory.impl.LruMemoryCache;
import com.zrp.core.assist.QueueProcessingType;
import com.zrp.core.decode.BaseImageDecoder;
import com.zrp.core.decode.ImageDecoder;
import com.zrp.core.download.BaseImageDownloader;
import com.zrp.core.download.ImageDownloader;
import com.zrp.core.utils.StorageUtils;

/**
 * Factory for providing of default options for{@linkplain ImageLoadierConfiguration configuration}
 * 
 * @author aaa
 *
 */
public class DefaultConfigurationFactory {

	/**
	 * Creates default implementation of task executor 
	 * @param threadPollSize
	 * @param threadPriority
	 * @param tasksProcessingType
	 * @return
	 */
	public static Executor createExecutor(int threadPollSize, int threadPriority,QueueProcessingType tasksProcessingType)
	{
		boolean lifo = tasksProcessingType == QueueProcessingType.LIFO;
//		BlockingQueue<Runnable> taskQueue = lifo? new
		return null;
	}
	
	/**
	 * Creates {@linkplain HashCodeFileNameGenerator default implementation} of FileNameGenerator} 
	 * @return
	 */
	public static FileNameGenerator createFileNameGenerator()
	{
		return new HashCodeFileNameGenerator();
	}
	
	/**
	 * Creates default implementation of {@link DisckCacheAware} de
	 * @param context
	 * @param discCacheFileNameGenerator
	 * @param discCacheFileCount
	 * @return
	 */
	public static DiscCacheAware createDiscCache(Context context, FileNameGenerator discCacheFileNameGenerator,int discCacheSize,int discCacheFileCount)
	{  
		if(discCacheSize > 0) {
			File individualCacheDir = StorageUtils.getIndividualCacheDirectory(context);
			return new TotalSizeLimitedDiscCache(individualCacheDir, discCacheFileNameGenerator,discCacheSize);
		}else if(discCacheFileCount > 0)
		{
			File individualCacheDir = StorageUtils.getIndividualCacheDirectory(context);
			return new FileCountLimitedDiscCache(individualCacheDir, discCacheFileNameGenerator, discCacheFileCount);
		}else {
			File cacheDir = StorageUtils.getCacheDirectory(context);
			return new UnlimitedDiscCache(cacheDir, discCacheFileNameGenerator);
		}
	}
	
	/**
	 * Creates reserve disc cache which will be used if primary disc cache becomes unvailable
	 * @param context
	 * @return
	 */
	public static DiscCacheAware createReserveDiscCache(Context context)
	{
		File cacheDir = context.getCacheDir();
		File individualDir = new File(cacheDir,"uil-images");
		if(individualDir.exists() || individualDir.mkdir()){
			cacheDir = individualDir;
		}
		return new TotalSizeLimitedDiscCache(cacheDir, 2 * 1024 * 1024); //limit - 2MB
	}
	
	public static MemoryCacheAware<String, Bitmap> createMemoryCache(int memoryCacheSize)
	{
		if(memoryCacheSize == 0 )
		{
			memoryCacheSize =  (int) (Runtime.getRuntime().maxMemory() / 8);
		}
		
		MemoryCacheAware<String, Bitmap> memoryCache;
		if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.GINGERBREAD)
		{
			memoryCache = new LruMemoryCache(memoryCacheSize);
		} else {
			memoryCache = new LRULimitedMemoryCache(memoryCacheSize);
		}
		return memoryCache;
	}
	
	public static ImageDownloader createImageDownloader(Context context)
	{
	    return new BaseImageDownloader(context);	
	}
	
	
	public static ImageDecoder createImageDecoder(boolean loggingEnabled)
	{
		return new BaseImageDecoder(loggingEnabled);
	}
	
	
	
	
}
