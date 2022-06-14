package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ActualizarReserva {

  val dbReservasMockeada = listaReservasDB.listReservas;

  def actualizarReserva(reserva : Reserva) : Future[Option[Reserva]] = Future{
    if(!dbReservasMockeada.find(_.id == reserva.id).isEmpty){
      val reservaModificada = dbReservasMockeada.find(_.id == reserva.id).get.copy(
        nombre = reserva.nombre,
        fechaReserva = reserva.fechaReserva,
        estado = reserva.estado,
      )
      Some(reservaModificada)
    }else{
      None
    }
  }

}

object ActualizarReserva extends ActualizarReserva
