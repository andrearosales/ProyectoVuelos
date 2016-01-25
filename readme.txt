HERRAMIENTAS UTILIZADAS Y VERSIONES
- Eclipse IDE: Eclipse Mars.1 (4.5.1)
- PostgreSQL: Version 9.5.0
- Apache Tomcat: Version 7.0.67

Este proyecto implementa las siguientes funcionalidades:
- CRUD Pasajero
- CRUD Ruta
- CRUD Avi�n
Las anteriores funcionalidades fueron desarrolladas en base a JavaEE, JSF y JPA (se omiti� spring y hibernate).
La unificaci�n del servidor con la base de datos no fue posible, por lo que actualmente las funcionalidades est�n probadas en base a informaci�n insertada directamente en el c�digo.

Las funcionalidades relacionadas con los vuelos y el reporte no se encuentran implementadas.

El c�digo fuente de la aplicaci�n est� dividido en las clases Java y los archivos para el contenido web
- SRC Java
	* control: Carpeta que contiene los Managed Bean a cargo de comunicar la capa de presentaci�n con el modelo.
	* logica: Carpeta que contiene los EJB (Enterprise Java Bean) que acceden directamente a las entidades del modelo.
	* model: Carpeta que contine las entidades creadas a partir de las tablas de la base de datos.

- Web Content: Incluye todos los archivos .xhtml (JSF) que representan la capa de presentaci�n.

Para correr la aplicaci�n es necesario crear un nuevo proyecto en Eclipse y agregar el c�digo fuente. Click derecho en el archivo index.xhtml -> Run as -> Run on server.

Es necesario instalar PostgreSQL y crear una nueva base de datos llamada "aplicacionVuelos". El script aplicacion_vuelos.sql contiene los statements para la creaci�n de las tablas.