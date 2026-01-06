package com.ryanphillips.tasky.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.text.input.TextFieldLineLimits
import androidx.compose.foundation.text.input.TextFieldState
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.PreviewLightDark
import androidx.compose.ui.unit.dp
import com.ryanphillips.tasky.core.designsystem.theme.CheckmarkIcon
import com.ryanphillips.tasky.core.designsystem.theme.Green1
import com.ryanphillips.tasky.core.designsystem.theme.Green2
import com.ryanphillips.tasky.core.designsystem.theme.TaskyTheme

@Composable
fun TaskyTextField(
    modifier: Modifier = Modifier,
    state: TextFieldState,
    hint: String,
    showError: Boolean = false,
    keyboardType: KeyboardType = KeyboardType.Text,
    trailingIcon: ImageVector? = null
) {
    var isFocused by remember {
        mutableStateOf(false)
    }
    BasicTextField(
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
                    if (showError) {
                        MaterialTheme.colorScheme.error
                    } else {
                        Color.Transparent
                    }
                },
                shape = RoundedCornerShape(10.dp)
            )
            .padding(20.dp)
            .onFocusChanged {
                isFocused = it.isFocused
            },
        state = state,
        lineLimits = TextFieldLineLimits.SingleLine,
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = ImeAction.Next
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
                            text = hint,
                            style = MaterialTheme.typography.bodyMedium,
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    }
                    innerBox()
                }

                trailingIcon?.let {
                    if (!showError) {
                        TrailingCheckmark()
                    }
                }
            }
        },
    )
}

@Composable
private fun TrailingCheckmark() {
    Icon(
        imageVector = CheckmarkIcon,
        contentDescription = "",
        tint = if (isSystemInDarkTheme()) Green2 else Green1
    )
}

@PreviewLightDark
@Composable
private fun TaskTextFieldPreview() {
    TaskyTheme {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) { // Default - Empty
            TaskyTextField(
                state = TextFieldState(initialText = ""),
                hint = "Name"
            )
            Spacer(modifier = Modifier.height(5.dp)) // Valid Text
            TaskyTextField(
                state = TextFieldState(initialText = "First Last"),
                hint = "Name",
                trailingIcon = CheckmarkIcon
            )
            Spacer(modifier = Modifier.height(5.dp)) // Error state
            TaskyTextField(
                state = TextFieldState(initialText = "First Last"),
                hint = "Name",
                showError = true,
                trailingIcon = CheckmarkIcon
            )
        }
    }
}