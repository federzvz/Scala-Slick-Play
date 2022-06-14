package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait EliminarReserva {

  def eliminarReserva(id : String) : Future[Reserva] = Future{
    Reserva("111","Nombre", new Date().toString, Reservada())
  }

}

object EliminarReserva extends EliminarReserva