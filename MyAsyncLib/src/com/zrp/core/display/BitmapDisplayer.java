package com.zrp.core.display;

import android.graphics.Bitmap;
import android.widget.ImageView;

/**
 * Display {@link Bitmap} in {@link ImageView}. Implementations can apply some charges to Bitmap or any animation for
 * displaying Bitmap.<br /> 
 * Implemetations have to be thread-safe.
 * @author wj
 *
 */
public interface BitmapDisplayer {

	
	/**
	 * Display bitmap in {@link ImageView}. Displayed bitmap should be returned. <br />
	 * <b>NOTE:</b> This method is called on UI thread so it's strongly recommended not to do any heavy work in it.
	 * @param bitmap Source bitmap 
	 * @param imageView {@linkplain ImageView imageView} to display Bitmap
	 * @return Bitmap which was displayed in {@link ImageView}
	 */
	Bitmap display(Bitmap bitmap, ImageView imageView);
}
