package com.example.roomdatabasekotlin.data.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity

@Dao
interface DaoConfiguration {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addconfiguration(configuration: ConfigurationEntity)

    @Update
    suspend fun updateconfiguration(configuration: ConfigurationEntity)

    @Query("SELECT * FROM configuration_table")
    fun readAllData(): LiveData<List<ConfigurationEntity>>

}
