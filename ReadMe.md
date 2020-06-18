一旦すぐに確認できるように作成。  
今後ちゃんとした計測を行う場合は別途設計する

# Lambdaベンチマーク測定用
## 対象言語
- java
- kotlin
- kotlin js

## 目的
メインで使用する言語を決めるための一つの材料としてLambdaでのパフォーマンス計測を行う。

## 観点
- スタートまでの時間を計測
- 計算処理の実行時間を計測

# メモ: ビルド&デプロイコマンド
1. rootディレクトリでビルド
2. 下記コマンドでデプロイ
```cmd
sls deploy --stage [stage名] --aws-profile [profile名]
```
例)
```cmd
sls deploy --stage production --aws-profile hoge
```

# 削除コマンド
```cmd
sls remove --stage [stage名] --aws-profile [profile名]
```
例)
```cmd
sls remove --stage production --aws-profile hoge
```