
create table `Celebrity` (
	`id` int  NOT NULL AUTO_INCREMENT,
	`CeleName` varchar (30),
	`gender` varchar (1),
	`filename` varchar (60) ,
	`size` BigInt,
	`timesave` DateTime ,
	`picture` longblob ,
	PRIMARY KEY (`id`)
)ENGINE=InnoDB ROW_FORMAT=DYNAMIC  DEFAULT CHARSET=utf8 COLLATE utf8_general_ci; 
