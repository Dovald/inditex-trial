Proyecto creado por Fernando Garcia Doval el 6 de junio de 2023.

Este proyecto consiste en una prueba técnica para la empresa Inditex gestionada a través de BCNC Group.

El enunciado de esta prueba se encuentra en src/main/resources/Test_Java.txt

Consiste en la realización de un servicio web que dado un producto, una fecha y la tienda este devuelva el precio al que tiene que ser vendido.

Para la creación del controlador he usado [swagger-codegen](https://github.com/swagger-api/swagger-codegen) a partir de un swagger que he creado para esta prueba usando OpenAPI 3.0

El swagger se encuentra en src/main/resources/openapi.yaml

He habilitado swagger-ui en este proyecto para realizar mis pruebas durante el desarrollo, se puede acceder desde http://localhost:8080/inditex/swagger-ui/index.html

Puerto por defecto el 8080, se puede cambiar la configuración en src/main/resources/application.properties

Dada la naturaleza de la prueba, que "solo" necesitamos un valor sin que la petición realice cambios en la base de datos, por coherencia he decidido definir el endpoint como un GET
sin requestBody y pasando todas las variables en forma de path o query.
