package denys.diomaxius.aws.data.network

import denys.diomaxius.aws.data.model.SoilMoisterResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SoilApiService {
    @GET("ScanSoilMoisture")
    suspend fun getSoilData(): SoilMoisterResponse

    @GET("ScanSoilMoisture")
    suspend fun getTodaySoilData(
        @Query("filter") filter: String = "today"
    ): SoilMoisterResponse
}