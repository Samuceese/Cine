import Database.ButacaEntity
import butacas.exceptions.ButacaException
import butacas.models.Actividad
import butacas.models.Butaca
import butacas.models.Estado
import butacas.models.Tipo

fun ButacaEntity.toButaca(): Butaca {
    val id = this.id
    val estado = when (this.estado) {
        "LIBRE" -> Estado.LIBRE
        "RESERVADA" -> Estado.RESERVADA
        "OCUPADA" -> Estado.OCUPADA
        else -> throw ButacaException.EstadoNoValido("Estado desconocido: ${this.estado}")
    }
    val actividad = when (this.actividad) {
        "ACTIVA" -> Actividad.ACTIVA
        "MANTENIMIENTO" -> Actividad.MANTENIMIENTO
        "OCUPADA" -> Actividad.FUERADESERVICIO
        else -> throw ButacaException.ActicidadNoValido("Actividad desconocida: ${this.actividad}")
    }
    val tipo = when (this.tipo) {
        "NORMAL" -> Tipo.NORMAL
        "VIP" -> Tipo.VIP
        else -> throw ButacaException.TipoNoValido("Tipo desconocido: ${this.tipo}")
    }
    val precio = this.precio

    return Butaca(id, estado, actividad, tipo)
}
