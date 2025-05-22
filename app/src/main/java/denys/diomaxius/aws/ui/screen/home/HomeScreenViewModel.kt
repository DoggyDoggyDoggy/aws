package denys.diomaxius.aws.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import denys.diomaxius.aws.data.model.SoilMoisture
import denys.diomaxius.aws.data.repository.SoilRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val soilRepository: SoilRepository
) : ViewModel() {
    private val _soilMoistureItems = MutableStateFlow<List<SoilMoisture>>(emptyList())
    val soilMoistureItems: StateFlow<List<SoilMoisture>> = _soilMoistureItems.asStateFlow()

    init {
        loadTodayData()
    }

    fun triggerSoilSensor(deviceId: String = "pi_soil_001") {
        viewModelScope.launch {
            soilRepository.triggerSoilSensor(deviceId)
        }
    }

    fun loadAllData() {
        viewModelScope.launch {
            _soilMoistureItems.value = soilRepository.fetchSoilData()
        }
    }

    fun loadTodayData() {
        viewModelScope.launch {
            _soilMoistureItems.value = soilRepository.fetchTodaySoilData()
        }
    }
}