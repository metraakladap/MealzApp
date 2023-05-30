package com.example.mealzapp.ui.meals

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.model.MealsRepository
import com.example.model.response.MealResponse
import com.example.model.response.MealsCategoriesResponses
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) :
    ViewModel() {

    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch() {
            val meals = getMeals()
            mealsState.value = meals
        }
    }


    val mealsState: MutableState<List<MealResponse>> = mutableStateOf(emptyList<MealResponse>())

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }

    private suspend fun getMeals(): List<MealResponse> {
        return repository.getMeals().categories
    }
}