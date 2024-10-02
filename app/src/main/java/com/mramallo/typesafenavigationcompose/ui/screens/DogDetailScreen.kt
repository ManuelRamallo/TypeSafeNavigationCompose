package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.mramallo.typesafenavigationcompose.domain.entity.BreedSize
import com.mramallo.typesafenavigationcompose.domain.entity.Dog

@Composable
fun DogDetailScreen(
    dog: Dog,
    breedSize: BreedSize,
    onBackClick: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(text = "${dog.name} with the ID of ${dog.id} has the breed size $breedSize")
    }

}