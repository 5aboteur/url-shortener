package com.github.saboteur

import java.util.Scanner
import kotlin.random.Random

fun main() {

    val scanner = Scanner(System.`in`)
    val urlShortener = UrlShortener()

    while (true) {
        val inputParameters = getInputParameters(scanner)

        if (!inputParameters.isValid()) continue

        urlShortener.apply {
            url = inputParameters.url
            keyword =
                if (inputParameters.keyword.isNullOrEmpty())
                    generateRandomKeyword()
                else
                    inputParameters.keyword
            isShortened = inputParameters.isShortened ?: false
        }

        println(urlShortener.transform())
    }
}

private fun getInputParameters(scanner: Scanner): InputParameters {
    with(scanner) {
        print("URL: ")
        val url = nextLine()

        print("Is it already shortened? (y/n): ")
        val isShortened = when (nextLine()) {
            "y", "Y", "Yes", "1" -> {
                true
            }
            "n", "N", "No", "0" -> {
                false
            }
            else -> {
                false
            }
        }

        val keyword = when (isShortened) {
            true -> null
            false -> {
                print("KEYWORD: ")
                nextLine()
            }
        }

        return InputParameters(url, keyword, isShortened)
    }
}

private val charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')

private fun generateRandomKeyword(): String =
    (1..Constants.RANDOM_KEYWORD_LENGTH)
        .map {
            Random.nextInt(0, charPool.size)
        }
        .map(charPool::get)
        .joinToString("")
