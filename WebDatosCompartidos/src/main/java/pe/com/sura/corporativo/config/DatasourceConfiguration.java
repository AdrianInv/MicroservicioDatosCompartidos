package pe.com.sura.corporativo.config;

/*import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.sql.DataSource;

import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import pe.com.sura.corporativo.util.SecretParameter;
import pe.com.sura.corporativo.util.UtilEncryption;*/

//@Configuration
public class DatasourceConfiguration {
	
	/*
	 * @Autowired SecretConfiguration awsSecret;
	 * 
	 * @Value("${spring.datasource.hikari.minimum-idle}") private int minimumIdle;
	 * 
	 * @Value("${spring.datasource.hikari.maximum-pool-size}") private int
	 * maxPoolSize;
	 * 
	 * @Primary
	 * 
	 * @Bean public DataSource dataSource() throws InvalidKeyException,
	 * NoSuchAlgorithmException, NoSuchPaddingException,
	 * InvalidAlgorithmParameterException, IllegalBlockSizeException,
	 * BadPaddingException { SecretParameter aws = awsSecret.getSecretKey();
	 * 
	 * HikariConfig hikariConfig = new HikariConfig();
	 * hikariConfig.setDriverClassName("com.mysql.jdbc.Driver");
	 * hikariConfig.setJdbcUrl(UtilEncryption.decrypt(Base64.decodeBase64(aws.
	 * getCercaniabdCoreUrl()), aws.getKeyEncriptacion()));
	 * hikariConfig.setUsername(UtilEncryption.decrypt(Base64.decodeBase64(aws.
	 * getCercaniabdCoreUsr()), aws.getKeyEncriptacion()));
	 * hikariConfig.setPassword(UtilEncryption.decrypt(Base64.decodeBase64(aws.
	 * getCercaniabdCorePassw()), aws.getKeyEncriptacion()));
	 * hikariConfig.setMaximumPoolSize(maxPoolSize);
	 * hikariConfig.setMinimumIdle(minimumIdle);
	 * hikariConfig.setConnectionTestQuery("SELECT 1");
	 * hikariConfig.setPoolName("springHikariCP");
	 * 
	 * return new HikariDataSource(hikariConfig); }
	 */


	

}
