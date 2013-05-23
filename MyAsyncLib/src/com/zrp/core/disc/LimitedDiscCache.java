package com.zrp.core.disc;

import java.io.File;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

import com.zrp.core.disc.naming.FileNameGenerator;

public abstract  class LimitedDiscCache extends BaseDiscCache {

	private final AtomicInteger cacheSize;
	private int sizeLimit;
	private final Map<File,Long> lastUsageDates = Collections.synchronizedMap(new HashMap<File, Long>());
	public LimitedDiscCache(File cacheDir,int sizeLimit) {
		this(cacheDir,);
		// TODO Auto-generated constructor stub
	}

	public LimitedDiscCache(File cacaheDir,FileNameGenerator fileNameGenerator,int sizeLimit)
	{
		super(cacaheDir, fileNameGenerator);
		this.sizeLimit  = sizeLimit;
		cacheSize = new AtomicInteger();
		
	}
	
	private void calculateCacheSizeAndFillUsageMap()
	{
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				int size = 0;
				File[] cachedFiles = cacheDir.listFiles();
				if(cachedFiles !=null )
				{
					for(File cachedFile : cachedFiles)
					{
						size += getSize(cachedFile);
						lastUsageDates.put(cachedFile, cachedFile.lastModified());
					}
					cacheSize.set(size);
				}
			}
		}).start();
	}
	
	@Override
	public void put(String key, File file) {
		// TODO Auto-generated method stub
		int valueSize =getSize(file);
		int curCacheSize = cacheSize.get();
		while(curCacheSize + valueSize > sizeLimit)
		{
			int freedSize = removeNext();
			if(freedSize ==0 )break; 
			
		}
	}

	private int removeNext()
	{
		if(lastUsageDates.isEmpty())
		{
			return 0;
		}
		Long oldestUsage = null;
		File mostLongUsedFile =null;
		Set<Entry<File,Long>> entries = lastUsageDates.entrySet();
		synchronized (lastUsageDates) {
			for(Entry<File,Long> entry: entries)
			{
				if(mostLongUsedFile==null)
				{
					mostLongUsedFile = entry.getKey();
					oldestUsage = entry.getValue();
				}else
				{
					Long lastValueUsage = entry.getValue();
					if(lastValueUsage < oldestUsage)
					{
						oldestUsage = lastValueUsage;
						mostLongUsedFile = entry.getKey();
					}
				}
			}
		}
		int fileSize = getSize(mostLongUsedFile);
		if(mostLongUsedFile.delete())
		{
			lastUsageDates.remove(mostLongUsedFile);
		}
		return fileSize;
	}
	
	protected abstract int getSize(File file);
}
