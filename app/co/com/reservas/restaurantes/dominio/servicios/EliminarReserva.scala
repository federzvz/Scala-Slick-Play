package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait EliminarReserva {

  val dbReservasMockeada = listaReservasDB.listReservas;

  def eliminarReserva(id : String) : Future[Option[Reserva]] = Future{
    if(!dbReservasMockeada.find(_.id == id).isEmpty){
      val reservaAEliminar = dbReservasMockeada.find(_.id == id).get
      Some(reservaAEliminar)
    }else{
      None
    }
  }

}

object EliminarReserva extends EliminarReserva