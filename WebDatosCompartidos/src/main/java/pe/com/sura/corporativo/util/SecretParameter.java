package pe.com.sura.corporativo.util;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SecretParameter {
	
	@JsonProperty("CORPORATIVO_SURA_MYSQL_URL")
	private String cercaniabdCoreUrl;

	@JsonProperty("CORPORATIVO_SURA_MYSQL_USR")
	private String cercaniabdCoreUsr;

	@JsonProperty("CORPORATIVO_SURA_MYSQL_PWD")
	private String cercaniabdCorePassw;
	
	@JsonProperty("CORPORATIVO_KEY_ENCRIPTACION")
	private String keyEncriptacion;
	

	public String getCercaniabdCoreUrl() {
		return cercaniabdCoreUrl;
	}

	public void setCercaniabdCoreUrl(String cercaniabdCoreUrl) {
		this.cercaniabdCoreUrl = cercaniabdCoreUrl;
	}

	public String getCercaniabdCoreUsr() {
		return cercaniabdCoreUsr;
	}

	public void setCercaniabdCoreUsr(String cercaniabdCoreUsr) {
		this.cercaniabdCoreUsr = cercaniabdCoreUsr;
	}

	public String getCercaniabdCorePassw() {
		return cercaniabdCorePassw;
	}

	public void setCercaniabdCorePassw(String cercaniabdCorePassw) {
		this.cercaniabdCorePassw = cercaniabdCorePassw;
	}

	public String getKeyEncriptacion() {
		return keyEncriptacion;
	}

	public void setKeyEncriptacion(String keyEncriptacion) {
		this.keyEncriptacion = keyEncriptacion;
	}
	
	

}
