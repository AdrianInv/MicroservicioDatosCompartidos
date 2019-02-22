package com.integra.datoscompartidos.config;

import org.springframework.cloud.aws.jdbc.config.annotation.EnableRdsInstance;
import org.springframework.context.annotation.Configuration;


@Configuration
//@ImportResource("classpath:/aws-config.xml")
@EnableRdsInstance(databaseName = "${database-name:}", 
                   dbInstanceIdentifier = "${db-instance-identifier:}", 
				   password = "${rdsPassword:}")
public class ResourceConfig {

}
