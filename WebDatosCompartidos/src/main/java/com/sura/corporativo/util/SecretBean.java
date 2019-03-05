package com.sura.corporativo.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties("parametro")
public class SecretBean {
	
	private String region;

	private String secretname;

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getSecretname() {
		return secretname;
	}

	public void setSecretname(String secretname) {
		this.secretname = secretname;
	}

	

}
