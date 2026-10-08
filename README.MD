# VetTurno - La agenda digital de Veterinaria Huellitas

## Descripción del Proyecto
VetTurno es una API REST construida con Spring Boot para modernizar la gestión de citas y turnos de la Veterinaria Huellitas, permitiendo registrar propietarios, mascotas, veterinarios y agendar turnos evitando cruces de horario.

## Tecnologías
- Java 17
- Spring Boot
- Maven
- MySQL & Spring Data JPA (Hibernate)
- Spring Security & JWT
- SpringDoc OpenAPI (Swagger UI)
- Bean Validation

## Roles del Sistema
- **USER** (Recepcionista - Paula): Registra propietarios, mascotas y agenda citas.
- **ADMIN** (Administradora - Doña Marta): Tareas de recepción y registro exclusivo de veterinarios.

## Cómo Ejecutar
1. Clonar el repositorio.
2. Crear la base de datos `vetturno` en MySQL.
3. Ajustar credenciales en `application.properties`.
4. Ejecutar con Maven:
   ```bash
   ./mvnw spring-boot:run