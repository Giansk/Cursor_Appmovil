package com.example.musicgen

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Mic
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.icons.outlined.Explore
import androidx.compose.material.icons.outlined.ShoppingBag
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.musicgen.ui.theme.MusicGenTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MusicGenTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    MusicHomeScreen()
                }
            }
        }
    }
}

@Composable
fun MusicHomeScreen() {
    val gradientBrush = Brush.verticalGradient(
        colors = listOf(Color(0xFF0DB4B0), Color(0xFF1BC48E)),
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )

    Scaffold(
        containerColor = Color.Transparent,
        bottomBar = { BottomNavBar() }
    ) { innerPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(gradientBrush)
                .padding(innerPadding)
        ) {
            Column(modifier = Modifier.fillMaxSize()) {
                Spacer(Modifier.height(8.dp))
                HeaderBar()
                Spacer(Modifier.height(16.dp))
                SectionTitle(text = "Generar Musica")
                Spacer(Modifier.height(8.dp))
                AssistantCard()
                Spacer(Modifier.height(16.dp))
                RecommendedSection()
                Spacer(Modifier.height(100.dp))
            }
        }
    }
}

@Composable
private fun HeaderBar() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 12.dp),
        color = Color(0xFF3A2F2B),
        shape = RoundedCornerShape(16.dp),
        tonalElevation = 4.dp
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(12.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .background(Color(0xFF2DE8B8)),
                contentAlignment = Alignment.Center
            ) {
                Text("M", color = Color(0xFF1A1A1A), fontWeight = FontWeight.Bold)
            }

            var query by remember { mutableStateOf("") }
            Surface(
                modifier = Modifier.weight(1f),
                color = Color.White,
                shape = RoundedCornerShape(24.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(Icons.Filled.Search, contentDescription = "Buscar", tint = Color(0xFF6F6C69))
                    Spacer(Modifier.width(8.dp))
                    Text(
                        text = if (query.isBlank()) "Buscar música" else query,
                        color = if (query.isBlank()) Color(0xFF9B9B9B) else Color(0xFF1A1A1A),
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.weight(1f)
                    )
                    Icon(Icons.Filled.Send, contentDescription = "Enviar", tint = Color(0xFF6F6C69))
                }
            }

            Box(
                modifier = Modifier
                    .size(28.dp)
                    .clip(CircleShape)
                    .background(Color(0xFFD9C4A9))
            )
        }
    }
}

@Composable
private fun SectionTitle(text: String) {
    Text(
        text = text,
        color = Color.White,
        fontSize = 20.sp,
        fontWeight = FontWeight.SemiBold,
        modifier = Modifier.padding(horizontal = 16.dp)
    )
}

@Composable
private fun AssistantCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        color = Color(0xFF2E2E2E).copy(alpha = 0.85f),
        shape = RoundedCornerShape(8.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = "¿En qué puedo ayudarte?",
                color = Color(0xFFBEBEBE),
                fontSize = 14.sp
            )
            Spacer(Modifier.height(12.dp))
            Surface(
                color = Color(0xFF3A3A3A),
                shape = RoundedCornerShape(20.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp, vertical = 10.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Pregúntale lo que quieras",
                        color = Color(0xFF9B9B9B),
                        modifier = Modifier.weight(1f)
                    )
                    Icon(Icons.Filled.Mic, contentDescription = "Mic", tint = Color(0xFF9B9B9B))
                }
            }
        }
    }
}

@Composable
private fun RecommendedSection() {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "Recomendado",
            color = Color.White,
            fontSize = 18.sp,
            fontWeight = FontWeight.SemiBold
        )
        Text("⋮", color = Color.White, fontSize = 22.sp)
    }

    Spacer(Modifier.height(8.dp))

    val albums = remember {
        (1..10).map { index -> "Album $index" }
    }

    LazyRow(
        contentPadding = PaddingValues(horizontal = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items(albums) { title ->
            AlbumCard(title)
        }
    }
}

@Composable
private fun AlbumCard(title: String) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .size(width = 120.dp, height = 120.dp)
                .clip(RoundedCornerShape(12.dp))
                .background(Color(0xFF2B2F38))
        ) {
            // Placeholder art block
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.linearGradient(
                            listOf(Color(0xFFEF5350), Color(0xFFFFA726))
                        )
                    )
            )
        }
        Spacer(Modifier.height(6.dp))
        Text(
            text = title,
            color = Color.White,
            maxLines = 1,
            overflow = TextOverflow.Ellipsis,
            fontSize = 12.sp
        )
    }
}

@Composable
private fun BottomNavBar() {
    Surface(color = Color(0xFF3A2F2B)) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            NavItem(icon = { Icon(Icons.Filled.Home, null, tint = Color.White) }, label = "Inicio")
            NavItem(icon = { Icon(Icons.Outlined.Explore, null, tint = Color.White) }, label = "Explorar")
            NavItem(icon = { Icon(Icons.Outlined.ShoppingBag, null, tint = Color.White) }, label = "Productos")
            NavItem(icon = { Icon(Icons.Filled.Person, null, tint = Color.White) }, label = "Contacto")
        }
    }
}

@Composable
private fun NavItem(icon: @Composable () -> Unit, label: String) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        icon()
        Spacer(Modifier.height(4.dp))
        Text(label, color = Color.White, fontSize = 11.sp)
    }
}