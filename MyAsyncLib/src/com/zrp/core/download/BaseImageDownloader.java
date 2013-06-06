package com.zrp.core.download;

/**
 * Provides retrieving of {@link InputStream} of image by URI from network or file system or app resources.<br/>
 * {@link URLConnection} is used to retrieve image stream from network. 
 * @author wj
 *
 */
public class BaseImageDownloader implements ImageDownloader {
		public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5 * 1000;
	
}
