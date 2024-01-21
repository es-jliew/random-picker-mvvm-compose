package com.essoft.randompicker.ui.common

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.essoft.randompicker.R
import com.essoft.randompicker.constants.ColorConstants

@Composable
fun CustomDialog(onDismissRequest: () -> Unit,
                 dialogText: String,
) {
    Dialog(onDismissRequest = { onDismissRequest() }) {
        Card(
            colors = CardDefaults.cardColors(containerColor = Color.Transparent),
            modifier = Modifier
                .fillMaxWidth()
                .background(
                    brush = Brush.horizontalGradient(
                        colors = ColorConstants.Button.GRADIENT_MAIN
                    ),
                    shape = RoundedCornerShape(15.dp)
                )
                .border(
                    width = 1.dp,
                    color = Color.White,
                    shape = RoundedCornerShape(15.dp)
                )
        ) {
            Column(
                modifier = Modifier,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Spacer(modifier = Modifier.padding(top = 16.dp))

                Icon(
                    Icons.Rounded.CheckCircle,
                    contentDescription = "imageDescription",
                    tint = Color.White
                )

                Spacer(modifier = Modifier.padding(top = 16.dp))

                Text(
                    text = stringResource(id = R.string.today_pick),
                    color = Color.White,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.W600,
                )

                Spacer(modifier = Modifier.padding(top = 16.dp))

                Text(
                    text = dialogText,
                    color = Color.White,
                    fontSize = 24.sp,
                )

                Spacer(modifier = Modifier.padding(top = 32.dp))
                
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Button(
                        onClick = { onDismissRequest() },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp, bottom = 16.dp)
                            .background(
                                color = Color.White,
                                shape = RoundedCornerShape(15.dp)
                            ),
                        colors = ButtonDefaults.buttonColors(containerColor = Color.Transparent),
                    ) {
                        Text(
                            color = Color(ColorConstants.Button.GRADIENT_START),
                            text= stringResource(id = R.string.btn_ok)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun PreviewCustomDialog() {
    CustomDialog(
        onDismissRequest = { /*TODO*/ },
        dialogText = "Test Item",
    )
}
