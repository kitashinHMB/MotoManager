# Controller

## Controllerとは

クライアントからHTTPリクエストを受け取る窓口。

リクエストに応じてServiceを呼び出し、処理結果をクライアントに返す。

## Controllerの基本構造

```java
@RestController
@RequestMapping("/api/motorcycles")
public class MotorcycleController {

    private final MotorcycleService
        motorcycleService;

    public MotorcycleController(
        MotorcycleService motorcycleService
    ) {
        this.motorcycleService =
            motorcycleService;
    }
}
```

## @RestController

REST APIを提供するControllerであることを示す。

戻り値のJavaオブジェクトは、通常JacksonによってJSON形式に変換される。

## @RequestMapping

Controllerが担当するURLの共通部分を指定する。

```java
@RequestMapping("/api/motorcycles")
```

## GET：全件取得

```java
@GetMapping
public List<Motorcycle> findAll() {
    return motorcycleService.findAll();
}
```

GET /api/motorcyclesへのリクエストを処理する。

## POST：登録

```java
@PostMapping
public Motorcycle save(
    @RequestBody Motorcycle motorcycle
) {
    return motorcycleService.save(motorcycle);
}
```

POST /api/motorcyclesへのリクエストを処理する。

## PUT：更新

```java
@PutMapping("/{id}")
public Motorcycle update(
    @PathVariable Long id,
    @RequestBody Motorcycle motorcycle
) {
    return motorcycleService.update(
        id, motorcycle
    );
}
```

PUT /api/motorcycles/1などのリクエストを処理する。

## DELETE：削除

```java
@DeleteMapping("/{id}")
public void delete(@PathVariable Long id) {
    motorcycleService.delete(id);
}
```

DELETE /api/motorcycles/1などのリクエストを処理する。

## @RequestBody

HTTPリクエストのBodyをJavaオブジェクトに変換する。

例えば以下のJSONを受け取る。

```json
{
    "name": "DragStar 250",
    "year": 2002
}
```

@RequestBody Motorcycle motorcycleによって、Motorcycleオブジェクトとして扱うことができる。

## @PathVariable

URLに含まれる値をメソッドの引数として取得する。

```text
/api/motorcycles/2
```

```java
@PathVariable Long id
```

この場合、idには2が入る。

## @RequestParam

URLのクエリパラメータを取得するアノテーション。

```text
/api/motorcycles?name=DragStar
```

```java
@RequestParam String name
```

※ MotoManagerの現時点では検索機能は未実装。

## Controllerの役割を整理する

ControllerはHTTP通信を担当し、業務処理はServiceに任せる。

Controllerにすべての処理を記述すると、コードが複雑になり保守しにくくなる。

## 関連ノート

- [[03_HTTPとREST API]]
- [[08_Service]]
- [[12_DTO]]

#Controller #RESTAPI #アノテーション
