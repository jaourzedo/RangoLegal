package com.example.rangolegal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rangolegal.databinding.FragmentSecondBinding
import com.example.rangolegal.databinding.ItemIngredientBinding
import com.example.rangolegal.databinding.ItemPreparationStepBinding

/** Tela 2: exibe os dados da receita cujo ID foi enviado pela lista. */
class SecondFragment : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val recipe = RecipeCatalog.findById(requireArguments().getInt(RecipeCatalog.RECIPE_ID, 1))
        binding.detailImage.setImageResource(recipe.image)
        binding.detailImage.contentDescription = getString(recipe.name)
        binding.detailName.setText(recipe.name)
        binding.detailCategory.setText(recipe.category)
        binding.detailDescription.setText(recipe.description)
        binding.detailTime.setText(recipe.time)
        binding.detailCost.setText(recipe.cost)
        binding.detailServings.setText(recipe.servings)

        binding.ingredientsList.removeAllViews()
        resources.getStringArray(recipe.ingredients).forEach { ingredient ->
            val row = ItemIngredientBinding.inflate(layoutInflater, binding.ingredientsList, false)
            row.ingredientText.text = getString(R.string.ingredient_bullet, ingredient)
            binding.ingredientsList.addView(row.root)
        }
        binding.preparationList.removeAllViews()
        resources.getStringArray(recipe.steps).forEachIndexed { index, instruction ->
            val row = ItemPreparationStepBinding.inflate(layoutInflater, binding.preparationList, false)
            row.stepNumber.text = getString(R.string.step_number, index + 1)
            row.stepDescription.text = instruction
            binding.preparationList.addView(row.root)
        }
        binding.backToRecipes.setOnClickListener { findNavController().navigateUp() }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
