package com.example.proyecto6

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.proyecto6.databinding.ActivityMainBinding
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.ColorTemplate

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var cadena: String = ""
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var myChart: PieChart = binding.pieChart1

        var dataList: ArrayList<PieEntry> = arrayListOf()

        //val cadena = binding.Entrada.text.split(",")

        for(i in 0 until 5){
            dataList.add(PieEntry((Math.random() *5+5).toFloat()))
        }

        /*for(a in 0 until cadena.size){
            dataList.add(PieEntry(cadena[a].toFloat()))
        }*/

        val colors = ArrayList<Int>()

        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)


        var dataSet = PieDataSet(dataList, "Resultados")
        dataSet.setColors(colors)
        dataSet.setValueTextSize(20f)
        dataSet.setValueFormatter(PercentFormatter())
        dataSet.setValueTextColor(Color.WHITE)

        var data = PieData(dataSet)
        myChart.setData(data)

        binding.buttonC.setOnClickListener{
            dataList.clear()
            val cadena = binding.Entrada.text.split(",")

            for(a in 0 until cadena.size){
                dataList.add(PieEntry(cadena[a].toFloat()))
            }

            dataSet = PieDataSet(dataList, "Resultados")
            dataSet.setColors(colors)
            dataSet.setValueTextSize(20f)
            dataSet.setValueFormatter(PercentFormatter())
            dataSet.setValueTextColor(Color.WHITE)

            data = PieData(dataSet)
            myChart.setData(data)
            binding.Entrada.text.clear()
        }
    }



    }