package com.ak.spendingApp.services

import com.ak.spendingApp.model.Item
import com.ak.spendingApp.repository.ItemRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ItemService @Autowired  constructor(private var itemRepository : ItemRepository) {

    fun getAllItemsInCategory(categoryId:Int) = itemRepository.findAll().filter { (it.categoryId==categoryId) }
    fun getItem(id:Int)= itemRepository.findById(id).get()
    fun addItemInCategory(categoryId:Int,name:String)=itemRepository.save(Item(categoryId,name))
    fun updateItemName(id: Int, name:String){
       var item = itemRepository.findById(id).get()
        item.itemName=name
        itemRepository.save(item)

    }

    fun deleteItem(id: Int)= itemRepository.deleteById(id)
}