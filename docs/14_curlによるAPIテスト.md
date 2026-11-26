# curlによるAPIテスト

## curlとは

ターミナルからHTTPリクエストなどを送信できるコマンドラインツール。

フロントエンドが完成していなくても、バックエンドの動作を確認できる。

## 主なオプション

| オプション | 意味 |
|---|---|
| -X | HTTPメソッドの指定 |
| -H | HTTP Headerの指定 |
| -d | Request Bodyの指定 |
| -i | Response Headerも表示 |
| -v | 通信の詳細を表示 |
| -s | 進捗表示などを抑制 |

## バイクの登録

```bash
curl -i -X POST \
http://localhost:8080/api/motorcycles \
-H "Content-Type: application/json" \
-d '{
  "name": "DragStar 250",
  "manufacturer": "YAMAHA",
  "year": 2002,
  "mileage": 55000
}'
```

## バイクの全件取得

```bash
curl -i http://localhost:8080/api/motorcycles
```

HTTPメソッドを指定しない場合、通常はGETになる。

## バイクの更新

```bash
curl -i -X PUT \
http://localhost:8080/api/motorcycles/2 \
-H "Content-Type: application/json" \
-d '{
  "name": "DragStar 250",
  "manufacturer": "YAMAHA",
  "year": 2002,
  "mileage": 55100
}'
```

## 整備記録の登録

```bash
curl -i -X POST \
http://localhost:8080/api/maintenance-records \
-H "Content-Type: application/json" \
-d '{
  "motorcycleId": 2,
  "maintenanceDate": "2026-11-26",
  "maintenanceName": "エンジンオイル交換",
  "mileage": 55100,
  "cost": 3000,
  "memo": "定期交換"
}'
```

## 整備記録の全件取得

```bash
curl -i \
http://localhost:8080/api/maintenance-records
```

## 整備記録の更新

```bash
curl -i -X PUT \
http://localhost:8080/api/maintenance-records/1 \
-H "Content-Type: application/json" \
-d '{
  "motorcycleId": 2,
  "maintenanceDate": "2026-11-26",
  "maintenanceName": "エンジンオイル・フィルター交換",
  "mileage": 55100,
  "cost": 5000,
  "memo": "オイルフィルターも同時交換"
}'
```

## 整備記録の削除

```bash
curl -i -X DELETE \
http://localhost:8080/api/maintenance-records/1
```

## バイクの削除

```bash
curl -i -X DELETE \
http://localhost:8080/api/motorcycles/2
```

外部キー制約があるため、整備記録を先に削除する。

各コマンドのIDは例であり、実際に登録されているIDに変更すること。

## レスポンスの確認

```text
HTTP/1.1 200
Content-Type: application/json
```

200は処理が成功したことを示す。

JSONの内容も確認し、登録・更新された値が正しいことを検証する。

## データが空になったことの確認

```bash
curl http://localhost:8080/api/motorcycles

curl http://localhost:8080/api/maintenance-records
```

両方とも以下が返れば全件削除されている。

```json
[]
```

## curlによる削除とTRUNCATEの違い

curlによるDELETE APIは、バックエンドの処理を通してデータを削除する。

TRUNCATEはMySQLのテーブルを直接初期化する。

DELETE APIでは通常、自動採番されるIDはリセットされない。

## 関連ノート

- [[03_HTTPとREST API]]
- [[05_MySQLとデータベース接続]]
- [[13_CRUD処理の全体像]]

#curl #API #テスト
