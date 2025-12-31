# Report Service

[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5.8-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.0.0-blue.svg)](https://spring.io/projects/spring-cloud)
[![OpenPDF](https://img.shields.io/badge/OpenPDF-3.0.0-red.svg)](https://github.com/LibrePDF/OpenPDF)
[![SpringDoc OpenAPI](https://img.shields.io/badge/SpringDoc%20OpenAPI-2.8.10-blue.svg)](https://springdoc.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg)](https://maven.apache.org/)

Servicio de generación de reportes para el sistema de gestión de agua.

## Descripción

Este servicio es responsable de generar reportes y liquidaciones en formato PDF para el sistema de gestión de agua. Utiliza OpenPDF 3.0.0 para la generación de documentos PDF y se integra con otros servicios a través de Spring Cloud. En esta versión se ha migrado completamente de iText a OpenPDF para mejorar el rendimiento y mantener compatibilidad con licencias.

## Características

- Generación de liquidaciones individuales en PDF
- Generación de liquidaciones por zona en PDF
- Envío automático de liquidaciones por correo electrónico
- Integración con servicios de facturación y consumo
- Soporte para códigos de barras en las liquidaciones
- Configuración mejorada de health checks y actuator endpoints
- Modo testing para desarrollo y pruebas

## Tecnologías

- Java 25
- Spring Boot 3.5.8
- Spring Cloud 2025.0.0
- OpenPDF 3.0.0 (migrado desde iText)
- Spring Cloud Netflix Eureka Client
- Spring Cloud OpenFeign
- Spring Boot Mail
- SpringDoc OpenAPI 2.8.10
- Lombok para reducción de boilerplate code
- Caffeine para caching
- Consul para service discovery

## Requisitos

- Java 25 o superior
- Maven 3.8 o superior
- Acceso a los servicios dependientes:
  - Core Service
  - Eureka Server
  - Consul Server

## Configuración

El servicio se configura a través de los siguientes archivos:

- `bootstrap.yml`: Configuración básica del servicio
- `application.yml`: Configuración específica de la aplicación

### Propiedades principales

```yaml
app:
  eureka: 8761
  consul: 8500
  logging: debug
  name: report-service
  testing: false
  mail:
    username: uid
    password: pwd

management:
  health:
    mail:
      enabled: false
  endpoints:
    access:
      default: none
```

## Uso

### Generar una liquidación individual

```java
String pdfPath = liquidacionService.generateOnePdf(prefijoId, facturaId);
```

### Generar liquidaciones por zona

```java
String pdfPath = liquidacionService.generateZonaPdf(periodoId, zona);
```

### Enviar liquidación por correo

```java
String result = liquidacionService.sendLiquidacion(prefijoId, facturaId);
```

## Desarrollo

### Estructura del proyecto

```
src/main/java/com/sauce/agua/report/
├── client/         # Clientes Feign para servicios externos
│   ├── core/       # Clientes para servicios core
│   └── facade/     # Clientes para servicios facade
├── model/          # DTOs y modelos de datos
│   └── dto/        # Data Transfer Objects
├── service/        # Servicios de negocio
├── controller/     # Controladores REST
└── configuration/  # Configuraciones
```

### Compilación

```bash
mvn clean install
```

### Ejecución

```bash
mvn spring-boot:run
```

### Testing

```bash
mvn test
```

## Migración desde versión anterior

Esta versión incluye una migración completa de las librerías de PDF:

- **Antes**: iText (`com.lowagie.text`)
- **Ahora**: OpenPDF (`org.openpdf.text`)

Esta migración mejora el rendimiento y evita problemas de licencias manteniendo toda la funcionalidad existente.

## Licencia

Este proyecto es privado y confidencial.
