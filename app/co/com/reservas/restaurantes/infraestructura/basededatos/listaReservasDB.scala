package co.com.reservas.restaurantes.infraestructura.basededatos

import co.com.reservas.restaurantes.dominio.modelo.{Rechazado, Reserva, Reservada, SinEstado}

import java.util.Date

object listaReservasDB {
  val listReservas = List(
    Reserva("1","Cita 1 Pepe", new Date().toString, Reservada()),
    Reserva("2","Cita 2 Carlos", new Date().toString, SinEstado()),
    Reserva("3","Cita 3 Jose", new Date().toString, Rechazado()),
    Reserva("4","Cita 4 Pepito", new Date().toString, Rechazado()),
    Reserva("5","Cita 5 Lionel", new Date().toString, Reservada()),
    Reserva("6","Cita 6 Jesús", new Date().toString, SinEstado()),
    Reserva("7","Cita 7 Roberto", new Date().toString, Rechazado()),
    Reserva("8","Cita 8 Beto", new Date().toString, SinEstado()),
    Reserva("9","Cita 9 Zayden", new Date().toString, Reservada()),
    Reserva("10","Cita 10 Cristaldo", new Date().toString, Reservada())
  )
}
