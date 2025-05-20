package denys.diomaxius.aws.data.model

import kotlinx.serialization.Serializable

@Serializable
data class SoilMoisterResponse(
    val items: List<SoilMoisture>
)
