# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

## [1.0.1] - 2026-04-28

### Changed
- **deps**: Actualización de Spring Boot: 4.0.4 → 4.0.6
- **config**: Configuración de Feign Decoder con `ResponseEntityDecoder` y `SpringDecoder` en `ReportConfiguration`

### Fixed
- Mejora en la configuración de deserialización de respuestas Feign

## [1.0.0] - 2026-03-31

### Changed
- **BREAKING**: Actualización de Spring Boot 3.5.8 → 4.0.4
- **deps**: Actualización de Spring Cloud: 2025.0.0 → 2025.1.0
- **deps**: Actualización de SpringDoc OpenAPI: 2.8.10 → 3.0.2
- **deps**: Actualización de OpenPDF: 3.0.0 → 3.0.3
- **deps**: Actualización de commons-lang3: 3.18.0 → 3.20.0
- **config**: Eliminación de configuración executable en spring-boot-maven-plugin
- **refactor**: ConsumoContextDto y DatoConsumoDto usan @Getter/@Setter/@NoArgsConstructor/@AllArgsConstructor

### Added
- **deps**: Nueva dependencia commons-fileupload 1.6.0

### Security
- Actualización a últimas versiones estables de dependencias

## [0.0.1] - 2024-01-24

### Added
- Implementación inicial del servicio de reportes
- Generación de liquidaciones individuales
- Generación de liquidaciones por zona
- Envío automático de liquidaciones por correo
- Integración con servicios core
- Documentación inicial del proyecto 