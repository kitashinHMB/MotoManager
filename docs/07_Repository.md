# Repository

## Repositoryとは

データベースへのアクセスを担当するクラスやインターフェース。

Spring Data JPAを利用することで、基本的なSQLを自分で記述しなくてもデータベースを操作できる。

## Repositoryの定義

```java
public interface MotorcycleRepository
        extends JpaRepository<Motorcycle, Long> {
}
```

## JpaRepositoryとは

Spring Data JPAが提供するインターフェース。

基本的なCRUD操作に必要なメソッドが定義されている。

## ジェネリクスの意味

```java
JpaRepository<Motorcycle, Long>
```

Motorcycleは操作対象となるEntityの型。

Longは主キーの型。

## なぜインターフェースだけで動作するのか

Spring Data JPAが起動時にRepositoryの実装を生成するため、自分で基本的な処理を実装する必要がない。

## 主なメソッド

| メソッド | 処理 |
|---|---|
| save(entity) | データの保存 |
| findAll() | 全件取得 |
| findById(id) | ID指定で取得 |
| deleteById(id) | ID指定で削除 |
| existsById(id) | 存在確認 |
| count() | 件数取得 |
| deleteAll() | 全件削除 |

## save()

```java
motorcycleRepository.save(motorcycle);
```

Entityの状態に応じて、新規登録または既存データの更新を行う。

## findAll()

```java
List<Motorcycle> motorcycles =
    motorcycleRepository.findAll();
```

登録されているバイクをList形式で取得する。

## findById()

```java
motorcycleRepository.findById(id);
```

指定されたIDのデータを取得する。

戻り値はOptional型である。

## Optionalとは

値が存在する場合と存在しない場合を扱うためのクラス。

```java
Motorcycle motorcycle =
    motorcycleRepository.findById(id)
        .orElseThrow(() ->
            new RuntimeException(
                "バイクが見つかりません"
            )
        );
```

データが存在すればMotorcycleを取得する。

存在しなければ例外を発生させる。

## RepositoryとSQLの対応イメージ

| Repository | SQL |
|---|---|
| save() | INSERT / UPDATE |
| findAll() | SELECT |
| findById() | SELECT WHERE |
| deleteById() | DELETE |
| count() | SELECT COUNT |

実際に発行されるSQLや発行のタイミングは、Entityの状態やトランザクションなどによって異なる。

## 関連ノート

- [[06_EntityとJPA]]
- [[08_Service]]
- [[10_依存性注入（DI）]]

#Repository #SpringDataJPA #Optional
