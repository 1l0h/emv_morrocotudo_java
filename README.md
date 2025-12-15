🚀 EMV Java con PostgreSQL: Entorno Mínimo Viable
Este repositorio contiene la configuración para un Entorno Mínimo Viable (EMV) de desarrollo que permite levantar una aplicación Java junto con una base de datos persistente PostgreSQL, todo orquestado por Docker Compose. El objetivo es proporcionar un sandbox funcional para nuevos proyectos Java que requieran persistencia de datos.

🎯 Arquitectura del Entorno (Paso 1)
El entorno se define mediante dos servicios principales:


app (Java): Contenedor que construye y ejecuta la aplicación Java con JDK 17 (Eclipse Temurin).


db (PostgreSQL): Base de datos relacional PostgreSQL 14 que asegura la persistencia de los datos.

✅ Requisitos Previos
Para utilizar este EMV, es necesario tener instalados en tu sistema:

Docker Engine: Para construir y ejecutar los contenedores.

Docker Compose: Para orquestar los servicios (app y db) con el comando docker compose.

🛠️ Configuración y Uso (Paso 3)
1. Estructura de Archivos
Asegúrate de que los siguientes archivos se encuentren en el directorio raíz de tu proyecto:

docker-compose.yml

Dockerfile


Emv.java (El código fuente que se compila y ejecuta )

2. Pasos de Configuración Inicial
El Dockerfile se encarga automáticamente de:

Descargar la imagen base eclipse-temurin:17-jdk-focal.

Copiar el código fuente Emv.java.

Compilar el código (RUN javac Emv.java).

Definir las variables de entorno para la base de datos.

Ejecutar la aplicación y mantener el contenedor activo (tail -f /dev/null).

3. Comandos de Operación del Entorno
Acción	Comando	Notas
🟢 Iniciar el Entorno	docker compose up -d	
Construye las imágenes y levanta ambos servicios en segundo plano (-d).

🟡 Verificar el Estado	docker compose ps	
Confirma que ambos servicios (app y db) estén en estado Up.

📜 Ver Prueba de Funcionamiento	docker compose logs app	
Muestra la salida de Emv.java (banner, latido, estado).

🛑 Detener Contenedores	docker compose down	
Detiene y elimina los contenedores y la red. Mantiene el volumen de datos (db_data).

🗑️ Limpiar Todo	docker compose down -v	
Detiene, elimina contenedores y elimina permanentemente los datos de la DB (-v para volúmenes).


Exportar a Hojas de cálculo

🔌 Conexión a Servicios (Paso 3)
Servicio de Aplicación (app)
El contenedor app ha mapeado su puerto interno 8080 al puerto 8080 de tu máquina local.

URL de Acceso (Web): http://localhost:8080 (Para futuras aplicaciones web/servlets).


Estado Actual: La prueba de concepto (Emv.java) imprime su estado directamente en los logs del contenedor.

Servicio de Base de Datos (db)
La conexión se establece internamente desde el servicio app al servicio db. No se requiere mapear el puerto 5432 al host por seguridad.

Variable de Conexión	Host	Puerto	Usuario	Contraseña	DB Name
Valor	db	5432	usuario_app	clave_secreta_app	mi_base_de_datos

Exportar a Hojas de cálculo

URL de Conexión (Ejemplo JDBC para el servicio app):


jdbc:postgresql://db:5432/mi_base_de_datos