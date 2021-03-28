package com.example.roomdatabasekotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.roomdatabasekotlin.data.entity.ConfigurationEntity
import com.example.roomdatabasekotlin.viewmodel.ConfigurationVM
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private lateinit var configurationVM: ConfigurationVM
    lateinit var httptxt : String
    lateinit var localhost1 : String
    lateinit var port1: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configurationVM =  ViewModelProvider(this).get(ConfigurationVM::class.java)
        configurationVM.getconfiguration(this)!!.observe(this, Observer {


            println("$ //////////////////////////{${it[0].hostname}")
            println(" //////////////////////////{${it[0].id}")

        })

        addroom.setOnClickListener {

            httptxt = httpst.text.toString()
            localhost1 = localhost.text.toString()
            port1 = port.text.toString()


            var a =      ConfigurationEntity(1, httptxt, localhost1, port1)
            configurationVM.updateconfiguration(a)
            configurationVM.getconfiguration(this)!!.observe(this, Observer {


                println("$httptxt //////////////////////////{${it[0].hostname}")
                println("$httptxt //////////////////////////{${it[0].id}")

            })

        }
    }
}