# Liquid Glass Bottom Navigation Bar

A beautiful, animated bottom navigation bar with liquid glass morphism effect for Jetpack Compose.

## Features

✨ Smooth liquid animations
🎨 Customizable colors and styles
🔄 Spring-based transitions
💎 Glass morphism effect
⚡ Lightweight and performant

## Installation

Add JitPack repository in your root `settings.gradle.kts`:

```kotlin
dependencyResolutionManagement {
    repositories {
        maven { url = uri("https://jitpack.io") }
    }
}
```

Add the dependency in your app `build.gradle.kts`:

```kotlin
dependencies {
    implementation("com.github.yourusername:liquid-glass-bottom-nav:1.0.0")
}
```

## Usage

```kotlin
import com.yourname.liquidglassnav.LiquidGlassBottomNavBar
import com.yourname.liquidglassnav.NavItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*

@Composable
fun MyScreen() {
    var selectedIndex by remember { mutableStateOf(0) }
    
    val navItems = listOf(
        NavItem(Icons.Default.Home, "Home", "home"),
        NavItem(Icons.Default.Search, "Search", "search"),
        NavItem(Icons.Default.Favorite, "Favorites", "favorites"),
        NavItem(Icons.Default.Person, "Profile", "profile")
    )

    Scaffold(
        bottomBar = {
            LiquidGlassBottomNavBar(
                items = navItems,
                selectedIndex = selectedIndex,
                onItemSelected = { selectedIndex = it },
                backgroundColor = Color(0xFF1A1A2E),
                selectedColor = Color.White,
                unselectedColor = Color.White.copy(alpha = 0.5f),
                glowColor = Color(0xFF00D9FF)
            )
        }
    ) { padding ->
        // Your content
    }
}
```

## Customization

| Parameter | Type | Description |
|-----------|------|-------------|
| `items` | `List<NavItem>` | Navigation items to display |
| `selectedIndex` | `Int` | Currently selected item index |
| `onItemSelected` | `(Int) -> Unit` | Callback when item is selected |
| `backgroundColor` | `Color` | Background glass color |
| `selectedColor` | `Color` | Selected icon color |
| `unselectedColor` | `Color` | Unselected icon color |
| `glowColor` | `Color` | Glow effect color |

## License

MIT License - feel free to use in your projects!

## Contributing

Pull requests are welcome! Please feel free to submit issues and enhancement requests.
```

---

## Steps to Create in Android Studio

1. **Create New Project**: File → New → New Project → Empty Activity
2. **Add Library Module**: Right-click project → New → Module → Android Library
3. **Copy all the files** above into their respective locations
4. **Sync Gradle**
5. **Commit to GitHub**
6. **Tag a release** (e.g., v1.0.0) for JitPack to build

That's it! Your library is ready to publish! 🚀