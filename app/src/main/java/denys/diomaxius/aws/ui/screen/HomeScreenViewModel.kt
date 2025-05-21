package denys.diomaxius.aws.ui.screen

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
        loadAllData()
    }

    fun loadAllData() {
        viewModelScope.launch {
            _soilMoistureItems.value = soilRepository.fetchSoilData()
        }
    }
}