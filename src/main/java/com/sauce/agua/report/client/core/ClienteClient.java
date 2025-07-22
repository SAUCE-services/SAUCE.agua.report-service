package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.ClienteDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "core-service", contextId = "clienteClient", path = "/api/core/cliente")
public interface ClienteClient {

    @PostMapping("/search")
    List<ClienteDto> findAllSearch(@RequestBody List<String> chain);

    @GetMapping("/bycliente/{clienteId}")
    List<ClienteDto> findAllByClienteId(@PathVariable Long clienteId);

    @GetMapping("/activos/{byname}")
    List<ClienteDto> findAllActivos(@PathVariable Boolean byname);

    @GetMapping("/activos2lectura/{zona}/{ruta}")
    List<ClienteDto> findAllActivos2Lectura(@PathVariable Integer zona,
                                                                @PathVariable Integer ruta);

    @GetMapping("/activosbyzona")
    List<ClienteDto> findAllActivosByZona();

    @GetMapping("/activosbyruta/{zona}")
    List<ClienteDto> findAllActivosByRuta(@PathVariable Integer zona);

    @GetMapping("/activosmedibles")
    List<ClienteDto> findAllActivosMedibles();

    @GetMapping("/activosbyzonaruta/{zona}/{ruta}")
    List<ClienteDto> findAllActivosByZonaRuta(@PathVariable Integer zona,
                                                                  @PathVariable Integer ruta);

    @GetMapping("/activosbyzonarutaotros/{zona}/{ruta}")
    List<ClienteDto> findAllActivosByZonaRutaOtros(@PathVariable Integer zona,
                                                                       @PathVariable Integer ruta);

    @GetMapping("/activosconcuotafija")
    List<ClienteDto> findAllActivosConCuotaFija();

    @GetMapping("/activosconmedidor")
    List<ClienteDto> findAllActivosConMedidor();

    @GetMapping("/zona/{zona}")
    List<ClienteDto> findAllActivosZona(@PathVariable Integer zona);

    @GetMapping("/rango/{clienteIddesde}/{clienteIdhasta}")
    List<ClienteDto> findAllActivosRango(@PathVariable Long clienteIddesde,
                                                             @PathVariable Long clienteIdhasta);

    @GetMapping("/sociosactivosconmedidor")
    List<ClienteDto> findAllSociosActivosConMedidor();

    @GetMapping("/sociosactivos")
    List<ClienteDto> findAllSociosActivos();

    @GetMapping("/sociosactivosconcuotafija")
    List<ClienteDto> findAllSociosActivosConCuotaFija();

    @GetMapping("/deudoresplancorte")
    List<ClienteDto> findAllDeudoresPlanCorte();

    @GetMapping("/deudoresfactura60dias")
    List<ClienteDto> findAllDeudoresFactura60Dias();

    @GetMapping("/{uniqueId}")
    ClienteDto findByUniqueId(@PathVariable Long uniqueId);

    @GetMapping("/lastbyclienteId/{clienteId}")
    ClienteDto findLastByClienteId(@PathVariable Long clienteId);

    @GetMapping("/lastcliente")
    ClienteDto findLastCliente();

    @GetMapping("/nextbyclienteId/{clienteId}")
    ClienteDto findNextCliente(@PathVariable Long clienteId);
    
    @PostMapping("/")
    ClienteDto add(@RequestBody ClienteDto cliente);

    @PutMapping("/{uniqueId}")
    ClienteDto update(@RequestBody ClienteDto cliente, @PathVariable Long uniqueId);

}
