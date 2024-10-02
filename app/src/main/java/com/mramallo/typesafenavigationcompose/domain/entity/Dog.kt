package com.mramallo.typesafenavigationcompose.domain.entity

import kotlinx.serialization.Serializable

@Serializable
data class Dog(
    val id: Int,
    val name: String
)

enum class BreedSize {
    SMALL,
    MEDIUM,
    LARGE
}
