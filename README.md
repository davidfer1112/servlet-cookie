# Documentación del Repositorio Servlet Cookie

## Introducción
Este repositorio contiene un proyecto Java que utiliza Servlets para manejar cookies en una aplicación web. La aplicación permite listar productos, iniciar sesión y cerrar sesión utilizando cookies para mantener el estado de la sesión.

## Requisitos

Para ejecutar y desarrollar este proyecto necesitas tener instalado:

- JDK 17: Necesario para compilar y ejecutar el proyecto Java.
- Apache Maven: Utilizado para gestionar las dependencias del proyecto y facilitar el proceso de construcción.
- Apache Tomcat: Servidor web utilizado para desplegar la aplicación.

## Configuración del Proyecto
La configuración del proyecto se realiza a través del archivo `pom.xml`, el cual contiene las dependencias necesarias para el proyecto y la configuración específica para el plugin de Apache Tomcat, permitiendo el despliegue de la aplicación directamente desde Maven.

### Dependencias
El proyecto depende de la API de Jakarta EE y de la biblioteca Jackson para el manejo de JSON. Estas dependencias se definen en el archivo `pom.xml` como se muestra a continuación:

```xml
<dependencies>
    <dependency>
        <groupId>jakarta.platform</groupId>
        <artifactId>jakarta.jakartaee-api</artifactId>
        <version>9.1.0</version>
        <scope>provided</scope>
    </dependency>
    <dependency>
        <groupId>com.fasterxml.jackson.core</groupId>
        <artifactId>jackson-databind</artifactId>
        <version>2.12.3</version>
    </dependency>
</dependencies>
```

## Configuración de Maven para Tomcat
Para facilitar el despliegue de la aplicación en un servidor Tomcat directamente desde Maven, se incluye la configuración del plugin tomcat7-maven-plugin en el pom.xml. Esta configuración especifica la URL del servidor Tomcat y las credenciales de acceso.

```xml
<plugin>
    <groupId>org.apache.tomcat.maven</groupId>
    <artifactId>tomcat7-maven-plugin</artifactId>
    <version>2.2</version>
    <configuration>
        <url>http://localhost:8080/manager/text</url>
        <username>admin</username>
        <password>123</password>
    </configuration>
</plugin>
```

## Estructura del Proyecto
El proyecto está estructurado en varios paquetes que contienen clases para controladores, modelos, y servicios. A continuación, se detalla la estructura y el propósito de cada componente principal del proyecto.

# Modelos

## Producto
La clase Producto representa los productos que se pueden listar en la aplicación. Cada producto tiene un id, nombre, tipo, y precio.
```java
public class Producto {
    private Long id;
    private String nombre;
    private String tipo;
    private int precio;

    // Constructores, getters y setters
}
```

# Servicios

## ProductoService
Define la interfaz para los servicios relacionados con los productos. Incluye un método para obtener todos los productos disponibles.

```java
public interface ProductoService {
    List<Producto> getAll();
}
ProductoServiceImp
Implementación de la interfaz ProductoService, donde se simula la obtención de productos.

public class ProductoServiceImp implements ProductoService {
    @Override
    public List<Producto> getAll() {
        // Implementación
    }
}
```

## LoginService
Define la interfaz para los servicios relacionados con el inicio de sesión. Incluye métodos para iniciar sesión y obtener el nombre de usuario de la cookie.

```java
public interface LoginService {
    void login(HttpServletRequest req, HttpServletResponse resp);
    Optional<String> getUsername(HttpServletRequest req);
}
LoginServiceImp
Implementación de la interfaz LoginService, maneja el inicio de sesión y la recuperación del nombre de usuario desde una cookie.

public class LoginServiceImp implements LoginService {
    @Override
    public void login(HttpServletRequest req, HttpServletResponse resp) {
        // Implementación
    }

    @Override
    public Optional<String> getUsername(HttpServletRequest req) {
        // Implementación
    }
}
```

# Controladores

## ProductosServlet
Servlet que maneja la petición GET para listar los productos. Si el usuario está logueado y es admin, muestra también el precio de los productos.

```java
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    ProductoService service = new ProductoServiceImp();
    List<Producto> productos = service.getAll();

    LoginService auth = new LoginServiceImp();
    Optional<String> cookieOptional = auth.getUsername(req);

    // Código para generar la respuesta HTML
}
```

## LoginServlet y LogOutServlet
Servlets que manejan las peticiones para iniciar y cerrar sesión, respectivamente.

## Vistas
El proyecto utiliza HTML incrustado en los Servlets para generar las vistas. Por ejemplo, la lista de productos se genera dinámicamente en el método doGet del ProductosServlet.

## Archivos de Configuración
- pom.xml: Archivo de Maven para gestionar las dependencias y la construcción del proyecto.
- web.xml: Archivo de configuración de la aplicación web, define los servlets y sus mapeos de URL.
  
## Ejecución del Proyecto
Para ejecutar el proyecto, se necesita tener instalado `Java y Maven`. Se puede compilar y ejecutar utilizando el comando:

```cmd
mvn tomcat7:run 
```
