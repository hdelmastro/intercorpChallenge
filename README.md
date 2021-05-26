# Intercorp Challenge

_API para la obtencion de diversos datos de clientes registrados_

## Comenzando 🚀

_A continuación se detalla los paso para la puesta en funcionamiento de forma local de la aplicación._

### Pre-requisitos 📋

_Debes tener instalado JAVA jdk 1.8 o posterior (https://www.oracle.com/ar/java/technologies/javase/javase-jdk8-downloads.html)._

_Y Maven para poder compilar el proyecto (https://maven.apache.org/download.cgi)._


### Instalación Local🔧

_Una vez clonado el repositorio dirigirse a la carpeta de descarga, para ejecutarlo debe correr la siguiente linea de commandos:_

```
mvn spring-boot:run
```

## Pruebas ⚙️

_Desde la documentación Swagger:_

https://intercorp-challenge.herokuapp.com/swagger-ui.html#/

_O, de forma local:_

_Para crear nuevos clientes puede hacer un POST al siguientes endpoint:_

```
http://localhost:8080/intercorp/client
```
```Body
{
  "age": 5,
  "birthDate": "1985-05-05",
  "lastName": "Perez",
  "name": "Juan"
}
```

_Para probar el servicio puede hacer un GET a alguno de los siguientes endpoints:_

```
http://localhost:8080/intercorp/listclientes
```
```
http://localhost:8080/intercorp/kpideclientes
```


## Construido con 🛠️

* [Maven](https://maven.apache.org/) - Manejador de dependencias
* [Sring Boot](https://spring.io/projects/spring-boot/) 
* [Lombok](https://projectlombok.org/) 

## Autores ✒️

* **Héctor Edgardo del Mastro** - *Trabajo Inicial* - [hdelmastro](https://github.com/hdelmastro)

