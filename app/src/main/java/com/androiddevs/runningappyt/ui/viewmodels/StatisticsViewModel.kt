package com.androiddevs.runningappyt.ui.viewmodels

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import com.androiddevs.runningappyt.repository.MainRepository
import javax.inject.Inject

class StatisticsViewModel @ViewModelInject constructor(
    val minRepository: MainRepository
):ViewModel() {
}