package com.example.myfirstapp

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var edtPanjang: EditText
    private lateinit var edtLebar: EditText
    private lateinit var btnHitung: Button
    private lateinit var tvHasil: TextView

    //Navigation Drawer
    lateinit var toggle: ActionBarDrawerToggle

    companion object {
        private const val STATE_RESULT = "state_result"
    }

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportActionBar?.title = "Kloths"


        // akhir

        /* Pindah Aktivity Explicit Intent*/
        val btnMoveActivity: Button = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)


        edtPanjang = findViewById(R.id.edt_panjang)
        edtLebar = findViewById(R.id.edt_lebar)
        btnHitung = findViewById(R.id.btn_hitung)
        tvHasil = findViewById(R.id.tv_hasil)

        btnHitung.setOnClickListener(this)

        if (savedInstanceState !=null){
            val result = savedInstanceState.getString(STATE_RESULT)
            tvHasil.text = result
        }
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_RESULT, tvHasil.text.toString())
    }

    //Navigation Drawer
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)){
            return true
        }

        return super.onOptionsItemSelected(item)
    }
    // nav_akhir

    override fun onClick(p0: View?) {
        if (p0?.id == R.id.btn_hitung) {
            val inputPanjang = edtPanjang.text.toString().trim()
            val inputLebar = edtLebar.text.toString().trim()


            var isEmptyFields = false

            if (inputPanjang.isEmpty()) {
                isEmptyFields = true
                edtPanjang.error = "Field ini tidak boleh kosong"
            }

            if (inputLebar.isEmpty()) {
                isEmptyFields = true
                edtLebar.error = "Field ini tidak boleh kosong"
            }

        }
        val hasil = edtPanjang.text.toString().toInt() * edtLebar.text.toString().toInt()
        tvHasil.text = hasil.toString()
        /* Tombol Klik Pindah Aktivity Explicit Intent*/
        when (p0?.id) {
            R.id.btn_move_activity -> {
                /*memberikan context (this@MainActivity) dan kelas activity tujuan (MoveActivity::class.java) pada konstruktor kelas intent. */
                val pindahIntent = Intent(this@MainActivity, MoveActivity::class.java)
                startActivity(pindahIntent)
            }
        }
    }
}