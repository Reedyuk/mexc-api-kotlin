# mexc-api-kotlin

[![Kotlin](https://img.shields.io/badge/kotlin-1.7.10-blue.svg)](http://kotlinlang.org)
![badge][badge-android]
![badge][badge-jvm]
![badge][badge-native]

[//]: # (![badge][badge-js])

A Kotlin Multiplatform Library for using the Mexc Api

## Running
The library works on the following platforms: `Android`, `iOS`, `JavaScript`, `JVM`.

## Usage

First register with Mexc for an api access key and secret key

https://www.mexc.com/user/openapi

Then create an instance of the client

```kotlin
val client = MexcClient("accessKey", "secretKey")
```

To access the different api endpoints, they are grouped into three categories as per the mexc api.
https://mxcdevelop.github.io/APIDoc/

Market Data
```kotlin
client.marketDataClient.trades("LUNCUSDT")
```

Spot Trades
```kotlin
client.spotTradeClient.allOrders("LUNCUSDT")
```

ETF
```kotlin
client.etfClient.info()
```


[badge-jvm]: http://img.shields.io/badge/platform-jvm-brightgreen.svg?style=flat
[badge-android]: http://img.shields.io/badge/platform-android-brightgreen.svg?style=flat
[badge-native]: http://img.shields.io/badge/platform-native-lightgrey.svg?style=flat

[//]: # ([badge-js]: http://img.shields.io/badge/platform-js-yellow.svg?style=flat)
