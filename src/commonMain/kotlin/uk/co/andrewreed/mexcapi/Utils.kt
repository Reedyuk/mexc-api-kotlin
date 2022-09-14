package uk.co.andrewreed.mexcapi

import com.appmattus.crypto.Algorithm
import io.ktor.http.*
import io.ktor.utils.io.core.*

internal fun Map<String, String>.requestParamString(): String {
    var paramString = ""
    forEach {
        paramString += it.key + "=" + it.value.urlEncode() + "&"
    }
    return paramString.dropLast(1)
}

internal fun String.urlEncode(): String = Url(this).fullPath.drop(1).replace("\\+", "%20")

internal fun sign(secretKey: String, timestamp: String, params: Map<String, String>): String {
    val str: String = (params + mapOf("timestamp" to timestamp)).requestParamString()
    val hmac = Algorithm.SHA_256.createHmac(secretKey.toByteArray())
    hmac.update(str.toByteArray())
    val signed = hmac.digest()
    return signed.toHex()
}

internal fun ByteArray.toHex(): String =
    asUByteArray()
        .joinToString("") {
            it.toString(radix = 16).padStart(2, '0')
        }
