CREATE TABLE IF NOT EXISTS users(
	id int unsigned NOT NULL AUTO_INCREMENT comment 'USERID',
	username text(20) NOT NULL comment 'ユーザーネーム',
	password varchar(50) NOT NULL comment 'パスワード',
	PRIMARY KEY(id)
);