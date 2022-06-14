package co.com.reservas.restaurantes.dominio.modelo

trait EstadoReserva

case class Reservada() extends EstadoReserva

case class Rechazado() extends EstadoReserva

case class SinEstado() extends EstadoReserva

case class Reserva(id: String, nombre : String, fechaReserva: String, estado : EstadoReserva)
