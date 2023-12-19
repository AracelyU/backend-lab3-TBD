# Instrucción configuración Laboratorio n°3 – TBD

Para poder realizar la consulta solicitada en mongodb,

Debe iniciar el proyecto backend. Asegurandose de crear una base de datos en pgAdmin (PostgreSQL) con el nombre “TBD_Lab2” y crear y poblar la base de datos que de mongodb según lo indicado en https://github.com/AracelyU/lab3_TBD_grupo3

Luego en Postman tras autenticar la sesión (*) , se coloca como método POST la url localhost:8080/taskMongo/tareasActivas/idEmergencia, con idEmergencia un numero entero positivo

(*) Para autenticar sesión en Postman se tiene que hacer una petición POST con la url localhost:8080/auth/login con un body JSON

{
    "username": "AracelyC",
    "password": "holamundo"

}

Luego el token generado se pega en el "Authorization" tipo "Bearer Token" de la consulta de tareasActivas. 

Consideraciones de implementación
1. Las sesiones de usuario duran 24 minutos. Pasado ese tiempo deberá volver a iniciar sesión.
2. Si desea ver más tareas o emergencias activas debe cambiar manualmente desde MongoDB Compass id_state: 2

Developed by @[benjaminCanalesC](https://github.com/benjaminCanalesC) @[BrancoGarciaS](https://github.com/BrancoGarciaS) @[daniel-eguiluz](https://github.com/daniel-eguiluz) @[aracelyU](https://github.com/aracelyU)
