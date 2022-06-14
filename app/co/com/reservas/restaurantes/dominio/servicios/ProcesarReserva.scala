package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProcesarReserva {

  val dbReservasMockeada = listaReservasDB.listReservas;

  def crearReserva(reserva : Reserva) : Future[Option[Reserva]] = Future{
    if(dbReservasMockeada.find(_.id == reserva.id).isEmpty){
      Some(reserva.copy(estado = Reservada()))
    }else{
      None
    }

  }

}

object ProcesarReserva extends ProcesarReserva
