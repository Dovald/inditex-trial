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

Para los tests unitarios he usado la libreria [bean-matchers](https://github.com/orien/bean-matchers) que aporta test basicos a las clases POJO para aumentar la cobertura de codigo.
Para los test de integración no he mockeado nada y he usado programación reactiva con WebTestClient para probar un end2end completo.
El proyecto dispone de jacoco para los informes de cobertura y surefire el informe de ejecución de test.

Posible mejoras:

- La aplicación tiene un alto grado de acoplamiento, se podria cambiar la arquitectura del proyecto a una hexagonal.
- Se podria añadir algun tipo de seguridad en el endpoint ya sea por token en la cabeceras o haciendo uso de un certificado.
- Para la solución de busqueda del precio se presupone que los datos siempre seran correctos y que nunca habrá dos precios con la misma prioridad dentro de una misma fecha,
  se podría añadir algun control para comprobar que los datos son correctos o que saltar
