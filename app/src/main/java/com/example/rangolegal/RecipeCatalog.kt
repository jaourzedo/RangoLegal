package com.example.rangolegal

/** Dados locais; os custos são exemplos referentes à receita inteira. */
data class Recipe(
    val id: Int,
    val name: Int,
    val description: Int,
    val category: Int,
    val time: Int,
    val cost: Int,
    val servings: Int,
    val image: Int,
    val ingredients: Int,
    val steps: Int
)

object RecipeCatalog {
    const val RECIPE_ID = "recipe_id"

    val recipes = listOf(
        Recipe(1, R.string.omelet_title, R.string.omelet_description, R.string.omelet_category,
            R.string.omelet_time, R.string.omelet_cost, R.string.omelet_servings,
            R.drawable.recipe_omelet, R.array.omelet_ingredients, R.array.omelet_steps),
        Recipe(2, R.string.pasta_title, R.string.pasta_description, R.string.pasta_category,
            R.string.pasta_time, R.string.pasta_cost, R.string.pasta_servings,
            R.drawable.recipe_pasta, R.array.pasta_ingredients, R.array.pasta_steps),
        Recipe(3, R.string.pancakes_title, R.string.pancakes_description, R.string.pancakes_category,
            R.string.pancakes_time, R.string.pancakes_cost, R.string.pancakes_servings,
            R.drawable.recipe_pancakes, R.array.pancakes_ingredients, R.array.pancakes_steps)
    )

    fun findById(id: Int): Recipe = recipes.firstOrNull { it.id == id } ?: recipes.first()
}
