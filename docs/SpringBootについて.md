# 1. Spring Bootの全体構造

Spring Bootは、Javaを使ってWebアプリケーションを動かすためのフレームワークです。

次のような構造になります。

ブラウザ

	HTML・CSS・JavaScript

	画面表示・入力・操作

	HTTPリクエスト

Spring Boot（Java）

	リクエストを受け取り、処理を実行する

データベース

	バイク情報・整備記録・予定を保存

例えば、ユーザーが「整備記録を登録する」ボタンを押した場合、

1. ブラウザからSpring Bootにデータを送信する
    
2. Javaが送られてきたデータを受け取る
    
3. 必要な処理を行う
    
4. データベースに保存する
    
5. 結果をブラウザに返す
    

という流れになります。

# 2. プロジェクトのフォルダ構造

Spring Initializrで作成したプロジェクトは、基本的に次のような構造になっています。

```

MotoManager/
├── .mvn/
├── mvnw
├── mvnw.cmd
├── pom.xml
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/example/motomanager/
    │   │       └── MotoManagerApplication.java
    │   │
    │   └── resources/
    │       ├── static/
    │       ├── templates/
    │       └── application.properties
    │
    └── test/
        └── java/
```

それぞれの役割を理解しておきましょう。

## ① `src/`

Source（ソースコード）

開発するプログラムのソースコードが格納されるフォルダです。

JavaのプログラムやHTML、設定ファイルなど、実際にアプリを作るためのファイルは基本的にこの中に置きます。

## ② `src/main/`

実際に動作するアプリケーション本体を格納します。

`main` は、アプリケーションの本番処理に使うコードやファイルを置く場所です。

## ③ `src/main/java/`

Javaのソースコードを置く場所です。

例えば、今後MotoManagerでは次のようなJavaクラスを作成します。

- `Controller`：画面やリクエストを受け付ける
    
- `Service`：アプリの処理・ルールを担当する
    
- `Repository`：データベースとのやり取りを担当する
    
- `Entity`：データの構造を定義する
    

これらはすべてJavaファイルです。

## ④ `src/main/resources/`

Java以外の設定ファイルや、Web画面に関するファイルを格納する場所です。

今回のWebアプリでは、特に重要になります。

|フォルダ・ファイル|役割|
|---|---|
|`static/`|HTML、CSS、JavaScript、画像など|
|`templates/`|Thymeleafなどで生成するHTML|
|`application.properties`|Spring Bootの設定|

今回はHTML・CSS・JavaScriptで画面を作る方針なので、まずは `static/` を中心に使用します。

# 3. `static`・`templates`・`java` の違い

ここは、今回の開発で特に重要です。

static

ブラウザにそのまま配信するファイル

HTML・CSS・JavaScript・画像

java

サーバー側で処理するプログラム

Controller・Service・Repositoryなど

### static（静的ファイル）

例えば、次のファイルを置いたとします。

```
resources/
└── static/
    ├── index.html
    ├── css/
    │   └── style.css
    └── js/
        └── main.js
```

Spring Bootは、これらのファイルをブラウザに配信できます。

`index.html` にアクセスした場合、Spring BootはHTMLを返し、ブラウザがHTMLを読み込んで画面を表示します。

- HTML → 画面の構造
    
- CSS → デザイン
    
- JavaScript → ブラウザ上の動作
    

この段階では、Javaが毎回HTMLの中身を生成する必要はありません。

### java（サーバー側）

こちらはJavaで処理を行う場所です。

例えば、整備記録を登録するときに、

- 入力されたデータが正しいか確認する
    
- 登録処理を行う
    
- データベースに保存する
    
- 保存結果を返す
    

といった処理を行います。

### templates（動的HTML）

`templates` は、主にThymeleafなどのテンプレートエンジンを使うときに利用します。

Javaから取得したデータをHTMLに埋め込んで画面を生成する仕組みです。

今回はHTML・CSS・JavaScriptで画面を作る方針なので、最初はtemplatesを使わずstaticを中心に進めてOKです。

# 4. Javaのパッケージ構造

今後Javaのファイルが増えるため、最初から役割ごとに整理することが重要です。

MotoManagerでは、次の構造をおすすめします。

```

com.example.motomanager
│
├── MotoManagerApplication.java
│
├── controller/
│   └── MotorcycleController.java
│
├── service/
│   └── MotorcycleService.java
│
├── repository/
│   └── MotorcycleRepository.java
│
└── entity/
    └── Motorcycle.java
```

それぞれの役割を簡単に説明します。

## Controller

ユーザーからの要求を受け取る

ブラウザから送られてきたリクエストを受け取り、どの処理を実行するかを決めます。

例：バイク登録のリクエストを受け取る

## Service

アプリケーションの処理を行う

登録や更新などの処理ルールを実行します。

例：走行距離や入力内容を確認する

## Repository

データベースとの橋渡し

データの登録・取得・更新・削除などを行います。

例：登録されたバイク情報をMySQLに保存する

## Entity

保存するデータの構造を定義する

データベースに保存する情報がどのような項目で構成されるかを定義します。

例：バイク名・メーカー・年式・走行距離

## 5. バイク登録を例にした処理の流れ

例えば、ユーザーがMotoManagerでバイクを登録したときは、次のような流れになります。

① HTML / JavaScript

バイク登録フォームからデータ送信

② Controller

登録リクエストを受け取る

③ Service

登録に必要な処理を行う

④ Repository

データの保存を依頼する

⑤ Database

バイク情報を保存する

実際には、保存結果が逆の方向へ返っていき、最終的にブラウザへレスポンスが返されます。

このように役割を分けることで、例えば「登録処理に問題があるのか」「データベースに問題があるのか」を調べやすくなります。

# 6. Spring Bootを動かすための重要なファイル

## `MotoManagerApplication.java`

これはSpring Bootの起動入口となるクラスです。

```
package com.example.motomanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MotoManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MotoManagerApplication.class, args);
    }
}
```

### 何をしているのか？

|コード|役割|
|---|---|
|`@SpringBootApplication`|Spring Bootアプリケーションであることを示す|
|`main()`|Javaプログラムの実行開始地点|
|`SpringApplication.run()`|Spring Bootを起動する|

通常のJavaアプリと同じく `main()` が開始地点ですが、`SpringApplication.run()` によってWebサーバーなども起動します。

## `pom.xml`

これはMavenの設定ファイルです。

Spring Bootで使用するライブラリや、Javaのバージョンなどを管理します。

例えば、Spring Webを追加すると、Webアプリケーションを作るために必要なライブラリをMavenが取得してくれます。

つまり、ライブラリを自分で1つずつダウンロードして設定する必要がありません。

## `mvnw`

これはMaven Wrapperです。

```
./mvnw spring-boot:run
```

このコマンドを実行すると、Mavenを利用してSpring Bootアプリを起動できます。

`mvnw` をプロジェクトに含めることで、開発者ごとにMavenをインストールする手間を減らし、指定されたMavenバージョンを利用しやすくなります。

# 7. 今覚えておけばいい構造

現段階では、すべてを暗記する必要はありません。

まずは次の関係を理解しておけば十分です。

## MotoManagerの役割分担

HTML

画面の構造

何を表示するか

CSS

デザイン

どう見せるか

JavaScript

ブラウザの動作

画面上でどう動くか

Java

サーバー側の処理

何を処理するか

DB

データ保存

何を記録して残すか

## 8. これから学ぶ順番

今の段階でおすすめなのは、次の順番です。

1. Spring Bootの基本構造 
    
2. HTML・CSSで画面を作る
    
3. JavaScriptでボタンやフォームを動かす
    
4. ControllerとHTTP通信を理解する
    
5. Javaからデータを受け取る
    
6. MySQLと接続する
    
7. Service・Repository・Entityに分ける
    
8. バイク登録機能を完成させる
    
9. 整備記録機能を追加する