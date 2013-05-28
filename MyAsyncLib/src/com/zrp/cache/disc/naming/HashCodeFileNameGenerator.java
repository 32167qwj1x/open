package com.zrp.cache.disc.naming;

public class HashCodeFileNameGenerator implements FileNameGenerator{

	@Override
	public String generate(String imageUri) {
		// TODO Auto-generated method stub
		return String.valueOf(imageUri.hashCode());
	}

}
