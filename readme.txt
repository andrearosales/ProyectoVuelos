HERRAMIENTAS UTILIZADAS Y VERSIONES
- Eclipse IDE: Eclipse Mars.1 (4.5.1)
- PostgreSQL: Version 9.5.0
- Apache Tomcat: Version 7.0.67

Este proyecto implementa las siguientes funcionalidades:
- CRUD Pasajero
- CRUD Ruta
- CRUD Avión
Las anteriores funcionalidades fueron desarrolladas en base a JavaEE, JSF y JPA (se omitió spring y hibernate).
La unificación del servidor con la base de datos no fue posible, por lo que actualmente las funcionalidades están probadas en base a información insertada directamente en el código.

Las funcionalidades relacionadas con los vuelos y el reporte no se encuentran implementadas.

El código fuente de la aplicación está dividido en las clases Java y los archivos para el contenido web
- SRC Java
	* control: Carpeta que contiene los Managed Bean a cargo de comunicar la capa de presentación con el modelo.
	* logica: Carpeta que contiene los EJB (Enterprise Java Bean) que acceden directamente a las entidades del modelo.
	* model: Carpeta que contine las entidades creadas a partir de las tablas de la base de datos.

- Web Content: Incluye todos los archivos .xhtml (JSF) que representan la capa de presentación.

Para correr la aplicación es necesario crear un nuevo proyecto en Eclipse y agregar el código fuente. Click derecho en el archivo index.xhtml -> Run as -> Run on server.

Es necesario instalar PostgreSQL y crear una nueva base de datos llamada "aplicacionVuelos". El script aplicacion_vuelos.sql contiene los statements para la creación de las tablas.