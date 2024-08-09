package com.android.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInHorizontally
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.android.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            MyApplicationTheme {
                MyApp()
                BackHandler(true) {
                    finish()
                }
            }
        }
    }
}

var currentLoadedTab = "a"

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyApp() {
    val selectedMenu = remember { mutableIntStateOf(1) }
    val navController = rememberNavController()
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val chatList = remember {
        mutableStateListOf(
            "Helldfgo",
            " dfgHi",
            "Hod fgw are you?",
            "I am d gfine",
            "What  dgabout you?",
            "I am g dgood",
            "Bye dg",
            "Goo dgdbye"
        )
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text("Sample App", modifier = Modifier.padding(16.dp))
                HorizontalDivider()
                NavigationDrawerItem(
                    label = { Text(text = "Home") },
                    selected = selectedMenu.intValue == 1,
                    onClick = {
                        selectedMenu.intValue = 1
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Mars") },
                    selected = selectedMenu.intValue == 2,
                    onClick = {
                        selectedMenu.intValue = 2
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Jupiter") },
                    selected = selectedMenu.intValue == 3,
                    onClick = {
                        selectedMenu.intValue = 3
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Mercury") },
                    selected = selectedMenu.intValue == 4,
                    onClick = {
                        selectedMenu.intValue = 4
                        scope.launch { drawerState.close() }
                    }
                )

                NavigationDrawerItem(
                    label = { Text(text = "Neptune") },
                    selected = selectedMenu.intValue == 5,
                    onClick = {
                        selectedMenu.intValue = 5
                        scope.launch { drawerState.close() }
                    }
                )
            }
        }
    ) {
        Scaffold(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight(), topBar = {
            TopAppBar(colors = TopAppBarDefaults.topAppBarColors(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                titleContentColor = MaterialTheme.colorScheme.primary,
            ),
                title = { Text(text = "Compose", modifier = Modifier.padding(10.dp)) },
                navigationIcon = {
                    Icon(
                        Icons.Sharp.Menu,
                        contentDescription = "C",
                        modifier = Modifier
                            .padding(10.dp)
                            .clickable {
                                scope.launch {
                                    drawerState.apply {
                                        if (isClosed) {
                                            open()
                                        } else {
                                            close()
                                        }
                                    }
                                }
                            })
                })
        }, bottomBar = {
            BottomAppBar {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = {
                                // Handle click
                                if (currentLoadedTab != "a") {
                                    currentLoadedTab = "a"
                                    navController.navigateUp()
                                    navController.navigate("a")
                                }
                            })
                    ) {
                        Icon(
                            Icons.Rounded.Star,
                            contentDescription = "A",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "A",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = {
                                if (currentLoadedTab != "b") {
                                    currentLoadedTab = "b"
                                    navController.navigateUp()
                                    navController.navigate("b")
                                }
                            })
                    ) {
                        Icon(
                            Icons.Rounded.Search,
                            contentDescription = "B",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "B",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = {
                                if (currentLoadedTab != "c") {
                                    currentLoadedTab = "c"
                                    navController.navigateUp()
                                    navController.navigate("c")
                                }
                            })
                    ) {
                        Icon(
                            Icons.Rounded.Call,
                            contentDescription = "C",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "C",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .clickable(onClick = {
                                if (currentLoadedTab != "d") {
                                    currentLoadedTab = "d"
                                    navController.navigateUp()
                                    navController.navigate("d")
                                }
                            })
                    ) {
                        Icon(
                            Icons.Rounded.Build,
                            contentDescription = "D",
                            modifier = Modifier.fillMaxWidth()
                        )
                        Text(
                            text = "D",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }) {
            NavHost(
                navController, startDestination = "a",
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxHeight()
                    .padding(it)
            ) {
                composable(route = "a") {
                    Listing(chatList)
                }
                composable(route = "b") {
                    Greeting("Bharath")
                }
                composable(route = "c") {
                    Greeting("Chetan")
                }
                composable(route = "d") {
                    Greeting("Dinesh")
                }
            }
        }
    }

    selectedMenu.intValue = 1

    LaunchedEffect(key1 = "Chat") {
        val uniqueTexts = mutableSetOf<String>()
        val randomTexts = listOf(
            "How are you doing?",
            "What's new?",
            "Nice to meet you!",
            "How's your day?",
            "Good to see you!",
            "Take care!",
            "See you later!",
            "Have a great day!"
        )

        while (uniqueTexts.size < randomTexts.size) {
            val newText = randomTexts.random()
            if (uniqueTexts.add(newText)) {
                chatList.add(newText)
                delay(1000L)
            }
        }
    }

}

@Composable
fun Greeting(name: String) {
    Box(modifier = Modifier.background(Color.White)) {
        Text(
            text = "Hello $name!",
            modifier = Modifier
                .fillMaxSize()
                .wrapContentWidth(Alignment.CenterHorizontally)
                .wrapContentHeight(Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun Listing(chatList: MutableList<String>) {
    val listState = rememberLazyListState()

    LaunchedEffect(chatList.size) {
        // Smoothly scroll to the last item in the list whenever a new item is added
        listState.animateScrollToItem(
            index = chatList.size - 1
        )
    }

    LazyColumn(
        state = listState,
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
    ) {
        items(chatList.size, key = { it.hashCode() }) { message ->
            AnimatedVisibility(
                visible = true,
                enter = fadeIn() + slideInHorizontally(initialOffsetX = { it / 2 }),
                exit = fadeOut() + slideOutHorizontally(targetOffsetX = { it / 2 })
            ) {
                Spacer(modifier = Modifier.padding(2.dp))
                Row(modifier = Modifier.fillMaxWidth()) {
                    Spacer(modifier = Modifier.weight(1f)) // Pushes the Box to the end
                    Box(
                        modifier = Modifier
                            .background(MaterialTheme.colorScheme.primary, RoundedCornerShape(5.dp))
                            .padding(5.dp),
                    ) {
                        Text(
                            text = chatList[message],
                            textAlign = TextAlign.End,
                            modifier = Modifier.padding(10.dp)
                        )
                    }
                }
            }
        }
    }
}
