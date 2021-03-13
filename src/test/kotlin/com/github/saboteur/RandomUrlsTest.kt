package com.github.saboteur

import com.github.saboteur.Constants.VALID_URL_REGEX
import com.github.saboteur.data.InvalidUrls
import com.github.saboteur.data.ValidUrls
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

internal class RandomUrlsTest {

    private val regex = Regex(VALID_URL_REGEX)

    @ParameterizedTest
    @ArgumentsSource(ValidUrls::class)
    fun `valid urls should match regex pattern`(
        urls: Array<String>
    ) {
        urls.forEach { url ->
            print("URL: $url ")
            regex.matches(url) shouldBe true
            println("OK")
        }
    }

    @ParameterizedTest
    @ArgumentsSource(InvalidUrls::class)
    fun `invalid urls should not match regex pattern`(
        urls: Array<String>
    ) {
        urls.forEach { url ->
            print("URL: $url ")
            regex.matches(url) shouldBe false
            println("NOT OK")
        }
    }
}