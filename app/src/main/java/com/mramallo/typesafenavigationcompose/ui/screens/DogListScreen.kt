package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
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
fun DogListScreen(
    onDogClick: (Dog, BreedSize) -> Unit,
    onBackClick: () -> Unit
) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Purple40, Pink60),
                    startY = 100f
                )
            )
            .padding(vertical = 40.dp)
    ) {
        item {
            IconButton(
                onClick = { onBackClick() },
                modifier = Modifier
                    .padding(20.dp)
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
        items(SAMPLE_DATA_DOGS.keys.toList()) { dog ->
            Column {
                Row(
                    modifier = Modifier.fillMaxSize(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        text = dog.toString(),
                        color = Color.White,
                        style = Typography.bodyMedium,
                        modifier = Modifier
                            .fillMaxWidth()
                            .clickable {
                                onDogClick(dog, SAMPLE_DATA_DOGS[dog]!!)
                            }
                            .padding(16.dp)
                            .weight(1f)
                    )
                    AsyncImage(
                        model = ImageRequest.Builder(LocalContext.current)
                            .data(R.drawable.right_arrow_svgrepo_com).build(),
                        contentDescription = "left_arrow",
                        colorFilter = ColorFilter.tint(Color.White),
                        modifier = Modifier
                            .size(16.dp)
                            .weight(0.2f)
                    )
                }
                Divider(
                    modifier = Modifier.padding(horizontal = 16.dp)
                )
            }

        }
    }

}


val SAMPLE_DATA_DOGS = mapOf(
    Dog(1, "Golden Retriever") to BreedSize.LARGE,
    Dog(2, "Labrador Retriever") to BreedSize.LARGE,
    Dog(3, "German Shepherd") to BreedSize.LARGE,
    Dog(4, "Poodle") to BreedSize.MEDIUM,
    Dog(5, "Bulldog") to BreedSize.MEDIUM,
    Dog(6, "Rottweiler") to BreedSize.LARGE,
    Dog(7, "Beagle") to BreedSize.SMALL,
    Dog(8, "Dachshund") to BreedSize.SMALL,
    Dog(9, "Boxer") to BreedSize.LARGE,
    Dog(10, "Yorkshire Terrier") to BreedSize.SMALL,
    Dog(11, "Siberian Husky") to BreedSize.LARGE,
    Dog(12, "Australian Shepherd") to BreedSize.MEDIUM,
    Dog(13, "Doberman Pinscher") to BreedSize.LARGE,
    Dog(14, "Bernese Mountain Dog") to BreedSize.LARGE,
    Dog(15, "French Bulldog") to BreedSize.SMALL,
    Dog(16, "Golden Doodle") to BreedSize.MEDIUM,
    Dog(17, "Pomeranian") to BreedSize.SMALL,
    Dog(18, "Shih Tzu") to BreedSize.SMALL,
    Dog(19, "Great Dane") to BreedSize.LARGE,
    Dog(20, "Border Collie") to BreedSize.MEDIUM,
)