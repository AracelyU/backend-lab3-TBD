-- SCRIPT DE POBLACIÓN DE DATOS

INSERT INTO state (id_state, state_name, state_description)
VALUES
    (1, 'Inicializada', 'La tarea o emergencia se ha definido pero no está en curso'),
    (2, 'En curso', 'La tarea o emergencia actualmente se está llevando a cabo'),
    (3, 'Finalizada', 'La tarea o emergencia se ha terminado de realizar');
	
INSERT INTO task (id_task, task_name, task_description, volunteers_required, id_state)
VALUES
	(1, 'Atender heridos', 'Ayudar a gente afectada directamente por el desastre', 10, 1),
	(2, 'Extraer escombros', 'Retirar los desechos del lugar', 15, 1),
	(3, 'Apagar fuego', 'Ayudar a combatir el incendio', 30, 1),
	(4, 'Guiar a lugar seguro', 'Buscar un lugar seguro al desastre', 5, 1),
	(5, 'Realizar SOS', 'Hacer una señal de auxilio', 4, 1),
	(6, 'Cubrir conductos de ventilación', 'Cerrar puertas y ventanas con paños húmedos', 10, 1),
	(7, 'Ayudar a subir a un lugar alto', 'Subir a un cerro o árbol', 5, 1),
	(8, 'Ayudar a evacuar las casas', 'Ayudar a la gente a que resguarde sus productos de valor', 10, 1),
	(9, 'Establecer centro de comandos', 'Coordinar con voluntarios y otras organizaciones', 9, 1),
	(10, 'Suministrar alimentos', 'Asignar alimentos a los afectados', 7, 1),
	(11, 'Evaluar daños', 'Realizar evaluación completa para determinar las necesidades a largo plazo', 5, 1),
	(12, 'Atender psicológicamente', 'Ofrecer apoyo psicológico a personas traumatizadas', 3, 1);

-- REQUEST
INSERT INTO request (id_request, request_name, request_description)
VALUES
    (1, 'Equipo médico', 'Equipo médico necesario para la tarea de Atender heridos.'),
    (2, 'Herramientas de construcción', 'Herramientas de construcción necesarias para la tarea de Extraer escombros.'),
    (3, 'Extintores', 'Extintores necesarios para la tarea de Apagar fuego.'),
    (4, 'Linternas', 'Linternas necesarias para la tarea de Guiar a lugar seguro.'),
    (5, 'Señales de SOS', 'Señales de SOS necesarias para la tarea de Realizar SOS.'),
    (6, 'Material de cubierta para conductos de ventilación', 'Material necesario para asegurar los conductos de ventilación en situaciones críticas.'),
    (7, 'Cuerdas', 'Cuerdas necesarias para la tarea de Ayudar a subir a un lugar alto.'),
    (8, 'Vehículos de transporte', 'Vehículos de transporte necesarios para la tarea de Ayudar a evacuar las casas.'),
    (9, 'Equipamiento de comunicación', 'Equipamiento de comunicación necesario para la tarea de Establecer centro de comandos.'),
    (10, 'Alimentos', 'Alimentos necesarios para la tarea de Suministrar alimentos.'),
    (11, 'Kits de evaluación de daños', 'Kits de evaluación de daños necesarios para la tarea de Evaluar daños.'),
    (12, 'Material de apoyo psicológico', 'Material de apoyo psicológico necesario para la tarea de Atender psicológicamente.');

-- TASK-REQUEST
INSERT INTO task_request (id_task, id_request)
VALUES
    (1, 1),  -- Equipamiento médico para la tarea "Atender heridos".
    (2, 2),  -- Herramientas de construcción para la tarea "Extraer escombros".
    (3, 3),  -- Extintores para la tarea "Apagar fuego".
    (4, 4),  -- Linternas para la tarea "Guiar a lugar seguro".
    (5, 5),  -- Señales de SOS para la tarea "Realizar SOS".
    (6, 6),  -- Material de cubierta para conductos de ventilación para la tarea "Cubrir conductos de ventilación".
    (7, 7),  -- Cuerdas para la tarea "Ayudar a subir a un lugar alto".
    (8, 8),  -- Vehículos de transporte para la tarea "Ayudar a evacuar las casas".
    (9, 9),  -- Equipamiento de comunicación para la tarea "Establecer centro de comandos".
    (10, 10),  -- Alimentos para la tarea "Suministrar alimentos".
    (11, 11),  -- Kits de evaluación de daños para la tarea "Evaluar daños".
    (12, 12);  -- Material de apoyo psicológico para la tarea "Atender psicológicamente".

INSERT INTO institution (id_institution, institution_name, institution_description)
VALUES
	(1, 'Instituto Nacional de Ayuda de Terremotos (INAT)', 
	'INAT se dedica a la investigación y la educación sobre la prevención de terremotos y la construcción de estructuras resistentes a los sismos'),
	 
	(2, 'Centro de Alerta Volcánica (CAV)',
	'CAV se dedica a la evacuación segura de áreas cercanas a los volcanes y en la educación pública sobre los riesgos volcánicos.'),
	  
	(3, 'Institución de Desastres por Tsunami (IDT)',
	'IDT se enfoca en la investigación y el seguimiento de tsunamis, incluyendo la detección temprana, la predicción de impacto y la preparación para emergencias. Colaboran con comunidades costeras para desarrollar planes de evacuación y concienciación.'),
	   
	(4, 'Centro de Recuperación de Ecosistemas Post-Incendio Forestal (CREPIF)',
	 'CREPIF se dedica a la restauración de áreas naturales después de incendios forestales, a través de la protección del suelo, reforestación, y la conservación de la biodiversidad'),
	   
	(5, 'Institución de Gestión de Inundaciones (IGI)',
	 'IGI es una institución encargada de la gestión de inundaciones en todo el país. Su misión es monitorear ríos y cuerpos de agua, coordinar la evacuación de áreas afectadas, emitir alertas tempranas y proporcionar ayuda a las comunidades inundadas'),
		
	(6, 'Institución de Prevención de Derrumbes y Deslizamiento de Tierra (IPDDT)',
	 'es una entidad especializada en la prevención y mitigación de derrumbes y deslizamientos de tierra en áreas montañosas y colinas. Implementan sistemas de monitoreo de la estabilidad del suelo y colaboran con las comunidades en la planificación de medidas preventivas');
		
INSERT INTO emergency_address (id_address_e, address, longitude, latitude) VALUES
	(1, 'Lautaro, Araucanía', -38.57434144039071, -72.4756987329032),
  	(2, 'Viña del Mar, Valparaíso', -32.993457378637764, -71.53361941561872),
  	(3, 'Pucón, Araucanía', -39.41955618986563, -71.93942618853083),
  	(4, 'Lago Ranco, Los Ríos', -40.57747844827906, -72.10983024396644),
  	(5, 'Mall Zofri - Sector antiguo, modulo 130, Iquique, Tarapacá', -20.22959943149161, -70.13553539158428),
  	(6, 'Sucre 1641, 1340517 Tocopilla, Antofagasta', -22.093843895975603, -70.20005600801197),
  	(7, 'Padre Felipe Gómez de Vidaurre, 8330369 Santiago, Región Metropolitana', -33.447969674529496, -70.65607952327353),
  	(8, 'Candelaria Pérez 26-66, Illapel, Coquimbo', -31.631798107170333, -71.17459210501087),
  	(9, 'Av. Angamos 290-194, Antofagasta', -23.67586252273854, -70.40806255684329),
  	(10, 'Constitución, Maule', -35.33074968305388, -72.43287959887027),
  	(11, 'Villa Santa Lucía, Chaitén, Los Lagos', -43.4106060512741, -72.36752613467937),
  	(12, 'Los Angeles, Bío Bío', -37.42699254228149, -72.3287247972075);	

UPDATE emergency_address SET geom = ST_SetSRID(ST_MakePoint(latitude, longitude), 4326);
		
INSERT INTO emergency (id_emergency, emergency_name, 
					   emergency_type, statement_date, id_state, id_address_e)
VALUES
	(1, 'Incendio forestal en comuna Lautaro', '0', '2023-10-15', 1, 1),
	(2, 'Incendio forestal en Viña del Mar', '0', '2023-10-14', 1, 2),
	(3, 'Erupción Volcán Villarica', '1', '2023-10-16', 1, 3),
	(4, 'Erupción complejo volcánico Puyehue', '1','2023-10-12', 1, 4),
	(5, 'Terremoto de Iquique', '2', '2023-10-15', 1, 5),
	(6, 'Terremoto Tocopilla', '2', '2023-10-13', 1, 6),
	(7, 'Derrumbe Santiago', '3', '2023-10-09', 1, 7),
	(8, 'Derrumbes en Illapel', '3', '2023-10-10', 1, 8),
	(9, 'Tsunami en Antofagasta', '4', '2023-10-08', 1, 9),
	(10, 'Tsunami en Constitución', '4', '2023-10-08', 1, 10),
	(11, 'Aluvión de Villa Santa Lucía', '5', '2023-10-13', 1, 11),
	(12, 'Aluvión del Biobío', '5', '2023-10-14', 1, 12);

INSERT INTO emergency_institution (id_emergency, id_institution)
VALUES
	(1,4), (2,4), (3,2), (4,2), (5,1), (6,1), (7,6), (8,6), (9,3), (10,3), (11,5), (12,5);
	
INSERT INTO emergency_task (id_emergency, id_task)
VALUES
	(1,1), (1,3), (1,5), (1,12),
	(2,3), (2,4), (2,8),
	(3,4), (3,6), (3,8), (3,12),
	(4,5), (4,6), (4,9),
	(5,1), (5,9), (5,10), (5,11),
	(6,2), (6,4), (6,12),
	(7,4), (7,11),
	(8,4), (8,11), (8,12),
	(9,2), (9,7), (9,8),
	(10,4), (10,7), (10,12),
	(11,8), (11,10), (11,11),
	(12,1), (12,2), (12,10);
	
INSERT INTO ability (id_ability, ability_name, ability_description)
VALUES 
	(1, 'Liderazgo', 'Ser capaz de guiar a equipos, coordinar esfuerzos y mantener la calma en situaciones caóticas'),
	(2, 'Adaptabilidad', 'Poder enfrentar situaciones dinámicas e impredecibles provocadas por los desastres naturales'),
	(3, 'Trabajo en equipo', 'Tener la capacidad de colaborar efectivamente con otro voluntario'),
	(4, 'Habilidades de busqueda y rescate', 'Ser capaz de buscar heridos y rescatar personas afectadas'),
	(5, 'Apoyo psicológico', 'Lidiar con el estrés y proporcionar apoyo emocional a las víctimas del desastre'),
	(6, 'Habilidades de atención médica', 'Saber proporcionar primeros auxilios y atención médica de emergencia');

INSERT INTO emergency_ability (id_emergency, id_ability)
VALUES
	(1,3),(1,6),(2,1),(2,3),(2,4),(3,2),(3,4),(3,6),(4,1),(4,2),(4,6),
	(5,2),(5,3),(5,4),(6,1),(6,4),(7,4),(7,5),(8,3),(8,5),(9,1),(9,5),
	(10,3),(10,5),(11,2),(11,3),(11,5),(12,2),(12,3),(12,4);

INSERT INTO profile (id_profile, photo, rut, first_name, second_name, first_lastname, second_lastname, description, gender, birthday)
VALUES
    (1, 'enlace', '23.453.465-6', 'Aracely', 'Gabriela', 'Castro', 'Perez', 'Administradora de la App', 'F', '2000-01-01'),
    (2, 'enlace', '12.345.678-9', 'Vicente', 'Andrés', 'Mieres', 'González', 'Administrador de la App', 'M', '2000-01-01'),
    (3, 'enlace', '34.567.890-1', 'Branco', 'Alberto', 'García', 'Santana', 'Administrador de la App', 'M', '2000-01-01'),
    (4, 'enlace', '45.678.901-2', 'Benjamin', 'Felipe', 'Canales', 'Díaz', 'Administrador de la App', 'M', '2000-01-01'),
    (5, 'enlace', '56.789.012-3', 'Daniel', 'Esteban', 'Eguiluz', 'Lopez', 'Administrador de la App', 'M', '2000-01-01'),
    (6, 'enlace', '67.890.123-4', 'Humberto', 'Mauricio', 'Salas', 'Fernández', 'Ayudando con erupciones volcanicas', 'M', '1998-04-12'),
    (7, 'enlace', '78.901.234-5', 'Carla', 'Isabel', 'Muñoz', 'Sánchez', 'Contratacando incendios', 'F', '1993-02-05'),
    (8, 'enlace', '89.012.345-6', 'Sofia', 'Beatriz', 'Carvajal', 'Ramírez', 'Resguardando tras inundaciones', 'F', '1990-02-10'),
    (9, 'enlace', '90.123.456-7', 'Fernando', 'Alejandro', 'Ramírez', 'Ortega', 'Investigador de Terremotos en INAT', 'M', '1985-08-25'),
    (10, 'enlace', '11.234.567-8', 'Lucía', 'Valentina', 'Torres', 'Hernández', 'Voluntaria de CAV para la Seguridad Volcánica', 'F', '1990-06-14'),
    (11, 'enlace', '12.345.678-9', 'Raúl', 'Eduardo', 'Mendoza', 'Silva', 'Especialista en Tsunamis en IDT', 'M', '1979-03-18'),
    (12, 'enlace', '23.456.789-0', 'Marta', 'Elena', 'Gutiérrez', 'López', 'Restauradora de CREPIF', 'F', '1992-12-03'),
    (13, 'enlace', '34.567.890-1', 'Manuel', 'Roberto', 'Hernández', 'Rodríguez', 'Gestor de Inundaciones en IGI', 'M', '1988-11-01'),
    (14, 'enlace', '45.678.901-2', 'Camila', 'Florencia', 'Silva', 'Martínez', 'Prevención de Derrumbes en IPDDT', 'F', '1980-07-22'),
    (15, 'enlace', '56.789.012-3', 'Luis', 'Antonio', 'Pérez', 'González', 'Investigador Asociado en INAT', 'M', '1990-04-15'),
    (16, 'enlace', '67.890.123-4', 'Ana', 'Carolina', 'Rodríguez', 'Muñoz', 'Asistente de Investigación en INAT', 'F', '1993-07-28'),
    (17, 'enlace', '78.901.234-5', 'Diego', 'Javier', 'Ortega', 'Martínez', 'Educador en CAV', 'M', '1985-02-10'),
    (18, 'enlace', '89.012.345-6', 'Elena', 'Margarita', 'López', 'Castro', 'Coordinadora de Tsunami en IDT', 'F', '1988-12-05'),
    (19, 'enlace', '90.123.456-7', 'José', 'Miguel', 'Martínez', 'Gómez', 'Especialista en Restauración en CREPIF', 'M', '1991-09-20'),
    (20, 'enlace', '11.234.567-K', 'Valentina', 'Isidora', 'Gómez', 'Rodríguez', 'Analista de Inundaciones en IGI', 'F', '1983-03-12'),
    (21, 'enlace', '23.345.678-0', 'Federico', 'Ignacio', 'Díaz', 'Hernández', 'Técnico en Deslizamientos de Tierra en IPDDT', 'M', '1980-05-08'),
    (22, 'enlace', '34.456.789-1', 'Laura', 'Gabriela', 'Castillo', 'Torres', 'Supervisora de INAT', 'F', '1982-10-16'),
    (23, 'enlace', '45.567.890-K', 'Andrés', 'Manuel', 'Sanchez', 'Silva', 'Coordinador de Voluntarios en CAV', 'M', '1987-06-30'),
    (24, 'enlace', '56.678.901-3', 'Mariana', 'Javiera', 'Vargas', 'Muñoz', 'Coordinadora de Respuesta a Tsunamis en IDT', 'F', '1992-01-25');

INSERT INTO user_address (id_address_u, address, latitude, longitude) VALUES
  	(1, 'Caupolicán 1027, Concepción, Bío Bío', -73.0547538041757, -36.821393959657435),
  	(2,'Avda. Fco de Aguirre 170, 1710156 La Serena, Coquimbo', -71.25461346356609, -29.90545603158812),
  	(3, 'Av. Carlos Condell 1127, 2261467 Quillota, Valparaíso', -71.24314311789601, -32.89143880250012),
  	(4, 'C. Nizar 8809, San Bernardo, Región Metropolitana', -70.74877907552514, -33.66914744049816),
  	(5, 'Dr. Manuel Barros Borgoño 340, Providencia, Región Metropolitana', -70.61747977739354, -33.431580375509526),
  	(6, 'Gral. Pedro Lagos Marchant 1110, 1000187 Arica, Arica y Parinacota', -70.31187746273224, -18.475727169073984),
  	(7, 'Independencia 640, 1000099 Arica, Arica y Parinacota', -70.31045352040502, -18.47447196422832),
  	(8, 'Cerro Moreno 10500, 1262357 Antofagasta', -70.3926797337, -23.571606640754734),
  	(9, 'Conferencia 1076, 8370569 Santiago, Región Metropolitana', -70.67478893135461, -33.462484966475095),
  	(10,'Manuel de Amat 3138, 8370750 Santiago, Región Metropolitana',-70.67768678902719, -33.46849237489128),
  	(11, 'El Valle 1294, San Bernardo, Región Metropolitana', -70.70928809087626, -33.572705313299025),
  	(12, 'Maipú 1843, 4081865 Concepción, Bío Bío', -73.03691617719457, -36.81804455010238),
  	(13, '10902 Los Almendros La Pintana, Región Metropolitana', -70.64430219087696, -33.56058374876691),
  	(14, 'Pje. Benozzo Gozzoli 4339, San Joaquín, Región Metropolitana', -70.63028937553493, -33.496725522081356),
  	(15 ,'Luis Beltrán 731, 9020841 Santiago, Pudahuel, Región Metropolitana', -70.75959567739277, -33.445750342297146),
  	(16 ,'Mujica 301, 9200800 Cerrillos, Región Metropolitana', -70.71825279088014, -33.50358528718388),
  	(17 ,'Federico Gana 3575, Macul, Región Metropolitana', -70.5951228890261, -33.48790802037042),
  	(18 ,'El Mesías 3948, 1731947 La Serena, Coquimbo', -71.22865457573029, -29.88598263106388),
  	(19 ,'Pje. Vallenar 2512, 1732932 La Serena, Coquimbo', -71.22717998922131, -29.879434620932617),
  	(20 ,'Joaquín Prieto 1131, 4081368 Concepción, Bío Bío', -73.04981053301252,-36.815639021789565),
  	(21 ,'Pje. Cinco 134, 4060831 Concepción, Bío Bío', -73.07152908883074, -36.81001301524118),
  	(22 ,'José Domingo Cañas 510, 7750078 Ñuñoa, Región Metropolitana', -70.6245400178644, -33.45482036051855),
  	(23 ,'Caupolicán 660, Providencia, Región Metropolitana', -70.62165556569133, -33.44738511181257),
  	(24 ,'Pje. 11 de Septiembre 230, Mejillones, Antofagasta', -70.44292641837411, -23.099618075044457);

UPDATE user_address SET geom = ST_SetSRID(ST_MakePoint(latitude, longitude), 4326);
  
INSERT INTO "user" (id_user, username, password, id_profile,
					 id_role, id_institution, id_address_u)
VALUES
	(1, 'aracelyC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 1, 1, 1, 1),
	(2, 'mieres7', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 2, 1, 2, 2),
	(3, 'garciaB', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 3, 1, 3, 3),
	(4, 'benjaminC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 4, 1, 4, 4),
	(5, 'daniE', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 5, 1, 5, 5),
	(6, 'humbertoS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 6, 2, 2, 6),
	(7, 'muñozC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 7, 2, 4, 7),
	(8, 'sofiCa', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 8, 2, 5, 8),
	(9, 'fernandoR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 9, 2, 1, 9), 
    (10, 'luciaT', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 10, 2, 2, 10),  
    (11, 'raulM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 11, 2, 3, 11),  
    (12, 'martaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 12, 3, 4, 12),  
    (13, 'manuelH', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 13, 3, 5, 13),  
    (14, 'camilaS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 14, 2, 6, 14),
	(15, 'luisP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 15, 3, 1, 15),  
    (16, 'anaR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 16, 3, 1, 16),  
    (17, 'diegoO', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 17, 3, 2, 17),  
    (18, 'elenaL', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 18, 3, 3, 18),  
    (19, 'joseM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 19, 3, 4, 19),  
    (20, 'valentinaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 20, 3, 5, 20),  
    (21, 'federicoD', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 21, 3, 6, 21),  
    (22, 'lauraC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 22, 3, 1, 22),  
    (23, 'andresS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 23, 3, 2, 23),  
    (24, 'marianaV', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 24, 3, 3, 24);

INSERT INTO user_ability (id_user, id_ability)
VALUES
    (1, 1), (2, 1), (3, 1), (4, 1), (5, 1), (6, 2), (7, 2),
    (8, 2), (9, 2), (10, 2), (11, 3), (12, 3), (13, 3),
    (14, 3), (15, 3), (16, 4), (17, 4), (18, 4), (19, 4),
    (20, 4), (21, 5), (22, 5), (23, 5), (24, 5), (1, 5),
    (2, 6), (3, 6), (4, 6), (5, 6), (6, 6);

INSERT INTO user_request (id_user, id_request)
VALUES
    (1, 1), (2, 2), (3, 3), (4, 4), (5, 5), (6, 6),
    (7, 7), (8, 8), (9, 9), (10, 10), (11, 11), (12, 12),
	(13, 1), (14, 2), (15, 3), (16, 4), (17, 5), (18, 6),
    (19, 7), (20, 8), (21, 9), (22, 10), (23, 11), (24, 12);

INSERT INTO ranking (ranking_position, id_user, id_task)
VALUES
	(1, 12, 1), (2, 13, 1), (3, 15, 1), 
	(1, 17, 2), (2, 18, 2), (3, 23, 2),
	(1, 19, 3), (2, 20, 3), (3, 24, 3),
	(1, 20, 4), (2, 21, 4), (3, 23, 4),
	(1, 2, 5), (2, 22, 5), (3, 12, 5),
	(1, 17, 6), (2, 18, 6), (3, 19, 6),
	(1, 18, 7), (2, 12, 7), (3, 13, 7), 
	(1, 13, 8), (2, 19, 8), (3, 21, 8),
	(1, 16, 9), (2, 18, 9), (3, 24, 9),
	(1, 20, 10), (2, 23, 10), (3, 12, 10),
	(1, 21, 11), (2, 23, 11), (3, 24, 11),
	(1, 17, 12), (2, 19, 12), (3, 24, 12);

-- Secuencias para evitar llaves duplicadas en posteo de datos en postman

SELECT setval('ability_id_ability_seq', 6);

SELECT setval('emergency_id_emergency_seq', 12);

SELECT setval('emergency_ability_id_emergency_ability_seq', 30);

SELECT setval('emergency_institution_id_emergency_institution_seq', 12);

SELECT setval('emergency_task_id_emergency_task_seq', 38);

SELECT setval('institution_id_institution_seq', 6);

SELECT setval('profile_id_profile_seq', 24);

SELECT setval('ranking_id_ranking_seq', 36);

SELECT setval('request_id_request_seq', 12);

SELECT setval('role_id_role_seq', 3);

SELECT setval('state_id_state_seq', 3);

SELECT setval('task_id_task_seq', 12);

SELECT setval('task_request_id_task_request_seq', 12);

SELECT setval('user_id_user_seq', 24);

SELECT setval('user_ability_id_user_ability_seq', 30);

SELECT setval('user_request_id_user_request_seq', 24);
