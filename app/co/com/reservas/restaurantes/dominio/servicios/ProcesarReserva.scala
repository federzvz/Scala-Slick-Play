package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB.listReservas

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ProcesarReserva {


  def crearReserva(reserva : Reserva) : Future[Option[Reserva]] = Future{
    if(listReservas.find(_.id == reserva.id).isEmpty){
      val newReserva = Reserva(reserva.id,reserva.nombre,reserva.fechaReserva,Reservada())
      listReservas = listReservas.appended(newReserva)
      Some(newReserva)
    }else{
      None
    }
  }

}

object ProcesarReserva extends ProcesarReserva
