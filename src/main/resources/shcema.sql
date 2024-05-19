CREATE TABLE IF NOT EXISTS product(
    id int(11) NOT NULL AUTO_INCREMENT,
	p_number varchar(256) NOT NULL comment '製品番号',
	category varchar(100) NOT NULL comment '種類',
	price varchar(256) not null comment '値段',
	registration_date not null comment '登録日'
	deleted_date timestamp comment '削除日'
	PRIMARY KEY(id)
);

CREATE TABLE IF NOT EXISTS stocks(
    id int(11) NOT NULL AUTO_INCREMENT,
    product_id int(11) NOT NULL comment '製品番号',
    inventory char(100) NOT NULL comment '在庫数',
    update_date timestamp comment '更新日時',
    PRIMARY KEY(id),
    FOREIGN KEY product_id
    REFERENCES product(id)
);

CREATE TABLE IF NOT EXISTS orders(
    id int(11) NOT NULL AUTO_INCREMENT,
    stocks_id int(11) NOT NULL comment '在庫管理番号',
    orders_number char(100) NOT NULL comment '発注数',
    order_date timestamp comment '発注日',
    delivery_date date NOT NULL '引き渡し日',
    PRIMARY KEY(id),
    FOREIGN KEY stocks_id
    REFERENCES stocks(id)
);