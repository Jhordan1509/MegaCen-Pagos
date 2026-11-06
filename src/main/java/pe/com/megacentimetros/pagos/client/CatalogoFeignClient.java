package pe.com.megacentimetros.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-catalogo", url = "http://localhost:9091/pmega/api/")
public interface CatalogoFeignClient {
	@GetMapping("/metodopago/{id}")
	Object getMetodoPago(@PathVariable("id") Long id);
}
