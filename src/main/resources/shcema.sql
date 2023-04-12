CREATE TABLE IF NOT EXISTS users(
	id int unsigned NOT NULL AUTO_INCREMENT comment 'USERID',
	username varchar(100) NOT NULL comment 'ユーザーネーム',
	password varchar(100) NOT NULL comment 'パスワード',
	PRIMARY KEY(id)
);