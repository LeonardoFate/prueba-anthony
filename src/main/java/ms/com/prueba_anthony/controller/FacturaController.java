package ms.com.prueba_anthony.controller;


import lombok.RequiredArgsConstructor;
import ms.com.prueba_anthony.dto.FacturaDTO;
import ms.com.prueba_anthony.service.FacturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facturas")
@RequiredArgsConstructor
public class FacturaController {

    private final FacturaService facturaService;

    @GetMapping
    public List<FacturaDTO> getAllFacturas() {
        return facturaService.getAllFacturas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FacturaDTO> getFacturaById(@PathVariable Long id) {
        return  ResponseEntity.ok(facturaService.getFacturaById(id));
    }

    @PostMapping
    public ResponseEntity<FacturaDTO> createFactura(@RequestBody FacturaDTO facturaDTO) {
        return  ResponseEntity.ok(facturaService.createFactura(facturaDTO));

    }

    @PutMapping("/{id}")
    public ResponseEntity<FacturaDTO> updateFactura(@PathVariable Long id, @RequestBody FacturaDTO facturaDTO) {
        return  ResponseEntity.ok(facturaService.updateFactura(id, facturaDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<FacturaDTO> deleteFactura(@PathVariable Long id) {
        facturaService.deleteFactura(id);
        return  ResponseEntity.noContent().build();
    }
}
