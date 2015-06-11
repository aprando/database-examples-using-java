CREATE SCHEMA 'example_schema' DEFAULT CHARACTER SET utf8 ;

CREATE TABLE 'example_schema'.'usuario' (
  'id' INT NOT NULL,
  'nome' VARCHAR(45) NULL,
  'data_nascimento' TIMESTAMP NULL,
  PRIMARY KEY ('id));
