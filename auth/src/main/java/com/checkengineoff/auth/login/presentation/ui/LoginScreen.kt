package com.checkengineoff.auth.login.presentation.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.checkengineoff.auth.R
import com.checkengineoff.core.presentation.ui.components.OutlinePasswordTextField
import com.checkengineoff.core.presentation.ui.components.OutlineUsernameTextField
import com.checkengineoff.core.ui.theme.CheckEngineOffTypography
import com.checkengineoff.auth.login.presentation.LoginViewModel
import com.checkengineoff.auth.login.presentation.structure.LoginIntent
import com.checkengineoff.auth.login.presentation.structure.LoginUiState

@Composable
fun LoginScreenRoute(
    onNavigateRegister: () -> Unit,
) {
    val viewModel: LoginViewModel = hiltViewModel()
    val uiState by viewModel.state.collectAsState()
    LoginScreen(
        uiState = uiState,
        onNavigateRegister = onNavigateRegister,
        onIntent = viewModel::onIntent
    )

}

@Composable
fun LoginScreen(
    uiState: LoginUiState,
    onNavigateRegister: () -> Unit,
    onIntent: (LoginIntent) -> Unit
) {
    Scaffold {
        LoginScreenContent(
            uiState = uiState,
            modifier = Modifier.padding(it),
            onNavigateRegister = onNavigateRegister,
            onIntent = onIntent
        )
    }

}

@Composable
fun LoginScreenContent(
    uiState: LoginUiState,
    modifier: Modifier,
    onNavigateRegister: () -> Unit,
    onIntent: (LoginIntent) -> Unit
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
            .padding(horizontal = 20.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Image(
                painter = painterResource(R.drawable.img_checkengineoff_without_bg),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .clip(CircleShape),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(32.dp))


            Card(
                shape = MaterialTheme.shapes.medium,
                elevation = CardDefaults.cardElevation(defaultElevation = 12.dp),
            ) {

                Column(
                    modifier = Modifier.padding(24.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Text(
                        text = "Login",
                        style = CheckEngineOffTypography.titleLarge
                    )

                    val passwordFocusRequester = remember { FocusRequester() }
                    val keyboardController = LocalSoftwareKeyboardController.current

                    OutlineUsernameTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .onFocusChanged {
                                onIntent(LoginIntent.OnUsernameFocus(isFocused = it.isFocused))
                            },
                        value = uiState.username,
                        hint = "Username",
                        errorMessage = uiState.usernameError,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Next
                        ),
                        keyboardActions = KeyboardActions(
                            onNext = {
                                passwordFocusRequester.requestFocus()
                            }
                        ),
                        onValueChange = {
                            onIntent(LoginIntent.OnUsernameChanged(it))
                        }
                    )

                    OutlinePasswordTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .focusRequester(passwordFocusRequester)
                            .onFocusChanged {
                                onIntent(LoginIntent.OnPasswordFocus(isFocused = it.isFocused))
                            },
                        value = uiState.password,
                        hint = "Password",
                        errorMessage = uiState.passwordError,
                        keyboardOptions = KeyboardOptions(
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = {
                                keyboardController?.hide()
                            }
                        ),
                        onValueChange = {
                            onIntent(LoginIntent.OnPasswordChanged(it))
                        }
                    )

                    Text(
                        text = "Forgot Password?",
                        modifier = Modifier.align(Alignment.End)
                    )

                    Button(
                        modifier = Modifier.fillMaxWidth(),
                        enabled = uiState.enableLoginAction,
                        onClick = {
                            onIntent(LoginIntent.OnLoginClicked)
                        }
                    ) {
                        Text("Login")
                    }

                    Row {
                        Text("Don't have an account?")
                        Text(
                            text = " Register",
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.clickable(onClick = { onNavigateRegister() })
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    LoginScreen(
        uiState = LoginUiState(),
        onNavigateRegister = {},
        onIntent = {}
    )
}