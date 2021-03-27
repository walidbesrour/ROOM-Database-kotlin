package com.example.roomdatabasekotlin.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasekotlin.data.database.ConfigurationDatabase
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity
import com.example.roomdatabasekotlin.repository.ConfigurationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfigurationVM (application: Application): AndroidViewModel(application){

    private val readAllData: LiveData<List<ConfigurationEntity>>
    private val repository: ConfigurationRepository


    init {
        val configurationDao = ConfigurationDatabase.getDatabase(application).DaoConfiguration()
        repository = ConfigurationRepository(configurationDao)
        readAllData = repository.readAllData
    }

    fun addconfiguration(configurationEntity: ConfigurationEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.addconfiguration(configurationEntity)
        }
    }

}