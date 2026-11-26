# プロジェクト構成とMaven

## プロジェクトの構成

```text
MotoManager/
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/motomanager/
    │   │       ├── MotoManagerApplication.java
    │   │       ├── controller/
    │   │       ├── service/
    │   │       ├── repository/
    │   │       ├── entity/
    │   │       └── dto/
    │   └── resources/
    │       ├── application.properties
    │       └── static/
    └── test/
```

## 各ディレクトリの役割

| ディレクトリ | 役割 |
|---|---|
| src/main/java | Javaのソースコード |
| src/main/resources | 設定ファイルなど |
| static | HTML・CSS・JavaScript |
| src/test | テストコード |
| target | ビルドによって生成されるファイル |

## Mavenとは

Javaプロジェクトのビルドやライブラリの管理を行うツール。

必要なライブラリを自動的に取得し、コンパイルやテストなどを実行できる。

## pom.xmlとは

POMはProject Object Modelの略である。

Mavenがプロジェクトを管理するための設定ファイル。

主に以下の情報を記述する。

- プロジェクト名
- バージョン
- Javaのバージョン
- 依存ライブラリ
- ビルド設定

## dependencies

使用するライブラリを指定する部分。

Spring BootのWeb機能を導入する依存関係の例。

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-web</artifactId>
</dependency>
```

### groupId

ライブラリを提供する組織やグループの識別子。

### artifactId

ライブラリ自体の識別子。

### version

ライブラリのバージョン。

Spring Bootの依存関係管理によって、バージョンの指定を省略できる場合がある。

## 主な依存ライブラリ

| ライブラリ | 役割 |
|---|---|
| Spring Boot Web | Web通信・REST API |
| Spring Data JPA | データベース操作 |
| MySQL Connector/J | JavaとMySQLの接続 |
| Spring Boot Test | テスト |

## Maven Wrapper

Mavenをプロジェクト単位で利用するための仕組み。

MacやLinuxではmvnw、Windowsではmvnw.cmdを使用する。

## 主なコマンド

```bash
./mvnw spring-boot:run
./mvnw compile
./mvnw test
./mvnw clean
./mvnw package
```

| コマンド | 意味 |
|---|---|
| spring-boot:run | アプリケーションの起動 |
| compile | コンパイル |
| test | テストの実行 |
| clean | ビルド生成物の削除 |
| package | JARファイルなどの生成 |

## 関連ノート

- [[01_Spring Bootの基礎]]
- [[05_MySQLとデータベース接続]]

#Maven #pom.xml
