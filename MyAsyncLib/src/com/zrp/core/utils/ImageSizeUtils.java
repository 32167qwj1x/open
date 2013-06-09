package com.zrp.core.utils;

import android.util.DisplayMetrics;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;

import com.zrp.core.assist.ImageSize;

/**
 * Provides calculations with image sizes, scales
 * @author aaa
 *
 */
public class ImageSizeUtils {

	private ImageSizeUtils(){
	}
	
	/**
	 * Defines target size for image. Size is defined by target {@link ImageView view} parameters,configuration
	 * parameters or device display dimensions.<br />
	 * Size computing algorithm:<br />
	 * 1) Get the actual drawn <b>getWidth</b> and <b> getHeight </b> of the View. If view haven't drawn yet then go
	 * to step #2. <br />
	 * 2) Get <b>layout_width</b> and <b>layout_height</b>. If both of them haven't exact value then go to step #3.<br />
	 * 3) Get <b>maxWidth</b> and <b>maxHeight</b>. If both of them are not set then go to step #4<br />
	 * 4) Get <b>maxImageWidth</b> param (<b>maxImageWidthForMemoryCache</b>) and <b>maxImageHeight </b> param
	 * (<b>maxImageHeightForMemoryCache</b>). If both of them are not set (equal 0) then go to step #5. <br />
	 * 5) Get device screen dimensions.
	 * @param imageView
	 * @param maxImageWidth
	 * @param maxImageHeight
	 * @return
	 */
	public static ImageSize defineTargetSizeForView(ImageView imageView, int maxImageWidth, int maxImageHeight){
		final DisplayMetrics displayMetrics = imageView.getContext().getResources().getDisplayMetrics();
		
		final LayoutParams params = imageView.getLayoutParams();
		int width = params.width == LayoutParams.WRAP_CONTENT ? 0 : imageView.getWidth(); // Get actual image width
	}
}
