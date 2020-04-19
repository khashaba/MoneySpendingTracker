package com.ak.spendingApp.services

import com.ak.spendingApp.model.Category
import com.ak.spendingApp.repository.CategoryRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class CategoryService @Autowired  constructor( private var categoryRepository : CategoryRepository) {

    fun getAllCategories() = categoryRepository.findAll()
    fun getCategory(id:Int): Category {
        return categoryRepository.findById(id).get()
    }
    fun addCategory(name:String)=categoryRepository.save(Category(name))
    fun updateCategory(id: Int, name:String){
       var category = categoryRepository.findById(id).get()
        category.categoryName=name
        categoryRepository.save(category)

    }

    fun deleteCategory(id: Int)= categoryRepository.deleteById(id)
}