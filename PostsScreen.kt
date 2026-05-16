package com.miapp

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun PantallaPostsConLoading() {
    var isLoading by remember { mutableStateOf(true) }
    var posts by remember { mutableStateOf<List<Post>>(emptyList()) }
    var error by remember { mutableStateOf<String?>(null) }

    // Cargar datos al iniciar la pantalla
    LaunchedEffect(Unit) {
        try {
            posts = RetrofitClient.api.obtenerPosts()
        } catch (e: Exception) {
            error = "Error al cargar los posts: ${e.message}"
        } finally {
            isLoading = false
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Barra de titulo
        Surface(
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = "Mi App Android",
                style = MaterialTheme.typography.titleLarge,
                color = MaterialTheme.colorScheme.onPrimary,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 14.dp),
                fontWeight = FontWeight.Bold
            )
        }

        // Contenido principal
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            when {
                isLoading -> {
                    // ProgressBar mientras carga
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {
                        CircularProgressIndicator(
                            color = MaterialTheme.colorScheme.primary
                        )
                        Spacer(modifier = Modifier.height(12.dp))
                        Text(
                            text = "Cargando posts...",
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                }

                error != null -> {
                    // Mensaje de error
                    Text(
                        text = error!!,
                        color = MaterialTheme.colorScheme.error,
                        modifier = Modifier.padding(16.dp)
                    )
                }

                else -> {
                    // Lista de posts con LazyColumn
                    ListaPosts(posts = posts)
                }
            }
        }
    }
}

@Composable
fun ListaPosts(posts: List<Post>) {
    LazyColumn(
        modifier = Modifier.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(posts) { post ->
            TarjetaPost(post = post)
        }
    }
}

@Composable
fun TarjetaPost(post: Post) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surface
        )
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            // Numero de post
            Text(
                text = "Post #${post.id}",
                style = MaterialTheme.typography.labelMedium,
                color = MaterialTheme.colorScheme.primary
            )
            Spacer(modifier = Modifier.height(4.dp))

            // Titulo del post
            Text(
                text = post.title.replaceFirstChar { it.uppercase() },
                style = MaterialTheme.typography.titleSmall,
                fontWeight = FontWeight.Bold,
                maxLines = 2,
                overflow = TextOverflow.Ellipsis
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Cuerpo del post
            Text(
                text = post.body,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}
