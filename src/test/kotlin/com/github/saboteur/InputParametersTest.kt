package com.github.saboteur

import com.github.saboteur.data.InvalidUrlData
import com.github.saboteur.data.TooLongKeywordData
import com.github.saboteur.data.NullUrlData
import com.github.saboteur.data.ValidInputParametersData
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ArgumentsSource

internal class InputParametersTest {

    @Test
    fun `test fields`() {
        val inputParameters = InputParameters(
            url = "http://foo.bar",
            keyword = "random",
            isShortened = false
        )

        with(inputParameters) {
            url shouldBe "http://foo.bar"
            keyword shouldBe "random"
            isShortened shouldBe false
        }

    }

    @Nested
    inner class IsValid {

        @ParameterizedTest
        @ArgumentsSource(ValidInputParametersData::class)
        fun `returns true because all parameters are set`(inputParameters: InputParameters) {
            val result = inputParameters.isValid()
            result shouldBe true
        }

        @ParameterizedTest
        @ArgumentsSource(NullUrlData::class)
        fun `returns false because provided url is null`(inputParameters: InputParameters) {
            val result = inputParameters.isValid()
            result shouldBe false
        }

        @ParameterizedTest
        @ArgumentsSource(InvalidUrlData::class)
        fun `returns false because invalid url provided`(inputParameters: InputParameters) {
            val result = inputParameters.isValid()
            result shouldBe false
        }

        @ParameterizedTest
        @ArgumentsSource(TooLongKeywordData::class)
        fun `returns false because keyword length exceeds its limit`(inputParameters: InputParameters) {
            val result = inputParameters.isValid()
            result shouldBe false
        }
    }
}