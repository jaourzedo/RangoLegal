package com.example.rangolegal

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.rangolegal.databinding.FragmentFirstBinding
import com.example.rangolegal.databinding.ItemRecipeBinding

/** Tela 1: lista local de receitas, com cartões definidos em XML. */
class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recipeList.removeAllViews()
        RecipeCatalog.recipes.forEach { recipe ->
            val item = ItemRecipeBinding.inflate(layoutInflater, binding.recipeList, false)
            item.recipeImage.setImageResource(recipe.image)
            item.recipeImage.contentDescription = getString(recipe.name)
            item.recipeName.setText(recipe.name)
            item.recipeTime.setText(recipe.time)
            item.recipeCost.setText(recipe.cost)
            item.root.contentDescription = getString(R.string.open_recipe,
                getString(recipe.name), getString(recipe.time), getString(recipe.cost))
            item.root.setOnClickListener {
                findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment,
                    bundleOf(RecipeCatalog.RECIPE_ID to recipe.id))
            }
            binding.recipeList.addView(item.root)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
