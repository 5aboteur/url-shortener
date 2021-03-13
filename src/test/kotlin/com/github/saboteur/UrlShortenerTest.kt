package com.github.saboteur

import com.github.saboteur.data.TransformUrlData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class UrlShortenerTest {

    val urlShortener = UrlShortener()

    @Nested
    inner class Transform {

        @ParameterizedTest
        @ArgumentsSource(TransformUrlData::class)
        fun `successfully shortens provided url`(
            originalUrl: String,
            keyword: String,
            isShortened: Boolean,
            shortenedUrl: String
        ) {
            urlShortener.apply {
                this.url = originalUrl
                this.keyword = keyword
                this.isShortened = false
            }

            val result = urlShortener.transform()

            result shouldBe shortenedUrl
        }

        @ParameterizedTest
        @ArgumentsSource(TransformUrlData::class)
        fun `successfully retrieves original url`(
            originalUrl: String,
            keyword: String,
            isShortened: Boolean,
            shortenedUrl: String
        ) {
            urlShortener.apply {
                this.url = originalUrl
                this.keyword = keyword
                this.isShortened = false
            }

            var result = urlShortener.transform()

            result shouldBe shortenedUrl

            urlShortener.apply {
                this.url = result
                this.keyword = null
                this.isShortened = true
            }

            result = urlShortener.transform()

            result shouldBe originalUrl
        }
    }
}