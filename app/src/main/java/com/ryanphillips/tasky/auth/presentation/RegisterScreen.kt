package com.ryanphillips.tasky.auth.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.ryanphillips.tasky.core.designsystem.theme.TaskyTheme

// TODO: Implement Register screen according to the mockup.
@Composable
fun RegisterScreenRoot(
//    viewModel: RegisterViewModel = hiltViewModel()
) {
    RegisterScreen(
        state = RegisterState()
    )
}

@Composable
private fun RegisterScreen(
    state: RegisterState
) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = "Create your account")
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                state = state.name
            )
            TextField(
                state = state.email
            )
            TextField(
                state = state.password
            )
            Button(
                onClick = {}
            ) {
                Text(text = "GET STARTED")
            }
            // TODO: "Log in" needs to be clickable and nav to Login screen.
            Text(
                text = "Already have an account? Log in"
            )
        }
    }
}

@Preview
@Composable
private fun RegisterScreenPreview() {
    TaskyTheme {
        RegisterScreen(
            state = RegisterState()
        )
    }
}