# MotoManager 開発記録

## プロジェクト概要

バイクの車両情報やメンテナンス履歴を管理するWebアプリケーション。

オイル交換、消耗品交換、修理などの整備記録を管理し、過去の整備内容や費用を確認できるようにする。

## 開発環境

- OS：macOS
- エディタ：VS Code
- 言語：Java
- フレームワーク：Spring Boot
- データベース：MySQL
- ビルドツール：Maven
- APIテスト：curl

## バックエンドのクラス構成

```text
com.example.motomanager/
├── MotoManagerApplication.java
├── controller/
│   ├── MotorcycleController.java
│   └── MaintenanceRecordController.java
├── service/
│   ├── MotorcycleService.java
│   └── MaintenanceRecordService.java
├── repository/
│   ├── MotorcycleRepository.java
│   └── MaintenanceRecordRepository.java
├── entity/
│   ├── Motorcycle.java
│   └── MaintenanceRecord.java
└── dto/
    └── MaintenanceRecordRequest.java
```

## 実装済みAPI

| Method | URL | 処理 |
|---|---|---|
| GET | /api/motorcycles | バイク全件取得 |
| POST | /api/motorcycles | バイク登録 |
| PUT | /api/motorcycles/{id} | バイク更新 |
| DELETE | /api/motorcycles/{id} | バイク削除 |
| GET | /api/maintenance-records | 整備記録全件取得 |
| POST | /api/maintenance-records | 整備記録登録 |
| PUT | /api/maintenance-records/{id} | 整備記録更新 |
| DELETE | /api/maintenance-records/{id} | 整備記録削除 |

## 開発進捗

### バックエンド基本機能

- [x] Spring Bootの環境構築
- [x] Mavenの設定
- [x] MySQLの環境構築
- [x] Spring BootとMySQLの接続
- [x] Motorcycle Entityの作成
- [x] Motorcycle Repositoryの作成
- [x] Motorcycle Serviceの作成
- [x] Motorcycle Controllerの作成
- [x] バイク情報のCRUD操作
- [x] MaintenanceRecord Entityの作成
- [x] MaintenanceRecord Repositoryの作成
- [x] MaintenanceRecord Serviceの作成
- [x] MaintenanceRecord Controllerの作成
- [x] 外部キーによる関連付け
- [x] Request DTOの作成
- [x] 整備記録のCRUD操作
- [x] curlによる基本動作確認

### フロントエンド

- [ ] HTMLによる画面作成
- [ ] CSSによるデザイン
- [ ] JavaScriptによるAPI通信
- [ ] バイク一覧の表示
- [ ] バイク登録フォーム
- [ ] バイク情報の編集・削除
- [ ] 整備記録の表示
- [ ] 整備記録の登録・編集・削除

### バックエンドの追加・改善機能

- [ ] IDを指定したデータ取得
- [ ] バイク別の整備記録取得
- [ ] バリデーション
- [ ] 例外処理の改善
- [ ] 適切なHTTP Status Codeの返却
- [ ] Response DTO
- [ ] 日付順のソート
- [ ] 整備記録の検索
- [ ] 整備費用の集計
- [ ] データベース接続情報の安全な管理
- [ ] JUnitによる自動テスト

## 開発日誌

### 2026-11-26

バックエンドの基本的なCRUD機能が完成した。

DTOを使用して整備記録の登録・更新リクエストを受け取れるようになった。

curlを使用して登録・取得・更新・削除を確認した。

整備記録を先に削除することで、外部キー制約に抵触せずバイク情報を削除できた。

### 現在の課題

基本的な機能は完成しているが、不正な入力や存在しないIDに対する適切なエラー処理などは未完成である。

現時点では学習用アプリケーションとしての基本機能が完成した段階であり、本番運用を想定した設計や安全性の確保は今後の課題とする。

### 次回の開発予定

フロントエンドの実装を開始する。

HTML・CSS・JavaScriptを使用し、fetch()によって既存のREST APIと通信する。


※AIに学習した内容をまとめてもらっています。

## 学習内容

- [[01_Spring Bootの基礎]]
- [[02_プロジェクト構成とMaven]]
- [[03_HTTPとREST API]]
- [[04_アプリケーションの階層構造]]
- [[05_MySQLとデータベース接続]]
- [[06_EntityとJPA]]
- [[07_Repository]]
- [[08_Service]]
- [[09_Controller]]
- [[10_依存性注入（DI）]]
- [[11_テーブル間の関連付け]]
- [[12_DTO]]
- [[13_CRUD処理の全体像]]
- [[14_curlによるAPIテスト]]

#MotoManager #個人開発 #開発日誌
