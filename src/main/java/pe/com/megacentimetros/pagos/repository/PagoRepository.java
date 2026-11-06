package pe.com.megacentimetros.pagos.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pe.com.megacentimetros.pagos.entity.PagoEntity;

public interface PagoRepository extends JpaRepository<PagoEntity, Long> {

	@Query("select d from PagoEntity d where d.estado = true")
	List<PagoEntity> findAllCustom();
}
