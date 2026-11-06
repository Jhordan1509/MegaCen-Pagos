package pe.com.megacentimetros.pagos.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "megacentimetros-microservicio-ventas", url = "http://localhost:9096/pmega/api/")
public interface VentasFeignClient {
	@GetMapping("/facturaventa/{id}")
	Object getFacturaVenta(@PathVariable("id") Long id);
}
