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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.withLink
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.ryanphillips.tasky.R
import com.ryanphillips.tasky.core.designsystem.component.TaskyPasswordTextField
import com.ryanphillips.tasky.core.designsystem.component.TaskyTextField
import com.ryanphillips.tasky.core.designsystem.theme.CheckmarkIcon
import com.ryanphillips.tasky.core.designsystem.theme.Inter
import com.ryanphillips.tasky.core.designsystem.theme.TaskyTheme

// TODO: Implement Register screen according to the mockup.
@Composable
fun RegisterScreenRoot( //    viewModel: RegisterViewModel = hiltViewModel()
) {
    RegisterScreen(
        state = RegisterState()
    )
}

@Composable
private fun RegisterScreen(
    state: RegisterState
) {
    Scaffold(
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background)
                .padding(innerPadding),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(
                    top = 40.dp,
                    bottom = 40.dp
                ),
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
                TaskyTextField(
                    modifier = Modifier.padding(8.dp),
                    state = state.name,
                    hint = "Name",
                    trailingIcon = if (state.name.text.isNotEmpty()) CheckmarkIcon else null
                )
                TaskyTextField(
                    modifier = Modifier.padding(8.dp),
                    state = state.email,
                    hint = "Email",
                    keyboardType = KeyboardType.Email,
                    trailingIcon = if (state.email.text.isNotEmpty()) CheckmarkIcon else null
                )
                TaskyPasswordTextField(
                    modifier = Modifier.padding(8.dp),
                    state = state.password,
                    showPassword = false,
                    onToggleVisibility = {}
                )
                // TODO: Make design system component for Primary Button
                Button(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 8.dp, vertical = 16.dp),
                    onClick = {
                        // TODO: Implement
                    }
                ) {
                    Text(
                        modifier = Modifier.padding(16.dp),
                        text = stringResource(R.string.get_started),
                        style = MaterialTheme.typography.labelLarge
                    )
                }
                AlreadyHaveAccountLogIn(
                    onClick = {
                        // TODO: Implement
                    }
                )
            }
        }
    }
}

@Composable
private fun AlreadyHaveAccountLogIn(
    onClick: () -> Unit = {}
) {
    val annotatedString = buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                fontFamily = Inter,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        ) {
            append(stringResource(R.string.already_have_an_account) + " ")
            withLink(
                LinkAnnotation.Clickable(
                    tag = "register_login",
                    styles = TextLinkStyles(
                        style = SpanStyle(
                            fontFamily = Inter,
                            fontWeight = FontWeight.SemiBold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colorScheme.scrim
                        )
                    ),
                    linkInteractionListener = {
                        onClick()
                    })
            ) {
                append(stringResource(R.string.log_in))
            }
        }
    }
    Text(
        text = annotatedString,
        style = MaterialTheme.typography.labelMedium
    )
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