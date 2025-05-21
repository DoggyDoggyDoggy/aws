package denys.diomaxius.aws

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import dagger.hilt.android.AndroidEntryPoint
import denys.diomaxius.aws.ui.screen.home.HomeScreen
import denys.diomaxius.aws.ui.theme.AwsTheme

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AwsTheme {
                HomeScreen()
            }
        }
    }
}