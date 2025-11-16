package com.compose.liquidglassbottomnav

import android.os.Bundle
import android.provider.CalendarContract
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.compose.liquidglassbottomnav.screens.*
import com.compose.liquidglassbottomnav.ui.theme.*
import com.compose.liquidglassnav.LiquidGlassBottomNavBar
import com.compose.liquidglassnav.NavItem
import com.google.android.material.color.HarmonizedColorAttributes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LiquidGlassBottomNavTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    var selectedIndex by remember { mutableStateOf(0) }

    val navItems = listOf(
        NavItem(
            icon = Icons.Outlined.Home,
            activeIcon = Icons.Filled.Home,
            label = "Home",
            route = "home"
        ),
        NavItem(
            icon = Icons.Outlined.Search,
            activeIcon = Icons.Filled.Search,
            label = "Search",
            route = "search"
        ),
        NavItem(
            icon = Icons.Outlined.FavoriteBorder,
            activeIcon = Icons.Filled.Favorite,
            label = "Favorites",
            route = "favorites"
        ),
        NavItem(
            icon = Icons.Outlined.Person,
            activeIcon = Icons.Filled.Person,
            label = "Profile",
            route = "profile",
            badge = 5
        )
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = Brush.horizontalGradient(
                colors = listOf(
                    Color.Red,
                    Color.Magenta,
                    DarkBackground,
                    CardBackground,
                    Color.Red,
                    Color.Magenta,

                )
            )
            )
    ) {
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier
                .fillMaxSize()
                .padding(bottom = 100.dp)
        ) {
            composable("home") { HomeScreen() }
            composable("search") { SearchScreen() }
            composable("favorites") { FavoritesScreen() }
            composable("profile") { ProfileScreen() }
        }

        Box(
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 24.dp)
        ) {
            LiquidGlassBottomNavBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = { index ->
                    selectedIndex = index
                    navController.navigate(navItems[index].route) {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                },
                backgroundColor = CardBackground,
                selectedColor = Color.White,
                unselectedColor = Color.White.copy(alpha = 0.6f),
                activeColor = AccentCyan,
                borderColor = Color.White.copy(alpha = 0.2f),
                barHeight = 70.dp,
                cornerRadius = 30.dp,
                showBorder = true
            )
        }
    }
}