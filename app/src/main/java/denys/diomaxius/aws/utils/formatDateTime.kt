package denys.diomaxius.aws.utils

import java.time.Instant
import java.time.LocalDateTime
import java.time.ZoneId
import java.time.format.DateTimeFormatter

fun date(timestampSeconds: Long): String {
    val dateTime = LocalDateTime.ofInstant(
        Instant.ofEpochSecond(timestampSeconds),
        ZoneId.systemDefault()
    )

    val formatter = DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm")
    val formatted = dateTime.format(formatter)

    return formatted
}