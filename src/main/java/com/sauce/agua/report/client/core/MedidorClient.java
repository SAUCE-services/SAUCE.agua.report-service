package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.MedidorDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "core-service/api/core/medidor")
public interface MedidorClient {

    @GetMapping("/cliente/{clienteId}/{colocado}")
    MedidorDto findByClienteId(
            @PathVariable Long clienteId,
            @PathVariable Boolean colocado);

    @GetMapping("/cliente/colocado/{clienteId}")
    MedidorDto findColocadoByClienteId(
            @PathVariable Long clienteId);

}
