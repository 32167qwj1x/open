package com.zrp.core.assist;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;


public class FlushedInputStream extends FilterInputStream {

	public FlushedInputStream(InputStream inputStream)
	{
		super(inputStream);
	}

	@Override
	public long skip(long byteCount) throws IOException {

		long totalBytesSkipped = 0l;
		while (totalBytesSkipped < byteCount)
		{
			long bytesSkipped = in.skip(byteCount - totalBytesSkipped);
			if(bytesSkipped == 0l)
			{
				int by_te = read();
				if(by_te < 0)
				{
					break;
				}else
				{
					bytesSkipped = 1;
				}
			}
			totalBytesSkipped += bytesSkipped;
		}
		return totalBytesSkipped;
	}
	
	
}
