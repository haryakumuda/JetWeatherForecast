package com.kumuda.jetweatherforecast.widgets

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.rounded.MoreVert
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController


@ExperimentalMaterial3Api
@Composable
fun WeatherAppBar(
    title: String = "Title",
    icon: ImageVector? = null,
    isMainScreen: Boolean = true,
    elevation: Dp = 4.dp,
    navController: NavController,
    onAddActionClicked: () -> Unit = {},
    onButtonClicked: () -> Unit = {},
) {
    TopAppBar(modifier = Modifier.shadow(
        elevation = elevation,
        spotColor = Color.Black,
        shape = RoundedCornerShape(5.dp)
    ), colors =
    TopAppBarDefaults.smallTopAppBarColors(
        containerColor = Color.Transparent,
        titleContentColor = MaterialTheme.colorScheme.primary
    ), title = {
        Text(
            text = title,
            color = MaterialTheme.colorScheme.primary,
            style = TextStyle(
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,

                )
        )
    }, actions = {
        if (isMainScreen) {
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Search,
                    contentDescription = "Search Icon",
                    tint = MaterialTheme.colorScheme.primary
                )

            }
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Rounded.MoreVert,
                    contentDescription = "More Icon",
                    tint = MaterialTheme.colorScheme.primary
                )
            }
        } else Box {}

    }, navigationIcon = {
        if (icon != null) {
            Icon(
                imageVector = icon,
                contentDescription = "navigationIcon",
                tint = MaterialTheme.colorScheme.primary,
                modifier = Modifier.clickable { onButtonClicked.invoke() }
            )
        }
    })
}


//@ExperimentalMaterial3Api
//@Composable
//fun WeatherAppBar() {
//    TopAppBar(colors = TopAppBarDefaults.smallTopAppBarColors(
//        containerColor = MaterialTheme.colorScheme.primary,
//        titleContentColor = Color.White
//    ),
//        title = { Text("Main Screen") },
//        navigationIcon = {
//            IconButton(
//                onClick = { navController.popBackStack() }
//            ) {
//                Icon(
//                    Icons.Default.ArrowBack,
//                    contentDescription = "Arrow Back",
//                    tint = Color.White
//                )
//            }
//        }
//    )
//}