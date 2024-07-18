CREATE table if not exists cities (
	city_id bigserial primary key,
	name varchar(250) not null
);

CREATE table if not exists airports (
	airport_id bigserial primary key,
	name varchar(250) not null,
	city_id bigint references cities(city_id) not null
);

CREATE table if not exists flights (
	flight_id varchar(20) primary key,
	departure_airport_id bigint references airports(airport_id) not null,
	destination_airport_id bigint references airports(airport_id) not null,
	departure_date_time timestamp not null,
	return_date_time timestamp not null,
	price real not null
);

truncate table flights restart identity cascade;
truncate table airports restart identity cascade;
truncate table cities restart identity cascade;

DROP PROCEDURE IF EXISTS sp_delete_city_by_id;

CREATE or REPLACE PROCEDURE sp_delete_city_by_id(bigint)
LANGUAGE plpgsql
AS
'
    BEGIN
        DELETE FROM cities WHERE city_id = $1;
    END
';

DROP PROCEDURE IF EXISTS sp_update_city;

CREATE or REPLACE PROCEDURE sp_update_city(bigint, varchar(250))
LANGUAGE plpgsql
AS
'
    BEGIN
        UPDATE cities set name = $2 where city_id = $1;
    END
';

DROP FUNCTION IF EXISTS find_city_by_name;

CREATE or REPLACE FUNCTION find_city_by_name(varchar(250))
RETURNS TABLE (id bigint, city_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities WHERE name = $1;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_all_cities;

CREATE or REPLACE FUNCTION find_all_cities()
RETURNS TABLE (id bigint, city_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS find_city_by_id;

CREATE or REPLACE FUNCTION find_city_by_id(bigint)
RETURNS TABLE (id bigint, city_name varchar(250))
AS
'
    BEGIN
        RETURN QUERY SELECT * FROM cities WHERE city_id = $1;
    END
' LANGUAGE plpgsql;

DROP FUNCTION IF EXISTS insert_city;

CREATE or REPLACE FUNCTION insert_city(varchar(250))
RETURNS bigint
AS
'
    BEGIN
       INSERT INTO cities (name) VALUES ($1);
       RETURN currval($$cities_city_id_seq$$::regclass);
    END
' LANGUAGE plpgsql;