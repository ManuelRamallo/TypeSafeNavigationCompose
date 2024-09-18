package com.mramallo.typesafenavigationcompose.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.mramallo.typesafenavigationcompose.R
import com.mramallo.typesafenavigationcompose.ui.theme.Purple40
import com.mramallo.typesafenavigationcompose.ui.theme.Purple80
import com.mramallo.typesafenavigationcompose.ui.theme.Typography

@Composable
fun HomeScreen(
    onDetailClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    colors = listOf(Purple40, Purple80),
                    startY = 100f
                )
            )
            .safeContentPadding()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Spacer(modifier = Modifier.height(48.dp))
        Text(
            text = "Type-Safe Navigation",
            color = Color.White,
            style = Typography.titleLarge,
            modifier = Modifier
                .fillMaxWidth(),
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(200.dp))
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(R.drawable.ic_security).build(),
            modifier = Modifier.size(300.dp),
            contentDescription = "ic_security",
        )

    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen {

    }
}