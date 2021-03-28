package com.example.roomdatabasekotlin.viewmodel

import android.app.Application
import android.content.Context
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.roomdatabasekotlin.data.database.ConfigurationDatabase
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity
import com.example.roomdatabasekotlin.repository.ConfigurationRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ConfigurationVM (application: Application): AndroidViewModel(application){

     var readAllData: LiveData<List<ConfigurationEntity>>
     val repository: ConfigurationRepository


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

    fun updateconfiguration(configurationEntity: ConfigurationEntity){
        viewModelScope.launch(Dispatchers.IO) {
            repository.updateconfiguration(configurationEntity)
        }
    }

    fun getconfiguration(context: Context) : LiveData<List<ConfigurationEntity>>? {

        readAllData = repository.readAllData
        return readAllData
    }

}