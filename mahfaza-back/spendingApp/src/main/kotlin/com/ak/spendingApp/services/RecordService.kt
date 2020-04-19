package com.ak.spendingApp.services

import com.ak.spendingApp.model.Item
import com.ak.spendingApp.model.Record
import com.ak.spendingApp.repository.RecordRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.RequestBody

@Service
class RecordService @Autowired  constructor(private var recordRepository: RecordRepository) {

    fun getAllRecords() = recordRepository.findAll()
    fun getRecord(id:Int)= recordRepository.findById(id).get()
    fun addRecord(record:Record)=recordRepository.save(record)
    fun updateRecord(id: Int,amount: Float,categoryId:Int,itemId:Int,description:String){
       var record= recordRepository.findById(id).get()
        record.amount=amount
        record.categoryId=categoryId
        record.itemId=itemId
        record.description=description
        recordRepository.save(record)

    }

    fun deleteRecord(id: Int)= recordRepository.deleteById(id)
}