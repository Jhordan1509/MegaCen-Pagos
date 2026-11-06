package pe.com.megacentimetros.pagos.restcontroller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.com.megacentimetros.pagos.entity.PagoEntity;
import pe.com.megacentimetros.pagos.service.PagoService;

@RestController
@RequestMapping("/api/pago")
public class PagoRestController {

	@Autowired
	private PagoService servicio;

	@GetMapping
	public List<PagoEntity> findAll() {
		return servicio.findAll();
	}

	@GetMapping("/custom")
	public List<PagoEntity> findAllCustom() {
		return servicio.findAllCustom();
	}

	@GetMapping("/{id}")
	public PagoEntity findById(@PathVariable Long id) {
		return servicio.findById(id);
	}

	@PostMapping
	public PagoEntity add(@RequestBody PagoEntity obj) {
		return servicio.add(obj);
	}

	@PutMapping("/{id}")
	public PagoEntity update(@RequestBody PagoEntity obj, @PathVariable Long id) {
		return servicio.update(obj, id);
	}

	@DeleteMapping("/{id}")
	public PagoEntity delete(@PathVariable Long id) {
		return servicio.delete(id);
	}

	@PatchMapping("/{id}")
	public PagoEntity enable(@PathVariable Long id) {
		return servicio.enable(id);
	}
}
