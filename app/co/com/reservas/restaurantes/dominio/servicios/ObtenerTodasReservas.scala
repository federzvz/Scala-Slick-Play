package co.com.reservas.restaurantes.dominio.servicios

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.infraestructura.basededatos.listaReservasDB.listReservas

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

trait ObtenerTodasReservas {
  def obtenerTodasReservas: Future[Option[List[Reserva]]] = Future{
    val isListReservaVacia = listReservas.isEmpty
    isListReservaVacia match {
      case true => None
      case false => {
        Some(listReservas)
      }
    }
  }
}

object ObtenerTodasReservas extends ObtenerTodasReservas