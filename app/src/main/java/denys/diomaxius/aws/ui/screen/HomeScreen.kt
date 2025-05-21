package denys.diomaxius.aws.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import denys.diomaxius.aws.data.model.SoilMoisture
import denys.diomaxius.aws.utils.date


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel = hiltViewModel()
) {
    val soilMoistureItems by viewModel.soilMoistureItems.collectAsState()

    Scaffold (
        topBar = {
            TopBar()
        }
    ) { innerPadding ->
        Content(
            modifier = Modifier.padding(innerPadding),
            soilMoistureItems = soilMoistureItems
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            titleContentColor = MaterialTheme.colorScheme.primary,
        ),
        title = {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text ="Soil Moister App",
                textAlign = TextAlign.Center
            )
        }
    )
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
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(32.dp))
            ,
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = item.deviceId
            )

            Spacer(modifier = Modifier.height(8.dp))

            HorizontalDivider(
                thickness = 2.dp,
                color = Color.Black
            )

            Row (
                modifier = Modifier.padding(horizontal = 8.dp)
            ) {
                Text(
                    text = "Date: "
                )

                Text(
                    text = date(item.timestamp)
                )
            }

            Row (
                modifier = Modifier.padding(horizontal = 8.dp)
            ){
                Text(
                    text = "Soil Moisture: "
                )

                Text(
                    text = item.soilmoisture
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SoilMoistureItemPreview() {
    SoilMoistureItem(
        item = SoilMoisture(
            deviceId = "Example_Device_Id",
            timestamp = 1234567890,
            soilmoisture = "Example_Soil_Moisture_Value"
        )
    )
}