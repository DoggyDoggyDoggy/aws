package denys.diomaxius.aws.ui.screen.Login

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import denys.diomaxius.aws.navigation.Screen

@Composable
fun LoginScreen(
    navHostController: NavHostController
) {
    var login by remember {
        mutableStateOf("")
    }

    var password by remember {
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Welcome back!",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = FontFamily.Monospace,
                fontWeight = FontWeight.Bold
            )
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Sign in to your account",
            textAlign = TextAlign.Center,
            style = TextStyle(
                fontSize = 20.sp
            )
        )

        Spacer(modifier = Modifier.height(35.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Enter your login",
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = login,
            onValueChange = {
                login = it
            },
            label = {
                Text(text = "Login")
            },
        )

        Spacer(modifier = Modifier.height(20.dp))

        Text(
            modifier = Modifier.fillMaxWidth(),
            text = "Enter your password",
            textAlign = TextAlign.Left,
            style = TextStyle(
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = password,
            onValueChange = {
                password = it
            },
            label = {
                Text(text = "Password")
            },
            visualTransformation = PasswordVisualTransformation()
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp),
            onClick = {
                navHostController.navigate(Screen.Home.route) {
                    popUpTo(Screen.Login.route) {
                        inclusive = true
                    }
                    launchSingleTop = true
                }
            }
        ) {
            Text(
                text = "Login"
            )
        }
    }
}














