package com.sauce.agua.report.client.core.facade;

import com.sauce.agua.report.model.dto.FacturaDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "core-service/api/core/facturacion")
public interface FacturacionClient {

    @PostMapping("/codigopf")
    String codigopf(@RequestBody FacturaDto factura);

}
