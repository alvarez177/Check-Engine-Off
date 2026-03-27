package com.bold.core.presentation.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun OutlinePhoneTextField(
    modifier: Modifier = Modifier,
    value: String,
    hint: String = "Phone number",
    errorMessage: String? = null,
    keyboardOptions: KeyboardOptions = KeyboardOptions(
        keyboardType = KeyboardType.Phone,
        imeAction = ImeAction.Next
    ),
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = value,
        onValueChange = { input ->
            val filtered = input.filter { it.isDigit() }
            onValueChange(filtered)
        },
        label = { Text(hint) },
        singleLine = true,
        isError = errorMessage != null,
        supportingText = {
            if (errorMessage != null) {
                Text(
                    text = errorMessage,
                    color = MaterialTheme.colorScheme.error
                )
            }
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,

        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Phone,
                contentDescription = "Phone icon"
            )
        },

        shape = RoundedCornerShape(12.dp)
    )
}

@Preview(showBackground = true)
@Composable
fun OutlinePhoneTextFieldPreview() {
    OutlinePhoneTextField(
        value = "",
        onValueChange = {}
    )
}