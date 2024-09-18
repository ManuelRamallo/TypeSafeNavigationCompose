package com.mramallo.typesafenavigationcompose.ui.navigation

import kotlinx.serialization.Serializable

@Serializable
object Home

@Serializable
data class Detail(val name: String, val age: Int?)