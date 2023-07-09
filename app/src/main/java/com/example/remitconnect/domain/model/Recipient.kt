package com.example.remitconnect.domain.model

data class Recipient(
    val country: String,
    val mobile_wallet: String,
    val name: String
) {
    fun doesMatchSearchQuery(query: String): Boolean {
        val matchingCombination = listOf(
            //FirstName LastName
            "${name.split(" ").first()} ${name.split(" ")[1]}",
            //FirstNameLastName
            "${name.split(" ").first()}${name.split(" ")[1]}",
            // with initials
            "${name.split(" ").first().first()} ${name.split(" ")[1].first()}",
        )

        return matchingCombination.any {
            it.contains(query, ignoreCase = true)
        }
    }
}
