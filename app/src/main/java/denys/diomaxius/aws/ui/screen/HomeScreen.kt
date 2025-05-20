package denys.diomaxius.aws.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import denys.diomaxius.aws.data.model.SoilMoisture

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val soilMoistureItems by viewModel.soilMoistureItems.collectAsState()

    Scaffold { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            soilMoistureItems = soilMoistureItems
        )
    }
}

@Composable
fun Content(
    modifier: Modifier = Modifier,
    soilMoistureItems: List<SoilMoisture>
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(soilMoistureItems) { item ->
            SoilMoistureItem(item)
        }
    }
}

@Composable
fun SoilMoistureItem(item: SoilMoisture) {
    Text(text = item.deviceId)
}



















