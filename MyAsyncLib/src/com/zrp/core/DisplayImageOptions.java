package com.zrp.core;

import android.graphics.BitmapFactory.Options;
import android.os.Handler;

import com.zrp.core.assist.ImageScaleType;
import com.zrp.core.display.BitmapDisplayer;
import com.zrp.core.download.ImageDownloader;
import com.zrp.core.process.BitmapProcessor;

/**
 * Contains options for image display. Defines:
 * <ul>
 * <li>whether stub image will be displayed in {@link android.widget.ImageView ImageView} during image loading</li>
 * <li>whether stub image will be displayed in {@link android.widget.ImageView ImageView} if empty URI} </li>
 * <li>whether stub image will be displayed in {@link android.widget.ImageView ImageView} if image loading fails</li>
 * <li>whether {@link androi.widget.ImageVIew ImageView} should be reset before image loading start</li>
 * <li>whether loaded image will be cached in memory<li>
 * <li>whether loaded image will be cached on disc</li>
 * <li>image scale type </li>
 * <li>decoding options (incluing bitmap decoding configuration)</li>
 * <li>delay before loading of image</li>
 * <li>auxiliary object which will be passed to {@link ImageDownloader#getStrean(java.net.URI,Object) ImageDownloader}</li>
 * <li>pre-processor for image Bitmap (before caching in meory)</li>
 * <li>post-processor for image Bitmap (before caching in memory)</li>
 * <li>how decoded {@link Bitmao} will be
 * @author wj
 *
 */
public final  class DisplayImageOptions {

	private final int stubImage;
	private final int imageForEmptyUri;
	private final int imageOnFail;
	private final boolean resetViewBeforeLoading;
	private final boolean cacheInMemory;
	private final boolean cacaheOnDisc;
	private final ImageScaleType imageScaleType;
	private final Options decodingOptions;
	private final int delayBeforeLoading;
	private final Object extraForDownloader;
	private final BitmapProcessor preProcessor;
	private final BitmapProcessor postProcessor;
	private final BitmapDisplayer displayer;
	private final Handler handler;
	
//	private DisplayImageOptions(Buidler)
	
	
	public static class Builder {
		private int stubImage = 0;
		private int imageForEmptyUri = 0;
		private int imageOnFail = 0;
		private boolean resetViewBeforeLoading = false;
		private boolean cacheInMemory = false;
		private boolean cacheOnDisc = false;
		private ImageScaleType imageScaleType = ImageScaleType.IN_SAMPLE_POWER_OF_2;
		private Options decodingOptions =new Options();
		private int delayBeforeLoading = 0;
		private Object extraForDownloader =  null;
		private BitmapProcessor preProcessor = null;
		private BitmapProcessor postProcessor = null;
		private BitmapDisplayer displayer = DefaultConfigurationFactory.cre
				
	}
}
