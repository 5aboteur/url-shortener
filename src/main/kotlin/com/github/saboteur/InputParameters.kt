package com.github.saboteur

data class InputParameters(
    val url: String?,
    val keyword: String?,
    val isShortened: Boolean?
) {
    fun isValid() = when {
        url == null -> {
            println("Provided URL is null")
            false
        }
        !keyword.isNullOrEmpty() && keyword.length > Constants.KEYWORD_MAX_LENGTH -> {
            println("Keyword length [${keyword.length}] shouldn't exceed its limit [${Constants.KEYWORD_MAX_LENGTH}]")
            false
        }
        else -> {
            Regex(Constants.VALID_URL_REGEX).matches(url).also { isMatches ->
                if (!isMatches)
                    println("Provided string [$url] is not a valid URL")
            }
        }
    }
}
