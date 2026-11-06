package pe.com.megacentimetros.pagos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class MegacentimetrosMicroservicioPagosApplication {

	public static void main(String[] args) {
		SpringApplication.run(MegacentimetrosMicroservicioPagosApplication.class, args);
	}

}
