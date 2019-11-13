package com.example.carloancalculator

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalculate.setOnClickListener{
            calculateLoan()
        }

    }

    private fun calculateLoan() {

        if(editTextCarPrice.text.isEmpty()){
            editTextCarPrice.setError(getString(R.string.error_input))
            return
        }



        val carPrice: Int = editTextCarPrice.text.toString().toInt()
        val downPayment: Int = editTextDownPayment.text.toString().toInt()
        val loan: Int = carPrice - downPayment
        val interestRate: Double = editTextInterestRate.text.toString().toDouble()
        val loanPeriod: Int = editTextLoanPeriod.text.toString().toInt()
        val interest: Double = loan * (interestRate/100) * loanPeriod
        val monthlyRepayment: Double = (loan + interest) /loanPeriod /12

        Toast.makeText(this,"Calculate Loan", Toast.LENGTH_SHORT).show()

        textViewLoan.setText(getString(R.string.loan) + "${loan}")
        textViewInterest.setText(getString(R.string.interest) + "${interest}")
        textViewMonthlyRepayment.setText(getString(R.string.monthly_repayment) + "${monthlyRepayment}")


    }

    fun reset(view: View){
        editTextCarPrice.setText("")
        editTextDownPayment.setText("")
        editTextInterestRate.setText("")
        editTextLoanPeriod.setText("")
        textViewLoan.setText(R.string.loan)
        textViewInterest.setText(R.string.interest)
        textViewMonthlyRepayment.setText(R.string.monthly_repayment)

        Toast.makeText(this, "Reset",Toast.LENGTH_SHORT).show()
    }
}
