package com.ersafra.freteminimo

//import androidx.compose.ui.tooling.preview.Preview
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainScreen()
            //MobileAds.initialize(this)

        }
    }
}

@Composable
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        topBar = { TopBar() },
        bottomBar = { BottomNavigationBar(navController) },
        content = { padding ->
            Box(modifier = Modifier.padding(padding)) {
                Navigation(navController = navController)
            }
        },
        backgroundColor = colorResource(R.color.white) // Set background color to avoid the white flashing when you switch between screens
    )
}

//@Preview(showBackground = true)
//@Composable
//fun MainScreenPreview() {
//    MainScreen()
//}

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(navController, startDestination = NavigationItem.Tabela.route) {
        composable(NavigationItem.Tabela.route) {
            TabelaScreen()
        }
        composable(NavigationItem.Fracao.route) {
            FracaoScreen()
        }
        composable(NavigationItem.Diarias.route) {
            DiariasScreen()
        }

    }
}


//@Composable
//fun SampleTopBar() {
//    Column {
//        TopAppBar(
//            //elevation = 4.dp,
//            title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp) },
//            //backgroundColor =  MaterialTheme.colors.primarySurface,
//            backgroundColor = colorResource(id = R.color.teal_200),
//            contentColor = Color.White,
//            navigationIcon = {
//                IconButton(onClick = {/* Do Something*/ }) {
//                    Icon(Icons.Filled.ArrowBack, null)
//                }
//            //        },
//            actions = {
//                IconButton(onClick = {/* Do Something*/ }) {
//                    Icon(Icons.Filled.Share, null)
//                }
//                IconButton(onClick = { }) {
//                    Icon(Icons.Filled.Info, null)
//                }
//            })
//
//        // Text("Hello World")
//
//    }
//}

@Composable
fun TopBar() {
    TopAppBar(
        title = { Text(text = stringResource(R.string.app_name), fontSize = 18.sp)  },
        backgroundColor = colorResource(id = R.color.cinza),
        contentColor = Color.Black
    )
}
@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        NavigationItem.Tabela,
        NavigationItem.Fracao,
        NavigationItem.Diarias,
        )
    BottomNavigation(
        modifier = Modifier.height(70.dp),
        elevation = 8.dp,
        backgroundColor = colorResource(id = R.color.cinza),
        contentColor = Color.White
    ) {
        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute = navBackStackEntry?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(painterResource(id = item.icon), contentDescription = item.title) },
                label = { Text(text = item.title) },
                selectedContentColor = Color.Red,
                unselectedContentColor = Color.Gray.copy(0.4f),
                alwaysShowLabel = true,
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        navController.graph.startDestinationRoute?.let { route ->
                            popUpTo(route) {
                                saveState = true
                            }
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun BottomNavigationBarPreview() {
//    //BottomNavigationBar()
//    TopBar()
//}
