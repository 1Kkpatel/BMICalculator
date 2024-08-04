package com.example.bmicalculator

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.Dispatchers.Main
import kotlin.math.pow

class MainActivity : AppCompatActivity() {


    private lateinit var edtWeight: EditText
    private lateinit var edtHeightFt: EditText
    private lateinit var edtHeightIn: EditText
    private lateinit var btnCalculate: Button
    private lateinit var txtResult: TextView
    private lateinit var main: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //initialization

        edtWeight=findViewById(R.id.edtWeight)
        edtHeightFt=findViewById(R.id.edtHeightFt)
        edtHeightIn=findViewById(R.id.edtHeightIn)
        btnCalculate=findViewById(R.id.btnCalculate)
        txtResult=findViewById(R.id.txtResult)
        main=findViewById(R.id.main)

        btnCalculate.setOnClickListener {
            //taking the value from the views using the id's
            //change from string to integer
            val wt=edtWeight.text.toString().toInt()
            val ft=edtHeightFt.text.toString().toInt()
            val inch=edtHeightIn.text.toString().toInt()


            val totalIn=ft*12+inch
            val totalCm=totalIn*2.53
            val totalM=totalCm/100

            //calculate BMI
            val bmi=wt/(totalM.pow(2.0))  //for power we use pow()

            if(bmi>25){
                txtResult.text="No need to Feedup"
                main.setBackgroundColor(getColor(R.color.red))
                edtWeight.setTextColor(getColor(R.color.white))
                edtHeightFt.setTextColor(getColor(R.color.white))
                edtHeightIn.setTextColor(getColor(R.color.white))
                btnCalculate.setTextColor(getColor(R.color.white))
                txtResult.setTextColor(getColor(R.color.white))

            }else{
                txtResult.text="Normal"
                main.setBackgroundColor(getColor(R.color.black))
                edtWeight.setTextColor(getColor(R.color.white))
                edtHeightFt.setTextColor(getColor(R.color.white))
                edtHeightIn.setTextColor(getColor(R.color.white))
                btnCalculate.setTextColor(getColor(R.color.white))
                txtResult.setTextColor(getColor(R.color.white))
            }
        }

    }
}