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
