package com.android.myapplication

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.BackHandler
import androidx.activity.compose.setContent
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Build
import androidx.compose.material.icons.rounded.Call
import androidx.compose.material.icons.rounded.Search
import androidx.compose.material.icons.rounded.Star
import androidx.compose.material.icons.sharp.Menu
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Button
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
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
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
                    ChatScreen(chatList)
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
fun ChatItem(message: String, index: Int) {
    val odd = index % 2 == 0
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = if(odd) 0.dp else 10.dp, end = if(odd.not()) 0.dp else 10.dp, top = 5.dp)
    ) {
        if (odd) {
            Spacer(modifier = Modifier.weight(1f))
        }
        Box(
            modifier = Modifier
                .background(
                    MaterialTheme.colorScheme.primary,
                    RoundedCornerShape(5.dp)
                )
                .padding(5.dp),
        ) {
            Text(
                text = message,
                textAlign = TextAlign.End,
                modifier = Modifier.padding(10.dp),
                color = Color.White
            )
        }
        if (odd.not()) {
            Spacer(modifier = Modifier.weight(1f))
        }
    }
}


@Composable
fun ChatScreen(messages: MutableList<String>) {
    var text by remember { mutableStateOf("") }
    val listState = rememberLazyListState()
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        // Chat messages list
        LazyColumn(
            state = listState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
        ) {
            itemsIndexed(messages, itemContent = { index: Int, message: String ->
                ChatItem(message, index)
            })
        }

        // Input field and send button
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            TextField(
                value = text,
                onValueChange = { text = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("Type a message") }
            )
            Spacer(modifier = Modifier.width(6.dp))
            Button(onClick = {
                if (text.isNotBlank()) {
                    messages.add(text)  // Add the new message to the chat list
                    text = ""  // Clear the input field after sending the message
                    coroutineScope.launch {
                        listState.animateScrollToItem(messages.size - 1)
                    }
                }
            }) {
                Text("Send")
            }
        }
    }
}

