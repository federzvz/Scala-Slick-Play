package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ObtenerReserva {

  val dbReservasMockeada = listaReservasDB.listReservas;

  def obtenerReserva(id : String) : Future[Option[Reserva]] = Future{
    if(!dbReservasMockeada.find(_.id == id).isEmpty){
      Some(dbReservasMockeada.find(_.id == id).get)
    }else{
      None
    }
  }

}

object ObtenerReserva extends ObtenerReserva
