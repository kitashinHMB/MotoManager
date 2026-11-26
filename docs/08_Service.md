# Service

## Serviceとは

アプリケーションの業務処理を担当する階層。

Controllerから処理の依頼を受け、必要に応じてRepositoryを使用する。

## ビジネスロジックとは

アプリケーションの目的を実現するための処理やルール。

MotoManagerでは以下のような処理が該当する。

- バイク情報の登録
- 更新対象の存在確認
- 整備記録とバイクの関連付け
- 削除対象の確認

## Serviceの基本構造

```java
@Service
public class MotorcycleService {

    private final MotorcycleRepository
        motorcycleRepository;

    public MotorcycleService(
        MotorcycleRepository motorcycleRepository
    ) {
        this.motorcycleRepository =
            motorcycleRepository;
    }
}
```

## @Service

SpringにServiceクラスであることを伝えるアノテーション。

Springの管理対象となる。

## 登録処理

```java
public Motorcycle save(Motorcycle motorcycle) {
    return motorcycleRepository.save(motorcycle);
}
```

受け取ったMotorcycleをRepositoryに渡して保存する。

## 全件取得

```java
public List<Motorcycle> findAll() {
    return motorcycleRepository.findAll();
}
```

Repositoryから取得したデータを呼び出し元に返す。

## 更新処理

```java
public Motorcycle update(
    Long id, Motorcycle motorcycle
) {
    Motorcycle existing =
        motorcycleRepository.findById(id)
            .orElseThrow(() ->
                new RuntimeException(
                    "バイクが見つかりません"
                )
            );

    existing.setName(motorcycle.getName());
    existing.setManufacturer(
        motorcycle.getManufacturer()
    );
    existing.setYear(motorcycle.getYear());
    existing.setMileage(motorcycle.getMileage());

    return motorcycleRepository.save(existing);
}
```

### 更新処理の流れ

1. IDを使用して既存データを取得する。
2. 存在しない場合は例外を発生させる。
3. 受け取ったデータで既存データを変更する。
4. Repositoryを使用して保存する。

## 削除処理

```java
public void delete(Long id) {

    if (!motorcycleRepository.existsById(id)) {
        throw new RuntimeException(
            "バイクが見つかりません"
        );
    }

    motorcycleRepository.deleteById(id);
}
```

## ServiceとRepositoryの違い

Repositoryはデータベースを操作する。

Serviceはどのような条件や順序でデータベースを操作するかを決める。

## 関連ノート

- [[07_Repository]]
- [[09_Controller]]
- [[10_依存性注入（DI）]]
- [[13_CRUD処理の全体像]]

#Service #ビジネスロジック
