# **Proyecto Examen 2**

## **_Gestión de Productos - API Rest con Spring Boot_**

El presente proyecto consiste en la realización de un API Rest desarrollada con Spring Boot para el cual se ha elegido el tema de un gestor de productos (CRUD), utilizando una separación por capas, conectado a una base de datos en MySQL, y un frontend web el cual permite ejecutar todas las peticiones para la gestión.

### **Tecnologías Utilizadas**
* Java 17
* Spring Boot
* Spring Data JPA
* MySQL
* HTML, CSS, JavaScript
* Bootstrap
* Maven

### **Requisitos previos**
Se debe tener instalado:
* Java JDK 17
* Maven
* MySQL
* Git
* Intellij (u otro entorno de desarrollo)


Configuración de la base de datos:
1.	Crear una base de datos en MySQL de nombre "empresa_productos"
2.	Configurar el archivo src/main/resources/application.properties

   spring.application.name=producto

   spring.datasource.url=jdbc:mysql://localhost:3306/empresa_productos
   
   **spring.datasource.username=tu_usuario**
   
   **spring.datasource.password=tu_contraseña**

   spring.jpa.hibernate.ddl-auto=update
   
   spring.jpa.show-sql=true

   spring.jpa.database-platform=org.hibernate.dialect.MySQL8Dialect
   
   spring.jpa.properties.hibernate.format_sql=true

   **spring.sql.init.mode=true (cambiar el "true" por "never" despues de correr el programa por primera vez, si no cada vez que se corra el programa se crearan los datos del data.sql y habran valores repetidos)**
   
   spring.jpa.defer-datasource-initialization=true

   server.port=8080

### **Ejecución del sistema:**

1. Abrir el proyecto en un entorno de desarrollo que tolere las tecnologías antes mencionadas.
2. Ejecutar la clase ProductoApplication.java, ubicada en src/main/java/com.empresa.producto.
3. En el navegador colocar la URL: http://localhost:8080/index.html, para visualizar el frontend.
4. Realizar las peticiones: Crear, Mostrar, Actualizar, Eliminar, Buscar por ID o por Nombre.


### **Si se desea probar los Endpoint principales en ApiDog, Postman u otro.**
### **Ejecutar de la siguiente manera:**

1. Abrir el proyecto en un entorno de desarrollo que tolere las tecnologías antes mencionadas.
2. Ejecutar la clase ProductoApplication.java, ubicada en src/main/java/com.empresa.producto.

URL principal: http://localhost:8080

| Método | URL                 | Acción              |
| ------ | ------------------- | ------------------- |
| GET    | /api/productos      | Listar productos    |
| GET    | /api/productos/{id} | Obtener por id      |
| POST   | /api/productos      | Crear producto      |
| PUT    | /api/productos/{id} | Actualizar producto |
| DELETE | /api/productos/{id} | Eliminar producto   |



**Realizado por:**
* Emily Pazmiño
* Ariana Villota
