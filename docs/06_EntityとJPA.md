# EntityとJPA

## ORMとは

Object Relational Mappingの略。

Javaのオブジェクトとリレーショナルデータベースのデータを対応付ける仕組み。

SQLを直接記述する量を減らし、Javaオブジェクトを使用してデータベースを操作できる。

## JPAとは

Java Persistence API（現在のJakarta Persistence）の略。

JavaでORMを利用するための仕様。

JPA自体は仕様であり、実際の処理を行う実装が必要である。

## Hibernateとは

JPAの仕様を実装したORMフレームワーク。

Spring Bootでは一般的にHibernateが使用される。

## Spring Data JPAとは

JPAを利用したデータベース操作を簡単にするためのSpringの仕組み。

```text
Javaアプリケーション
        ↓
Spring Data JPA
        ↓
JPAのAPI
        ↓
Hibernate（JPAの実装）
        ↓
JDBC
        ↓
MySQL
```

## Entityとは

データベースのテーブルに対応するJavaクラス。

MotoManagerのMotorcycleクラスを例にする。

```java
@Entity
public class Motorcycle {

    @Id
    @GeneratedValue(
        strategy = GenerationType.IDENTITY
    )
    private Long id;

    private String name;
    private String manufacturer;
    private int year;
    private int mileage;

    public Motorcycle() {
    }
}
```

※ Getter・Setter・importは省略。

## 主なアノテーション

### @Entity

JPAが管理するEntityクラスであることを示す。

### @Id

主キーとなるフィールドを指定する。

### @GeneratedValue

主キーの値を自動生成するための設定。

### GenerationType.IDENTITY

データベース側の自動採番機能を使用する。

MySQLではAUTO_INCREMENTが利用される。

## Entityとテーブルの対応

| Javaのフィールド | データベースのカラム例 |
|---|---|
| Long id | BIGINT |
| String name | VARCHAR |
| String manufacturer | VARCHAR |
| int year | INT |
| int mileage | INT |

## GetterとSetter

privateフィールドの値を取得・変更するためのメソッド。

```java
public String getName() {
    return name;
}

public void setName(String name) {
    this.name = name;
}
```

getName()は値を取得する。

setName()は値を変更する。

this.nameはクラスのフィールドを表し、右側のnameは引数を表す。

## Longとlongの違い

longは基本データ型であり、nullを保持できない。

Longはラッパークラスであり、nullを保持できる。

EntityのIDをLongにすることで、まだIDが割り当てられていない状態をnullで表現できる。

## デフォルトコンストラクタ

```java
public Motorcycle() {
}
```

JPAがEntityのインスタンスを生成するために、引数なしのコンストラクタが必要となる。

## 関連ノート

- [[05_MySQLとデータベース接続]]
- [[07_Repository]]
- [[11_テーブル間の関連付け]]

#Entity #JPA #Hibernate #ORM
