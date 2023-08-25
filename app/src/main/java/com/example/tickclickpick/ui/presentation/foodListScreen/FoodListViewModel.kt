package com.example.tickclickpick.ui.presentation.foodListScreen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.repo.FoodRepository
import kotlinx.coroutines.launch

class FoodListViewModel(private val foodRepository: FoodRepository): ViewModel(), IFoodListViewModel {
    var foodModelList by mutableStateOf(emptyList<FoodModel>())

    override fun getAllFood() {
        viewModelScope.launch {
            //recipeRepo.getAll(recipeModel as MutableList<RecipeModel>)
            foodRepository.getAllFood().collect { response ->
               foodModelList = response
            }
        }
    }

    override fun addFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.addFood(foodModel)
        }
    }

    override fun removeFood(foodModel: FoodModel) {
        viewModelScope.launch {
            foodRepository.updateFood(foodModel)
        }
    }
}