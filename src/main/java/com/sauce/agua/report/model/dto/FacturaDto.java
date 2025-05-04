package com.sauce.agua.report.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

@Data
public class FacturaDto {

    private Integer prefijoId;
    private Long facturaId;
    private Long uniqueId;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fecha;

    private Long clienteId;
    private Integer periodoId;
    private Integer situacionIva = 0;
    private BigDecimal tasa = BigDecimal.ZERO;
    private BigDecimal descuento = BigDecimal.ZERO;
    private Byte pagada = 0;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ssZ", timezone = "UTC")
    private OffsetDateTime fechaPago;

    private Integer tipoId = 0;
    private Byte anulada = 0;
    private BigDecimal total = BigDecimal.ZERO;
    private BigDecimal interes = BigDecimal.ZERO;
    private String letras = "";
    private Integer prefijoIdInteres = 0;
    private Long facturaIdInteres = 0L;
    private BigDecimal ivaCf = BigDecimal.ZERO;
    private BigDecimal ivaRi = BigDecimal.ZERO;
    private BigDecimal ivaRn = BigDecimal.ZERO;
    private Integer periodoIdFin;
    private Byte cancelada = 0;
    private Integer planIdCancela;
    private String pfCodigo;
    private Long cajamovimientoId;
    private String uid = "";
    private PeriodoDto periodo;

}
