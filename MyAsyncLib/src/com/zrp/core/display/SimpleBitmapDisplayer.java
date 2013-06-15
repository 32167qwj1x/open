package com.zrp.core.display;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class SimpleBitmapDisplayer implements BitmapDisplayer {

	public Bitmap display(Bitmap bitmap, ImageView imageView) {
		imageView.setImageBitmap(bitmap);
		return bitmap;
	}

}
