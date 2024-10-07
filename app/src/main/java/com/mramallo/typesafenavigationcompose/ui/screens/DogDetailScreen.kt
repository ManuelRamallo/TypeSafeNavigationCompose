package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mramallo.typesafenavigationcompose.R
import com.mramallo.typesafenavigationcompose.domain.entity.BreedSize
import com.mramallo.typesafenavigationcompose.domain.entity.Dog
import com.mramallo.typesafenavigationcompose.ui.theme.Pink60
import com.mramallo.typesafenavigationcompose.ui.theme.Purple40
import com.mramallo.typesafenavigationcompose.ui.theme.Typography

@Composable
fun DogDetailScreen(
    dog: Dog,
    breedSize: BreedSize,
    onBackClick: () -> Unit
) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            modifier = Modifier
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Pink60, Purple40),
                        startY = 100f
                    )
                )
                .padding(vertical = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.size(80.dp))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.dog_breed_svgrepo_com).build(),
                contentDescription = "ic_security",
                modifier = Modifier
                    .size(250.dp)
                    .weight(1f)
            )

            Text(
                text = "The selected dog is ${dog.name.uppercase()}, and it's breed is of ${breedSize.name.uppercase()} type",
                style = Typography.headlineLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .weight(.8f),
                textAlign = TextAlign.Center,
                color = Color.White
            )
        }

        IconButton(
            onClick = { onBackClick() },
            modifier = Modifier
                .padding(horizontal = 20.dp, vertical = 60.dp)
                .size(60.dp),
            colors = IconButtonDefaults.iconButtonColors(
                containerColor = Color(0xFFB384EB)
            )
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(R.drawable.left_arrow_svgrepo_com).build(),
                    colorFilter = ColorFilter.tint(Color.White),
                    contentDescription = "left_arrow",
                    modifier = Modifier.size(24.dp)
                )
            }
        }
    }
}