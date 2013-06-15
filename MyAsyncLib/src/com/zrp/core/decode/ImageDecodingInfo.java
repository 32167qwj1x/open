package com.zrp.core.decode;

import android.graphics.BitmapFactory.Options;

import com.zrp.core.assist.ImageScaleType;
import com.zrp.core.assist.ImageSize;
import com.zrp.core.assist.ViewScaleType;

/**
 * Contains needed information for decoding image to Bitmap
 * @author wj
 *
 */
public class ImageDecodingInfo {

	private final String imageKey;
	private final String imageUri;
	private final ImageSize targetSize;
	
	private final ImageScaleType imageScaleType;
	private final ViewScaleType viewScaleType;
	
	private final Options decodingOptions;
	
	public ImageDecidingInfo(String imageKey, String imageUri, ImageSize targetSize, ViewScaleType viewScaleType, ImageDownloader downloader, DisplayImageOptions displayOptions){
		this.imageKey = imageKey;
		this.imageUri = imageUri;
		this.targetSize = targetSize;
		
		this.imageScaleType = displayOptions.getIma
		
	}
}
