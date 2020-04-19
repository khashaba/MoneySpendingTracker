package com.ak.spendingApp.controller
import com.ak.spendingApp.model.Category
import com.ak.spendingApp.services.CategoryService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/categories")
@CrossOrigin
class CategoryController @Autowired constructor( private val categoryService: CategoryService) {


    @GetMapping("")
    fun getAllCategories()=ResponseEntity.ok(categoryService.getAllCategories())

    @GetMapping("/{id}")
    fun getCategory(@PathVariable("id") id: String): ResponseEntity<Category> {
        val foundedCategory = categoryService.getCategory( id.toInt())
        return if (foundedCategory!= null) {
           // val corporationInfoResponseDTO = categoryData.toCorporationResponseDto()
            ResponseEntity.ok(foundedCategory)

        } else {
            println("mshmawgod")
            ResponseEntity.notFound().build()

        }
    }

    @PostMapping("")
    fun addCategory(@RequestBody categoryName: String)=categoryService.addCategory(categoryName)
    @PutMapping("/{id}")
    fun updateCategory(@PathVariable("id") id:String, @RequestBody categoryNewName: String)=categoryService.updateCategory(id.toInt(),categoryNewName)
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable("id") id:String)= categoryService.deleteCategory(id.toInt())
}