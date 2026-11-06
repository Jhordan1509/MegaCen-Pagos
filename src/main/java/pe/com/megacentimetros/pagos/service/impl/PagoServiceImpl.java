package pe.com.megacentimetros.pagos.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import pe.com.megacentimetros.pagos.client.CatalogoFeignClient;
import pe.com.megacentimetros.pagos.client.VentasFeignClient;
import pe.com.megacentimetros.pagos.client.ComprasFeignClient;
import pe.com.megacentimetros.pagos.exception.ResourceNotFoundException;
import pe.com.megacentimetros.pagos.entity.PagoEntity;
import pe.com.megacentimetros.pagos.repository.PagoRepository;
import pe.com.megacentimetros.pagos.service.PagoService;

@Service
public class PagoServiceImpl implements PagoService {

	private PagoRepository repositorio;
	private CatalogoFeignClient catalogoFeignClient;
	private VentasFeignClient ventasFeignClient;
	private ComprasFeignClient comprasFeignClient;

	public PagoServiceImpl(PagoRepository repositorio,
			CatalogoFeignClient catalogoFeignClient,
			VentasFeignClient ventasFeignClient,
			ComprasFeignClient comprasFeignClient) {
		this.repositorio = repositorio;
		this.catalogoFeignClient = catalogoFeignClient;
		this.ventasFeignClient = ventasFeignClient;
		this.comprasFeignClient = comprasFeignClient;
	}

	@Override
	public List<PagoEntity> findAll() {
		List<PagoEntity> lista = repositorio.findAll();
		for (PagoEntity pago : lista) {
			pago.setMetodopago(catalogoFeignClient.getMetodoPago(pago.getCodmetpag()));
			if (pago.getCodfacven() != null) {
				pago.setFacturaventa(ventasFeignClient.getFacturaVenta(pago.getCodfacven()));
			}
			if (pago.getCodfacprov() != null) {
				pago.setFacturaproveedor(comprasFeignClient.getFacturaProveedor(pago.getCodfacprov()));
			}
		}
		return lista;
	}
	@Override
	public List<PagoEntity> findAllCustom() {
		List<PagoEntity> lista = repositorio.findAllCustom();
		for (PagoEntity pago : lista) {
			pago.setMetodopago(catalogoFeignClient.getMetodoPago(pago.getCodmetpag()));
			if (pago.getCodfacven() != null) {
				pago.setFacturaventa(ventasFeignClient.getFacturaVenta(pago.getCodfacven()));
			}
			if (pago.getCodfacprov() != null) {
				pago.setFacturaproveedor(comprasFeignClient.getFacturaProveedor(pago.getCodfacprov()));
			}
		}
		return lista;
	}
	@Override
	public PagoEntity findById(Long id) {
		PagoEntity pago = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago con id " + id + " no existe"));
		pago.setMetodopago(catalogoFeignClient.getMetodoPago(pago.getCodmetpag()));
		if (pago.getCodfacven() != null) {
			pago.setFacturaventa(ventasFeignClient.getFacturaVenta(pago.getCodfacven()));
		}
		if (pago.getCodfacprov() != null) {
			pago.setFacturaproveedor(comprasFeignClient.getFacturaProveedor(pago.getCodfacprov()));
		}
		return pago;
	}
	@Override
	public PagoEntity add(PagoEntity obj) {
		obj.setEstado(true);
		if (obj.getFecha() == null) {
			obj.setFecha(LocalDateTime.now());
		}
		if (obj.getSituacion() == null) {
			obj.setSituacion("PENDIENTE");
		}
		return repositorio.save(obj);
	}
	@Override
	public PagoEntity update(PagoEntity obj, Long id) {
		PagoEntity objpag = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago con id " + id + " no existe"));
		BeanUtils.copyProperties(obj, objpag, "codigo");
		return repositorio.save(objpag);
	}
	@Override
	public PagoEntity delete(Long id) {
		PagoEntity objpag = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago con id " + id + " no existe"));
		objpag.setEstado(false);
		return repositorio.save(objpag);
	}
	@Override
	public PagoEntity enable(Long id) {
		PagoEntity objpag = repositorio.findById(id).orElseThrow(() -> new ResourceNotFoundException("Pago con id " + id + " no existe"));
		objpag.setEstado(true);
		return repositorio.save(objpag);
	}
}
