# Usa una imagen base con Java Development Kit (JDK) para compilar
FROM eclipse-temurin:17-jdk-focal

# Establece el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copia el código fuente Java
COPY Emv.java .

# Compila el código Java (genera Emv.class)
RUN javac Emv.java

# --- Credenciales (Para el EMV, si la app se conectara a la DB) ---
# Aunque tu app actual no las usa, las incluimos para demostrar la configuración:
ENV DB_HOST=db
ENV DB_PORT=5432
ENV DB_USER=usuario_app
ENV DB_PASS=clave_secreta_app
ENV DB_NAME=mi_base_de_datos

# Comando para ejecutar la aplicación cuando el contenedor se inicie
# NOTA: La aplicación se ejecutará e imprimirá su estado,
# y luego el comando 'tail -f /dev/null' mantendrá el contenedor activo.
CMD ["sh", "-c", "java Emv && tail -f /dev/null"]