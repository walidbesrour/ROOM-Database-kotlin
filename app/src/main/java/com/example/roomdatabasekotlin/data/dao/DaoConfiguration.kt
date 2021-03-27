package com.example.roomdatabasekotlin.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity

interface DaoConfiguration {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addconfiguration(configuration: ConfigurationEntity)

    @Query("SELECT * FROM configuration_table")
    fun readAllData(): LiveData<List<ConfigurationEntity>>

}
