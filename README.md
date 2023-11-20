# Instrucción configuración Laboratorio n°2 – TBD
Para comenzar la configuración se requiere realizar un pull al repositorio https://github.com/Mieres7/Frontend_dbd2_grupo3/.

Configurar el backend:
1.	Crear una base de datos en pgAdmin (PostgreSQL) con el nombre “TBD_Lab2”.
2.	Utilizar la herramienta de Query, copiar el código “dbCreate” desde el repositorio y ejecutarlo.
3.	Utilizar la herramienta de Query, copiar el código “dbLoad” desde el repositorio y ejecutarlo.
4.	Utilizar la herramienta de Query, copiar el código “dbTriggers” desde el repositorio y ejecutarlo.
5.	Desde intelliJ se carga la carpeta correspondiente al backend y se configura los datos relacionados al perfil de PostgreSQL a la espera de la carga de las dependencias. En el archivo “application.properties” en resources se debe indicar la información respectiva a la base de datos, los valores por defecto son el puerto 5432, user postgres y la password 1234.
6.	Verificando que el IDE ejecute el archivo “Laboratorio1BackendApplication” se le da a correr el programa (Mayus + F10).

Configurar el frontend:
1.	Desde una terminal dentro de la carpeta del frontend se debe ejecutar el comando “npm install”.
2.	Al tener las dependencias instaladas se ejecuta el comando “npm run dev”.
3.	Se accede a la ruta entregada por la terminal.

Consideraciones de implementación
1. Las sesiones de usuario duran 24 minutos. Pasado ese tiempo deberá volver a iniciar sesión.
2. Si desea modificar el estado de una tarea las palabras aceptadas son las siguientes: Inicializada, En curso, Finalizada, inicializada, en curso, finalizada.
3. Si desea revisar la participación en la base de datos revisar el repositorio: https://github.com/benjaminCanalesC/lab1-TBD-grupo3

Developed by @[benjaminCanalesC](https://github.com/benjaminCanalesC) @[BrancoGarciaS](https://github.com/BrancoGarciaS) @[daniel-eguiluz](https://github.com/daniel-eguiluz) @[aracelyU](https://github.com/aracelyU)
