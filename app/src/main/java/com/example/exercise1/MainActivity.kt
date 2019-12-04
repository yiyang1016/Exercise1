package com.example.exercise1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.IntegerRes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        findViewById<Button>(R.id.buttonCalculate).setOnClickListener {
            Loan()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener {
            Reset()
        }
    }

    private fun Loan() {
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val payment = findViewById<EditText>(R.id.editTextDownPayment)
        val rate = findViewById<EditText>(R.id.editTextInterestRate)
        val year = findViewById<EditText>(R.id.editTextLoanPeriod)

        val totalCarLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyPay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        val num1: Int = price.text.toString().toInt()
        val num2: Int = payment.text.toString().toInt()
        val num3: Double = rate.text.toString().toDouble()
        val num4: Int = year.text.toString().toInt()

        //CarLoan
        val total1: Int = num1-num2
        totalCarLoan.setText("Loan : RM "+total1.toString())
        //Interest

        val total2: Double = total1*num3*num4
        interest.setText("Interest : RM "+total2.toString())

        //Monthly Repayment
        val total3: Double = (total2+total1)/num4/12
        monthlyPay.setText("Monthly Payment : RM "+total3.toFloat().toString())
    }
    private fun Reset(){
        val price = findViewById<EditText>(R.id.editTextCarPrice)
        val payment = findViewById<EditText>(R.id.editTextDownPayment)
        val rate = findViewById<EditText>(R.id.editTextInterestRate)
        val year = findViewById<EditText>(R.id.editTextLoanPeriod)

        val totalCarLoan = findViewById<TextView>(R.id.textViewLoan)
        val interest = findViewById<TextView>(R.id.textViewInterest)
        val monthlyPay = findViewById<TextView>(R.id.textViewMonthlyRepayment)

        price.setText("")
        payment.setText("")
        year.setText("")
        rate.setText("")
        totalCarLoan.setText("Loan :")
        interest.setText("Interest :")
        monthlyPay.setText("Monthly Repayment :")
    }
}

