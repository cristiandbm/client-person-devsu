create table clients (
	client_id VARCHAR(20) NOT NULL PRIMARY KEY,
	name VARCHAR(20) NOT NULL,
	address VARCHAR(40) NOT NULL, 
	phone VARCHAR(20) NOT NULL,
	password VARCHAR(10) NOT NULL,
	status BOOLEAN NOT NULL
);