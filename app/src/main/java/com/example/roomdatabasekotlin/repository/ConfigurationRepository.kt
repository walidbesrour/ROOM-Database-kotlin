package com.example.roomdatabasekotlin.repository

import androidx.lifecycle.LiveData
import com.example.roomdatabasekotlin.data.dao.DaoConfiguration
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity

class ConfigurationRepository(private val daoConfiguration: DaoConfiguration) {

    val readAllData: LiveData<List<ConfigurationEntity>> = daoConfiguration.readAllData()

    suspend fun addconfiguration(Configuration: ConfigurationEntity){
        daoConfiguration.addconfiguration(Configuration)
    }
}