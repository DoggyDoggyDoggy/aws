package denys.diomaxius.aws.data.network

import denys.diomaxius.aws.data.model.SoilMoisterResponse
import retrofit2.http.GET

interface SoilApiService {
    @GET("ScanSoilMoisture")
    suspend fun getSoilData(): SoilMoisterResponse
}