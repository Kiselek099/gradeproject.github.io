package com.example.grade

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    private lateinit var textET: EditText
    private lateinit var randomNumBTN: Button
    private lateinit var randomNumTV: TextView

    @SuppressLint("MissingInflatedId")
    private var currentViewId: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        textET = findViewById(R.id.textET)
        registerForContextMenu(textET)
        randomNumBTN = findViewById(R.id.randomNumBTN)
        randomNumTV = findViewById(R.id.randomNumTV)
        randomNumBTN.setOnClickListener {
            randomNumTV.text = Random.nextInt(1, 50).toString()
        }
        registerForContextMenu(randomNumTV)

    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        currentViewId = v?.id ?: 0
        menuInflater.inflate(R.menu.context_menu, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        when (currentViewId) {
            R.id.textET->changeColorForET(item)
            R.id.randomNumTV->changeColorForRandomTV(item)
            else -> return super.onContextItemSelected(item)
        }
        return true
    }
    private fun changeColorForET(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_color_quality -> {
                when (textET.text.toString()) {
                    "1" -> {
                        textET.setBackgroundColor(getColor(R.color.orange))
                        Toast.makeText(this, "Цвет изменен на оранжевый", Toast.LENGTH_SHORT).show()
                    }

                    "2" -> {
                        textET.setBackgroundColor(getColor(R.color.yellow))
                        Toast.makeText(this, "Цвет изменен на желтый", Toast.LENGTH_SHORT).show()
                    }

                    "3" -> {
                        textET.setBackgroundColor(getColor(R.color.green))
                        Toast.makeText(this, "Цвет изменен на зеленый", Toast.LENGTH_SHORT).show()
                    }

                    "4" -> {
                        textET.setBackgroundColor(getColor(R.color.blue))
                        Toast.makeText(this, "Цвет изменен на синий", Toast.LENGTH_SHORT).show()
                    }

                    "5" -> {
                        textET.setBackgroundColor(getColor(R.color.red))
                        Toast.makeText(this, "Цвет изменен на красный", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        textET.setBackgroundColor(getColor(R.color.white))
                        Toast.makeText(this, "Цвет изменен на белый", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            R.id.menu_exit -> {
                finish()
                Toast.makeText(this, "Выход из приложения", Toast.LENGTH_LONG).show()
            }
        }
    }
    private fun changeColorForRandomTV(item: MenuItem) {
        when (item.itemId) {
            R.id.menu_color_quality -> {
                when (randomNumTV.text.toString().toIntOrNull()) {
                    in 1..10 -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.red))
                        Toast.makeText(this, "Цвет изменен на красный", Toast.LENGTH_SHORT).show()
                    }

                    in 11..20 -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.orange))
                        Toast.makeText(this, "Цвет изменен на оранжевый", Toast.LENGTH_SHORT).show()
                    }

                    in 21..30 -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.yellow))
                        Toast.makeText(this, "Цвет изменен на желтый", Toast.LENGTH_SHORT).show()
                    }

                    in 31..40 -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.green))
                        Toast.makeText(this, "Цвет изменен на зеленый", Toast.LENGTH_SHORT).show()
                    }

                    in 41..50 -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.blue))
                        Toast.makeText(this, "Цвет изменен на синий", Toast.LENGTH_SHORT).show()
                    }

                    else -> {
                        randomNumTV.setBackgroundColor(getColor(R.color.white))
                        Toast.makeText(this, "Цвет изменен на белый", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            R.id.menu_exit -> {
                finish()
                Toast.makeText(this, "Выход из приложения", Toast.LENGTH_LONG).show()
            }
        }
    }
}
