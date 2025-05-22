package denys.diomaxius.aws.data.repository

import denys.diomaxius.aws.data.model.TriggerRequest
import denys.diomaxius.aws.data.network.SoilApiService
import denys.diomaxius.aws.data.network.TriggerApiService
import javax.inject.Inject


class SoilRepository @Inject constructor(
    private val dataApi: SoilApiService,
    private val triggerApi: TriggerApiService
) {
    suspend fun fetchSoilData() = dataApi.getSoilData().items

    suspend fun fetchTodaySoilData() = dataApi.getTodaySoilData().items

    suspend fun triggerSoilSensor(deviceId: String): String {
        val response = triggerApi.triggerSoilSensor(TriggerRequest(device_id = deviceId))
        return response.message
    }
}
