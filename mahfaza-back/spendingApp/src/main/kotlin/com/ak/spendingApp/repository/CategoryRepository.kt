package com.ak.spendingApp.repository

import com.ak.spendingApp.model.Category

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface CategoryRepository : CrudRepository<Category,Int >{

}