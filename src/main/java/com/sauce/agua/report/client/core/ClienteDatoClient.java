package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.ClienteDatoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "core-service/api/core/clientedato")
public interface ClienteDatoClient {

    @GetMapping("/{clienteId}")
    ClienteDatoDto findByClienteId(@PathVariable Long clienteId);

    @PostMapping("/")
    ClienteDatoDto add(@RequestBody ClienteDatoDto clienteDato);

    @PutMapping("/{clienteId}")
    ClienteDatoDto update(@RequestBody ClienteDatoDto clienteDato, @PathVariable Long clienteId);

}
