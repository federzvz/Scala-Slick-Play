package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB.listReservas

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait EliminarReserva {

  def eliminarReserva(id : String) : Future[Option[Reserva]] = Future{
    val isReservaRequerida = !listReservas.find(_.id == id).isEmpty
    isReservaRequerida match {
      case true =>{
        val reservaRequerida = listReservas.find(_.id == id).get
        listReservas = listReservas.filterNot(reserva => reserva.equals(reservaRequerida))
        Some(reservaRequerida)
      }
      case false => None
    }
  }

}

object EliminarReserva extends EliminarReserva