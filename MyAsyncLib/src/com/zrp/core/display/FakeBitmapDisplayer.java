package com.zrp.core.display;

import android.graphics.Bitmap;
import android.widget.ImageView;

public class FakeBitmapDisplayer implements BitmapDisplayer {

	@Override
	public Bitmap display(Bitmap bitmap, ImageView imageView) {
		//do nothing
		return bitmap;
	}

}
