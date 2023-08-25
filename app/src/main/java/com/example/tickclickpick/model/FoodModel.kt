package com.example.tickclickpick.model

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class FoodModel(
    @Id
    var id: Long = 0,
    var name: String? = null,
    var isChecked: Boolean = false
)