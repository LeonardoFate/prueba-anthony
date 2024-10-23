package ms.com.prueba_anthony.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FacturaDTO {

    private Long id;
    @JsonProperty("Cliente")
    private String cliente;
    private LocalDate fecha;
    private Double total;
}
