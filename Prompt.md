## PROMPT COMPLETO

Actúa como un ingeniero DevOps experto y genera los archivos necesarios para un Entorno Mínimo Viable (EMV) de Java con persistencia PostgreSQL utilizando Docker Compose. La salida debe ser presentada en tres bloques de código distintos: docker-compose.yml, Dockerfile y README.md.

## PARTE 1: Configuración de Servicios (docker-compose.yml)
1 - Versión: Utiliza la versión 3.8.

2 - Servicios: Define dos servicios: app (Java) y db (PostgreSQL).

3 - Servicio app (Java):

- Debe construirse a partir de un Dockerfile en el directorio actual (build: .).

- Mapea el puerto del host 8080 al puerto del contenedor 8080.

- Debe tener la política de reinicio restart: always.

4 - Servicio db (PostgreSQL):

- Usa la imagen postgres:14-alpine.

- Define las siguientes variables de entorno para la configuración interna: POSTGRES_DB: mi_base_de_datos, POSTGRES_USER: usuario_app, POSTGRES_PASSWORD: clave_secreta_app.

- Utiliza un volumen con nombre (db_data) para la persistencia en el path /var/lib/postgresql/data.

- Debe tener la política de reinicio restart: always.

- Expón el puerto 5432 solo internamente (expose).

5 - Volúmenes: Define el volumen con nombre db_data.

## PARTE 2: Definición de la Aplicación (Dockerfile)
1 - Imagen Base: Usa la imagen robusta eclipse-temurin:17-jdk-focal para evitar errores de image not found.

2 - Lógica Java: La aplicación está en el archivo Emv.java. El Dockerfile debe:

- Establecer el WORKDIR en /app.

- Copiar el archivo Emv.java al contenedor.

- Compilar el archivo Java usando RUN javac Emv.java.

3 - Credenciales: Define las mismas variables de entorno para la DB que en el servicio db para que la aplicación Java las use, demostrando la configuración de la aplicación: ENV DB_HOST=db, ENV DB_PORT=5432, ENV DB_USER=usuario_app, ENV DB_PASS=clave_secreta_app, ENV DB_NAME=mi_base_de_datos.

4 - Comando de Ejecución (Solución de Reinicio): El comando final (CMD) debe ejecutar la aplicación Java y mantener el contenedor activo para evitar el bucle de reinicio. Utiliza CMD ["sh", "-c", "java Emv && tail -f /dev/null"].

## PARTE 3: Documentación (README.md)
Genera un archivo README.md completo y profesional que incluya:

1 - Título y Objetivo (EMV Java + PostgreSQL).

2 - Arquitectura: Breve descripción de los servicios app y db.

3 - Requisitos Previos: (Docker y Docker Compose).

4 - Comandos de Operación en una tabla, incluyendo: docker compose up -d, docker compose ps, docker compose down, docker compose down -v, y el comando para ver los logs de la aplicación (docker compose logs app).

5 - Sección de Conexión a Servicios que liste las variables y valores de conexión (Hostname, Puerto, Usuario, Contraseña, DB Name) para el servicio db, indicando que db es el hostname interno.
