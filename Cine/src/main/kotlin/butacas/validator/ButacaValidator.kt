package butacas.validator

import butacas.exceptions.ButacaException
import butacas.models.Butaca
import org.lighthousegames.logging.logging

private val logger = logging()

class ButacaValidator {

    fun validate(butaca: Butaca): Butaca {
        logger.debug { "Validando butaca" }

        if (!esValidaButaca(butaca.id)) {
            logger.error { "Butaca invalida" }
            throw ButacaException.ButacaNoValida("La butaca con ID ${butaca.id} no es válida")
        }

        return butaca
    }

    private fun esValidaButaca(id: String): Boolean {
        val regex = Regex("[A-F][1-7]")
        return regex.matches(id)
    }
}
