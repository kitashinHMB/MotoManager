# MySQLとデータベース接続

## MySQLとは

リレーショナルデータベース管理システム（RDBMS）の一つ。

データをテーブル形式で管理し、SQLを使用して操作する。

## データベースの基本用語

| 用語 | 意味 |
|---|---|
| Database | データを管理する領域 |
| Table | データを格納する表 |
| Column | データの項目・列 |
| Record | 1件分のデータ・行 |
| Primary Key | レコードを一意に識別するキー |
| Foreign Key | 他のテーブルとの関連を表すキー |

## MySQLへのログイン

```bash
mysql -u root -p
```

- -u：ユーザーを指定する
- root：管理者ユーザー
- -p：パスワードを入力する

## データベースの作成

```sql
CREATE DATABASE motomanager;
```

## 主なSQLコマンド

```sql
SHOW DATABASES;

USE motomanager;

SHOW TABLES;

DESC motorcycle;

SELECT * FROM motorcycle;
```

## Spring Bootとの接続

src/main/resources/application.propertiesに設定を記述する。

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/motomanager?serverTimezone=Asia/Tokyo&characterEncoding=UTF-8

spring.datasource.username=root
spring.datasource.password=自分のパスワード

spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true
```

## JDBCとは

Java Database Connectivityの略。

Javaからデータベースにアクセスするための標準API。

MySQL Connector/JはMySQLに接続するためのJDBCドライバーである。

## 接続URLの意味

```text
jdbc:mysql://localhost:3306/motomanager
```

| 部分 | 意味 |
|---|---|
| jdbc:mysql | MySQLへのJDBC接続 |
| localhost | 自分のコンピューター |
| 3306 | MySQLの標準ポート番号 |
| motomanager | データベース名 |

## ddl-auto

Hibernateによるテーブル構造の管理方法を指定する。

| 設定値 | 意味 |
|---|---|
| none | 自動変更しない |
| validate | テーブル構造を検証する |
| update | 必要に応じて構造を更新する |
| create | 起動時にテーブルを再作成する |
| create-drop | 起動時に作成し、終了時に削除する |

開発中はupdateが便利だが、本番環境ではデータベースの変更を適切に管理する必要がある。

## データを空にする方法

```sql
SET FOREIGN_KEY_CHECKS = 0;

TRUNCATE TABLE maintenance_record;
TRUNCATE TABLE motorcycle;

SET FOREIGN_KEY_CHECKS = 1;
```

TRUNCATEはテーブル構造を残して全件削除し、自動採番もリセットする。

実行前にテーブル名と削除対象を必ず確認する。削除したデータはROLLBACKでは復元できない。

## 注意事項

データベースのパスワードをGitHubなどに公開しないこと。

本番環境ではrootではなく、必要な権限だけを持つユーザーを利用することが望ましい。

## 関連ノート

- [[06_EntityとJPA]]
- [[07_Repository]]
- [[11_テーブル間の関連付け]]

#MySQL #SQL #JDBC
