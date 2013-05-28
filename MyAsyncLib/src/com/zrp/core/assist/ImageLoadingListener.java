package com.zrp.core.assist;
import android.graphics.Bitmap;
import android.view.View;



public interface ImageLoadingListener {

	
	void onLoadingStarted(String imageUri,View view);
	
	void onLoadingFailed(String imageUri,View view,FailReason failReason);
	
	void onLoadingComplete(String imageUri, View view, Bitmap loadedImage);
	
	void onLoadingCancelled(String imageUri,View view);
}
