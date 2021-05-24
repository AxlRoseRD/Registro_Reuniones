create database Reuniones;
use Reuniones;

drop table eventos;
drop database Reuniones;

CREATE TABLE eventos (
  Id int NOT NULL AUTO_INCREMENT,
  eventName varchar(15) not NULL,
  eventDate DATE not NULL,
  startTime varchar(7) not NULL,
  endTime varchar(7) not NULL,
  eventPlace varchar(45) DEFAULT NULL,
  eventDetails varchar(120) DEFAULT NULL,
  PRIMARY KEY (Id)
)

select * from eventos where eventDate like'%2021-04-28%';
select * from eventos where eventDate like '%2021-04-28%';

INSERT INTO eventos VALUES (1,'Prueba','2021-04-28','18:30PM','22:00PM','ITLA','Este es un vento de prueba');

SELECT * FROM eventos;