package co.com.reservas.restaurantes.dominio.modelo

import co.com.reservas.restaurantes.dominio.modelo.value.types.{Fecha, Identificador, Nombre}

trait EstadoReserva

case class Reservada() extends EstadoReserva

case class Rechazado() extends EstadoReserva

case class SinEstado() extends EstadoReserva

case class Reserva(id: Identificador, nombre : Nombre, fechaReserva: Fecha, estado : EstadoReserva)
