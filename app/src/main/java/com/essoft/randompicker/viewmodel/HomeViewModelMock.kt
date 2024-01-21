package com.essoft.randompicker.viewmodel

import com.essoft.randompicker.repo.IFoodRepository

class HomeViewModelMock(foodRepository: IFoodRepository) : HomeViewModel(foodRepository) {
}