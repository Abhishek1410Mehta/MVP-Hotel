drop database if exists hotelbooking_db;
create database hotelbooking_db;
use  hotelbooking_db;

create table Booking(
	booking_id int primary key auto_increment,
	hotel_name varchar(20),
	user_mobile BIGINT(10),
	source varchar(15),
	destination varchar(10),
	fare float(9,2),
	booking_date DATE,
	status CHAR NOT NULL
);


insert into Booking values(1,'JK Residency',9877766756,'San Jose','Los Angles',3400,sysdate()+2,'B');
insert into Booking values(2,'The Lalit',8898766766,'San Francisco','San Jose',4800,sysdate()+4,'B');

commit;

select * from Booking;