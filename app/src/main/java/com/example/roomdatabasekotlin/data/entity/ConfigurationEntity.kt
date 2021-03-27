package com.example.roomdatabasekotlin.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "configuration_table")
data class ConfigurationEntity (

    val hostname: String,
    val protocol: String,
    val age:  String
)