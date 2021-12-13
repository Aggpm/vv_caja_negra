# Verificación y Validación del Software 2021
GRUPO IWM-42 grupo 3 

## Instrucciones para ejecutar este proyecto
* ####Clonar el repositorio utilizando un IDE
  (se debe importar como proyecto maven): https://github.com/Aggpm/vv_caja_blanca.git
* ####IMPORTAR JAR EN INTELLIJ:
    * Al abrir el proyecto importado, en la esquina inferior derecha del programa veremos "non-managed pom.xml file found:", desplegamos el mensaje y añadimos como proyecto de maven.
    * Posteriormente, en el apartado de "Run", accedemos a editar la configuración y añadimos una nueva configuración (símbolo +), y rellenamos el campo de linea de comando con:
      install:install-file-Dfile=/my/path/SingleList.jar-DgroupId=com.singleList -DartifactId=SingleList-Dversion=0.0.1-SNAPSHOT-Dpackaging=jar ; sustituyendo /my/path/ con el directorio donde se encuentre el proyecto guardado.
    * Finalmente aplicamos los cambios y corremos el programa para su inclusión.

* ####Ejecutar "maven install"
    * Para descargar las librerias(comprobar que se ha descargado SingleLinkedList.jar)

    * En el apartado de Maven View|Tool Windows ejecutar "mvn clean", "mvn compile" y por ultimo "mvn test"


## Instrucciones para utilizar este proyecto

* Cada alumno debe crearse un usuario de Github
* Un miembro del grupo debe hacer fork a este proyecto y añadir al repositorio forkeado a sus compañeros de grupo y al profesor como colaboradores.
* Descargar el proyecto utilizando git clone desde el terminal o desde el IDE.
* Seguir las indicaciones del enunciado para añadir las dependencias necesarias para empezar a realizar las pruebas
* Modificar este fichero añadiendo el número de grupo correspondiente y las instrucciones para ejecutar la práctica

