package com.auth.register.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.auth.register.presentation.UserRegistrationViewModel
import com.auth.register.presentation.structure.UserRegistrationScreenState
import com.bold.core.presentation.ui.components.OutlineEmailTextField
import com.bold.core.presentation.ui.components.OutlinePasswordTextField
import com.bold.core.presentation.ui.components.OutlinePhoneTextField
import com.bold.core.presentation.ui.components.OutlineUsernameTextField
import com.bold.core.ui.theme.CheckEngineOffTypography

@Composable
fun UserRegistrationScreenRoute(
    onBackClick: () -> Unit
) {
    val viewModel: UserRegistrationViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsState()
    UserRegistrationScreen(
        uiState = uiState,
        onBackClick = onBackClick,
        onUsernameChange = viewModel::onUsernameChanged,
        onUsernameFocusLost = viewModel::onUsernameFocusLost
    )
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserRegistrationScreen(
    uiState: UserRegistrationScreenState,
    onBackClick: () -> Unit,
    onUsernameChange: (String) -> Unit,
    onUsernameFocusLost: () -> Unit
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = ""
                    )
                },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null
                        )
                    }
                }
            )
        }
    ) {
        UserRegistrationScreenContent(
            uiState = uiState,
            modifier = Modifier.padding(it),
            onUsernameChange = onUsernameChange,
            onUsernameFocusLost = onUsernameFocusLost
        )

    }
}

@Composable
fun UserRegistrationScreenContent(
    uiState: UserRegistrationScreenState,
    modifier: Modifier,
    onUsernameChange: (String) -> Unit,
    onUsernameFocusLost: () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(
                Brush.verticalGradient(
                    colors = listOf(
                        Color(0xFF2563EB),
                        Color(0xFF1E3A8A)
                    )
                )
            )
            .verticalScroll(rememberScrollState())
    ) {

        Card(
            modifier = Modifier,
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 0.dp,
                bottomStart = 24.dp,
                bottomEnd = 24.dp
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 30.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {

                Text(
                    text = "Create account",
                    style = CheckEngineOffTypography.titleLarge
                )

                Text(
                    text = "Create a new account",
                    style = CheckEngineOffTypography.labelMedium
                )
            }

        }

        Card(
            modifier = Modifier
                .align(Alignment.Center)
                .padding(top = 50.dp, start = 10.dp, end = 10.dp, bottom = 10.dp),
            shape = MaterialTheme.shapes.medium,
            elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            colors = CardDefaults.cardColors(
                containerColor = Color.White
            ),
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlineUsernameTextField(
                    modifier = Modifier.fillMaxWidth()
                        .onFocusChanged {
                            if (!it.isFocused) {
                                onUsernameFocusLost()
                            }
                        },
                    value = uiState.username,
                    hint = "Username",
                    isError = uiState.usernameError != null,
                    errorMessage = uiState.usernameError,
                    onValueChange = {
                        onUsernameChange(it)
                    }
                )

                OutlineEmailTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    hint = "Email",
                    onValueChange = {}
                )

                OutlinePhoneTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    hint = "Phone",
                    onValueChange = {}
                )

                OutlinePasswordTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = "",
                    hint = "Password",
                    onValueChange = {}
                )

                Button(
                    modifier = Modifier.fillMaxWidth(),
                    onClick = {}
                ) {
                    Text("Create account")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun UserRegistrationScreenPreview() {
    UserRegistrationScreen(
        uiState = UserRegistrationScreenState(),
        onBackClick = {},
        onUsernameChange = {},
        onUsernameFocusLost = {}
    )
}

