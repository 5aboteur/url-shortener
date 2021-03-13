package com.github.saboteur

import com.github.saboteur.Constants.SHORTENED_URL_BEGINNING

class UrlShortener(
    var url: String? = null,
    var keyword: String? = null,
    var isShortened: Boolean = false
) {

    private val originalHashToUrlMap = mutableMapOf<Int, String>()
    private val shortenedHashToOriginalHashMap = mutableMapOf<Int, Int>()

    fun transform(): String = if (!isShortened) shorten() else retrieveOriginal()

    private fun shorten(): String {
        val origHash = url.hashCode()

        originalHashToUrlMap[origHash] = requireNotNull(url)

        val sb = StringBuilder()

        sb.append(SHORTENED_URL_BEGINNING).append(keyword)

        val shortenedUrl = sb.toString()
        val shHash = keyword.hashCode()

        shortenedHashToOriginalHashMap[shHash] = origHash

        return shortenedUrl
    }

    private fun retrieveOriginal(): String {
        val kw = requireNotNull(url).substringAfter(SHORTENED_URL_BEGINNING)
        val kwHash = kw.hashCode()

        val origHash = shortenedHashToOriginalHashMap[kwHash]

        return originalHashToUrlMap[origHash].orEmpty()
    }
}
