CREATE TABLE `orders`
(
    `id`       BIGINT(20)     NOT NULL AUTO_INCREMENT,
    `no`       VARCHAR(255)   NOT NULL,
    `sku`      VARCHAR(255)   NOT NULL,
    `price`    DECIMAL(19, 2) NOT NULL,
    `quantity` INT(11)        NOT NULL,
    PRIMARY KEY (`id`)
)