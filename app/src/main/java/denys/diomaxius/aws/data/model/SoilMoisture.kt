package denys.diomaxius.aws.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SoilMoisture(
    val deviceId: String,
    val timestamp: Long,
    val soilmoisture: String
)