package socio.models

import java.time.LocalDateTime

data class Socio(
    val id: Long,
    val nombre: String,
    val gmail: String,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val updatedAt: LocalDateTime = LocalDateTime.now(),
    val isDeleted: Boolean = false
)