# Laboratorio 2 - Sistemas Distribuidos USACH

## Ingesta de datos streaming a una base de datos y disponibilización de interfaz de consulta de datos

## Integrantes del grupo

- Pablo Cáceres Luzanto
- Nicolás Mariángel Toledo
- Juan Pablo Rojas

## Descripción del problema

El problema al cual nos enfrentamos consta de dos partes principalmente. En primer lugar, se debe ingerir datos desde un stream de datos público en tiempo real, y estos datos almacenarlos en una base de datos, en este caso, PostgreSQL montada en Google Cloud Platform a través de Google CloudSQL. Luego, a través de una simple página web se debe disponibilizar la ingesta de datos mencionada anteriormente para que determinados usuarios, previa autenticación puedan acceder a estos. 

## Enfoque de solución

En este caso, el enfoque utilizado aborda el problema desde una perspectiva de Sistema Distribuido, utilizando las herramientas que nos brinda Google CloudSQL para poder flexibilizar la capacidad de almacenamiento y, por ende el rendimiento de nuestra base de datos ante determinados escenarios de manera automática.


## Desarrollo de la actividad

### Principales inconvenientes o barreras detectadas.

Dentro de los principales inconvenientes que se tuvo a la hora de llevar a cabo la solución, se encuentran:

- Curva de aprendizaje en Google Cloud Platform.
- Curva de aprendizaje Yaml.
- Conexión Rest API con PostgreSQL.
- Hackeo a nuestra plataforma.

### Clases/funciones/procedimientos principales del desarrollo.

El desarrollo de la solución se compone de principalmente 4 partes

- Instancia de SQL en Google Cloud Platform. En esta instancia, se almacenan los datos obtenidos a partir de la ingesta de datos en tiempo real de wikipedia.

- Código en java utilizado para ingerir los datos y enviarlos a la instancia mencionada en el punto anterior.

- Código en java en el framework springboot utilizado para disponibilizar una pequeña API que simplemente obtiene todas las entradas almacenadas en la instancia de mysql en Google Cloud Platform.

- Aplicación construida en Laravel, que disponibiliza y visualiza los datos adquiridos a través de la API mencionada en el punto anterior, en conjunto con el uso de credenciales para otorgar acceso a estos datos.  

## Resultados

## Link de acceso a versión productiva del software.
[Sistemas Distribuidos Data Streaming](https://github.com/Uriyah3/sd_data_streaming)

##  Pasos para desplegar servicio desde cero, considerar:

### Maquina linux estándar (tomar como referencia ubuntu server en su última versión LTS)

### Implementar arquitectura como código (Yaml y TerraForm).
