package denys.diomaxius.aws.ui.screen.home

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    menuItem: Int,
    changeMenuItem: (Int) -> Unit
) {
    Row(
        modifier = modifier
            .fillMaxWidth()
    ) {
        Card(
            modifier = Modifier
                .padding(vertical = 8.dp)
                .padding(start = 8.dp, end = 4.dp)
                .clickable{
                    changeMenuItem(0)
                },
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
                .padding(vertical = 8.dp, horizontal = 4.dp)
                .clickable{
                    changeMenuItem(1)
                },
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
        modifier = Modifier,
        changeMenuItem = {}
    )
}