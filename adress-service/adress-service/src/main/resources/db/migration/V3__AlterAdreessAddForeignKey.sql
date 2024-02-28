ALTER TABLE `address`
ADD COLUMN `employee_id` INT;

ALTER TABLE `address`
ADD CONSTRAINT `emplopyee_id`
   FOREIGN KEY (`employee_id`)
   REFERENCES `employee` (`id`);