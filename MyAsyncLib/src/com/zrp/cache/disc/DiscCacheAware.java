package com.zrp.cache.disc;

import java.io.File;

public interface DiscCacheAware {

	void put(String key,File file);
	
	File get(String key);
	
	void clear();
}
