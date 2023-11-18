--Crea la tabla query_log que almacena la información de los SELECT, UPDATE y DELETE
CREATE TABLE IF NOT EXISTS public.query_log (
    id SERIAL PRIMARY KEY,
    username TEXT,
    table_name TEXT,
    query_text TEXT,
	operation TEXT,
    timestamp TIMESTAMPTZ DEFAULT NOW()
);

-- Crear tabla en donde se coloque el id del usuario que esta logeado
CREATE TABLE IF NOT EXISTS login_identification (
    id_login_identification SERIAL PRIMARY KEY,
    user_id INT
);

-- login_identification comienza con una id inicial que se actualiza
insert into login_identification (user_id) values (0);

-------------- TRIGGERS EN ORDEN

-- Crear una función que registre las operaciones en la tabla "ability"
CREATE OR REPLACE FUNCTION log_query_ability()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN

    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'ability';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_ability, ability_name) VALUES (' || NEW.id_ability || ', ' || quote_literal(NEW.ability_name) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET ability_name = ' || quote_literal(NEW.ability_name) || ' WHERE id_ability = ' || NEW.id_ability;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_ability = ' || OLD.id_ability;
    END IF;

    -- Insertar el registro en la tabla "query_log"
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla ability
CREATE TRIGGER log_query_ability_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.ability
FOR EACH ROW
EXECUTE FUNCTION log_query_ability();




-- Crear una función que registre las operaciones en la tabla emergency
CREATE OR REPLACE FUNCTION log_query_emergency()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'emergency';

   -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_emergency, emergency_name, emergency_location, emergency_type, statement_date, id_state) VALUES (' || NEW.id_emergency || ', ' || quote_literal(NEW.emergency_name) || ', ' || quote_literal(NEW.emergency_location) || ', ' || quote_literal(NEW.emergency_type) || ', ' || quote_literal(NEW.statement_date) || ', ' || NEW.id_state || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET emergency_name = ' || quote_literal(NEW.emergency_name) || ', emergency_location = ' || quote_literal(NEW.emergency_location) || ', emergency_type = ' || quote_literal(NEW.emergency_type) || ', statement_date = ' || quote_literal(NEW.statement_date) || ', id_state = ' || NEW.id_state || ' WHERE id_emergency = ' || NEW.id_emergency;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_emergency = ' || OLD.id_emergency;
    END IF;

    -- Insertar el registro en la tabla query_log 
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla emergency
CREATE TRIGGER log_query_emergency_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.emergency
FOR EACH ROW
EXECUTE FUNCTION log_query_emergency();


-- Crear una función que registre las operaciones en la tabla emergency_ability
CREATE OR REPLACE FUNCTION log_query_emergency_ability()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'emergency_ability';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_ability, id_emergency) VALUES (' || NEW.id_ability || ', ' || NEW.id_emergency || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_ability = ' || NEW.id_ability || ', id_emergency = ' || NEW.id_emergency || ' WHERE id_ability = ' || OLD.id_ability || ' AND id_emergency = ' || OLD.id_emergency;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_ability = ' || OLD.id_ability || ' AND id_emergency = ' || OLD.id_emergency;
    END IF;

    -- Insertar el registro en la tabla query_log 
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla emergency_ability
CREATE TRIGGER log_query_emergency_ability_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.emergency_ability
FOR EACH ROW
EXECUTE FUNCTION log_query_emergency_ability();




-- Crear una función que registre las operaciones en la tabla emergency_institution
CREATE OR REPLACE FUNCTION log_query_emergency_institution()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'emergency_institution';

    -- Obtener la operación realizada y construir la consulta
IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_emergency, id_institution) VALUES (' || NEW.id_emergency || ', ' || NEW.id_institution || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_emergency = ' || NEW.id_emergency || ', id_institution = ' || NEW.id_institution || ' WHERE id_emergency = ' || OLD.id_emergency || ' AND id_institution = ' || OLD.id_institution;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_emergency = ' || OLD.id_emergency || ' AND id_institution = ' || OLD.id_institution;
    END IF;


    -- Insertar el registro en la tabla query_log 
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla emergency_institution
CREATE TRIGGER log_query_emergency_institution_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.emergency_institution
FOR EACH ROW
EXECUTE FUNCTION log_query_emergency_institution();




-- Crear una función que registre las operaciones en la tabla emergency_task
CREATE OR REPLACE FUNCTION log_query_emergency_task()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'emergency_task';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_emergency, id_task) VALUES (' || NEW.id_emergency || ', ' || NEW.id_task || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_emergency = ' || NEW.id_emergency || ', id_task = ' || NEW.id_task || ' WHERE id_emergency = ' || OLD.id_emergency || ' AND id_task = ' || OLD.id_task;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_emergency = ' || OLD.id_emergency || ' AND id_task = ' || OLD.id_task;
    END IF;
	
    -- Insertar el registro en la tabla query_log 
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla emergency_task
CREATE TRIGGER log_query_emergency_task_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.emergency_task
FOR EACH ROW
EXECUTE FUNCTION log_query_emergency_task();





-- Crear una función que registre las operaciones en la tabla institution
CREATE OR REPLACE FUNCTION log_query_institution()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'institution';

    -- Obtener la operación realizada y construir la consulta
        IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_institution, institution_name, institution_description) VALUES (' || NEW.id_institution || ', ' || quote_literal(NEW.institution_name) || ', ' || quote_literal(NEW.institution_description) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET institution_name = ' || quote_literal(NEW.institution_name) || ', institution_description = ' || quote_literal(NEW.institution_description) || ' WHERE id_institution = ' || NEW.id_institution;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_institution = ' || OLD.id_institution;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla institution
CREATE TRIGGER log_query_institution_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.institution
FOR EACH ROW
EXECUTE FUNCTION log_query_institution();





-- Crear una función que registre las operaciones en la tabla profile
CREATE OR REPLACE FUNCTION log_query_profile()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'profile';

    -- Obtener la operación realizada y construir la consulta
	IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_profile, photo, first_name, second_name, first_lastname, second_lastname, description, gender, birthday) VALUES (' || NEW.id_profile || ', ' || quote_literal(NEW.photo) || ', ' || quote_literal(NEW.first_name) || ', ' || quote_literal(NEW.second_name) || ', ' || quote_literal(NEW.first_lastname) || ', ' || quote_literal(NEW.second_lastname) || ', ' || quote_literal(NEW.description) || ', ' || quote_literal(NEW.gender) || ', ' || quote_literal(NEW.birthday) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET photo = ' || quote_literal(NEW.photo) || ', first_name = ' || quote_literal(NEW.first_name) || ', second_name = ' || quote_literal(NEW.second_name) || ', first_lastname = ' || quote_literal(NEW.first_lastname) || ', second_lastname = ' || quote_literal(NEW.second_lastname) || ', description = ' || quote_literal(NEW.description) || ', gender = ' || quote_literal(NEW.gender) || ', birthday = ' || quote_literal(NEW.birthday) || ' WHERE id_profile = ' || NEW.id_profile;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_profile = ' || OLD.id_profile;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla profile
CREATE TRIGGER log_query_profile_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.profile
FOR EACH ROW
EXECUTE FUNCTION log_query_profile();





-- Crear una función que registre las operaciones en la tabla ranking
CREATE OR REPLACE FUNCTION log_query_ranking()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'ranking';

    -- Obtener la operación realizada y construir la consulta
 	IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_ranking, ranking_position, id_user, id_task) VALUES (' || NEW.id_ranking || ', ' || NEW.ranking_position || ', ' || NEW.id_user || ', ' || NEW.id_task || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET ranking_position = ' || NEW.ranking_position || ', id_user = ' || NEW.id_user || ', id_task = ' || NEW.id_task || ' WHERE id_ranking = ' || NEW.id_ranking;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_ranking = ' || OLD.id_ranking;
    END IF;

	
    -- Insertar el registro en la tabla query_log 
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla ranking
CREATE TRIGGER log_query_ranking_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.ranking
FOR EACH ROW
EXECUTE FUNCTION log_query_ranking();





-- Crear una función que registre las operaciones en la tabla request
CREATE OR REPLACE FUNCTION log_query_request()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'request';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_request, request_name, request_description) VALUES (' || NEW.id_request || ', ' || quote_literal(NEW.request_name) || ', ' || quote_literal(NEW.request_description) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET request_name = ' || quote_literal(NEW.request_name) || ', request_description = ' || quote_literal(NEW.request_description) || ' WHERE id_request = ' || NEW.id_request;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_request = ' || OLD.id_request;
    END IF;
    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla request
CREATE TRIGGER log_query_request_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.request
FOR EACH ROW
EXECUTE FUNCTION log_query_request();



-- Crear una función que registre las operaciones en la tabla role
CREATE OR REPLACE FUNCTION log_query_role()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'role';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_role, role_name) VALUES (' || NEW.id_role || ', ' || quote_literal(NEW.role_name) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET role_name = ' || quote_literal(NEW.role_name) || ' WHERE id_role = ' || NEW.id_role;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_role = ' || OLD.id_role;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla rol
CREATE TRIGGER log_query_role_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.role
FOR EACH ROW
EXECUTE FUNCTION log_query_role();



-- Crear una función que registre las operaciones en la tabla state
CREATE OR REPLACE FUNCTION log_query_state()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'state';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_state, state_name, state_description) VALUES (' || NEW.id_state || ', ' || quote_literal(NEW.state_name) || ', ' || quote_literal(NEW.state_description) || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET state_name = ' || quote_literal(NEW.state_name) || ', state_description = ' || quote_literal(NEW.state_description) || ' WHERE id_state = ' || NEW.id_state;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_state = ' || OLD.id_state;
    END IF;
    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla state
CREATE TRIGGER log_query_state_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.state
FOR EACH ROW
EXECUTE FUNCTION log_query_state();





-- Crear una función que registre las operaciones en la tabla task
CREATE OR REPLACE FUNCTION log_query_task()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'task';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_task, task_name, task_description, volunteers_required, id_state) VALUES (' || NEW.id_task || ', ' || quote_literal(NEW.task_name) || ', ' || quote_literal(NEW.task_description) || ', ' || NEW.volunteers_required || ', ' || NEW.id_state || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET task_name = ' || quote_literal(NEW.task_name) || ', task_description = ' || quote_literal(NEW.task_description) || ', volunteers_required = ' || NEW.volunteers_required || ', id_state = ' || NEW.id_state || ' WHERE id_task = ' || NEW.id_task;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_task = ' || OLD.id_task;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla task
CREATE TRIGGER log_query_task_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.task
FOR EACH ROW
EXECUTE FUNCTION log_query_task();



-- Crear una función que registre las operaciones en la tabla task_request
CREATE OR REPLACE FUNCTION log_query_task_request()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'task_request';

-- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_task_request, id_task, id_request) VALUES (' || NEW.id_task_request || ', ' || NEW.id_task || ', ' || NEW.id_request || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_task = ' || NEW.id_task || ', id_request = ' || NEW.id_request || ' WHERE id_task_request = ' || NEW.id_task_request;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_task_request = ' || OLD.id_task_request;
    END IF;
    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla task_request
CREATE TRIGGER log_query_task_request_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.task_request
FOR EACH ROW
EXECUTE FUNCTION log_query_task_request();




-- Crear una función que registre las operaciones en la tabla user
CREATE OR REPLACE FUNCTION log_query_user()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'user';

 	-- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_user, username, password, id_profile, id_role, id_institution) VALUES (' || NEW.id_user || ', ' || quote_literal(NEW.username) || ', ' || quote_literal(NEW.password) || ', ' || NEW.id_profile || ', ' || NEW.id_role || ', ' || NEW.id_institution || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET username = ' || quote_literal(NEW.username) || ', password = ' || quote_literal(NEW.password) || ', id_profile = ' || NEW.id_profile || ', id_role = ' || NEW.id_role || ', id_institution = ' || NEW.id_institution || ' WHERE id_user = ' || NEW.id_user;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_user = ' || OLD.id_user;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla user
CREATE TRIGGER log_query_user_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.user
FOR EACH ROW
EXECUTE FUNCTION log_query_user();




-- Crear una función que registre las operaciones en la tabla user_ability
CREATE OR REPLACE FUNCTION log_query_user_ability()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'user_ability';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_user_ability, id_user, id_ability) VALUES (' || NEW.id_user_ability || ', ' || NEW.id_user || ', ' || NEW.id_ability || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_user = ' || NEW.id_user || ', id_ability = ' || NEW.id_ability || ' WHERE id_user_ability = ' || NEW.id_user_ability;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_user_ability = ' || OLD.id_user_ability;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text, operation) VALUES (username, table_name, query_text, operation);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla user_ability
CREATE TRIGGER log_query_user_ability_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.user_ability
FOR EACH ROW
EXECUTE FUNCTION log_query_user_ability();



-- Crear una función que registre las operaciones en la tabla user_request
CREATE OR REPLACE FUNCTION log_query_user_request()
RETURNS TRIGGER AS $$
DECLARE
    username TEXT;
    table_name VARCHAR(25);
    query_text TEXT;
    operation TEXT;
BEGIN
    -- obtener id de usuario y nombre de la tabla
    SELECT user_id::TEXT INTO username FROM login_identification LIMIT 1;
    table_name := 'user_request';

    -- Obtener la operación realizada y construir la consulta
    IF (TG_OP = 'INSERT') THEN
        query_text := 'INSERT';
        operation := 'INSERT INTO ' || TG_TABLE_NAME || ' (id_user_request, id_user, id_request) VALUES (' || NEW.id_user_request || ', ' || NEW.id_user || ', ' || NEW.id_request || ')';
    ELSIF (TG_OP = 'UPDATE') THEN
        query_text := 'UPDATE';
        operation := 'UPDATE ' || TG_TABLE_NAME || ' SET id_user = ' || NEW.id_user || ', id_request = ' || NEW.id_request || ' WHERE id_user_request = ' || NEW.id_user_request;
    ELSIF (TG_OP = 'DELETE') THEN
        query_text := 'DELETE';
        operation := 'DELETE FROM ' || TG_TABLE_NAME || ' WHERE id_user_request = ' || OLD.id_user_request;
    END IF;

    -- Insertar el registro en la tabla query_log usando la variable current_username, table_name y query_text
    INSERT INTO query_log (username, table_name, query_text) VALUES (username, table_name, query_text);

    RETURN NEW;
END;
$$ LANGUAGE plpgsql;

-- Crear el trigger que se dispara después de INSERT, UPDATE o DELETE en la tabla user_request
CREATE TRIGGER log_query_user_request_trigger
AFTER INSERT OR UPDATE OR DELETE
ON public.user_request
FOR EACH ROW
EXECUTE FUNCTION log_query_user_request();

