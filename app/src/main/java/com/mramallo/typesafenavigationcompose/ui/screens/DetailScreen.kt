package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mramallo.typesafenavigationcompose.R
import com.mramallo.typesafenavigationcompose.ui.theme.Purple40
import com.mramallo.typesafenavigationcompose.ui.theme.Purple80
import com.mramallo.typesafenavigationcompose.ui.theme.Typography

@Composable
fun DetailScreen(
    name: String,
    age: Int?,
    onBackClick: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Purple80),
    ) {
        Box(
            modifier = Modifier
                .padding(top = 150.dp)
                .fillMaxSize()
                .clip(
                    RoundedCornerShape(
                        bottomStart = 20.dp,
                        bottomEnd = 20.dp,
                        topStart = 20.dp,
                        topEnd = 20.dp
                    )
                )
                .background(
                    brush = Brush.verticalGradient(
                        colors = listOf(Purple40, Purple80),
                        startY = 100f
                    )
                )
        )
        Column {
            Box(
                modifier = Modifier
                    .padding(top = 110.dp, start = 32.dp),
                contentAlignment = Alignment.TopStart
            ) {
                Button(
                    onClick = { onBackClick.invoke() },
                    modifier = Modifier
                        .size(80.dp)
                        .clip(CircleShape),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFB384EB)
                    )
                ) {
                    Icon(
                        imageVector = Icons.Outlined.KeyboardArrowLeft,
                        contentDescription = "",
                        modifier = Modifier.size(100.dp)
                    )
                }
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .safeContentPadding()
                .padding(24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.weight(0.8f))
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(R.drawable.man_svgrepo_com).build(),
                contentDescription = "ic_security",
                modifier = Modifier
                    .size(250.dp)
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Text(
                text = "$name",
                color = Color.White,
                style = Typography.titleLarge,
                modifier = Modifier.fillMaxWidth(),
                textAlign = TextAlign.Center,
                lineHeight = 1.5.em
            )
            Spacer(modifier = Modifier.weight(0.1f))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                Text(
                    text = "$age years old",
                    color = Color.White,
                    style = Typography.bodyLarge,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF707070).copy(0.2f))
                        .padding(12.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 1.5.em
                )
                Text(
                    text = "Android Developer",
                    color = Color.White,
                    style = Typography.bodyLarge,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF707070).copy(0.2f))
                        .padding(12.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 1.5.em
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 24.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Team Leader",
                    color = Color.White,
                    style = Typography.bodyLarge,
                    modifier = Modifier
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xFF707070).copy(0.2f))
                        .padding(12.dp),
                    textAlign = TextAlign.Center,
                    lineHeight = 1.5.em
                )
            }
            Spacer(modifier = Modifier.weight(0.3f))
        }
    }

}