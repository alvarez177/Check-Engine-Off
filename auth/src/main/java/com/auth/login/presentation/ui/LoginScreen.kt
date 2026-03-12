package com.auth.login.presentation.ui

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.bold.core.ui.theme.CheckEngineOffTypography

@Composable
fun LoginScreen(
    modifier: Modifier
) {
    Box(
        modifier = modifier.fillMaxSize().padding(horizontal = 20.dp),
        contentAlignment = Alignment.Center
    ) {
        Card(
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp)
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Login",
                    style = CheckEngineOffTypography.titleLarge,
                    modifier = Modifier.align(Alignment.CenterHorizontally)
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Username") })

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    onValueChange = {},
                    label = { Text(text = "Password") })

                Text(
                    text = "Forgot Password?",
                    modifier = Modifier.align(Alignment.End)
                )

                Button(
                    modifier = Modifier.fillMaxWidth().align(Alignment.CenterHorizontally),
                    onClick = {}
                ) {
                    Text(
                        text = "Login"
                    )
                }

                Row {
                    Text(
                        text = "Don't have an account?"
                    )
                    Text(
                        text = " Register",
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        modifier = Modifier
    )
}