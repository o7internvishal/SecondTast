package com.example.secondtast

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.NavController

import androidx.navigation.fragment.NavHostFragment

class MainActivity : AppCompatActivity() {
   private lateinit var navController: NavController
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//        val navHostFragment = supportFragmentManager
//            .findFragmentById(R.id.fragment) as NavHostFragment
//        navController = navHostFragment.navController
        val navHostFragment=supportFragmentManager
            .findFragmentById(R.id.fragment)as NavHostFragment
        navController=navHostFragment.navController
//        findNavController().navigate(R.id.addFragment)

    }
}