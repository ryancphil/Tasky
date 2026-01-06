package com.ryanphillips.tasky.auth.presentation

import androidx.compose.foundation.text.input.TextFieldState

data class RegisterState(
    val name: TextFieldState = TextFieldState(),
    val email: TextFieldState = TextFieldState(),
    val password: TextFieldState = TextFieldState()
)
