package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ActualizarReserva {

  def actualizarReserva(id : String, reserva : Reserva) : Future[Reserva] = Future{
    Reserva("111","Nombre", new Date().toString, Reservada())
  }

}

object ActualizarReserva extends ActualizarReserva
