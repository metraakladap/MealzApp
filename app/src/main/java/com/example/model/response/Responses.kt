package com.example.model.response

import com.google.gson.annotations.SerializedName

data class MealsCategoriesResponses(private val categories: List<MealResponse>)

data class MealResponse(
    @SerializedName("idCategory") private val id: String,
    @SerializedName("strCategory") private val name: String,
    @SerializedName("strCategoryDescription") private val description: String,
    @SerializedName("strCategoryThumb") private val imageUrl: String
)