# Pacman Product Ranking API

Este proyecto implementa una API REST para ordenar productos según criterios ponderados (ventas, ratio de stock, etc.).

## 🧱 Arquitectura

El proyecto sigue el patrón de **Arquitectura Hexagonal (Ports & Adapters)**:

- **Dominio (`domain`)**: Modelos y puertos
- **Aplicación (`application`)**: Lógica de negocio y servicios
- **Infraestructura (`infrastructure`)**: Controladores REST
- **Entrada (`controller`)**: Adaptador HTTP
- **Salida (no implementada aún)**: Adaptadores como base de datos o eventos

## 🚀 Ejecutar

```bash
./mvnw spring-boot:run
```

Swagger UI disponible en:
```
http://localhost:8080/swagger-ui/index.html
```

## ✅ Endpoints disponibles

- `POST /api/products/sorted`: Devuelve la lista de productos ordenados según pesos enviados.

## 🧪 Testing

- Tests unitarios: `src/test/java/com/pacman/application`
- Tests de integración: `src/test/java/com/pacman/infrastructure/controller`

## 📦 Tecnologías

- Java 17+
- Spring Boot
- Springdoc OpenAPI (Swagger)
- JUnit 5

---

## 📥 Ejemplo de llamada API

### Endpoint

```http
POST /api/products/sorted
Content-Type: application/json
```

### Body

```json
{
  "sales": 1.0,
  "stockRatio": 0.5
}
```

### Ejemplo de respuesta

```json
[
  {
    "id": 1,
    "name": "Camiseta Blanca",
    "sales": 120,
    "stock": {
      "S": 10,
      "M": 15,
      "L": 5
    }
  },
  {
    "id": 2,
    "name": "Camiseta Negra",
    "sales": 100,
    "stock": {
      "S": 8,
      "M": 12,
      "L": 10
    }
  }
]
```

### curl

```bash
curl -X POST http://localhost:8080/api/products/sorted \
  -H "Content-Type: application/json" \
  -d '{"sales": 1.0, "stockRatio": 0.5}'
```
