# Spring Bootの基礎

## Springとは

Springとは、Javaでアプリケーションを開発するためのフレームワークである。

Web通信、データベース接続、オブジェクトの管理など、アプリケーション開発に必要な仕組みを提供している。

## Spring Bootとは

Spring Bootとは、Springを利用したアプリケーションを簡単に開発・起動するための仕組みである。

従来のSpringでは多くの設定を手動で行う必要があったが、Spring Bootでは自動設定によって開発者の負担を軽減できる。

## Spring Bootの特徴

- 設定の自動化
- 組み込みWebサーバー
- ライブラリの導入が容易
- REST APIを簡単に構築できる
- データベースとの連携が容易

## フレームワークとライブラリの違い

ライブラリは、開発者が必要に応じて呼び出して使用する。

フレームワークは、アプリケーション全体の仕組みを提供し、その仕組みに従って開発者がコードを記述する。

## Spring Bootの起動

```java
@SpringBootApplication
public class MotoManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            MotoManagerApplication.class, args
        );
    }
}
```

### @SpringBootApplication

Spring Bootのアプリケーションであることを示すアノテーション。

主に以下の機能をまとめている。

- Configuration：設定クラスとして扱う
- EnableAutoConfiguration：自動設定を有効にする
- ComponentScan：管理対象のクラスを検索する

### SpringApplication.run()

Spring Bootを起動するメソッド。

Spring MVCを使用する一般的なWebアプリケーションでは、組み込みTomcatも起動する。

## アノテーションとは

Javaのクラスやメソッドなどに追加情報を与える仕組み。

先頭に「@」を付けて記述する。

Springではアノテーションによって、クラスやメソッドの役割を指定する。

## 起動コマンド

```bash
./mvnw spring-boot:run
```

起動後は、通常以下のURLからアクセスできる。

```text
http://localhost:8080/
```

## 関連ノート

- [[02_プロジェクト構成とMaven]]
- [[04_アプリケーションの階層構造]]
- [[10_依存性注入（DI）]]

#SpringBoot #基礎
