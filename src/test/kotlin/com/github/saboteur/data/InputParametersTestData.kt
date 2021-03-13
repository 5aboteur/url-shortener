package com.github.saboteur.data

import com.github.saboteur.Constants.KEYWORD_MAX_LENGTH
import com.github.saboteur.InputParameters
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.ArgumentsProvider
import java.util.stream.Stream

internal class ValidInputParametersData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        val inputParameters = InputParameters(
            url = "https://test.com/shortenMePlease",
            keyword = "sQz",
            isShortened = false
        )

        return Stream.of(
            Arguments.of(inputParameters)
        )
    }
}

internal class NullUrlData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        val inputParameters = InputParameters(
            url = null,
            keyword = "sQz",
            isShortened = false
        )

        return Stream.of(
            Arguments.of(inputParameters)
        )
    }
}

internal class InvalidUrlData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        val inputParameters = InputParameters(
            url = "h#tp://test.com/",
            keyword = "sQz",
            isShortened = false
        )

        return Stream.of(
            Arguments.of(inputParameters)
        )
    }
}

internal class TooLongKeywordData : ArgumentsProvider {
    override fun provideArguments(context: ExtensionContext?): Stream<out Arguments> {
        val inputParameters = InputParameters(
            url = "https://test.com/shortenMePlease",
            keyword = "a".repeat(KEYWORD_MAX_LENGTH + 1),
            isShortened = false
        )

        return Stream.of(
            Arguments.of(inputParameters)
        )
    }
}