package denys.diomaxius.aws.data.repository

import denys.diomaxius.aws.data.network.SoilApiService
import javax.inject.Inject


class SoilRepository @Inject constructor(
    private val api: SoilApiService
) {
    suspend fun fetchSoilData() = api.getSoilData().items

    suspend fun fetchTodaySoilData() = api.getTodaySoilData().items
}
