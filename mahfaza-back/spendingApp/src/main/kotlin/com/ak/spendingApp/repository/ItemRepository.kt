package com.ak.spendingApp.repository

import com.ak.spendingApp.model.Item

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface ItemRepository : CrudRepository<Item,Int>{
}