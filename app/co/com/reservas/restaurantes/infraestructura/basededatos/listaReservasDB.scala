package co.com.reservas.restaurantes.infraestructura.basededatos

import co.com.reservas.restaurantes.dominio.modelo.{Reserva, SinEstado}

import java.util.Date

object listaReservasDB {
  val listReservas = List(
    Reserva("1","Cita 1", new Date().toString, SinEstado()),
    Reserva("2","Cita 2", new Date().toString, SinEstado()),
    Reserva("3","Cita 3", new Date().toString, SinEstado()),
    Reserva("4","Cita 4", new Date().toString, SinEstado()),
    Reserva("5","Cita 5", new Date().toString, SinEstado()),
    Reserva("6","Cita 6", new Date().toString, SinEstado()),
    Reserva("7","Cita 7", new Date().toString, SinEstado()),
    Reserva("8","Cita 8", new Date().toString, SinEstado()),
    Reserva("9","Cita 9", new Date().toString, SinEstado()),
    Reserva("10","Cita 10", new Date().toString, SinEstado())
  )
}
