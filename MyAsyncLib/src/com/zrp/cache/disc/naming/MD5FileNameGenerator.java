package com.zrp.cache.disc.naming;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.zrp.cache.disc.utils.L;

public class MD5FileNameGenerator implements FileNameGenerator{

	
	private static final String HASH_ALGORITHM="MD5";
	private static final int RADIX = 10+ 26;  // 10 Êý×Ö + 26×ÖÄ¸
	
	public String generate(String imageUri) {
		// TODO Auto-generated method stub
		byte[] md5 = getMD5(imageUri.getBytes());
		BigInteger bi = new BigInteger(md5).abs();
		return bi.toString(RADIX);
	}

	
	private byte[] getMD5(byte[] data)
	{
		byte[] hash = null;
		try
		{
			MessageDigest digest = MessageDigest.getInstance(HASH_ALGORITHM);
			digest.update(data);
			hash = digest.digest();
		}catch(NoSuchAlgorithmException e)
		{
			L.e(e);
		}
		return hash;
	}
	
}
