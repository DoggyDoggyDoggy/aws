package denys.diomaxius.aws.ui.screen.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.aws.data.model.SoilMoisture


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val soilMoistureItems by viewModel.soilMoistureItems.collectAsState()

    var menuItem by remember {
        mutableStateOf(0)
    }

    Scaffold(
        topBar = {
            TopBar()
        }
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            soilMoistureItems = soilMoistureItems,
            menuItem = menuItem
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    soilMoistureItems: List<SoilMoisture>,
    menuItem: Int
) {
    Column(
        modifier = modifier.fillMaxSize()
    ) {
        Menu(
            modifier = Modifier
                .padding(horizontal = 8.dp)
                .padding(top = 8.dp),
            menuItem = menuItem
        )

        LazyColumn {
            items(soilMoistureItems) { item ->
                SoilMoistureItem(item)
            }
        }
    }
}

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    menuItem: Int
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 8.dp, end = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (menuItem == 1) MaterialTheme.colorScheme.primaryContainer else
                    MaterialTheme.colorScheme.primary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Today",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
        }

        Card(
            modifier = Modifier
                .padding(vertical = 8.dp, horizontal = 4.dp),
            colors = CardDefaults.cardColors(
                containerColor = if (menuItem == 0) MaterialTheme.colorScheme.primaryContainer else
                    MaterialTheme.colorScheme.primary,
            ),
            elevation = CardDefaults.cardElevation(
                defaultElevation = 4.dp
            )
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "All data",
                fontSize = 20.sp,
                fontWeight = FontWeight.Normal
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun MenuPreview() {
    Menu(
        menuItem = 0,
        modifier = Modifier
    )
}