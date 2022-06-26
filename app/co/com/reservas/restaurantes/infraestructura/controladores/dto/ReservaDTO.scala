package co.com.reservas.restaurantes.infraestructura.controladores.dto

import co.com.reservas.restaurantes.dominio.modelo.value.types.{Estado, Fecha, Identificador, Nombre}

case class ReservaDTO(id: Identificador, nombre : Nombre, fechaReserva: Fecha, estado : Estado)
