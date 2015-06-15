-- Create schema
CREATE SCHEMA example_schema;

-- Create Table
CREATE TABLE example_schema.usuario (
  id INT NOT NULL AUTO_INCREMENT,
  nome VARCHAR(45) NULL,
  telefone INT NULL,
  email VARCHAR(45) NULL,
  PRIMARY KEY (id));

-- Insert some data
INSERT INTO example_schema.usuario (id, nome, telefone, email) values (1, 'Homer Simpsons', '99999999', 'homer@fox.com');
INSERT INTO example_schema.usuario (id, nome, telefone, email) values (2, 'Jhon Snow', '99991234', 'jhon@got.com');
INSERT INTO example_schema.usuario (id, nome, telefone, email) values (3, 'Rick Grimes', '67899999', 'rick@twd.com');
INSERT INTO example_schema.usuario (id, nome, telefone, email) values (4, 'Steve Jobs', '456745679', 'steve@apple.com');
INSERT INTO example_schema.usuario (id, nome, telefone, email) values (5, 'Magic Jadson', '85765687', 'magic@gmail.com');

-- Count open connections
SHOW processlist;
SHOW STATUS WHERE variable_name = 'Threads_connected';