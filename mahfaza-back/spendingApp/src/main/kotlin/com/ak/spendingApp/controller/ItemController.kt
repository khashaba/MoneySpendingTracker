package com.ak.spendingApp.controller
import com.ak.spendingApp.model.Item
import com.ak.spendingApp.services.ItemService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/items")
@CrossOrigin
class ItemController @Autowired constructor(private val itemService: ItemService) {


    @GetMapping("/category/{id}")
    fun getAllItemsInCategory(@PathVariable("id") id:String)=ResponseEntity.ok(itemService.getAllItemsInCategory(id.toInt()))

    @GetMapping("/{id}")
    fun getItem(@PathVariable("id") id: String): ResponseEntity<Item> {
        val foundedItem = itemService.getItem( id.toInt())
        return if (foundedItem!= null) {
           // val corporationInfoResponseDTO = categoryData.toCorporationResponseDto()
            ResponseEntity.ok(foundedItem)

        } else {
            ResponseEntity.notFound().build()

        }
    }

    @PostMapping("category/{id}")
    fun addItemInCategory(@PathVariable("id") id:String,@RequestBody itemName: String)=itemService.addItemInCategory(id.toInt(),itemName)
    @PutMapping("/{id}")
    fun updateItem(@PathVariable("id") id:String, @RequestBody itemNewName: String)=itemService.updateItemName(id.toInt(),itemNewName)
    @DeleteMapping("/{id}")
    fun deleteCategory(@PathVariable("id") id:String)= itemService.deleteItem(id.toInt())
}