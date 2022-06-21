package co.com.reservas.restaurantes.infraestructura.controladores.dto

import co.com.reservas.restaurantes.dominio.modelo.value.types.{Estado, Fecha, Identificador, NombreReserva}

case class ReservaDTO(id: Identificador, nombre : NombreReserva, fechaReserva: Fecha, estado : Estado)
