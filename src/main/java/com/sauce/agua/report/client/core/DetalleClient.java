package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.DetalleDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "core-service/api/core/detalle")
public interface DetalleClient {

    @GetMapping("/factura/{prefijoId}/{facturaId}")
    List<DetalleDto> findAllByFactura(@PathVariable Integer prefijoId, @PathVariable Long facturaId);

}
