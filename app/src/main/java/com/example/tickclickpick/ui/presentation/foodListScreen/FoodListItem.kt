package com.example.tickclickpick.ui.presentation.foodListScreen

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.ui.theme.AppTheme

@Composable
fun FoodListItem(foodModel: FoodModel, onRemoveClick:() -> Unit) {
    Card(
        modifier = Modifier
            .wrapContentHeight()
            .fillMaxWidth()
            .padding(20.dp, 5.dp)
    ) {
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(24.dp, 6.dp)
        ) {
            Checkbox(
                checked = foodModel.isChecked,
                onCheckedChange = { foodModel.isChecked = it },
                modifier = Modifier.padding(end = 8.dp)
            )

            Text(
                text = foodModel.name.toString(),
                fontSize = 24.sp,
                //fontFamily = FontFamily(Font(R.font.playfair_display_regular)),
            )

            IconButton(
                onClick = onRemoveClick
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    contentDescription = "Remove",
                    tint = Color.Red
                )
            }
            /*Text(
                text = recipeModel.instructions.toString(),
                //fontFamily = FontFamily(Font(R.font.plus_jakarta_sans_regular)),
                lineHeight = 17.sp
            )*/
        }
    }
}

@Preview
@Composable
fun PreviewFoodListItem() {
    AppTheme {
        FoodListItem(foodModel = FoodModel(id = 0, name = "Preview text")) {

        }
    }
}