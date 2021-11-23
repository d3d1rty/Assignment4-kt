package com.example.assignment4

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.assignment4.databinding.ActivityMainBinding
import kotlin.math.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val buttonIds = listOf(
            R.id.button_add, R.id.button_clear, R.id.button_cos, R.id.button_divide, R.id.button_lg,
            R.id.button_log, R.id.button_minus, R.id.button_pow, R.id.button_sin, R.id.button_sqrt,
            R.id.button_square, R.id.button_tan, R.id.button_times
        )

        for(id in buttonIds) {
            binding.root.getViewById(id).setOnClickListener(this)
        }
    }

    override fun onClick(v: View?) {
        val button = v?.getId()

        if (button == R.id.button_clear) {
            binding.edittextX.setText("")
            binding.edittextY.setText("")
            binding.edittextResult.setText("")
            return
        }

        val x = binding.edittextX.text.toString().toDoubleOrNull()
        val y = binding.edittextY.text.toString().toDoubleOrNull()
        val btnsRequireY = listOf(
            R.id.button_add, R.id.button_times, R.id.button_minus, R.id.button_divide,
            R.id.button_pow
        )

        if (x == null) {
            binding.edittextResult.setText("WARNING: the X field is empty")
            return
        } else if (y == null && button in btnsRequireY) {
            binding.edittextResult.setText("WARNING: the Y field is empty")
            return
        }

        val result : String = when(button) {
            R.id.button_add -> "${x} + ${y} = ${(x + y!!).toString()}"
            R.id.button_cos -> "cos(${x}) = ${cos(x).toString()}"
            R.id.button_divide -> "${x} / ${y} = ${(x / y!!).toString()}"
            R.id.button_lg -> "lg(${x}) = ${ln(x).toString()}"
            R.id.button_log -> "log(${x}) = ${log10(x).toString()}"
            R.id.button_minus -> "${x} - ${y} = ${(x - y!!).toString()}"
            R.id.button_pow -> "${x} ^ ${y} = ${x.pow(y!!).toString()}"
            R.id.button_sin -> "sin(${x}) = ${sin(x).toString()}"
            R.id.button_sqrt -> "sqrt(${x}) = ${sqrt(x).toString()}"
            R.id.button_square -> "${x} ^ 2 = ${(x * x).toString()}"
            R.id.button_tan -> "tan(${x}) = ${tan(x).toString()}"
            R.id.button_times -> "${x} * ${y} = ${(x * y!!).toString()}"
            else -> "uh oh stinky"
        }

        binding.edittextResult.setText(result)
        binding.textviewHistory.setText("${result}\n${binding.textviewHistory.text}")
    }
}