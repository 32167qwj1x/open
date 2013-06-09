package com.zrp.core.download;

import java.io.IOException;
import java.io.InputStream;

import com.zrp.core.assist.FlushedInputStream;

public class SlowNetworkImageDownloader implements ImageDownloader {

	private final ImageDownloader wrappedDownloader;
	
	
	public SlowNetworkImageDownloader(ImageDownloader wrappedDownloader)
	{
		this.wrappedDownloader = wrappedDownloader;
	}
	
	@Override
	public InputStream getStream(String imageUri, Object extra) throws IOException {
		InputStream imageStream = wrappedDownloader.getStream(imageUri, extra);
		switch (Scheme.ofUri(imageUri)) {
		case HTTP:
		case HTTPS:
			return new FlushedInputStream(imageStream);
		default:
			return imageStream;
		}
	}

}
