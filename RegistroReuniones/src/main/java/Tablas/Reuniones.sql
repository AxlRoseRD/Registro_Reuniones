create database Reuniones;
use Reuniones;
drop table eventos;
CREATE TABLE eventos (
  Id int NOT NULL AUTO_INCREMENT,
  eventName varchar(15) not NULL,
  eventDate varchar(10) not NULL,
  startTime varchar(7) not NULL,
  endTime varchar(7) not NULL,
  eventPlace varchar(45) DEFAULT NULL,
  eventDetails varchar(120) DEFAULT NULL,
  PRIMARY KEY (Id)
)

INSERT INTO eventos VALUES (1,'Prueba','2021-04-28','18:30PM','22:00PM','ITLA','Este es un vento de prueba');

SELECT * FROM eventos;