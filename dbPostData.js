// Para trabajar con MongoDB
const { MongoClient } = require('mongodb');
var ObjectID = require('mongodb').ObjectId;
const url = 'mongodb://localhost:27017';

// Nombre de la base de datos
const nombreDb = 'TBD_Lab3';

async function importarDatos(){
    const conexion = await MongoClient.connect(url);
    const db = conexion.db(nombreDb);


    // ABILITY ------------------------------------------------------------------
    // Comprobar si hay datos en la colección ability antes de insertar
    const abilityCollection = db.collection('ability');
    const abilityCount = await abilityCollection.countDocuments({});

    if (abilityCount === 0) {
        // Si no hay datos, insertar documentos
        await abilityCollection.insertMany([
            { id_ability: 1, ability_name: 'Liderazgo', ability_description: 'Ser capaz de guiar a equipos, coordinar esfuerzos y mantener la calma en situaciones caóticas' },
            { id_ability: 2, ability_name: 'Adaptabilidad', ability_description: 'Poder enfrentar situaciones dinámicas e impredecibles provocadas por los desastres naturales' },
            { id_ability: 3, ability_name: 'Trabajo en equipo', ability_description: 'Tener la capacidad de colaborar efectivamente con otro voluntario' },
            { id_ability: 4, ability_name: 'Habilidades de búsqueda y rescate', ability_description: 'Ser capaz de buscar heridos y rescatar personas afectadas' },
            { id_ability: 5, ability_name: 'Apoyo psicológico', ability_description: 'Lidiar con el estrés y proporcionar apoyo emocional a las víctimas del desastre' },
            { id_ability: 6, ability_name: 'Habilidades de atención médica', ability_description: 'Saber proporcionar primeros auxilios y atención médica de emergencia' },
        ]);

        console.log('Datos de ability importados correctamente');
    } else {
        console.log('La colección ability ya contiene datos. No se realizaron inserciones.');
    }


    // EMERGENCY -----------------------------------------------------------------------------------------
    // Comprobar si hay datos en la colección emergency antes de insertar
    const emergencyCollection = db.collection('emergency');
    const emergencyCount = await emergencyCollection.countDocuments({});

    if (emergencyCount === 0) {
        // Si no hay datos, insertar documentos
        await emergencyCollection.insertMany([
            { id_emergency: 1, emergency_name: 'Incendio forestal en comuna Lautaro', emergency_location: 'Lautaro, Región de la Araucanía', emergency_type: '0', statement_date: '2023-10-15', id_state: 2 },
            { id_emergency: 2, emergency_name: 'Incendio forestal en Viña del Mar', emergency_location: 'Viña del Mar, Región de Valparaíso', emergency_type: '0', statement_date: '2023-10-14', id_state: 2 },
            { id_emergency: 3, emergency_name: 'Erupción Volcán Villarica', emergency_location: 'Región de la Araucanía', emergency_type: '1', statement_date: '2023-10-16', id_state: 1 },
            { id_emergency: 4, emergency_name: 'Erupción complejo volcánico Puyehue', emergency_location: 'Región de los Ríos', emergency_type: '1', statement_date: '2023-10-12', id_state: 2 },
            { id_emergency: 5, emergency_name: 'Terremoto de Iquique', emergency_location: 'Región de Tarapacá', emergency_type: '2', statement_date: '2023-10-15', id_state: 2 },
            { id_emergency: 6, emergency_name: 'Terremoto Tocopilla', emergency_location: 'Región de Antofagasta', emergency_type: '2', statement_date: '2023-10-13', id_state: 1 },
            { id_emergency: 7, emergency_name: 'Derrumbe Santiago', emergency_location: 'Región Metropolitana', emergency_type: '3', statement_date: '2023-10-09', id_state: 1 },
            { id_emergency: 8, emergency_name: 'Derrumbes en Illapel', emergency_location: 'Región de Coquimbo', emergency_type: '3', statement_date: '2023-10-10', id_state: 1 },
            { id_emergency: 9, emergency_name: 'Tsunami en Antofagasta', emergency_location: 'Región de Antofagasta', emergency_type: '4', statement_date: '2023-10-08', id_state: 1 },
            { id_emergency: 10, emergency_name: 'Tsunami en Constitución', emergency_location: 'Región de El Maule', emergency_type: '4', statement_date: '2023-10-08', id_state: 1 },
            { id_emergency: 11, emergency_name: 'Aluvión de Villa Santa Lucía', emergency_location: 'Chaitén, Región de Los Lagos', emergency_type: '5', statement_date: '2023-10-13', id_state: 1 },
            { id_emergency: 12, emergency_name: 'Aluvión del Biobío', emergency_location: 'Región del Biobío', emergency_type: '5', statement_date: '2023-10-14', id_state: 1 },
        ]);

        console.log('Datos de emergency importados correctamente');
    } else {
        console.log('La colección emergency ya contiene datos. No se realizaron inserciones.');
    }



    // EMERGENCY-ABILITY ---------------------------------------------------------------------------
    // Comprobar si hay datos en la colección emergency_ability antes de insertar
    const emergencyAbilityCollection = db.collection('emergency_ability');
    const emergencyAbilityCount = await emergencyAbilityCollection.countDocuments({});

    if (emergencyAbilityCount === 0) {
        // Si no hay datos, insertar documentos
        await emergencyAbilityCollection.insertMany([
            { id_emergency: 1, id_ability: 3 },
            { id_emergency: 1, id_ability: 6 },
            { id_emergency: 2, id_ability: 1 },
            { id_emergency: 2, id_ability: 3 },
            { id_emergency: 2, id_ability: 4 },
            { id_emergency: 3, id_ability: 2 },
            { id_emergency: 3, id_ability: 4 },
            { id_emergency: 3, id_ability: 6 },
            { id_emergency: 4, id_ability: 1 },
            { id_emergency: 4, id_ability: 2 },
            { id_emergency: 4, id_ability: 6 },
            { id_emergency: 5, id_ability: 2 },
            { id_emergency: 5, id_ability: 3 },
            { id_emergency: 5, id_ability: 4 },
            { id_emergency: 6, id_ability: 1 },
            { id_emergency: 6, id_ability: 4 },
            { id_emergency: 7, id_ability: 4 },
            { id_emergency: 7, id_ability: 5 },
            { id_emergency: 8, id_ability: 3 },
            { id_emergency: 8, id_ability: 5 },
            { id_emergency: 9, id_ability: 1 },
            { id_emergency: 9, id_ability: 5 },
            { id_emergency: 10, id_ability: 3 },
            { id_emergency: 10, id_ability: 5 },
            { id_emergency: 11, id_ability: 2 },
            { id_emergency: 11, id_ability: 3 },
            { id_emergency: 11, id_ability: 5 },
            { id_emergency: 12, id_ability: 2 },
            { id_emergency: 12, id_ability: 3 },
            { id_emergency: 12, id_ability: 4 },
        ]);

        console.log('Datos de emergency_ability importados correctamente');
    } else {
        console.log('La colección emergency_ability ya contiene datos. No se realizaron inserciones.');
    }


    // EMERGENCY-INSTITUTION ---------------------------------------------------------------------
    // Comprobar si hay datos en la colección emergency_institution antes de insertar
    const emergencyInstitutionCollection = db.collection('emergency_institution');
    const emergencyInstitutionCount = await emergencyInstitutionCollection.countDocuments({});

    if (emergencyInstitutionCount === 0) {
        // Si no hay datos, insertar documentos
        await emergencyInstitutionCollection.insertMany([
            { id_emergency: 1, id_institution: 4 },
            { id_emergency: 2, id_institution: 4 },
            { id_emergency: 3, id_institution: 2 },
            { id_emergency: 4, id_institution: 2 },
            { id_emergency: 5, id_institution: 1 },
            { id_emergency: 6, id_institution: 1 },
            { id_emergency: 7, id_institution: 6 },
            { id_emergency: 8, id_institution: 6 },
            { id_emergency: 9, id_institution: 3 },
            { id_emergency: 10, id_institution: 3 },
            { id_emergency: 11, id_institution: 5 },
            { id_emergency: 12, id_institution: 5 },
        ]);

        console.log('Datos de emergency_institution importados correctamente');
    } else {
        console.log('La colección emergency_institution ya contiene datos. No se realizaron inserciones.');
    }


    // EMERGENCY-TASK --------------------------------------------------------------------
    // Comprobar si hay datos en la colección emergency_task antes de insertar
    const emergencyTaskCollection = db.collection('emergency_task');
    const emergencyTaskCount = await emergencyTaskCollection.countDocuments({});

    if (emergencyTaskCount === 0) {
        // Si no hay datos, insertar documentos
        await emergencyTaskCollection.insertMany([
            { id_emergency: 1, id_task: 1 },
            { id_emergency: 1, id_task: 3 },
            { id_emergency: 1, id_task: 5 },
            { id_emergency: 1, id_task: 12 },
            { id_emergency: 2, id_task: 3 },
            { id_emergency: 2, id_task: 4 },
            { id_emergency: 2, id_task: 8 },
            { id_emergency: 3, id_task: 4 },
            { id_emergency: 3, id_task: 6 },
            { id_emergency: 3, id_task: 8 },
            { id_emergency: 3, id_task: 12 },
            { id_emergency: 4, id_task: 5 },
            { id_emergency: 4, id_task: 6 },
            { id_emergency: 4, id_task: 9 },
            { id_emergency: 5, id_task: 1 },
            { id_emergency: 5, id_task: 9 },
            { id_emergency: 5, id_task: 10 },
            { id_emergency: 5, id_task: 11 },
            { id_emergency: 6, id_task: 2 },
            { id_emergency: 6, id_task: 4 },
            { id_emergency: 6, id_task: 12 },
            { id_emergency: 7, id_task: 4 },
            { id_emergency: 7, id_task: 11 },
            { id_emergency: 8, id_task: 4 },
            { id_emergency: 8, id_task: 11 },
            { id_emergency: 8, id_task: 12 },
            { id_emergency: 9, id_task: 2 },
            { id_emergency: 9, id_task: 7 },
            { id_emergency: 9, id_task: 8 },
            { id_emergency: 10, id_task: 4 },
            { id_emergency: 10, id_task: 7 },
            { id_emergency: 10, id_task: 12 },
            { id_emergency: 11, id_task: 8 },
            { id_emergency: 11, id_task: 10 },
            { id_emergency: 11, id_task: 11 },
            { id_emergency: 12, id_task: 1 },
            { id_emergency: 12, id_task: 2 },
            { id_emergency: 12, id_task: 10 },
            // ... Otros documentos
        ]);

        console.log('Datos de emergency_task importados correctamente');
    } else {
        console.log('La colección emergency_task ya contiene datos. No se realizaron inserciones.');
    }


    // INSTITUTION --------------------------------------------------------------------------------------
    // Comprobar si hay datos en la colección institution antes de insertar
    const institutionCollection = db.collection('institution');
    const institutionCount = await institutionCollection.countDocuments({});

    if (institutionCount === 0) {
        // Si no hay datos, insertar documentos
        await institutionCollection.insertMany([
            { id_institution: 1, institution_name: 'Instituto Nacional de Ayuda de Terremotos (INAT)', institution_description: 'INAT se dedica a la investigación y la educación sobre la prevención de terremotos y la construcción de estructuras resistentes a los sismos' },
            { id_institution: 2, institution_name: 'Centro de Alerta Volcánica (CAV)', institution_description: 'CAV se dedica a la evacuación segura de áreas cercanas a los volcanes y en la educación pública sobre los riesgos volcánicos.' },
            { id_institution: 3, institution_name: 'Institución de Desastres por Tsunami (IDT)', institution_description: 'IDT se enfoca en la investigación y el seguimiento de tsunamis, incluyendo la detección temprana, la predicción de impacto y la preparación para emergencias. Colaboran con comunidades costeras para desarrollar planes de evacuación y concienciación.' },
            { id_institution: 4, institution_name: 'Centro de Recuperación de Ecosistemas Post-Incendio Forestal (CREPIF)', institution_description: 'CREPIF se dedica a la restauración de áreas naturales después de incendios forestales, a través de la protección del suelo, reforestación, y la conservación de la biodiversidad' },
            { id_institution: 5, institution_name: 'Institución de Gestión de Inundaciones (IGI)', institution_description: 'IGI es una institución encargada de la gestión de inundaciones en todo el país. Su misión es monitorear ríos y cuerpos de agua, coordinar la evacuación de áreas afectadas, emitir alertas tempranas y proporcionar ayuda a las comunidades inundadas' },
            { id_institution: 6, institution_name: 'Institución de Prevención de Derrumbes y Deslizamiento de Tierra (IPDDT)', institution_description: 'Es una entidad especializada en la prevención y mitigación de derrumbes y deslizamientos de tierra en áreas montañosas y colinas. Implementan sistemas de monitoreo de la estabilidad del suelo y colaboran con las comunidades en la planificación de medidas preventivas' },
        ]);

        console.log('Datos de institution importados correctamente');
    } else {
        console.log('La colección institution ya contiene datos. No se realizaron inserciones.');
    }

    // PROFILE ------------------------------------------------------------------------------------------------
    // Comprobar si hay datos en la colección profile antes de insertar
    const profileCollection = db.collection('profile');
    const profileCount = await profileCollection.countDocuments({});

    if (profileCount === 0) {
        // Si no hay datos, insertar documentos
        await profileCollection.insertMany([
            { id_profile: 1, photo: 'enlace', rut: '23.453.465-6', first_name: 'Aracely', second_name: 'Gabriela', first_lastname: 'Castro', second_lastname: 'Perez', description: 'Administradora de la App', gender: 'F', birthday: '2000-01-01' },
            { id_profile: 2, photo: 'enlace', rut: '12.345.678-9', first_name: 'Vicente', second_name: 'Andrés', first_lastname: 'Mieres', second_lastname: 'González', description: 'Administrador de la App', gender: 'M', birthday: '2000-01-01' },
            { id_profile: 3, photo: 'enlace', rut: '34.567.890-1', first_name: 'Branco', second_name: 'Alberto', first_lastname: 'García', second_lastname: 'Santana', description: 'Administrador de la App', gender: 'M', birthday: '2000-01-01' },
            { id_profile: 4, photo: 'enlace', rut: '45.678.901-2', first_name: 'Benjamin', second_name: 'Felipe', first_lastname: 'Canales', second_lastname: 'Díaz', description: 'Administrador de la App', gender: 'M', birthday: '2000-01-01' },
            { id_profile: 5, photo: 'enlace', rut: '56.789.012-3', first_name: 'Daniel', second_name: 'Esteban', first_lastname: 'Eguiluz', second_lastname: 'Lopez', description: 'Administrador de la App', gender: 'M', birthday: '2000-01-01' },
            { id_profile: 6, photo: 'enlace', rut: '67.890.123-4', first_name: 'Humberto', second_name: 'Mauricio', first_lastname: 'Salas', second_lastname: 'Fernández', description: 'Ayudando con erupciones volcanicas', gender: 'M', birthday: '1998-04-12' },
            { id_profile: 7, photo: 'enlace', rut: '78.901.234-5', first_name: 'Carla', second_name: 'Isabel', first_lastname: 'Muñoz', second_lastname: 'Sánchez', description: 'Contratacando incendios', gender: 'F', birthday: '1993-02-05' },
            { id_profile: 8, photo: 'enlace', rut: '89.012.345-6', first_name: 'Sofia', second_name: 'Beatriz', first_lastname: 'Carvajal', second_lastname: 'Ramírez', description: 'Resguardando tras inundaciones', gender: 'F', birthday: '1990-02-10' },
            { id_profile: 9, photo: 'enlace', rut: '90.123.456-7', first_name: 'Fernando', second_name: 'Alejandro', first_lastname: 'Ramírez', second_lastname: 'Ortega', description: 'Investigador de Terremotos en INAT', gender: 'M', birthday: '1985-08-25' },
            { id_profile: 10, photo: 'enlace', rut: '11.234.567-8', first_name: 'Lucía', second_name: 'Valentina', first_lastname: 'Torres', second_lastname: 'Hernández', description: 'Voluntaria de CAV para la Seguridad Volcánica', gender: 'F', birthday: '1990-06-14' },
            { id_profile: 11, photo: 'enlace', rut: '12.345.678-9', first_name: 'Raúl', second_name: 'Eduardo', first_lastname: 'Mendoza', second_lastname: 'Silva', description: 'Especialista en Tsunamis en IDT', gender: 'M', birthday: '1979-03-18' },
            { id_profile: 12, photo: 'enlace', rut: '23.456.789-0', first_name: 'Marta', second_name: 'Elena', first_lastname: 'Gutiérrez', second_lastname: 'López', description: 'Restauradora de CREPIF', gender: 'F', birthday: '1992-12-03' },
            { id_profile: 13, photo: 'enlace', rut: '34.567.890-1', first_name: 'Manuel', second_name: 'Roberto', first_lastname: 'Hernández', second_lastname: 'Rodríguez', description: 'Gestor de Inundaciones en IGI', gender: 'M', birthday: '1988-11-01' },
            { id_profile: 14, photo: 'enlace', rut: '45.678.901-2', first_name: 'Camila', second_name: 'Florencia', first_lastname: 'Silva', second_lastname: 'Martínez', description: 'Prevención de Derrumbes en IPDDT', gender: 'F', birthday: '1980-07-22' },
            { id_profile: 15, photo: 'enlace', rut: '56.789.012-3', first_name: 'Luis', second_name: 'Antonio', first_lastname: 'Pérez', second_lastname: 'González', description: 'Investigador Asociado en INAT', gender: 'M', birthday: '1990-04-15' },
            { id_profile: 16, photo: 'enlace', rut: '67.890.123-4', first_name: 'Ana', second_name: 'Carolina', first_lastname: 'Rodríguez', second_lastname: 'Muñoz', description: 'Asistente de Investigación en INAT', gender: 'F', birthday: '1993-07-28' },
            { id_profile: 17, photo: 'enlace', rut: '78.901.234-5', first_name: 'Diego', second_name: 'Javier', first_lastname: 'Ortega', second_lastname: 'Martínez', description: 'Educador en CAV', gender: 'M', birthday: '1985-02-10' },
            { id_profile: 18, photo: 'enlace', rut: '89.012.345-6', first_name: 'Elena', second_name: 'Margarita', first_lastname: 'López', second_lastname: 'Castro', description: 'Coordinadora de Tsunami en IDT', gender: 'F', birthday: '1988-12-05' },
            { id_profile: 19, photo: 'enlace', rut: '90.123.456-7', first_name: 'José', second_name: 'Miguel', first_lastname: 'Martínez', second_lastname: 'Gómez', description: 'Especialista en Restauración en CREPIF', gender: 'M', birthday: '1991-09-20' },
            { id_profile: 20, photo: 'enlace', rut: '11.234.567-K', first_name: 'Valentina', second_name: 'Isidora', first_lastname: 'Gómez', second_lastname: 'Rodríguez', description: 'Analista de Inundaciones en IGI', gender: 'F', birthday: '1983-03-12' },
            { id_profile: 21, photo: 'enlace', rut: '23.345.678-0', first_name: 'Federico', second_name: 'Ignacio', first_lastname: 'Díaz', second_lastname: 'Hernández', description: 'Técnico en Deslizamientos de Tierra en IPDDT', gender: 'M', birthday: '1980-05-08' },
            { id_profile: 22, photo: 'enlace', rut: '34.456.789-1', first_name: 'Laura', second_name: 'Gabriela', first_lastname: 'Castillo', second_lastname: 'Torres', description: 'Supervisora de INAT', gender: 'F', birthday: '1982-10-16' },
            { id_profile: 23, photo: 'enlace', rut: '45.567.890-K', first_name: 'Andrés', second_name: 'Manuel', first_lastname: 'Sanchez', second_lastname: 'Silva', description: 'Coordinador de Voluntarios en CAV', gender: 'M', birthday: '1987-06-30' },
            { id_profile: 24, photo: 'enlace', rut: '56.678.901-3', first_name: 'Mariana', second_name: 'Javiera', first_lastname: 'Vargas', second_lastname: 'Muñoz', description: 'Coordinadora de Respuesta a Tsunamis en IDT', gender: 'F', birthday: '1992-01-25' }
        ]);

        console.log('Datos de profile importados correctamente');
    } else {
        console.log('La colección profile ya contiene datos. No se realizaron inserciones.');
    }

    // RANKING -------------------------------------------------
    const rankingCollection = db.collection('ranking');
    const rankingCount = await rankingCollection.countDocuments({});

    if (rankingCount === 0) {
        // Si no hay datos, insertar documentos
        await rankingCollection.insertMany([
            { ranking_position: 1, id_user: 12, id_task: 1 },
            { ranking_position: 2, id_user: 13, id_task: 1 },
            { ranking_position: 3, id_user: 15, id_task: 1 },
            { ranking_position: 1, id_user: 17, id_task: 2 },
            { ranking_position: 2, id_user: 18, id_task: 2 },
            { ranking_position: 3, id_user: 23, id_task: 2 },
            { ranking_position: 1, id_user: 19, id_task: 3 },
            { ranking_position: 2, id_user: 20, id_task: 3 },
            { ranking_position: 3, id_user: 24, id_task: 3 },
            { ranking_position: 1, id_user: 20, id_task: 4 },
            { ranking_position: 2, id_user: 21, id_task: 4 },
            { ranking_position: 3, id_user: 23, id_task: 4 },
            { ranking_position: 1, id_user: 2, id_task: 5 },
            { ranking_position: 2, id_user: 22, id_task: 5 },
            { ranking_position: 3, id_user: 12, id_task: 5 },
            { ranking_position: 1, id_user: 17, id_task: 6 },
            { ranking_position: 2, id_user: 18, id_task: 6 },
            { ranking_position: 3, id_user: 19, id_task: 6 },
            { ranking_position: 1, id_user: 18, id_task: 7 },
            { ranking_position: 2, id_user: 12, id_task: 7 },
            { ranking_position: 3, id_user: 13, id_task: 7 },
            { ranking_position: 1, id_user: 13, id_task: 8 },
            { ranking_position: 2, id_user: 19, id_task: 8 },
            { ranking_position: 3, id_user: 21, id_task: 8 },
            { ranking_position: 1, id_user: 16, id_task: 9 },
            { ranking_position: 2, id_user: 18, id_task: 9 },
            { ranking_position: 3, id_user: 24, id_task: 9 },
            { ranking_position: 1, id_user: 20, id_task: 10 },
            { ranking_position: 2, id_user: 23, id_task: 10 },
            { ranking_position: 3, id_user: 12, id_task: 10 },
            { ranking_position: 1, id_user: 21, id_task: 11 },
            { ranking_position: 2, id_user: 23, id_task: 11 },
            { ranking_position: 3, id_user: 24, id_task: 11 },
            { ranking_position: 1, id_user: 17, id_task: 12 },
            { ranking_position: 2, id_user: 19, id_task: 12 },
            { ranking_position: 3, id_user: 24, id_task: 12 },
        ]);

        console.log('Datos de ranking importados correctamente');
    } else {
        console.log('La colección ranking ya contiene datos. No se realizaron inserciones.');
    }




    // REQUEST ----------------------------------------------------------------------
    // Comprobar si hay datos en la colección request antes de insertar
    const requestCollection = db.collection('request');
    const requestCount = await requestCollection.countDocuments({});
    if (requestCount === 0) {
        // Si no hay datos, insertar documentos
        await requestCollection.insertMany([
            { id_request: 1, request_name: 'Equipo médico', request_description: 'Equipo médico necesario para la tarea de Atender heridos.' },
            { id_request: 2, request_name: 'Herramientas de construcción', request_description: 'Herramientas de construcción necesarias para la tarea de Extraer escombros.' },
            { id_request: 3, request_name: 'Extintores', request_description: 'Extintores necesarios para la tarea de Apagar fuego.' },
            { id_request: 4, request_name: 'Linternas', request_description: 'Linternas necesarias para la tarea de Guiar a lugar seguro.' },
            { id_request: 5, request_name: 'Señales de SOS', request_description: 'Señales de SOS necesarias para la tarea de Realizar SOS.' },
            { id_request: 6, request_name: 'Material de cubierta para conductos de ventilación', request_description: 'Material necesario para asegurar los conductos de ventilación en situaciones críticas.' },
            { id_request: 7, request_name: 'Cuerdas', request_description: 'Cuerdas necesarias para la tarea de Ayudar a subir a un lugar alto.' },
            { id_request: 8, request_name: 'Vehículos de transporte', request_description: 'Vehículos de transporte necesarios para la tarea de Ayudar a evacuar las casas.' },
            { id_request: 9, request_name: 'Equipamiento de comunicación', request_description: 'Equipamiento de comunicación necesario para la tarea de Establecer centro de comandos.' },
            { id_request: 10, request_name: 'Alimentos', request_description: 'Alimentos necesarios para la tarea de Suministrar alimentos.' },
            { id_request: 11, request_name: 'Kits de evaluación de daños', request_description: 'Kits de evaluación de daños necesarios para la tarea de Evaluar daños.' },
            { id_request: 12, request_name: 'Material de apoyo psicológico', request_description: 'Material de apoyo psicológico necesario para la tarea de Atender psicológicamente.' },
        ]);

        console.log('Datos de request importados correctamente');
    } else {
        console.log('La colección request ya contiene datos. No se realizaron inserciones.');
    }


    // ROLE -------------------------------------------------------------------------------
    const roleCollection = db.collection('role');
    const roleCount = await roleCollection.countDocuments({});

    if (roleCount === 0) {
        await roleCollection.insertMany([
            { id_role: 1, role_name: 'ADMIN' },
            { id_role: 2, role_name: 'COORDINADOR' },
            { id_role: 3, role_name: 'USER' },
        ]);

        console.log('Datos de role importados correctamente');
    } else {
        console.log('La colección role ya contiene datos. No se realizaron inserciones.');
    }


    // STATE -------------------------------------------------------------------------------
    const stateCollection = db.collection('state');
    const stateCount = await stateCollection.countDocuments({});
    if (stateCount === 0) {
        await stateCollection.insertMany([
            { id_state: 1, state_name: 'Inicializada', state_description: 'La tarea o emergencia se ha definido pero no está en curso' },
            { id_state: 2, state_name: 'En curso', state_description: 'La tarea o emergencia actualmente se está llevando a cabo' },
            { id_state: 3, state_name: 'Finalizada', state_description: 'La tarea o emergencia se ha terminado de realizar' },
        ]);
        console.log('Datos de state importados correctamente');
    } else {
        console.log('La colección state ya contiene datos. No se realizaron inserciones.');
    }

    // TASK -------------------------------------------------------------------------------------
    const taskCollection = db.collection('task');
    const taskCount = await taskCollection.countDocuments({});
    if (taskCount === 0) {
        await taskCollection.insertMany([
            { id_task: 1, task_name: 'Atender heridos', task_description: 'Ayudar a gente afectada directamente por el desastre', volunteers_required: 10, id_state: 2 },
            { id_task: 2, task_name: 'Extraer escombros', task_description: 'Retirar los desechos del lugar', volunteers_required: 15, id_state: 1 },
            { id_task: 3, task_name: 'Apagar fuego', task_description: 'Ayudar a combatir el incendio', volunteers_required: 30, id_state: 2 },
            { id_task: 4, task_name: 'Guiar a lugar seguro', task_description: 'Buscar un lugar seguro al desastre', volunteers_required: 5, id_state: 2 },
            { id_task: 5, task_name: 'Realizar SOS', task_description: 'Hacer una señal de auxilio', volunteers_required: 4, id_state: 2 },
            { id_task: 6, task_name: 'Cubrir conductos de ventilación', task_description: 'Cerrar puertas y ventanas con paños húmedos', volunteers_required: 10, id_state: 1 },
            { id_task: 7, task_name: 'Ayudar a subir a un lugar alto', task_description: 'Subir a un cerro o árbol', volunteers_required: 5, id_state: 1 },
            { id_task: 8, task_name: 'Ayudar a evacuar las casas', task_description: 'Ayudar a la gente a que resguarde sus productos de valor', volunteers_required: 10, id_state: 2 },
            { id_task: 9, task_name: 'Establecer centro de comandos', task_description: 'Coordinar con voluntarios y otras organizaciones', volunteers_required: 9, id_state: 2 },
            { id_task: 10, task_name: 'Suministrar alimentos', task_description: 'Asignar alimentos a los afectados', volunteers_required: 7, id_state: 2 },
            { id_task: 11, task_name: 'Evaluar daños', task_description: 'Realizar evaluación completa para determinar las necesidades a largo plazo', volunteers_required: 5, id_state: 1 },
            { id_task: 12, task_name: 'Atender psicológicamente', task_description: 'Ofrecer apoyo psicológico a personas traumatizadas', volunteers_required: 3, id_state: 2 },
        ]);
        console.log('Datos de task importados correctamente');
    } else {
        console.log('La colección task ya contiene datos. No se realizaron inserciones.');
    }

    // TASK-REQUEST ------------------------------------------------------------------------------
    // Comprobar si hay datos en la colección task_request antes de insertar
    const taskRequestCollection = db.collection('task_request');
    const taskRequestCount = await taskRequestCollection.countDocuments({});
    if (taskRequestCount === 0) {
        // Si no hay datos, insertar documentos
        await taskRequestCollection.insertMany([
            { id_task: 1, id_request: 1 }, // Equipamiento médico para la tarea "Atender heridos".
            { id_task: 2, id_request: 2 }, // Herramientas de construcción para la tarea "Extraer escombros".
            { id_task: 3, id_request: 3 }, // Extintores para la tarea "Apagar fuego".
            { id_task: 4, id_request: 4 }, // Linternas para la tarea "Guiar a lugar seguro".
            { id_task: 5, id_request: 5 }, // Señales de SOS para la tarea "Realizar SOS".
            { id_task: 6, id_request: 6 }, // Material de cubierta para conductos de ventilación para la tarea "Cubrir conductos de ventilación".
            { id_task: 7, id_request: 7 }, // Cuerdas para la tarea "Ayudar a subir a un lugar alto".
            { id_task: 8, id_request: 8 }, // Vehículos de transporte para la tarea "Ayudar a evacuar las casas".
            { id_task: 9, id_request: 9 }, // Equipamiento de comunicación para la tarea "Establecer centro de comandos".
            { id_task: 10, id_request: 10 }, // Alimentos para la tarea "Suministrar alimentos".
            { id_task: 11, id_request: 11 }, // Kits de evaluación de daños para la tarea "Evaluar daños".
            { id_task: 12, id_request: 12 }, // Material de apoyo psicológico para la tarea "Atender psicológicamente".
        ]);

        console.log('Datos de task_request importados correctamente');
    } else {
        console.log('La colección task_request ya contiene datos. No se realizaron inserciones.');
    }


    // USER -----------------------------------------------------
    const userCollection = db.collection('user');
    const userCount = await userCollection.countDocuments({});
    if (userCount === 0) {
        await userCollection.insertMany([
            { id_user: 1, username: 'aracelyC', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 1, id_role: 1, id_institution: 1 },
            { id_user: 2, username: 'mieres7', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 2, id_role: 1, id_institution: 2 },
            { id_user: 3, username: 'garciaB', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 1, id_institution: 3 },
            { id_user: 4, username: 'benjaminC', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 4, id_role: 1, id_institution: 4 },
            { id_user: 5, username: 'daniE', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 5, id_role: 1, id_institution: 5 },
            { id_user: 6, username: 'humbertoS', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 6, id_role: 2, id_institution: 2 },
            { id_user: 7, username: 'muñozC', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 7, id_role: 2, id_institution: 4 },
            { id_user: 8, username: 'sofiCa', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 8, id_role: 2, id_institution: 5 },
            { id_user: 9, username: 'fernandoR', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 9, id_role: 2, id_institution: 1 },
            { id_user: 10, username: 'luciaT', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 10, id_role: 2, id_institution: 2 },
            { id_user: 11, username: 'raulM', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 11, id_role: 2, id_institution: 3 },
            { id_user: 12, username: 'martaG', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 12, id_role: 3, id_institution: 4 },
            { id_user: 13, username: 'manuelH', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 13, id_role: 3, id_institution: 5 },
            { id_user: 14, username: 'camilaS', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 14, id_role: 2, id_institution: 6 },
            { id_user: 15, username: 'luisP', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 1, id_institution: 1},
            { id_user: 16, username: 'anaR', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 1, id_institution: 1 },
            { id_user: 17, username: 'diegoO', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 2, id_institution: 2 },
            { id_user: 18, username: 'elenaL', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 3, id_institution: 3 },
            { id_user: 19, username: 'joseM', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 4, id_institution: 4 },
            { id_user: 20, username: 'valentinaG', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 5, id_institution: 5 },
            { id_user: 21, username: 'federicoD', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 6, id_institution: 6 },
            { id_user: 22, username: 'lauraC', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 1, id_institution: 1 },
            { id_user: 23, username: 'andresS', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 2, id_institution: 2 },
            { id_user: 24, username: 'marianaV', password: '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', id_profile: 3, id_role: 3, id_institution: 3 },

        ]);

        console.log('Datos de usuario importados correctamente');
    } else {
        console.log('La colección user ya contiene datos. No se realizaron inserciones.');
    }

    // USER-ABILITY ------------------------------------------------------
    const userAbilityCollection = db.collection('user_ability');
    const userAbilityCount = await userAbilityCollection.countDocuments({});
    if (userAbilityCount === 0) {
        await userAbilityCollection.insertMany([
            { id_user: 1, id_ability: 1 },
            { id_user: 2, id_ability: 1 },
            { id_user: 3, id_ability: 1 },
            { id_user: 4, id_ability: 1 },
            { id_user: 5, id_ability: 1 },
            { id_user: 6, id_ability: 2 },
            { id_user: 7, id_ability: 2 },
            { id_user: 8, id_ability: 2 },
            { id_user: 9, id_ability: 2 },
            { id_user: 10, id_ability: 2 },
            { id_user: 11, id_ability: 3 },
            { id_user: 12, id_ability: 3 },
            { id_user: 13, id_ability: 3 },
            { id_user: 14, id_ability: 3 },
            { id_user: 15, id_ability: 3 },
            { id_user: 16, id_ability: 4 },
            { id_user: 17, id_ability: 4 },
            { id_user: 18, id_ability: 4 },
            { id_user: 19, id_ability: 4 },
            { id_user: 20, id_ability: 4 },
            { id_user: 21, id_ability: 5 },
            { id_user: 22, id_ability: 5 },
            { id_user: 23, id_ability: 5 },
            { id_user: 24, id_ability: 5 },
            { id_user: 1, id_ability: 5 },
            { id_user: 2, id_ability: 6 },
            { id_user: 3, id_ability: 6 },
            { id_user: 4, id_ability: 6 },
            { id_user: 5, id_ability: 6 },
            { id_user: 6, id_ability: 6 },
        ]);
        console.log('Datos de user_ability importados correctamente');
    } else {
        console.log('La colección user_ability ya contiene datos. No se realizaron inserciones.');
    }

    // USER-REQUEST -----------------------------------------
    const userRequestCollection = db.collection('user_request');
    const userRequestCount = await userRequestCollection.countDocuments({});

    if (userRequestCount === 0) {
        // Si no hay datos, insertar documentos
        await userRequestCollection.insertMany([
            { id_user: 1, id_request: 1 },
            { id_user: 2, id_request: 2 },
            { id_user: 3, id_request: 3 },
            { id_user: 4, id_request: 4 },
            { id_user: 5, id_request: 5 },
            { id_user: 6, id_request: 6 },
            { id_user: 7, id_request: 7 },
            { id_user: 8, id_request: 8 },
            { id_user: 9, id_request: 9 },
            { id_user: 10, id_request: 10 },
            { id_user: 11, id_request: 11 },
            { id_user: 12, id_request: 12 },
            { id_user: 13, id_request: 1 },
            { id_user: 14, id_request: 2 },
            { id_user: 15, id_request: 3 },
            { id_user: 16, id_request: 4 },
            { id_user: 17, id_request: 5 },
            { id_user: 18, id_request: 6 },
            { id_user: 19, id_request: 7 },
            { id_user: 20, id_request: 8 },
            { id_user: 21, id_request: 9 },
            { id_user: 22, id_request: 10 },
            { id_user: 23, id_request: 11 },
            { id_user: 24, id_request: 12 },
        ]);

        console.log('Datos de user_request importados correctamente');
    } else {
        console.log('La colección user_request ya contiene datos. No se realizaron inserciones.');
    }

    
    //---------------------------------------

    console.log('Datos importados correctamente');
    conexion.close();
}

// importar datos
importarDatos();