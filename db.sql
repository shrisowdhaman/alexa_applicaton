create database redxinsurance;

SHOW VARIABLES LIKE 'collation_database';
CREATE TABLE `policy` (
	`id` INT NULL,
	`policyNumber` VARCHAR(50) NULL,
	`policyExpDate` DATE NULL
)
COLLATE='latin1_swedish_ci'
ENGINE=InnoDB
 
INSERT INTO `redxinsurance`.`policy` (`id`, `policyNumber`, `policyExpDate`) VALUES ('1', 'A111', '2018-03-18');
INSERT INTO `redxinsurance`.`policy` (`id`, `policyNumber`, `policyExpDate`) VALUES ('2', 'B222', '2018-04-18');

ALTER TABLE `policy`ADD COLUMN `dob` DATE NULL DEFAULT NULL AFTER `policyDate`;


//http://localhost:8080/validatePolicy/A111
//http://localhost:8080/
//http://localhost:8080/getPolicyExpDate/A111/1999-09-09T04:00:00.000+0000