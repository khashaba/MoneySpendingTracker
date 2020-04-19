package com.ak.spendingApp.model

import java.util.*
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Record(var amount: Float,var categoryId:Int, var itemId: Int, var description:String, val date:Date){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0


}