package com.zrp.core;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;

import com.zrp.cache.disc.naming.FileNameGenerator;
import com.zrp.cache.disc.naming.HashCodeFileNameGenerator;
import com.zrp.core.assist.QueueProcessingType;

public class DefaultConfigurationFactory {

	public static Executor createExecutor(int threadPollSize, int threadPriority,QueueProcessingType tasksProcessingType)
	{
		boolean lifo = tasksProcessingType == QueueProcessingType.LIFO;
//		BlockingQueue<Runnable> taskQueue = lifo? new
		return null;
	}
	
	
	public static FileNameGenerator createFileNameGenerator()
	{
		return new HashCodeFileNameGenerator();
	}
}
