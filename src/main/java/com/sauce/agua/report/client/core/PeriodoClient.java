package com.sauce.agua.report.client.core;

import com.sauce.agua.report.model.dto.PeriodoDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@FeignClient(name = "core-service/api/core/periodo")
public interface PeriodoClient {

    @GetMapping("/")
    List<PeriodoDto> findAll();

    @GetMapping("/recaudado/{desde}/{hasta}")
    List<PeriodoDto> findAllRecaudadoByPeriodo(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime desde,
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime hasta);

    @GetMapping("/{periodoId}")
    PeriodoDto findByPeriodoId(@PathVariable Integer periodoId);

    @GetMapping("/last")
    PeriodoDto findLast();

    @GetMapping("/today")
    PeriodoDto findToday();

    @GetMapping("/byfecha/{fecha}")
    PeriodoDto findByFecha(
            @PathVariable @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) OffsetDateTime fecha);

    @PostMapping("/")
    PeriodoDto add(@RequestBody PeriodoDto periodo);

    @PutMapping("/{periodoId}")
    PeriodoDto update(@RequestBody PeriodoDto periodo, @PathVariable Integer periodoId);

    @DeleteMapping("/{periodoId}")
    Void delete(@PathVariable Integer periodoId);

}
