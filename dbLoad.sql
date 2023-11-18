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
    (24, 'enlace', '56.678.901-3', 'Mariana', 'Javiera', 'Vargas', 'Muñoz', 'Coordinadora de Respuesta a Tsunamis en IDT', 'F', '1992-01-25'),
	(25, 'enlace', '21.323.535-6', 'Carlos', 'Julio', 'Jimenez', 'De la Fuente', 'Voluntario para ayudar en Desastres Naturales', 'M', '1998-01-02'),
    (26, 'enlace', '19.422.322-4', 'Ana', 'María', 'Carvajal', 'Zamorano', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1995-12-04'),
    (27, 'enlace', '20.232.325-7', 'Oscar', 'Alberto', 'Gallardo', 'Jimenez', 'Voluntario para ayudar en Desastres Naturales', 'M', '2000-09-14'),
    (28, 'enlace', '21.453.334-3', 'Iván', 'Jesus', 'Canales', 'García', 'Voluntario para ayudar en Desastres Naturales', 'M', '2002-01-13'),
	(29, 'enlace', '18.567.432-9', 'Daniela', 'Isabel', 'Pérez', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1997-07-15'),
    (30, 'enlace', '17.456.789-2', 'Miguel', 'Angel', 'Aguilar', 'Soto', 'Voluntario para ayudar en Desastres Naturales', 'M', '1996-05-20'),
    (31, 'enlace', '19.678.543-5', 'Laura', 'Antonia', 'Gutiérrez', 'Fernández', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1999-03-10'),
    (32, 'enlace', '20.876.543-1', 'Felipe', 'Andrés', 'Vargas', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '2001-08-28'),
    (33, 'enlace', '14.567.890-1', 'Cristian', 'Andrés', 'Muñoz', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1990-06-25'),
    (34, 'enlace', '16.789.012-3', 'Maria', 'Lorena', 'López', 'Soto', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1992-09-18'),
    (35, 'enlace', '15.432.109-2', 'Juan', 'Pablo', 'Pérez', 'García', 'Voluntario para ayudar en Desastres Naturales', 'M', '1991-12-02'),
    (36, 'enlace', '17.654.321-4', 'Andrea', 'Isabel', 'Gómez', 'Gutiérrez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1993-03-14'),
    (37, 'enlace', '16.789.123-5', 'Javier', 'Alejandro', 'Rodriguez', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '1992-10-30'),
    (38, 'enlace', '15.432.234-4', 'Luisa', 'Fernanda', 'Fernández', 'Soto', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1991-05-12'),
    (39, 'enlace', '17.654.345-3', 'Claudio', 'Andrés', 'Cortez', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1993-12-05'),
    (40, 'enlace', '14.567.456-2', 'Isabel', 'Cristina', 'Soto', 'García', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1990-08-18'),
    (41, 'enlace', '13.456.567-8', 'Camila', 'Andrea', 'Vásquez', 'López', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1989-09-23'),
    (42, 'enlace', '12.345.678-9', 'Roberto', 'Ignacio', 'López', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '1988-04-15'),
    (43, 'enlace', '14.567.789-0', 'Mariana', 'Alejandra', 'García', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1990-01-28'),
    (44, 'enlace', '11.222.333-4', 'Felix', 'Antonio', 'Martínez', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '1987-07-12'),
    (45, 'enlace', '12.333.444-5', 'Lucia', 'Esther', 'Rodriguez', 'López', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1988-12-05'),
    (46, 'enlace', '13.444.555-6', 'Sergio', 'Alberto', 'Pérez', 'García', 'Voluntario para ayudar en Desastres Naturales', 'M', '1989-03-18'),
    (47, 'enlace', '14.555.666-7', 'Natalia', 'Isabel', 'González', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1990-08-01'),
    (48, 'enlace', '17.234.567-8', 'Lucas', 'Ignacio', 'Vargas', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1993-04-20'),
    (49, 'enlace', '16.345.678-9', 'Sofia', 'Fernanda', 'Pérez', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1992-11-12'),
    (50, 'enlace', '18.456.789-0', 'Martin', 'Alejandro', 'Cortez', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1994-06-03'),
    (51, 'enlace', '19.567.890-1', 'Valentina', 'Isabel', 'Soto', 'García', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1995-09-15'),
    (52, 'enlace', '18.678.901-2', 'Diego', 'Antonio', 'Martínez', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '1994-12-10'),
    (53, 'enlace', '19.789.012-3', 'Juana', 'Isabel', 'Rodriguez', 'López', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1995-03-25'),
    (54, 'enlace', '20.890.123-4', 'Javier', 'Andrés', 'Cortez', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1996-07-08'),
    (55, 'enlace', '21.901.234-5', 'Ignacio', 'Alejandro', 'Soto', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '1997-05-15'),
    (56, 'enlace', '22.012.345-6', 'Andrea', 'Isabel', 'López', 'García', 'Voluntaria para ayudar en Desastres Naturales', 'F', '1998-08-28'),
    (57, 'enlace', '23.123.456-7', 'Ricardo', 'Antonio', 'González', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '1999-11-11'),
    (58, 'enlace', '24.234.567-8', 'Soledad', 'Fernanda', 'Rodriguez', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2000-02-24'),
    (59, 'enlace', '25.345.678-9', 'Francisco', 'Ignacio', 'Cortez', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '2001-06-07'),
    (60, 'enlace', '26.456.789-0', 'Clara', 'Isabel', 'Pérez', 'García', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2002-09-20'),
    (61, 'enlace', '27.567.890-1', 'Mauricio', 'Andrés', 'Gómez', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '2003-12-03'),
    (62, 'enlace', '28.678.901-2', 'Carla', 'Andrea', 'González', 'López', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2000-04-15'),
    (63, 'enlace', '29.789.012-3', 'Rodrigo', 'Antonio', 'Martínez', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '2001-08-28'),
    (64, 'enlace', '30.890.123-4', 'Luz', 'Isabel', 'Aguilera', 'López', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2002-11-11'),
    (65, 'enlace', '31.901.234-5', 'Juan', 'Alejandro', 'Cortez', 'Gómez', 'Voluntario para ayudar en Desastres Naturales', 'M', '2003-02-24'),
    (66, 'enlace', '32.012.345-6', 'Ana', 'Isabel', 'Rodriguez', 'García', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2004-06-07'),
    (67, 'enlace', '33.123.456-7', 'Manuel', 'Antonio', 'Soto', 'López', 'Voluntario para ayudar en Desastres Naturales', 'M', '2005-09-20'),
    (68, 'enlace', '34.234.567-8', 'Margarita', 'Fernanda', 'Cortez', 'Gómez', 'Voluntaria para ayudar en Desastres Naturales', 'F', '2006-12-03'),
    (69, 'enlace', '35.345.678-9', 'Francisco', 'Ignacio', 'López', 'García', 'Voluntario para ayudar en Desastres Naturales', 'M', '2007-03-18');

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
  	(24 ,'Pje. 11 de Septiembre 230, Mejillones, Antofagasta', -70.44292641837411, -23.099618075044457),
	(25, 'Balmaceda 723, Lautaro, Araucanía', -72.43827935931678, -38.53042350636534),
	(26, 'C. Volcán Villarrica 0714, Lautaro, Araucanía', -72.42297470349541, -38.51571330066502),
	(27, 'Andrés Truan 560, Lautaro, Araucanía', -72.4223495169874, -38.54204510819005),
	(28, 'Aníbal Pinto 17-21, Lautaro, Araucanía', -72.43082335931692, -38.528262301576184),
	(29, 'Pje. 5 51-13, 2551297 Viña del Mar, Valparaíso', -71.5031699749322, -33.00835301706132),
    (30, 'Del manzano, Viña del Mar, Valparaíso', -71.51787163583953, -33.01952862256363),
    (31, 'Raúl Toro 293, 2550628 Viña del Mar, Valparaíso', -71.51517840376806, -33.00208268484305),
    (32, 'Av. Pacifico 4432, Viña del Mar, Valparaíso', -71.51680150376832, -32.99708369104915),
    (33, 'Urbano Tapia 650-610, Licanray, Villarica, Araucanía', -72.15768100344408, -39.48751264948438),
    (34, 'Arauco 60-98, Pucon, Pucón, Araucanía', -71.97393848123798, -39.27223109045184),
    (35, 'Lincoyán 100-198, Pucon, Pucón, Araucanía', -71.97856256112657, -39.27458760129282),
    (36, 'Eschprcenie 645, Pucon, Pucón, Araucanía', -71.9700025290734, -39.27924315985007),
    (37, 'Caupolicán 965-991, 5220689 La Unión, Los Ríos', -73.07489973223606, -40.299715963158214),
    (38, 'Manuel Montt 600-500, La Unión, Los Ríos', -73.0787319899074, -40.29542575744363),
    (39, 'C. Serrano 1096, Rio Bueno, Río Bueno, Los Ríos', -72.94735496465206, -40.34011460981336),
    (40, 'Blanco Encalada 780, 5240000 Rio Bueno, Río Bueno, Los Ríos', -72.95922711874077, -40.336216555511236),
    (41, 'Dieciocho de Septiembre 101-199, Iquique, Tarapacá', -70.14246381960882, -20.211739990463272),
    (42, 'Manuel Bulnes 1698-1684, 1101272 Iquique, Tarapacá', -70.139611486388, -20.219831594554606),
    (43, 'Bolívar 701-799, Iquique, Tarapacá', -70.14734960028852, -20.21239552848933),
    (44, 'Teniente Uribe, Tocopilla, Antofagasta', -70.19470331954822, -22.082298785379102),
    (45, 'Arica 3100-3136, Tocopilla, Antofagasta', -70.18978003693657, -22.08068384018599),
    (46, 'Dolores, Tocopilla, Antofagasta', -70.19089927537034, -22.087775541241548),
    (47, 'Orella, Tocopilla, Antofagasta', -70.19190000420613, -22.08013038604493),
	(48, 'Av. El Bosque de Santiago 468-466, Huechuraba, Región Metropolitana', -70.63201529210636, -33.37552962205471),
    (49, 'Las Hualtatas 7226-7114, Vitacura, Región Metropolitana', -70.56183136142107, -33.39122703225791),
    (50, 'San Francisco 8478, 9020078 Santiago, Pudahuel, Región Metropolitana', -70.74414718840549, -33.43647817573659),
    (51, 'Gorbea 2242, Santiago, Región Metropolitana', -70.66664360374703, -33.4533160560961),
    (52, 'Pedro Toro 160-154, Illapel, Coquimbo', -71.16126500383093, -31.626286484171604),
    (53, 'Av. Carrera Pinto 413, Illapel, Coquimbo', -71.16666000383081, -31.62877786448021),
    (54, 'Paula Jaraquemada 15-97, Illapel, Coquimbo', -71.17386139351461, -31.631613858651214),
    (55, 'Chiloé 4299-4197, Antofagasta', -70.3856483180725, -23.631494254958106),
    (56, 'San Pedro, 1242468 Antofagasta', -70.38293200415265, -23.632726101150933),
    (57, 'Vallenar 453-421, Antofagasta', -70.38996164690809, -23.623853852098),
    (58, 'Pje. Paraguay 1407, Antofagasta', -70.37958864690809, -23.629908125519215),
    (59, 'Matadero 195-295, Constitución, Maule', -72.40197755298549, -35.339970071849955),
    (60, 'Bernardo Ohiggins 923, 3560709 Constitución, Maule', -72.4079713901634, -35.334609095695335),
    (61, 'Tocornal 826, 3560825 Constitución, Maule', -72.41464823249224, -35.337413259774706),
    (62, 'Pedro Aguirre Cerda, Chaiten, Chaitén, Los Lagos', -72.70665573209077, -42.917494729299165),
    (63, 'Diego Portales 456, 5850000 Chaiten, Chaitén, Los Lagos', -72.71075875359868, -42.91738503401788),
    (64, 'Villa Santa Lucía, Chaitén, Los Lagos', -72.36666648973366, -43.41561135168314),
    (65, 'Villa Santa Lucía, Chaitén, Los Lagos', -72.3645215032269, -43.4138792230261),
    (66, 'Argentina 192, 4450633 Biobio, Los Angeles, Bío Bío', -72.34249341128822, -37.46289296628384),
    (67, 'Ercilla 835, 4440000 Los Angeles, Bío Bío', -72.35495340024373, -37.463086792386214),
    (68, 'Campanario 2461, 4451245 Campanario, Los Angeles, Bío Bío', -72.33506643238648, -37.44576714653532),
    (69, 'Av. Nieves Vásquez 299, Los Angeles, Bío Bío', -72.33330990355073, -37.450213084925736);
	
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
    (24, 'marianaV', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 24, 3, 3, 24),
	(25, 'carlosJ', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 25, 3, 4, 25),
	(26, 'anaC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 26, 3, 4, 26),
	(27, 'oscarG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 27, 3, 4, 27),
	(28, 'ivanC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 28, 3, 4, 28),
	(29, 'danielaP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 29, 3, 4, 29),
    (30, 'miguelA', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 30, 3, 4, 30),
    (31, 'lauraG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 31, 3, 4, 31),
    (32, 'felipeV', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 32, 3, 4, 32),
    (33, 'cristianM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 33, 3, 2, 33),
    (34, 'mariaL', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 34, 3, 2, 34),
    (35, 'juanP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 35, 3, 2, 35),
    (36, 'andreaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 36, 3, 2, 36),
    (37, 'javierR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 37, 3, 2, 37),
    (38, 'luisaF', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 38, 3, 2, 38),
    (39, 'claudioC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 39, 3, 2, 39),
    (40, 'isabelS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 40, 3, 2, 40),
    (41, 'camilaV', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 41, 3, 1, 41),
    (42, 'robertoL', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 42, 3, 1, 42),
    (43, 'marianaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 43, 3, 1, 43),
    (44, 'felixM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 44, 3, 1, 44),
    (45, 'luciaR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 45, 3, 1, 45),
    (46, 'sergioP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 46, 3, 1, 46),
    (47, 'nataliaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 47, 3, 1, 47),
    (48, 'lucasV', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 48, 3, 6, 48),
    (49, 'sofiaP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 49, 3, 6, 49),
    (50, 'martinC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 50, 3, 6, 50),
    (51, 'valentinaS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 51, 3, 6, 51),
    (52, 'diegoM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 52, 3, 6, 52),
    (53, 'luisM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 53, 3, 6, 53),
    (54, 'carlaT', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 54, 3, 6, 54),
    (55, 'oscarC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 55, 3, 6, 55),
    (56, 'joseL', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 56, 3, 6, 56),
    (57, 'paolaR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 57, 3, 6, 57),
    (58, 'adrianaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 58, 3, 6, 58),
    (59, 'ramonR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 59, 3, 6, 59),
    (60, 'claraP', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 60, 3, 6, 60),
    (61, 'mauricioG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 61, 3, 6, 61),
	(62, 'carlaG', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 62, 3, 5, 62),
    (63, 'rodrigoM', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 63, 3, 5, 63),
    (64, 'luzA', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 64, 3, 5, 64),
    (65, 'juanC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 65, 3, 5, 65),
    (66, 'anaR', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 66, 3, 5, 66),
    (67, 'manuelS', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 67, 3, 5, 67),
    (68, 'margaritaC', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 68, 3, 5, 68),
    (69, 'franciscoL', '$2a$10$klotFGdYLOB1mPcEzpoqLOIiqOdrs72Pj/Cs.RgOd8Hp4OMWDOj42', 69, 3, 5, 69);


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
    (19, 7), (20, 8), (21, 9), (22, 10), (23, 11), (24, 12),
	(25, 1), (26, 12), (27, 5), (28, 3), -- emergencia 1
	(29, 4), (30, 8), (31, 8), (32, 3), -- emergencia 2
	(33, 6), (34, 8), (35, 4), (36, 12), -- emergencia 3
	(37, 9), (38, 5), (39, 6), (40, 6), -- emergencia 4
	(41, 11), (42, 1), (43, 10), -- emergencia 5
	(44, 12), (45, 4), (46, 2), (47, 2), -- emergencia 6
	(48, 11), (49, 11), (50, 4), (51, 4), -- emergencia 7
	(52, 4), (53, 12), (54, 11), -- emergencia 8
	(55, 7), (56, 2), (57, 8), (58, 8), -- emergencia 9
	(59, 4), (60, 12), (61, 7), -- emergencia 10
	(62, 11), (63, 10), (64, 8), (65, 8), -- emergencia 11
	(66, 1), (67, 10), (68, 2), (69, 2); -- emergencia 12

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
	(1, 17, 12), (2, 19, 12), (3, 24, 12),
	(4, 25, 1), (4, 26, 3), (4, 27, 5), (4, 28, 12), -- e1
	(5, 29, 3), (5, 30, 4), (4, 31, 8), (5, 32, 8),
	(6, 33, 4), (4, 34, 6), (6, 35, 8), (5, 36, 12),
	(5, 37, 5), (5, 38, 6), (4, 39, 9), (5, 40, 9),
	(5, 41, 1), (6, 42, 9), (4, 43, 10), 
	(4, 44, 2), (7, 45, 4), (6, 46, 12), (5, 47, 2),
	(8, 48, 4), (4, 49, 11), (9, 50, 4), (5, 51, 11),
	(10, 52, 4), (6, 53, 11), (7, 54, 12),
	(6, 55, 2), (4, 56, 7), (7, 57, 8), (5, 58, 7),
	(11, 59, 4), (6, 60, 7), (8, 61, 12),
	(7, 62, 11), (8, 63, 11), (9, 64, 11), (10, 65, 11),
	(6, 66, 1), (7, 67, 2), (5, 68, 10), (6, 69, 10);

-- Secuencias para evitar llaves duplicadas en posteo de datos en postman

SELECT setval('emergency_address_id_address_e_seq', 12);

SELECT setval('user_address_id_address_u_seq', 69);

SELECT setval('ability_id_ability_seq', 6);

SELECT setval('emergency_id_emergency_seq', 12);

SELECT setval('emergency_ability_id_emergency_ability_seq', 30);

SELECT setval('emergency_institution_id_emergency_institution_seq', 12);

SELECT setval('emergency_task_id_emergency_task_seq', 38);

SELECT setval('institution_id_institution_seq', 6);

SELECT setval('profile_id_profile_seq', 69);

SELECT setval('ranking_id_ranking_seq', 81);

SELECT setval('request_id_request_seq', 12);

SELECT setval('role_id_role_seq', 3);

SELECT setval('state_id_state_seq', 3);

SELECT setval('task_id_task_seq', 12);

SELECT setval('task_request_id_task_request_seq', 12);

SELECT setval('user_id_user_seq', 69);

SELECT setval('user_ability_id_user_ability_seq', 30);

SELECT setval('user_request_id_user_request_seq', 69);
