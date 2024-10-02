package com.mramallo.typesafenavigationcompose.ui.navigation

import com.mramallo.typesafenavigationcompose.domain.entity.BreedSize
import com.mramallo.typesafenavigationcompose.domain.entity.Dog
import kotlinx.serialization.Serializable

@Serializable
object HomeRoute

@Serializable
data class DetailRoute(val name: String, val age: Int?)

@Serializable
object DogListRoute

@Serializable
data class DogDetailRoute(
    val dog: Dog,
    val breedSize: BreedSize
)