package com.github.saboteur.data

import com.github.saboteur.Constants.SHORTENED_URL_BEGINNING
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

internal class TransformUrlData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        val originalUrl = "https://test.com/shortenMePlease"
        val keyword = "sQz"
        val isShortened = false
        val shortenedUrl = SHORTENED_URL_BEGINNING + "sQz"

        return Stream.of(
            Arguments.of(
                originalUrl,
                keyword,
                isShortened,
                shortenedUrl
            )
        )
    }
}
