package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mramallo.typesafenavigationcompose.R
import com.mramallo.typesafenavigationcompose.ui.theme.Purple40
import com.mramallo.typesafenavigationcompose.ui.theme.Purple80
import com.mramallo.typesafenavigationcompose.ui.theme.Typography

@Composable
fun HomeScreen(
    onDetailClick: (String, Int) -> Unit,
    onListClick: () -> Unit
) {

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple40)
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height((LocalConfiguration.current.screenHeightDp * 0.9f).dp)
                .clip(
                    RoundedCornerShape(
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp
                    )
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Purple40, Purple80),
                        startY = 100f
                    )
                )
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(0.3f))
            Text(
                text = "Type-Safe   Navigation",
                color = Color.White,
                style = Typography.titleLarge,
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(0.4f),
                textAlign = TextAlign.Center,
                lineHeight = 1.5.em
            )
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.code_mobile_svgrepo_com).build(),
                contentDescription = "ic_security",
            )
            Box(
                modifier = Modifier.weight(.4f),
                contentAlignment = Alignment.Center
            ) {
                Button(
                    onClick = { onDetailClick.invoke("Manuel Ramallo", 28) },
                    modifier = Modifier
                        .size(100.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB384EB)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        contentDescription = "",
                        modifier = Modifier.size(50.dp)
                    )
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.End
            ) {
                Text(
                    text = "Go to List",
                    color = Color.White,
                    style = Typography.bodyLarge,
                    modifier = Modifier
                        .clickable {
                            onListClick.invoke()
                        }
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFFFFFF).copy(0.2f))
                        .padding(12.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 1.5.em
                )
            }

        }
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen(
        onDetailClick = { name, age -> /* TODO */ },
        onListClick = { /* TODO */ }
    )
}