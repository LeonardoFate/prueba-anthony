package ms.com.prueba_anthony.service;

import ms.com.prueba_anthony.dto.FacturaDTO;


import java.util.List;

public interface FacturaService {
    List<FacturaDTO> getAllFacturas();
    FacturaDTO getFacturaById(Long id);
    FacturaDTO createFactura(FacturaDTO facturaDTO);
    FacturaDTO updateFactura(Long id, FacturaDTO facturaDTO);
    void deleteFactura(Long id);
}
