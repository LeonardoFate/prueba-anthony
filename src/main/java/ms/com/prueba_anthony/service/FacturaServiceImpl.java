package ms.com.prueba_anthony.service;

import lombok.RequiredArgsConstructor;
import ms.com.prueba_anthony.dto.FacturaDTO;
import ms.com.prueba_anthony.model.Factura;
import ms.com.prueba_anthony.repository.FacturaRepository;
import org.modelmapper.ModelMapper;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class FacturaServiceImpl implements FacturaService {

    private final FacturaRepository facturaRepository;
    private final ModelMapper modelMapper;

    @Override
    public List<FacturaDTO> getAllFacturas(){
        return facturaRepository.findAll().stream()
                .map(factura -> modelMapper.map(factura, FacturaDTO.class))
                .collect(Collectors.toList());
    }
    @Override
    public FacturaDTO getFacturaById(Long id){
        Factura factura = facturaRepository.findById(id).orElseThrow();
        return modelMapper.map(factura, FacturaDTO.class);
    }

    @Override
    public FacturaDTO createFactura(FacturaDTO facturaDTO){
        Factura factura = modelMapper.map(facturaDTO, Factura.class);
        Factura nuevaFactura = facturaRepository.save(factura);
        return modelMapper.map(nuevaFactura, FacturaDTO.class);
    }

    @Override
    public FacturaDTO updateFactura(Long id, FacturaDTO facturaDTO) {
        Factura factura = facturaRepository.findById(id).orElseThrow();
        factura.setCliente(facturaDTO.getCliente());
        factura.setFecha(facturaDTO.getFecha());
        factura.setTotal(facturaDTO.getTotal());
        Factura FacturaActualizada = facturaRepository.save(factura);
        return modelMapper.map(FacturaActualizada, FacturaDTO.class);
    }

    @Override
    public void deleteFactura(Long id) {
        facturaRepository.deleteById(id);
    }
}
