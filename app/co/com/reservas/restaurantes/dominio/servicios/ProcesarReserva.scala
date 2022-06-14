package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProcesarReserva {

  def crearReserva(reserva : Reserva) : Future[Reserva] = Future{
    reserva.copy(estado = Reservada())
  }

}

object ProcesarReserva extends ProcesarReserva
