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
- Curva de aprendizaje Yaml y como aplicarlo en la GCP.
- Conexión Rest API con PostgreSQL.
- Hackeo a nuestra plataforma.

### Clases/funciones/procedimientos principales del desarrollo.

El desarrollo de la solución se compone de principalmente 4 partes

- Instancia de SQL en Google Cloud Platform. En esta instancia, se almacenan los datos obtenidos a partir de la ingesta de datos en tiempo real de wikipedia.

- Código en java obtenido y modificado desde [PubNub Java SDK 4.23.0](https://www.pubnub.com/docs/java-se-java/pubnub-java-sdk) utilizado para ingerir los datos desde [Wikipedia Changes](https://www.pubnub.com/developers/realtime-data-streams/wikipedia-changes) y enviarlos a la instancia mencionada en el punto anterior.


- Código en java en el framework springboot utilizado para disponibilizar una pequeña API que simplemente obtiene todas las entradas almacenadas en la instancia de mysql en Google Cloud Platform.

- Aplicación construida en Laravel, que disponibiliza y visualiza los datos adquiridos a través de la API mencionada en el punto anterior, en conjunto con el uso de credenciales para otorgar acceso a estos datos.  

## Resultados

## Link de acceso a versión productiva del software.
[Sistemas Distribuidos Access to streamed data](https://wikipedia-changes-page.herokuapp.com/)

##  Pasos para desplegar servicio desde cero:
Antes de desplegar el servicio, considerar que:
* Se utilizó una instancia de Cloud SQL para la base de datos PostgreSQL (que es donde se guardan los datos del streaming).
* Se tuvo problemas en automatizar el servicio que recibe los datos del stream y los almacena en la base de datos.
* El servicio que almacena los datos y la API que disponibliza los datos se implementaron para poder correr en Google App Engine.
* La página utiliza una base de datos (hosteada gratis en db4free.net) simple para almacenar a los usuarios y los tokens que pueden utilizar estos usuarios para acceder a la API. Además, la página se encuentra actualmente en Heroku, pero se puede utilizar cualquier otro servicio para el deployment de la página.

Para desplegar este servicio, los pasos son los siguientes:
1. Crear una cuenta en GCP y un proyecto con la facturación activada.
2. Crear una instancia de Cloud SQL [siguiendo esta guía de Google](https://cloud.google.com/sql/docs/postgres/quickstart).
3. Instalar la [SDK de Google Cloud](https://cloud.google.com/sdk/docs/) e inicializarla. Esta es utilizada para realizar el deployment de los servicios ya mencionados.
4. Instalar el App Engine SDK para Java utilizando `gcloud components install app-engine-java` luego de haber inicializado gcloud en la carpeta del proyecto.
5. Clonar este proyecto y hacer `cd streaming`
6. Cambiar el enlace de la conexión de la base de datos (buscar `jdbc:postgresql://google/...` en el proyecto) para conectarte a tu instancia de Cloud SQL y a la base de datos que hayas creado ahí. [Apretar aquí para más instrucciones sobre este paso](https://github.com/GoogleCloudPlatform/cloud-sql-jdbc-socket-factory).
7. Para poder conectarte a la base de datos en el entorno local, ejecutando `./gradlew bootRun` en Linux, o `gradlew.bat bootRun` en Windows, debes estar conectado por medio de gcloud a una cuenta de servicio que tenga los suficientes permisos, o definir la variable de entorno GOOGLE_APPLICATION_CREDENTIALS para que apunte a un archivo json que tenga las credenciales de una cuenta de servicio con los permisos suficientes para escribir y leer la base de datos.
8. Para realizar el deployment, entrar a la carpeta rest/streaming_wiki y ejecutar el comando `./gradlew appengineDeploy` (si sale un error sobre 'default' y 'apirest', cambiar 'service: apirest' en src/main/appengine/app.yaml a 'service: default'). Seguir esta misma instrucción para el deployment de 'streaming', aunque falta agregar el app.yaml neceario en este caso. 
9. Como no se pudo hacer que el streaming se ejecutará automáticamente, entrar por SSH al appengine de la instancia y clonar el repositorio dentro, instalar Java y ejecutar el comando `nohup ./gradlew bootRun &` para realizar el streaming.
10. [Para el deployment de la página en Heroku](https://devcenter.heroku.com/articles/getting-started-with-laravel). Cambiar las conexiones de la api en el archivo 'page/routes/api.php'.
