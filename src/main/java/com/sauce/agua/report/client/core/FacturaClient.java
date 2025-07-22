package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.FacturaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient(name = "core-service", contextId = "facturaClient", path = "/api/core/factura")
public interface FacturaClient {

    @GetMapping("/periodo/{periodoId}")
    List<FacturaDto> findAllByPeriodoId(@PathVariable Integer periodoId);

    @GetMapping("/zona/{periodoId}/{zona}")
    List<FacturaDto> findAllByPeriodoIdAndZona(@PathVariable Integer periodoId, @PathVariable Integer zona);

    @GetMapping("/{prefijoId}/{facturaId}")
    FacturaDto findByFactura(@PathVariable Integer prefijoId, @PathVariable Long facturaId);

    @PostMapping("/deuda/clientes/{periodoId}")
    List<FacturaDto> findAllDeudaByPeriodoIdAndClienteIds(
            @PathVariable Integer periodoId,
            @RequestBody List<Long> clienteIds);

    @PostMapping("/uniques")
    List<FacturaDto> findAllByUniqueIdIn(
            @RequestBody List<Long> uniqueIds) ;

    @GetMapping("/deuda/print/{clienteId}/{periodoIdReferencia}")
    List<FacturaDto> findAllByDeudaPrint(
            @PathVariable Long clienteId,
            @PathVariable Integer periodoIdReferencia);

}
