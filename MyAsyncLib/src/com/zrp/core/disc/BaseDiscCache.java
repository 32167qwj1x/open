package com.zrp.core.disc;

import java.io.File;

import com.zrp.core.DefaultConfigurationFactory;
import com.zrp.core.disc.naming.FileNameGenerator;


public abstract class BaseDiscCache implements DiscCacheAware{

	private static final String ERROR_ARG_NULL="\"%s\" argument must be not null";
	
	protected File cacheDir;
	
	private FileNameGenerator fileNameGenerator;
	
	public BaseDiscCache(File cacheDir)
	{
		this(cacheDir,DefaultConfigurationFactory.createFileNameGenerator());
	}
	
	public BaseDiscCache(File cacheDir,FileNameGenerator fileNameGenerator)
	{
		if(cacheDir == null )
		{
			throw new IllegalArgumentException("cacheDir"+ERROR_ARG_NULL);
		}
		if(fileNameGenerator ==null)
		{
			throw new IllegalArgumentException("fileNameGenerator"+ ERROR_ARG_NULL);
		}
		
		this.cacheDir = cacheDir;
		this.fileNameGenerator = fileNameGenerator;
	}


	@Override
	public File get(String key) {
		// TODO Auto-generated method stub
		String name = fileNameGenerator.generate(key);
		return new File(cacheDir,name);
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		File[] files =  cacheDir.listFiles();
		if(files!=null)
		{
			for(File f:files)
			{
				f.delete();
			}
		}
	}
	
	
	
}
