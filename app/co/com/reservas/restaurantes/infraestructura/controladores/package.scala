package co.com.reservas.restaurantes.infraestructura

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}
import co.com.reservas.restaurantes.infraestructura.controladores.dto.ReservaDTO
import play.api.libs.json.Json


package object controladores {
  implicit val serializable = Json.format[ReservaDTO]

  implicit def convertirADTO(reserva : Reserva) = {
    ReservaDTO(reserva.id,reserva.nombre,reserva.fechaReserva,reserva.estado.toString)
  }

  implicit def convertirAListDTO(listReserva : List[Reserva]) = {
    val listReservasDTO : List[ReservaDTO] = listReserva.map(r => ReservaDTO(r.id,r.nombre,r.fechaReserva,r.estado.toString)).toList
    listReservasDTO
  }

  implicit def convertirAReserva(reservaDTO: ReservaDTO) = {
    Reserva(reservaDTO.id,reservaDTO.nombre,reservaDTO.fechaReserva,Reservada())
  }
}
