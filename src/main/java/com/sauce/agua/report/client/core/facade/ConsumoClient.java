package com.sauce.agua.report.client.core.facade;

import com.sauce.agua.report.model.dto.facade.ConsumoContextDto;
import com.sauce.agua.report.model.dto.facade.DatoConsumoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "core-service/api/core/consumo")
public interface ConsumoClient {

    @PostMapping("/calculate")
    DatoConsumoDto calculateConsumo(@RequestBody ConsumoContextDto consumoContext);

}
