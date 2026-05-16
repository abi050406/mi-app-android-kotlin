package com.example.curso

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import kotlinx.coroutines.launch

@Composable
fun MainView() {

    var devices by remember {
        mutableStateOf<List<Device>>(emptyList())
    }

    val scope = rememberCoroutineScope()

    LaunchedEffect(Unit) {

        scope.launch {

            try {

                devices =
                    RetrofitInstance.api.getAllDevices()

            } catch (e: Exception) {

                e.printStackTrace()

            }

        }

    }

    Column {

        Text(
            text = "Comprar",
            modifier = Modifier.fillMaxWidth(),
            textAlign = TextAlign.Center
        )

        LazyColumn {

            items(devices) { device ->

                DeviceItemView(
                    device = device
                )

            }

        }

    }

}