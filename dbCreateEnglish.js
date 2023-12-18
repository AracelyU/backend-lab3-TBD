// Para trabajar con MongoDB
const { MongoClient } = require('mongodb');
const url = 'mongodb://localhost:27017';

// Nombre de la base de datos
const nombreDb = 'TBD_Lab3';

// Las colecciones
const colecciones = ['ability', 'emergency', 'emergency_ability', 'emergency_institution', 'emergency_task', 'institution', 'profile', 'ranking', 'request', 'role', 'state', 'task', 'task_request', 'user', 'user_ability', 'user_request'];


// Función para eliminar la base de datos si ya existe
async function eliminarBdExistente() {
    const conexion = await MongoClient.connect(url);
    await conexion.db(nombreDb).dropDatabase();
    conexion.close();
}


// Función para crear la base de datos junto a las colecciones necesarias
async function crearBd() {
    // Conectar con el servidor
    const conexion = await MongoClient.connect(url);
    const db = conexion.db(nombreDb);
    try{
        for(const coleccion of colecciones){
            await db.createCollection(coleccion);
        }
        console.log('Base de datos creada correctamente');
    }catch(error){
        console.log('Error al crear la base de datos: ', error);
    }
    conexion.close();
}

// Eliminar base de datos existente y luego crear la nueva
async function crearNuevaBd() {
    await eliminarBdExistente();
    await crearBd();
}


// Crear base de datos
crearNuevaBd();