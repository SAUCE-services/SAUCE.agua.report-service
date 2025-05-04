# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [Unreleased]

### Added
- Nuevo cliente Feign `FacturacionClient` para integración con el servicio de facturación
- Configuración de modo testing en `bootstrap.yml`
- Logging mejorado para debugging en `LiquidacionService`
- Métodos de logging para objetos DTOs

### Changed
- Actualización de dependencias:
  - Spring Boot de 3.4.2 a 3.4.5
  - Spring Cloud de 2024.0.0 a 2024.0.1
  - SpringDoc OpenAPI de 2.8.4 a 2.8.6
- Mejora en el formato del footer de las liquidaciones
- Optimización del layout de las tablas en el PDF
- Refactorización del código de logging para mejor legibilidad
- Modificación del sistema de envío de correos para soportar modo testing

### Removed
- Campo `pfBarras` de `FacturaDto`
- Sección de "2do Vencimiento" de las liquidaciones
- Código redundante en el footer de las liquidaciones

### Fixed
- Corrección en la generación de códigos de barras usando el servicio de facturación
- Ajuste en el alineamiento de valores numéricos en el footer
- Mejora en el manejo de correos electrónicos en modo testing

## [0.0.1] - 2024-01-24

### Added
- Implementación inicial del servicio de reportes
- Generación de liquidaciones individuales
- Generación de liquidaciones por zona
- Envío automático de liquidaciones por correo
- Integración con servicios core
- Documentación inicial del proyecto 