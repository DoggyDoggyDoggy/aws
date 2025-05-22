package denys.diomaxius.aws.data.network

import denys.diomaxius.aws.data.model.TriggerRequest
import denys.diomaxius.aws.data.model.TriggerResponse
import retrofit2.http.Body
import retrofit2.http.POST

interface TriggerApiService {
    @POST("TriggerSoilSensorReading")
    suspend fun triggerSoilSensor(@Body request: TriggerRequest): TriggerResponse
}