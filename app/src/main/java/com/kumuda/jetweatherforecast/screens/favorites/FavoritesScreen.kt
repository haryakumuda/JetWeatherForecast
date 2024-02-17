package com.kumuda.jetweatherforecast.screens.favorites

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.rounded.Delete
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.kumuda.jetweatherforecast.model.Favorite
import com.kumuda.jetweatherforecast.navigation.WeatherScreens
import com.kumuda.jetweatherforecast.widgets.WeatherAppBar

@ExperimentalMaterial3Api
@Composable
fun FavoritesScreen(
    navController: NavController,
    favoritesViewModel: FavoritesViewModel = hiltViewModel()
) {
    Scaffold(topBar = {
        WeatherAppBar(
            navController = navController,
            title = "Favorite Cities",
            icon = Icons.Default.ArrowBack, isMainScreen = false
        ) {
            navController.popBackStack()
        }
    }) { paddingValue ->
        Surface(
            modifier = Modifier
                .padding(paddingValue)
                .fillMaxWidth()
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                val list = favoritesViewModel.favList.collectAsState().value

                LazyColumn {
                    items(items = list) { favorite ->
                        CityRow(favorite, navController = navController, favoritesViewModel)
                    }
                }

            }
        }

    }

}

@Composable
fun CityRow(
    favorite: Favorite,
    navController: NavController,
    favoritesViewModel: FavoritesViewModel
) {
    Surface(
        modifier = Modifier
            .padding(3.dp)
            .fillMaxWidth()
            .height(50.dp)
            .clickable { navController.navigate(WeatherScreens.MainScreen.name + "/${favorite.city}") },
        shape = CircleShape.copy(topEnd = CornerSize(6.dp)),
        color = Color(0xffb2dfdb)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(text = favorite.city, modifier = Modifier.padding(start = 4.dp))
            Surface(
                modifier = Modifier.padding(0.dp),
                shape = CircleShape,
                color = Color(0xffd1e3e1)
            ) {
                Text(
                    text = favorite.country,
                    modifier = Modifier.padding(4.dp),
                    style = MaterialTheme.typography.labelLarge
                )

            }
            Icon(
                imageVector = Icons.Rounded.Delete,
                contentDescription = "delete",
                modifier = Modifier.clickable { favoritesViewModel.deleteFavorite(favorite) })

        }

    }
}
