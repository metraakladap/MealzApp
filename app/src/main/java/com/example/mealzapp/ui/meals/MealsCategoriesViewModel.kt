package com.example.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.example.model.MealsRepository
import com.example.model.response.MealResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(): List<MealResponse>{
        return repository.getMeals().categories
    }
}