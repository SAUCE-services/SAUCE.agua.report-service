package com.sauce.agua.report.model.dto;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class DetalleDto {

    private Integer prefijoId;
    private Long facturaId;
    private Integer rubroId;
    private String concepto = "";
    private BigDecimal cantidad = BigDecimal.ZERO;
    private BigDecimal precioUnitario = BigDecimal.ZERO;
    private Byte iva = 0;
    private Long detalleId;

}
