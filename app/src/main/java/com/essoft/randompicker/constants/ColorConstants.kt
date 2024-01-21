package com.essoft.randompicker.constants

import androidx.compose.ui.graphics.Color

object ColorConstants {
    //Custom colors
    object Button {
        const val BORDER = 0xFFF4F4F4
        const val GRADIENT_START = 0xFF53E88B
        const val GRADIENT_END = 0xFF15BE77

        val GRADIENT_MAIN = listOf(Color(GRADIENT_START), Color(GRADIENT_END))
        val GRADIENT_SUB = listOf(Color.White.copy(0.1f), Color.White.copy(0.1f),)
    }

    const val BACKGROUND = 0xFF0D0D0D
    const val BACKGROUND_TOP = 0xFF0D0D0D
}