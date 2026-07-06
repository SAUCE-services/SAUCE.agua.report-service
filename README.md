# Report Service

[![Java](https://img.shields.io/badge/Java-25-orange.svg)](https://www.oracle.com/java/)
[![Spring Boot](https://img.shields.io/badge/Spring%20Boot-4.1.0-brightgreen.svg)](https://spring.io/projects/spring-boot)
[![Spring Cloud](https://img.shields.io/badge/Spring%20Cloud-2025.1.2-blue.svg)](https://spring.io/projects/spring-cloud)
[![OpenPDF](https://img.shields.io/badge/OpenPDF-3.0.5-red.svg)](https://github.com/LibrePDF/OpenPDF)
[![SpringDoc OpenAPI](https://img.shields.io/badge/SpringDoc%20OpenAPI-3.0.3-blue.svg)](https://springdoc.org/)
[![Maven](https://img.shields.io/badge/Maven-3.8+-red.svg)](https://maven.apache.org/)

Servicio de generación de reportes para el sistema de gestión de agua.

## Descripción

Este servicio es responsable de generar reportes y liquidaciones en formato PDF para el sistema de gestión de agua. Utiliza OpenPDF 3.0.5 para la generación de documentos PDF y se integra con otros servicios a través de Spring Cloud.

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
- Spring Boot 4.1.0
- Spring Cloud 2025.1.2
- OpenPDF 3.0.5
- Spring Cloud Consul Discovery
- Spring Cloud OpenFeign
- Spring Boot Mail
- SpringDoc OpenAPI 3.0.3
- Lombok para reducción de boilerplate code
- Caffeine para caching
- Hibernate Validator

## Requisitos

- Java 25 o superior
- Maven 3.8 o superior
- Acceso a los servicios dependientes:
  - Core Service
  - Consul Server

## Configuración

El servicio se configura a través de los siguientes archivos:

- `bootstrap.yml`: Configuración básica del servicio
- `application.yml`: Configuración específica de la aplicación

### Propiedades principales

```yaml
app:
  port: 8092
  logging: debug
  name: report-service
  consul:
    host: consul-service
    port: 8500
  testing: false
  mail:
    username: uid
    password: pwd

server:
  port: ${app.port}

spring:
  application:
    name: ${app.name}
  cloud:
    consul:
      host: ${app.consul.host}
      port: ${app.consul.port}
      discovery:
        prefer-ip-address: true
        tags: report

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

## Diagramas

### Arquitectura del Servicio
![Arquitectura](docs/diagrams/architecture.mmd)

### Flujo de Solicitud
![Flujo de Solicitud](docs/diagrams/request-flow.mmd)

### Estados del Servicio
![Estados del Servicio](docs/diagrams/report-service-status.mmd)

## Desarrollo

### Estructura del proyecto

```
src/main/java/com/sauce/agua/report/
├── client/         # Clientes Feign para servicios externos
│   ├── core/       # Clientes para servicios core
│   │   └── facade/ # Clientes facade para servicios core
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

## Licencia

Este proyecto es privado y confidencial.
