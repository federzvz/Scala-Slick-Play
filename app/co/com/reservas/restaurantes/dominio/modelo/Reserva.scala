package co.com.reservas.restaurantes.dominio.modelo

import co.com.reservas.restaurantes.dominio.modelo.value.types.{Fecha, Identificador, NombreReserva}

trait EstadoReserva

case class Reservada() extends EstadoReserva

case class Rechazado() extends EstadoReserva

case class SinEstado() extends EstadoReserva

case class Reserva(id: Identificador, nombre : NombreReserva, fechaReserva: Fecha, estado : EstadoReserva)
