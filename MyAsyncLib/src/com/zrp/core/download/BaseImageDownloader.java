package com.zrp.core.download;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.content.Context;
import android.net.Uri;

/**
 * Provides retrieving of {@link InputStream} of image by URI from network or file system or app resources.<br/>
 * {@link URLConnection} is used to retrieve image stream from network. 
 * @author wj
 *
 */
public class BaseImageDownloader implements ImageDownloader {
		public static final int DEFAULT_HTTP_CONNECT_TIMEOUT = 5 * 1000;
		
		public static final int DEFAULT_HTTP_READ_TIMEOUT = 20 * 1000;
		
		protected static final int BUFFER_SIZE = 8 * 1024 ;
		
		protected static final String ALLOWED_URI_CHARS = "@#&=*+-_.,:!?()/~'%";
		
		private static final int MAX_REDIRECT_COUNT = 5;

		private static final String ERROR_UNSUPPORTED_SCHEME = "UTL doesn't support scheme(protocol) by default [%s]."
				+"You should implement this support yourself (BaseImageDownloader.getStreamFromOtherSource(...))";
		
		protected final Context context;
		protected final int connectTimeout;
		protected final int readTimeout;
		
		public BaseImageDownloader(Context context)
		{
			this.context = context.getApplicationContext();
			this.connectTimeout = DEFAULT_HTTP_CONNECT_TIMEOUT;
			this.readTimeout = DEFAULT_HTTP_READ_TIMEOUT;
		}
		
		
		public BaseImageDownloader(Context context , int connectTimeout , int readTimeout)
		{
			this.context = context.getApplicationContext();
			this.connectTimeout = connectTimeout;
			this.readTimeout = readTimeout;
		}
		
		
		@Override
		public InputStream getStream(String imageUri, Object extra) throws IOException {
			// TODO Auto-generated method stub
			switch (Scheme.ofUri(imageUri)) {
			case HTTP:
			case HTTPS:
				 return getSt
				
				break;

			default:
				break;
			}
			return null;
		}
		
		/**
		 * Retrieves {@link InputStream} of image by URI (image is located in the network).
		 * @param imageUri Image URI
		 * @param extra Auxiliary object which was passed to {@link DisplayImageOptions.Builder#extraForDownloader(Object)}
		 * @return {@link InputStream} of image
		 * @throws IOException if some I/O error occurs during network request or if no InputStream could be created for URI.
		 */
		protected InputStream getStreamFromNetwork(String imageUri, Object extra) throws IOException{
		{
			HttpsURLConnection conn = 
		}
		
		private HttpURLConnection connectTo(String url) throws IOException{
			String encodedUrl = Uri.encode(url,ALLOWED_URI_CHARS);
			HttpURLConnection conn = (HttpURLConnection) new URL(encodedUrl).openConnection();
			conn.setConnectTimeout(connectTimeout);
			conn
		}
}
