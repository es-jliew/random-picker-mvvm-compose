package com.example.tickclickpick.ui.presentation.homeScreen

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SearchBar
import androidx.compose.material3.SearchBarDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeSearchBar() {
    SearchBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 24.dp),
        query = "AAA AAA",
        onQueryChange = {},
        onSearch = {},
        active = false,
        onActiveChange = {},
        shape = RoundedCornerShape(15.dp),
        colors = SearchBarDefaults.colors(
            containerColor = Color.White.copy(alpha = 0.1f),
            inputFieldColors = TextFieldDefaults.colors(
                unfocusedTextColor = Color.White.copy(alpha = 0.4f),
                unfocusedLeadingIconColor = Color.White,
                unfocusedTrailingIconColor = Color.White
            )
        ),
        placeholder = { Text("Hinted search text") },
        leadingIcon = { Icon(Icons.Default.Search, contentDescription = null) },
        trailingIcon = { Icon(Icons.Default.MoreVert, contentDescription = null) },
    ) {}
}

@Preview
@Composable
fun PreviewHomeSearchBar() {
    HomeSearchBar()
}