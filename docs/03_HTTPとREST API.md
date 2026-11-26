# HTTPとREST API

## HTTPとは

クライアントとサーバーが通信するためのプロトコル。

クライアントがRequestを送り、サーバーがResponseを返す。

```text
Client
  ↓ HTTP Request
Server
  ↓ HTTP Response
Client
```

## APIとは

Application Programming Interfaceの略。

ソフトウェア同士が機能やデータを利用するための窓口。

## REST APIとは

HTTPなどを利用し、リソースに対する操作を行うAPIの設計方式。

MotoManagerではバイク情報や整備記録をリソースとして扱う。

## HTTPメソッドとCRUD

CRUDとは、データに対する基本的な4つの操作である。

| CRUD | HTTPメソッドの例 | 意味 |
|---|---|---|
| Create | POST | 登録 |
| Read | GET | 取得 |
| Update | PUT | 更新 |
| Delete | DELETE | 削除 |

## エンドポイント

APIにアクセスするための具体的なURL。

MotoManagerのバイク管理APIは以下の通り。

| メソッド | エンドポイント | 処理 |
|---|---|---|
| GET | /api/motorcycles | 全件取得 |
| POST | /api/motorcycles | 登録 |
| PUT | /api/motorcycles/{id} | 更新 |
| DELETE | /api/motorcycles/{id} | 削除 |

## JSONとは

JavaScript Object Notationの略。

システム間でデータをやり取りするためのデータ形式。

```json
{
    "name": "DragStar 250",
    "manufacturer": "YAMAHA",
    "year": 2002,
    "mileage": 55000
}
```

## HTTP Requestの構成

- Method：操作の種類
- URL：アクセス先
- Header：通信に関する追加情報
- Body：送信するデータ

JSONを送信するときは、通常以下のHeaderを指定する。

```text
Content-Type: application/json
```

## HTTP Status Code

サーバーが処理結果を伝えるための番号。

| コード | 意味 |
|---|---|
| 200 OK | 処理成功 |
| 201 Created | リソースの作成成功 |
| 204 No Content | 処理成功・Bodyなし |
| 400 Bad Request | 不正なリクエスト |
| 404 Not Found | 対象が存在しない |
| 405 Method Not Allowed | 許可されていないメソッド |
| 500 Internal Server Error | サーバー内部のエラー |

## 関連ノート

- [[09_Controller]]
- [[12_DTO]]
- [[14_curlによるAPIテスト]]

#HTTP #RESTAPI #JSON #CRUD
