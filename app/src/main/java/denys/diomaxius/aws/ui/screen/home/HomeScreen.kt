package denys.diomaxius.aws.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import denys.diomaxius.aws.data.model.SoilMoisture


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val soilMoistureItems by viewModel.soilMoistureItems.collectAsState()

    var menuItem by remember {
        mutableStateOf(0)
    }

    LaunchedEffect(menuItem) {
        if (menuItem == 0) {
            viewModel.loadTodayData()
        } else {
            viewModel.loadAllData()
        }
    }

    Scaffold(
        topBar = {
            TopBar()
        },
        floatingActionButton = {
            GetDataButton(
                onClick = { viewModel.triggerSoilSensor() },
                menuItem = menuItem
            )
        }
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            soilMoistureItems = soilMoistureItems,
            menuItem = menuItem,
            changeMenuItem = { menuItem = it }
        )
    }
}

@Composable
fun GetDataButton(
    onClick: () -> Unit,
    menuItem: Int,
) {
    if (menuItem == 0){
        ExtendedFloatingActionButton(
            onClick = { onClick() },
            icon = { Icon(Icons.Filled.AddCircle, "Get current data") },
            text = { Text(text = "Get current data") },
            containerColor = MaterialTheme.colorScheme.primary
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    soilMoistureItems: List<SoilMoisture>,
    menuItem: Int,
    changeMenuItem: (Int) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Menu(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
            menuItem = menuItem,
            changeMenuItem = changeMenuItem
        )

        LazyColumn {
            items(soilMoistureItems) { item ->
                SoilMoistureItem(item)
            }
        }
    }
}