package com.example.tickclickpick.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tickclickpick.model.DbResult
import com.example.tickclickpick.model.DialogState
import com.example.tickclickpick.model.FoodModel
import com.example.tickclickpick.repo.IFoodRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

open class HomeViewModel(private val foodRepository: IFoodRepository): ViewModel(), IHomeViewModel {
    private val _foodModelList = mutableStateOf(emptyList<FoodModel>())
    private val foodModelList: List<FoodModel> get() = _foodModelList.value

    private val _dialogState = mutableStateOf(DialogState())

    private val dialogState = _dialogState.value

    private var foodName: String = ""

    override fun retrieveAllFood() {
        viewModelScope.launch(Dispatchers.IO)  {
            foodRepository.retrieveAllFood().collect { response ->
                updateFoodModelList(response)
            }
        }
    }

    override fun createFood() {
        if(foodName.isNotEmpty()) {
            val foodModel = FoodModel(name = foodName, isChecked = false)

            viewModelScope.launch {
                try {
                    foodRepository.createFood(foodModel)
                } catch (e: Exception) {
                    DbResult.Failure("An error occurred: ${e.message}")
                }
            }
        }
    }

    override fun deleteFood(foodModel: FoodModel) {
        viewModelScope.launch(Dispatchers.IO) {
            val dbResult = try {
                if (foodRepository.deleteFood(foodModel)) {
                    DbResult.Success
                } else {
                    DbResult.Failure("Failed to delete food.")
                }
            } catch (e: Exception) {
                DbResult.Failure("An error occurred: ${e.message}")
            }

            withContext(Dispatchers.Main) {
                handleDeleteFoodResult(dbResult)
            }
        }
    }

    override fun pickFood() {
        if(_foodModelList.value.isNotEmpty()) {
            val checkedFoodList = _foodModelList.value.filter { it.isChecked }

            if (checkedFoodList.isNotEmpty()) {
                val randomIndex = (checkedFoodList.indices).random()

                _dialogState.value = DialogState(true, checkedFoodList[randomIndex].name!!)
            } else {
                _dialogState.value = DialogState(true, "Empty List")
            }
        }
    }

    override fun getFoodList(): MutableState<List<FoodModel>> {
        return _foodModelList
    }

    override fun getDialogState(): MutableState<DialogState> {
        return _dialogState
    }

    override fun resetDialogState() {
        _dialogState.value = DialogState(false, "")
    }

    override fun setFoodName(foodName: String) {
        this.foodName = foodName
    }

    override fun createDemoFood() {
        viewModelScope.launch {
            foodRepository.createDemoFood()
        }
    }

    override fun updateFoodModel(updatedFoodModel: FoodModel) {
        viewModelScope.launch(Dispatchers.IO) {
            foodRepository.updateFood(updatedFoodModel)
        }
    }

    private fun updateFoodModelList(newList: List<FoodModel>) {
        _foodModelList.value = newList
    }

    private fun handleDeleteFoodResult(dbResult: DbResult) {
        when (dbResult) {
            is DbResult.Success -> {
                // TODO: Handle success
            }
            is DbResult.Failure -> {
                // TODO: Handle failure
            }
        }
    }
}