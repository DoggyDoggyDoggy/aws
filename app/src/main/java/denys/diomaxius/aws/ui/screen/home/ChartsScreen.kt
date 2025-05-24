package denys.diomaxius.aws.ui.screen.home

import androidx.compose.animation.core.EaseInOutCubic
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import denys.diomaxius.aws.data.model.SoilMoisture
import ir.ehsannarmani.compose_charts.LineChart
import ir.ehsannarmani.compose_charts.models.AnimationMode
import ir.ehsannarmani.compose_charts.models.DrawStyle
import ir.ehsannarmani.compose_charts.models.Line
import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId

@Composable
fun ChartsScreen(
    modifier: Modifier = Modifier,
    soilMoistureItems: List<SoilMoisture>
) {
    val todayChartDataList = soilMoistureItems
        .filter {
            val dateTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(it.timestamp),
                ZoneId.systemDefault()
            )

            dateTime.toLocalDate() == LocalDateTime.now().toLocalDate()
        }
        .map { it.soilmoisture.toDoubleOrNull() ?: 0.0 }

    val weekChartDataList = soilMoistureItems
        .filter {
            val dateTime = LocalDateTime.ofInstant(
                Instant.ofEpochSecond(it.timestamp),
                ZoneId.systemDefault()
            )

            val now = LocalDateTime.now()
            val oneWeekAgo = now.minusDays(6)

            dateTime.toLocalDate() in oneWeekAgo.toLocalDate()..now.toLocalDate()
        }
        .map { it.soilmoisture.toDoubleOrNull() ?: 0.0 }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(12.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        SoilMoistureCharts(
            chartDataList = todayChartDataList,
            text = "Today Soil Moisture"
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        SoilMoistureCharts(
            chartDataList = weekChartDataList,
            text = "7 Days Soil Moisture"
        )
    }
}

@Composable
fun SoilMoistureCharts(
    chartDataList: List<Double>,
    text: String
) {

    Text(
        text = text,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    )

    Spacer(
        modifier = Modifier.height(25.dp)
    )

    LineChart(
        modifier = Modifier
            .height(300.dp)
            .fillMaxSize(),
        data = listOf(
            Line(
                label = "Soil Moisture",
                values = chartDataList,
                color = SolidColor(Color(0xFF23af92)),
                firstGradientFillColor = Color(0xFF2BC0A1).copy(alpha = .5f),
                secondGradientFillColor = Color.Transparent,
                strokeAnimationSpec = tween(2000, easing = EaseInOutCubic),
                gradientAnimationDelay = 1000,
                drawStyle = DrawStyle.Stroke(width = 2.dp),
            )
        ),
        animationMode = AnimationMode.Together(delayBuilder = {
            it * 500L
        }),
    )
}