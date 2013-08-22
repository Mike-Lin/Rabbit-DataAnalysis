CREATE DATABASE `pm25`
  CHARACTER SET 'utf8'
  COLLATE 'utf8_general_ci';

CREATE TABLE `city` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `station` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` char(50) DEFAULT NULL,
  `code` char(50) DEFAULT NULL,
  `city_id` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table station add constraint FK8EEC0134369FADC4 foreign key (city_id) references city (id);

CREATE TABLE `pm25` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `aqi` varchar(255) DEFAULT NULL,
  `co` varchar(255) DEFAULT NULL,
  `co_24h` varchar(255) DEFAULT NULL,
  `no2` varchar(255) DEFAULT NULL,
  `no2_24h` varchar(255) DEFAULT NULL,
  `o3` varchar(255) DEFAULT NULL,
  `o3_24h` varchar(255) DEFAULT NULL,
  `o3_8h` varchar(255) DEFAULT NULL,
  `o3_8h_24h` varchar(255) DEFAULT NULL,
  `pm10` varchar(255) DEFAULT NULL,
  `pm10_24h` varchar(255) DEFAULT NULL,
  `pm2_5` varchar(255) DEFAULT NULL,
  `pm2_5_24h` varchar(255) DEFAULT NULL,
  `positionName` varchar(255) DEFAULT NULL,
  `primaryPollutant` varchar(255) DEFAULT NULL,
  `quality` varchar(255) DEFAULT NULL,
  `so2` varchar(255) DEFAULT NULL,
  `so2_24h` varchar(255) DEFAULT NULL,
  `stationCode` varchar(255) DEFAULT NULL,
  `timePoint` varchar(255) DEFAULT NULL,
  `station_id` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK3489002961B1AD` (`station_id`),
  CONSTRAINT `FK3489002961B1AD` FOREIGN KEY (`station_id`) REFERENCES `station` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

alter table pm25 add constraint FK3489002961B1AD foreign key (station_id) references station (id);