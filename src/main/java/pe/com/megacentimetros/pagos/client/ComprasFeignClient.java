package pe.com.megacentimetros.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-compras", url = "http://localhost:9094/pmega/api/")
public interface ComprasFeignClient {
	@GetMapping("/facturaproveedor/{id}")
	Object getFacturaProveedor(@PathVariable("id") Long id);
}
