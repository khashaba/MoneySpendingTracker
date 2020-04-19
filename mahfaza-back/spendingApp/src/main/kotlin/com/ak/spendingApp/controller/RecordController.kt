package com.ak.spendingApp.controller
import com.ak.spendingApp.model.Item
import com.ak.spendingApp.model.Record
import com.ak.spendingApp.services.ItemService
import com.ak.spendingApp.services.RecordService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/record")
@CrossOrigin
class RecordController @Autowired constructor(private val recordService: RecordService) {


    @GetMapping("/")
    fun getAllRecords()=ResponseEntity.ok(recordService.getAllRecords())

    @GetMapping("/{id}")
    fun getRecord(@PathVariable("id") id: String): ResponseEntity<Record> {
        val foundedRecord = recordService.getRecord( id.toInt())
        return if (foundedRecord!= null) {
            ResponseEntity.ok(foundedRecord)

        } else {
            ResponseEntity.notFound().build()

        }
    }

    @PostMapping("/")
    fun addRecord(@RequestBody record:Record )=recordService.addRecord(record)
    //@PutMapping("/{id}")
   // fun updateRecord(@PathVariable("id") id:String,@RequestBody amount: String,@RequestBody name: String,@RequestBody categoryId: String,@RequestBody itemId: String,@RequestBody description: String )=recordService.updateRecord(id = id.toInt(),amount = amount.toFloat(),categoryId = categoryId.toInt(),itemId = itemId.toInt(),description = description)
    @DeleteMapping("/{id}")
    fun deleteRecord(@PathVariable("id") id:String)= recordService.deleteRecord(id.toInt())
}