package com.github.saboteur.data

import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

inline fun <reified T : Any> arguments(vararg args: T): ArgumentsProvider =
    ArgumentsProvider {
        Stream.of(*args).map { Arguments.of(it) }
    }

internal class ValidUrls : ArgumentsProvider by arguments(
    listOf(
        "http://test.com/shortenMePlease",
        "ftp://test.com/shortenMePlease",
        "file://test.com/shortenMePlease",
        "https://test.com/shortenMePlease",
        "https://test.com/shortenMePlease/",
        "https://test.com/shorten_Me_Please",
        "https://test.com/shortenMePlease/ifYoCan",
        "https://test.com/shortenMePlease/ifYoCan/?p=1488",
        "https://pwn.ed/1337",
        "https://username:password@test.com:8080",
        "https://username:password@test.com:8080/",
        "https://username@test.com",
        "https://username@test.com/",
        "https://username@test.com:8080",
        "https://username@test.com:8080/",
        "https://username:password@test.com",
        "https://username:password@test.com/",
        "https://1.3.3.7/",
        "https://1.3.3.7/8080",
        "https://1337.net",
        "https://1337-leet.com",
        "https://te_st.com.com/",
    ).toTypedArray()
)

internal class InvalidUrls : ArgumentsProvider by arguments(
    listOf(
        "",
        " ",
        "http://",
        "ftp://",
        "file://",
        "https://",
        "https://.",
        "https://..",
        "https://?",
        "https:// spaces are not allowed",
        "//",
        "//a",
        "///",
        "test.com",
        "lol://1337",
        "http:// test.com",
    ).toTypedArray()
)
