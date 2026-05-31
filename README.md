# registro-transacciones-backend

Backend del proyecto de registro de transacciones de pagos con Spring Boot, Java 17 y base de datos H2 en memoria.

## Requisitos

- Java 17+
- Maven 3.9+

## Ejecutar localmente

```bash
mvn spring-boot:run
```

La API queda disponible en `http://localhost:8080`.

## Endpoints principales

Base URL: `/api/transacciones`

- `GET /api/transacciones`: lista transacciones
- `GET /api/transacciones/{id}`: obtiene una transacción por id
- `POST /api/transacciones`: crea una transacción
- `PUT /api/transacciones/{id}`: actualiza una transacción
- `DELETE /api/transacciones/{id}`: elimina una transacción

Ejemplo de payload para crear/actualizar:

```json
{
  "descripcion": "Pago de servicio",
  "monto": 1250.50,
  "tipo": "EGRESO",
  "fecha": "2026-05-31T10:30:00"
}
```

## Consumo desde Angular

El backend habilita CORS para `http://localhost:4200` en rutas `/api/**`.

## Base de datos H2

- Consola: `http://localhost:8080/h2-console`
- JDBC URL: `jdbc:h2:mem:registrodb`
- User: `sa`
- Password: *(vacío)*

## Pruebas

```bash
mvn test
```
