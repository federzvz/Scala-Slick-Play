package co.com.reservas.restaurantes.infraestructura

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.controladores.dto.ReservaDTO
import play.api.libs.json.Json


package object controladores {
  implicit val serializable = Json.format[ReservaDTO]

  implicit def convertirADTO(reserva : Reserva) = {
    ReservaDTO(reserva.id,reserva.nombre,reserva.fechaReserva,reserva.estado.toString)
  }
}
