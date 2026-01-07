package com.ryanphillips.tasky.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicSecureTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.foundation.text.input.TextObfuscationMode
import androidx.compose.foundation.text.input.rememberTextFieldState
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.ryanphillips.tasky.R
import com.ryanphillips.tasky.core.designsystem.theme.EyeClosedIcon
import com.ryanphillips.tasky.core.designsystem.theme.EyeOpenIcon
import com.ryanphillips.tasky.core.designsystem.theme.TaskyTheme

@Composable
fun TaskyPasswordTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    showPassword: Boolean = false,
    onToggleVisibility: () -> Unit,
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    BasicSecureTextField(
        modifier = modifier
            .clip(
                shape = RoundedCornerShape(10.dp)
            )
            .background(
                color = MaterialTheme.colorScheme.surfaceVariant
            )
            .border(
                width = 1.dp,
                color = if (isFocused) {
                    MaterialTheme.colorScheme.outline
                } else {
                    Color.Transparent
                },
                shape = RoundedCornerShape(10.dp)
            )
            .padding(horizontal = 20.dp, vertical = 4.dp)
            .onFocusChanged {
                isFocused = it.isFocused
            },
        state = state,
        textObfuscationMode = if (showPassword) TextObfuscationMode.Visible else TextObfuscationMode.Hidden,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password
        ),
        textStyle = MaterialTheme.typography.bodyMedium.copy(
            color = MaterialTheme.colorScheme.primary
        ),
        decorator = { innerBox ->
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(modifier = Modifier.weight(1f)) {
                    if (state.text.isEmpty()) {
                        Text(
                            text = stringResource(R.string.password),
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    innerBox()
                }
                IconButton(
                    onClick = onToggleVisibility
                ) {
                    Icon(
                        imageVector = if (showPassword) EyeOpenIcon else EyeClosedIcon,
                        contentDescription = "Toggle password visibility",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant.copy(
                            alpha = .7f
                        )
                    )
                }
            }
        }
    )
}

@PreviewLightDark
@Composable
private fun TaskyPasswordTextFieldPreview() {
    TaskyTheme {
        TaskyPasswordTextField(
            state = rememberTextFieldState(),
            onToggleVisibility = {}
        )
    }
}