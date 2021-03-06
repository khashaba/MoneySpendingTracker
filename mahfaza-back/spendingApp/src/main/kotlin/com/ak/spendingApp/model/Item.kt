package com.ak.spendingApp.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class Item(var categoryId:Int,var name: String){
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id : Int = 0
}