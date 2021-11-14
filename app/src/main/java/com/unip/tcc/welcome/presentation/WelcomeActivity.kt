package com.unip.tcc.welcome.presentation

import android.graphics.drawable.GradientDrawable
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.unip.tcc.databinding.ActivityWelcomeBinding
import com.unip.tcc.welcome.domain.entity.WaterConsumptionEntity
import kotlinx.coroutines.InternalCoroutinesApi
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.components.Description
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry
import com.github.mikephil.charting.components.XAxis
import com.github.mikephil.charting.components.YAxis
import com.github.mikephil.charting.components.AxisBase

import com.github.mikephil.charting.formatter.ValueFormatter










@InternalCoroutinesApi
class WelcomeActivity : AppCompatActivity() {
    private val welcomeViewModel: WelcomeViewModel by viewModel()
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }
    private lateinit var barChart:BarChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observer()
        update()
        setupGrafico()
    }

    private fun observer(){
        welcomeViewModel.info.observe(
            this,
            { action ->
                when (action) {
                    is WelcomeViewAction.Error -> showViewError()
                    is WelcomeViewAction.HideLoading -> hideLoading()
                    is WelcomeViewAction.ShowLoading -> showLoading()
                    is WelcomeViewAction.Success -> showInfo(action.info, action.circleColor, action.stringRes)
                }
            }
        )
    }

    private fun showLoading() {
        binding.loading.visibility = View.VISIBLE
    }

    private fun showViewError() {
        with(binding) {
            viewSemDados.visibility = View.VISIBLE
            viewPrincipal.visibility = View.GONE
        }
    }

    private fun hideLoading() {
        binding.loading.visibility = View.GONE
    }

    private fun showInfo(entity: WaterConsumptionEntity, circleColor: Int, message: Int) {
        with(binding) {
            gastoAtual.text = "${entity.qtdToday} litros"
            gastoAnterior.text = "${entity.qtdYesterday} litros"
            mensagemPrincipal.text = getString(message)
            val circle = circle.background as GradientDrawable
            circle.setStroke(20, ContextCompat.getColor(this@WelcomeActivity, circleColor))
        }
        showView()
        showBarChart(entity)
    }

    private fun showView() {
        with(binding) {
            viewSemDados.visibility = View.GONE
            viewPrincipal.visibility = View.VISIBLE
        }
    }

    private fun setupGrafico(){
        barChart = binding.grafico
    }

    private fun showBarChart(entity: WaterConsumptionEntity) {

        val valueList = ArrayList<Float>()
        val entries: ArrayList<BarEntry> = ArrayList()
        val title = "Vazão em litros"
        val xAxisLabel: ArrayList<String> = ArrayList()

        //input data
        for (element in entity.week) {

            valueList.add( element.quantity.toFloat())
            xAxisLabel.add(element.date)
        }

        //fit the data into a bar
        for (i in 0 until valueList.size) {
            val barEntry = BarEntry(i.toFloat(), valueList[i])
            entries.add(barEntry)
        }
        val barDataSet = BarDataSet(entries, title)
        barDataSet.valueTextSize = 12f
        barChart.setDrawGridBackground(false)
        barChart.setDrawBarShadow(false)
        barChart.setDrawBorders(false)

        val description = Description()
        description.isEnabled = false
        barChart.description = description

        barChart.animateY(1000);
        val xAxis = barChart.xAxis
        xAxis.setDrawGridLines(false);
        xAxis.setDrawAxisLine(false);
        xAxis.position = XAxis.XAxisPosition.BOTTOM
        xAxis.isGranularityEnabled = true;

        val formatter: ValueFormatter = object : ValueFormatter() {
            override fun getFormattedValue(value: Float): String {
                return xAxisLabel[value.toInt()]
            }
        }
        xAxis.valueFormatter = formatter
        xAxis.granularity = 1f


        val rightAxis = barChart.axisRight
        rightAxis.isEnabled = false

        val data = BarData(barDataSet)
        barChart.data = data
        barChart.invalidate()

    }

    private fun update() {
        binding.btnAtualizar.setOnClickListener {
            welcomeViewModel.getInfo()
        }
    }

    private fun xLabel() {

    }


}

