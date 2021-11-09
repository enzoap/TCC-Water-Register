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

@InternalCoroutinesApi
class WelcomeActivity : AppCompatActivity() {
    private val welcomeViewModel: WelcomeViewModel by viewModel()
    private val binding by lazy {
        ActivityWelcomeBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        observer()
        update()
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
            circle.setStroke(10, ContextCompat.getColor(this@WelcomeActivity, circleColor))
        }
        showView()
    }

    private fun showView() {
        with(binding) {
            viewSemDados.visibility = View.GONE
            viewPrincipal.visibility = View.VISIBLE
        }
    }

    private fun update() {
        binding.btnAtualizar.setOnClickListener {
            welcomeViewModel.getInfo()
        }
    }
}