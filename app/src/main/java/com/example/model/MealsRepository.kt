package com.example.model

import com.example.model.api.MealsWebService
import com.example.model.response.MealsCategoriesResponses

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {
    fun getMeals(): MealsCategoriesResponses? {
        return webService.getMeals().execute().body() // Bad practice
    }
}