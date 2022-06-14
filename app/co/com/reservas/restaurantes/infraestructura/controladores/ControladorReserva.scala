package co.com.reservas.restaurantes.infraestructura.controladores

import co.com.reservas.restaurantes.dominio.servicios.ObtenerReserva
import co.com.reservas.restaurantes.infraestructura.controladores.dto.ReservaDTO
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.Singleton
import scala.concurrent.ExecutionContext.Implicits.global

@Singleton
class ControladorReserva(val controllerComponents: ControllerComponents) extends BaseController {
  def obtenerReserva(id : String) = Action.async{
    ObtenerReserva.obtenerReserva(id)
      .map(reserva => {
        val reservaDTO : ReservaDTO = reserva
        val json = Json.obj("data" -> reservaDTO)
        Ok(json)
      })
  }
}
