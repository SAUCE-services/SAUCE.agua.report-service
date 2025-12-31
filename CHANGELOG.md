# Changelog

Todos los cambios notables en este proyecto serán documentados en este archivo.

El formato está basado en [Keep a Changelog](https://keepachangelog.com/en/1.0.0/),
y este proyecto adhiere a [Semantic Versioning](https://semver.org/spec/v2.0.0.html).

## [0.1.0] - 2025-12-31

### Changed
- **BREAKING**: Migración completa de librerías PDF de `com.lowagie.text` a `org.openpdf.text`
  - Actualización de OpenPDF: 2.2.3 → 3.0.0
  - Eliminación de dependencias obsoletas de iText
  - Refactorización de imports y clases PDF
- **deps**: Actualización de Spring Boot: 3.5.3 → 3.5.8
- **deps**: Actualización de Java: 24 → 25
- **deps**: Actualización de SpringDoc OpenAPI: 2.8.9 → 2.8.10
- **refactor**: Simplificación del constructor usando Lombok @RequiredArgsConstructor
- **config**: Mejoras en configuración de actuator health checks
- **config**: Configuración de management endpoints access control

### Added
- **config**: Configuración mejorada de actuator health checks
- **config**: Configuración de management endpoints con acceso controlado
- **infra**: Actualización de Docker images para JDK 25
- **ci**: Actualización del workflow de GitHub Actions para JDK 25

### Fixed
- **perf**: Optimización en la generación de PDFs con la nueva librería OpenPDF
- **deps**: Eliminación de dependencias redundantes de iText

### Security
- **deps**: Actualización a las últimas versiones estables de dependencias

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
  - SpringDoc OpenAPI de 2.8.6 a 2.8.8
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
- Validación adicional para evitar generar códigos de barras cuando el valor es "00"

## [0.0.1] - 2024-01-24

### Added
- Implementación inicial del servicio de reportes
- Generación de liquidaciones individuales
- Generación de liquidaciones por zona
- Envío automático de liquidaciones por correo
- Integración con servicios core
- Documentación inicial del proyecto 