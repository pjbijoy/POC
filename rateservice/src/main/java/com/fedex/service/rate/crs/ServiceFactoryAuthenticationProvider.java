package com.fedex.service.rate.crs;

public interface ServiceFactoryAuthenticationProvider {
	public abstract String generateToken(String paramString);
	  
	  public abstract String getApplicationId(String paramString);
}
