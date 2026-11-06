package pe.com.megacentimetros.pagos.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.math.BigDecimal;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity(name = "PagoEntity")
@Table(name = "pago")
public class PagoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "codpag")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;

    @Column(name = "fecpag", nullable = false)
    private LocalDateTime fecha;

    @Column(name = "monto", nullable = false, precision = 12, scale = 2)
    private BigDecimal monto;

    @Column(name = "sitpag", length = 30, nullable = false)
    private String situacion;

    @Column(name = "numoper", length = 80)
    private String numeroOperacion;

    @Column(name = "obs", length = 250)
    private String observacion;

    @Column(name = "codmetpag", nullable = false)
    private Long codmetpag;

    @Column(name = "codfacven")
    private Long codfacven;

    @Column(name = "codfacprov")
    private Long codfacprov;

    @Column(name = "estpag", nullable = false)
    private Boolean estado;

    @Transient
    private Object metodopago;

    @Transient
    private Object facturaventa;

    @Transient
    private Object facturaproveedor;
}
