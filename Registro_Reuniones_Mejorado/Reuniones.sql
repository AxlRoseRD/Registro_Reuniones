create database Reuniones;
use Reuniones;

drop table eventos;
drop database Reuniones;

CREATE TABLE eventos (
  Id int NOT NULL AUTO_INCREMENT,
  eventName varchar(15) not NULL,
  eventDate DATE not NULL,
  startTime time not NULL,
  endTime time not NULL,
  eventPlace varchar(20) DEFAULT NULL,
  eventDetails varchar(60) DEFAULT NULL,
  PRIMARY KEY (Id)
)

select * from eventos where eventDate like'%2021-04-28%';

INSERT INTO eventos VALUES (1,'Prueba','2021-04-28','18:30:00','22:00:00','ITLA','Este es un vento de prueba');
