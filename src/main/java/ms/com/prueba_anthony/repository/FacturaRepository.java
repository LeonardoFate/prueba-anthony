package ms.com.prueba_anthony.repository;

import ms.com.prueba_anthony.model.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository<Factura, Long> {
}
