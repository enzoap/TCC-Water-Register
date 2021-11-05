package com.unip.tcc.welcome.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
    }

    private fun observer(){
        welcomeViewModel.info.observe(
            this,
            { action ->
                when (action) {
                    is WelcomeViewAction.Error -> TODO()
                    is WelcomeViewAction.HideLoading -> TODO()
                    is WelcomeViewAction.ShowLoading -> TODO()
                    is WelcomeViewAction.Success -> showInfo(action.info)
                }
            }
        )
    }

    private fun showInfo(entity: WaterConsumptionEntity) {
    }
}