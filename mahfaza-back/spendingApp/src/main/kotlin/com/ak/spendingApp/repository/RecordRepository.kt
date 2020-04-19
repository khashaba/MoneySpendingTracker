package com.ak.spendingApp.repository

import com.ak.spendingApp.model.Record

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository


@Repository
interface RecordRepository : CrudRepository<Record,Int>{
}