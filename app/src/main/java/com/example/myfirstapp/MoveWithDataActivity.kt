package com.example.myfirstapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MoveWithDataActivity : AppCompatActivity() {

    /* Const/Konstanta yaitu sebuah variabel yang nilainya tetap,
    biasanya digunakan sebagai key(kunci) yang dipakai untuk mengirim dan menerima data. sebelum onCreate */
    companion object {
        const val EXTRA_AGE = "extra_ege"
        const val EXTRA_NAME = "extra_name"
    }

    //Navigation Drawer
    lateinit var toggle: ActionBarDrawerToggle

    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_move_with_data)

        supportActionBar?.title = "Rekomendasi Baju"

    }

}