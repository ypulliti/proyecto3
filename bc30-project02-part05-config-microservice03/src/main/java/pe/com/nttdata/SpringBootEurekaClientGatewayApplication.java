package pe.com.nttdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class SpringBootEurekaClientGatewayApplication {

	public static void main(String[] args) {

		SpringApplication.run(SpringBootEurekaClientGatewayApplication.class, args);
	}

}
