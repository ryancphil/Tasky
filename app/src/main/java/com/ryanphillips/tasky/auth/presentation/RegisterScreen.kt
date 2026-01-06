package com.ryanphillips.tasky.auth.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.ryanphillips.tasky.R
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
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            modifier = Modifier.padding(top = 40.dp, bottom = 40.dp),
            text = stringResource(R.string.create_your_account),
            style = MaterialTheme.typography.headlineLarge,
            color = MaterialTheme.colorScheme.surface
        )
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .clip(
                    RoundedCornerShape(
                        topStart = 24.dp,
                        topEnd = 24.dp
                    )
                )
                .background(MaterialTheme.colorScheme.surface)
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // TODO: Make design system component for Primary TextField
            TextField(
                state = state.name
            )
            TextField(
                state = state.email
            )
            TextField(
                state = state.password
            )
            // TODO: Make design system component for Primary Button
            Button(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                onClick = {}
            ) {
                Text(text = stringResource(R.string.get_started))
            }
            // TODO: Modify so that "Log in" text is clickable and navigates to Login screen.
            Text(
                text = stringResource(R.string.already_have_an_account_log_in),
                style = MaterialTheme.typography.labelSmall
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RegisterScreenPreview() {
    TaskyTheme {
        RegisterScreen(
            state = RegisterState()
        )
    }
}