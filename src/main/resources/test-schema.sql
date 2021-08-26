drop table if exists `artist` CASCADE;
CREATE TABLE IF NOT EXISTS `artist` (
	`id` BIGINT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    PRIMARY KEY (`id`)
);

