package com.zrp.core.decode;

import java.io.IOException;
import java.io.InputStream;

import android.graphics.Bitmap;

import com.zrp.core.assist.ImageSize;

public class BaseImageDecoder implements ImageDecoder{

	protected static final String LOG_SABSAMPLE_IMAGE = "Subsample original image (%1$s) to %2$s (scale = %3$d) [%4$s]";
	protected static final String LOG_SCALE_IMAGE = "Scale subsampled image (%1$s) to %2$s (scale = %3$.5f) [%4$s]";
	protected static final String LOG_ROTATE_IMAGE = "Rotate image on %1$d\u00B0 [%2$s]";
	protected static final String LOG_FLIP_IMAGE = "Flip image horizontally [%s]";
	protected static final String ERROR_CANT_DECODE_IMAGE = "Image can't be decoded [%s]";
	
	protected boolean logginEnabled;
	
	public BaseImageDecoder(){
		
	}
	
	public BaseImageDecoder(boolean loggingEnabled)
	{
		this.logginEnabled = loggingEnabled;
	}
	
	/**
	 * Decodes image from URI into {@link Bitmap}. Image is scaled close to incoming {@linkplain ImageSize target size}
	 * during decoding  (depend on incoming parameters).
	 * 
	 * @param decodingInfo Needed data for decoding image
	 * 
	 * @return Decoded bitmap 
	 * @throws IOException if some I/O exception occurs during image reading
	 * @throws UnsupportedOperationException if image URI has unsupported scheme(protocol)
	 */
	public Bitmap decode(ImageDecodingInfo decodingInfo) throws IOException {
		InputStream imageStream getI
		
	}
	
	
	protected InputStream getImageStream(ImageDecodingInfo decodingInfo) throws IOException
	{
		return decodingInfo.get
	}
}
