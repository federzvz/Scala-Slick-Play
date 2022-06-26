package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB.listReservas

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ActualizarReserva {

  def actualizarReserva(reserva : Reserva) : Future[Option[Reserva]] = Future{ //Future Either(String || Reserva)
    val isReservaRequerida = !listReservas.find(_.id == reserva.id).isEmpty
    isReservaRequerida match {
      case true =>
        val reservaRequerida = listReservas.find(_.id == reserva.id).get
        val reservaModificada = reservaRequerida.copy(
          id = reserva.id,
          nombre = reserva.nombre,
          fechaReserva = reserva.fechaReserva,
          estado = reserva.estado)
        val listModificada : List[Reserva] = listReservas.map(r => {
          if(r.equals(reservaRequerida)){
            r.copy(nombre = reserva.nombre,fechaReserva = reserva.fechaReserva, estado = reserva.estado)
          }else{
            r
          }
        })
        listReservas = listModificada
        Some(reservaModificada)
      case false => None
    }
  }
}

object ActualizarReserva extends ActualizarReserva
