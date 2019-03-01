package com.integra.datoscompartidos.config;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DatosCompartidosConfiguration {
	
	@Bean
	public ConfigurationBean urlRedireccionPortal() 
			throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, 
			InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
		//SecretResponse secret = awsSecret.getSecretKey();
		ConfigurationBean configuracionBean = new ConfigurationBean();
		//configuracionBean.setPortalRedirectURL(secret.getDecodedRedireccionPortalUrl());
		return configuracionBean ;
	}

}
