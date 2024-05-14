# ProductCalculator
# 概要
 
在庫管理を円滑にするためのアプリです。

# 作成経緯
発注

# 使用技術
Java 11  
Spring Boot 3.0.5  
MySQL 5.7.33
 
# テーブル定義
## productsテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|p_number         |varchar8256)    |                |
|product          |varchar(256)    |                |
|category         |varchar(100)    |                |
|price            |varchar(256)    |                |
|registration_date|timestamp       |                |
|deleded_date     |timestamp       |                |

## stocksテーブル
|列名             |データ型         |備考            |
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|product_id       |int(11)         |                |
|inventory        |char(100)       |                |
|update_date      |timestamp       |                |



## ordersテーブル
|列名             |データ型         |備考            | 
|-----------------|----------------|----------------|
|id               |int(11)         |Auto_increment  |
|stocks_id        |int(11)         |                |
|orders_number    |int(11)         |                |
|order_date       |char(100)       |                |
|delivery_date    |date            |                |

![image](https://

# Requirement
 

 
# Installation
 

 
# Usage
 

# Note
 
 
