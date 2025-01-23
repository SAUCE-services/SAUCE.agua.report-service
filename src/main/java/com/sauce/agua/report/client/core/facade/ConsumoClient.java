package com.sauce.agua.report.client.core.facade;

import com.sauce.agua.report.model.dto.facade.DatoConsumoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.OffsetDateTime;

@FeignClient(name = "core-service/api/core/consumo")
public interface ConsumoClient {

    @GetMapping("/calculate/{clienteId}/{periodoId}/{medidorId}/{fechaEmision}")
    DatoConsumoDto calculateConsumo(@PathVariable Long clienteId, @PathVariable Integer periodoId, @PathVariable String medidorId, @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fechaEmision);

}
