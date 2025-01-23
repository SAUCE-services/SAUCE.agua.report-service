package com.sauce.agua.report.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ClienteDatoDto {

    private Long clienteId;
    private BigDecimal documento;
    private String email;
    private String fijo;
    private String celular;

}
