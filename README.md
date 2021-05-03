# Empressia Message Library

## 目次

* [概要](#概要)
* [使い方](#使い方)
	* [ライブラリの設定](#ライブラリの設定)
	* [メッセージプロパティの配置場所](#メッセージプロパティの配置場所)
* [ライセンス](#ライセンス)
* [使用しているライブラリ](#使用しているライブラリ)

## 概要

Empressia製のメッセージ管理ライブラリ＆ツールであるEmpressia Messageの一部です。  
ライブラリとして、基本的なクラスを提供します。  

## 使い方

### ライブラリの設定

ライブラリを追加します。  
Gradleであれば、例えば、以下のようにします。  

```groovy
dependencies {
	implementation(group:"jp.empressia", name:"jp.empressia.message", version:"1.0.0");
}
```

バージョンは、適宜、調整してください。

このライブラリのクラス自体を、直接、使用することは想定されていません。  
GeneratorやGradle用プラグインを使用してクラスを生成して使用します。  
これらは、Empresisa Messageの別のサブプロジェクト？です。  

生成されたクラスの使い方については、Empressia Messageを参照してください。  

### メッセージプロパティの配置場所

読み込まれるメッセージプロパティは、リソースとして、以下の順で探索されます。  

1. message（meessage.propertiesなど）
2. messages（meessages.propertiesなど）

この動きは、DefaultMessageProviderによるもので、  
以下のシステムプロパティで上書きできます。  

jp.empressia.message.DefaultMessageProvider.BasePath

MessageProviderを実装し、ServiceLoaderに登録することで、  
これらの実装を変更できます。  

## ライセンス

いつも通りのライセンスです。  
zlibライセンス、MITライセンスでも利用できます。  

ただし、チーム（複数人）で使用する場合は、MITライセンスとしてください。  

## 使用しているライブラリ

特にありません。

## 注意

プロジェクトはVSCodeのJava拡張機能ではテストを実行できないようです（2021/05/01）。  
Gradleからは実行できます。  
