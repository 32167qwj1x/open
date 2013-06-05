package com.zrp.core.assist;

import android.graphics.Bitmap;
import android.view.View;

/**
 * A conveninet class to extend when you only want to listen for a subset of all the image loading events. This
 * implements all method in the{@link ImageLoadingListener}  but does nothing
 * @author wj
 *
 */
public class SimpleImageLoadingListener implements ImageLoadingListener{

	public void onLoadingStarted(String imageUri, View view) {
		// TODO Auto-generated method stub
		
	}

	public void onLoadingFailed(String imageUri, View view,
			FailReason failReason) {
		// TODO Auto-generated method stub
		
	}

	public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
		// TODO Auto-generated method stub
		
	}

	public void onLoadingCancelled(String imageUri, View view) {
		// TODO Auto-generated method stub
		
	}

}
