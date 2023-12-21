package com.example.tickclickpick.ui.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun CustomDialog(onDismissRequest: () -> Unit,
                 onConfirmation: () -> Unit,
                 dialogTitle: String,
                 dialogText: String,
                 icon: ImageVector,
) {
    AlertDialog(
        icon = {
            Icon(icon, contentDescription = "Example Icon")
        },
        title = {
            Text(text = dialogTitle)
        },
        text = {
            Text(text = dialogText)
        },
        onDismissRequest = {
            onDismissRequest()
        },
        confirmButton = {
            TextButton(
                onClick = {
                    onConfirmation()
                }
            ) {
                Text("Confirm")
            }
        },
        dismissButton = {
            TextButton(
                onClick = {
                    onDismissRequest()
                }
            ) {
                Text("Dismiss")
            }
        }
    )
}

@Preview
@Composable
fun PreviewCustomDialog() {
    CustomDialog(
        onDismissRequest = { /*TODO*/ },
        onConfirmation = { /*TODO*/ },
        dialogTitle = "Test",
        dialogText = "Test",
        icon = Icons.Default.Info
    )
}
