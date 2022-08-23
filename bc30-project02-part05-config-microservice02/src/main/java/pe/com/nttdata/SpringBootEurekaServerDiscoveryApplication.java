package pe.com.nttdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SpringBootEurekaServerDiscoveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootEurekaServerDiscoveryApplication.class, args);
	}

}
