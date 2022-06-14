package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, Reservada}

import java.util.Date
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ObtenerReserva {

  def obtenerReserva(id : String) : Future[Option[Reserva]] = Future{
    if(id == "111"){
      Some(Reserva("111","Nombre", new Date().toString, Reservada()))
    }else{
      None
    }
  }

}

object ObtenerReserva extends ObtenerReserva
