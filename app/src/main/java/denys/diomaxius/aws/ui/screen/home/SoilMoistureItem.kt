package denys.diomaxius.aws.ui.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.aws.data.model.SoilMoisture
import denys.diomaxius.aws.utils.date

@Composable
fun SoilMoistureItem(item: SoilMoisture) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
        ),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 4.dp
        )
    ) {
        Column(
            modifier = Modifier
                .padding(8.dp)
                .clip(RoundedCornerShape(32.dp)),
        ) {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp, vertical = 4.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    modifier = Modifier,
                    text = item.deviceId,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.SemiBold
                )

                Box(
                    modifier = Modifier
                        .clip(CircleShape)
                        .size(16.dp)
                        .background(circleColor(item.soilmoisture.toInt()))
                )
            }

            HorizontalDivider(
                thickness = 2.dp,
                color = MaterialTheme.colorScheme.primary
            )

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Date: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Text(
                    text = date(item.timestamp),
                    fontSize = 16.sp
                )
            }

            Spacer(modifier = Modifier.height(4.dp))

            Row(
                modifier = Modifier.padding(horizontal = 12.dp)
            ) {
                Text(
                    text = "Soil Moisture: ",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )

                Text(
                    text = item.soilmoisture,
                    fontSize = 16.sp
                )
            }
        }
    }
}

fun circleColor(soilMoister: Int) : Color {
    return when {
        soilMoister < 120 -> Color.Red
        soilMoister in 120..180 -> Color.Yellow
        else -> Color.Green
    }
}

@Preview(showBackground = true)
@Composable
fun SoilMoistureItemPreview() {
    SoilMoistureItem(
        item = SoilMoisture(
            deviceId = "Example_Device_Id",
            timestamp = 1234567890,
            soilmoisture = "160"
        )
    )
}