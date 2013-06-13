package com.zrp.core.display;

import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;

/**
 * Display image with "fade in" animation
 * @author wj
 *
 */
public class FadeInBitmapDisplayer {

	private final int durationMillis;
	
	public FadeInBitmapDisplayer(int durationMills){
		this.durationMillis = durationMills;
	}
	
	public Bitmap display(Bitmap bitmap, ImageView imageView) {
		imageView.setImageBitmap(bitmap);
		animate(imageView, durationMillis);
		return bitmap;
	}
	
	public static void animate(ImageView imageView , int durationMillis) {
		AlphaAnimation fadeImage = new AlphaAnimation(0, 1);
		fadeImage.setDuration(durationMillis);
		fadeImage.setInterpolator(new DecelerateInterpolator());
		imageView.startAnimation(fadeImage);
	}
}
