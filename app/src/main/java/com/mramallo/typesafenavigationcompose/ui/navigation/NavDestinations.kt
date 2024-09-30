package com.mramallo.typesafenavigationcompose.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object HomeScreen

@Serializable
data class DetailScreen(val name: String, val age: Int?)