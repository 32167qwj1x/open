package com.zrp.core.decode;

import java.io.IOException;



import android.graphics.Bitmap;

public interface ImageDecoder {
	Bitmap decode(ImageDecodingInfo imageDecodingInfo) throws IOException;
}
