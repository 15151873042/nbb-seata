create table t_stock
(
    id         int auto_increment comment '主键' primary key,
    sku_code   varchar(255) null comment '商品编号',
    count      int default 0 null comment '商品库存数量',
    constraint commodity_codeunique (sku_code)
) charset = utf8mb4;

INSERT INTO seata_stock.t_stock (id, sku_code, count) VALUES (1, 'sku_code_01', 100);
INSERT INTO seata_stock.t_stock (id, sku_code, count) VALUES (2, 'sku_code_02', 100);



-- 注意此处0.3.0+ 增加唯一索引 ux_undo_log
CREATE TABLE `undo_log`
(
    `id`            bigint(20) NOT NULL AUTO_INCREMENT,
    `branch_id`     bigint(20) NOT NULL,
    `xid`           varchar(100) NOT NULL,
    `context`       varchar(128) NOT NULL,
    `rollback_info` longblob     NOT NULL,
    `log_status`    int(11) NOT NULL,
    `log_created`   datetime     NOT NULL,
    `log_modified`  datetime     NOT NULL,
    `ext`           varchar(100) DEFAULT NULL,
    PRIMARY KEY (`id`),
    UNIQUE KEY `ux_undo_log` (`xid`,`branch_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

