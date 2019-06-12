CREATE TABLE `user`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `code`  varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `encryptedPassword`  varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_4gr67lk0t9mc9aoqfbo9mdmtw` (`code`),
    UNIQUE KEY `UKfwmwi44u55bo4rvwsv0cln012` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `user_role`
(
    `id`          int(11)                                 NOT NULL AUTO_INCREMENT,
    `role`      varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `user_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKm254uwl46gh5ikwewewrimenoi` (`user_code`),
    CONSTRAINT `FKm254uwl46gh5idewuyvrimenoi` FOREIGN KEY (`user_code`) REFERENCES `user` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


CREATE TABLE `person`
(
    `id`    int(11) NOT NULL AUTO_INCREMENT,
    `code`  varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `email` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    `name`  varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `UK_4gr67lk0t9mc9aoqfbo9mdmtw` (`code`),
    UNIQUE KEY `UKfwmwi44u55bo4rvwsv0cln012` (`email`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

CREATE TABLE `phone_number`
(
    `id`          int(11)                                 NOT NULL AUTO_INCREMENT,
    `number`      varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    `person_code` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
    PRIMARY KEY (`id`),
    KEY `FKm254uwl46gh5ikcuyvrimenoi` (`person_code`),
    CONSTRAINT `FKm254uwl46gh5ikcuyvrimenoi` FOREIGN KEY (`person_code`) REFERENCES `person` (`code`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
