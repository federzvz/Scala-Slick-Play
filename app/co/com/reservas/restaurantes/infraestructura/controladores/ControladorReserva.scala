package co.com.reservas.restaurantes.infraestructura.controladores

import co.com.reservas.restaurantes.dominio.modelo.Reserva
import co.com.reservas.restaurantes.dominio.servicios.{ActualizarReserva, EliminarReserva, ObtenerReserva, ObtenerTodasReservas, ProcesarReserva}
import co.com.reservas.restaurantes.infraestructura.controladores.dto.ReservaDTO
import play.api.Logger
import play.api.libs.json.Json
import play.api.mvc.{BaseController, ControllerComponents}

import javax.inject.{Inject, Singleton}
import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

@Singleton
class ControladorReserva @Inject() (val controllerComponents: ControllerComponents) extends BaseController {

  val logger : Logger = Logger(this.getClass.getName)

  def obtenerReserva(id : String) = Action.async{
    ObtenerReserva.obtenerReserva(id)
      .map(reservaOpt => {
        reservaOpt.map(reserva => {
          val reservaDTO : ReservaDTO = reserva
          val json = Json.obj("data" -> reservaDTO)
          Ok(json)
        }).getOrElse(NotFound("No se encontro la reserva"))
    }).recover{
      case ex =>
        logger.error("Ocurrio un error en el servicio Logger", ex)
        InternalServerError("Ha ocurrido un error interno.")
    }
  }

  def eliminarReserva(id : String) = Action.async{

    EliminarReserva.eliminarReserva(id)
      .map(reserva => {
        if(reserva.isEmpty){
          NotFound("No se encontro la reserva")
        }else{
          val reservaDTO : ReservaDTO = reserva.get
          val json = Json.toJson(reservaDTO)
          Ok(json)
        }

      }).recover{
      case ex =>
        logger.error("Ocurrio un error en el servicio Logger", ex)
        InternalServerError("Ha ocurrido un error interno.")
    }
  }

  def crearReserva() = Action.async(parse.json){

    request =>
      val validar = request.body.validate[ReservaDTO]

      validar.asEither match{
        case Left(value) => Future.successful(BadRequest(value.toString))
        case Right(value) => ProcesarReserva.crearReserva(value)
          .map(reserva => {
            if(reserva.isEmpty) {
              NotFound("Ya existe una reserva con ese id")
            }else{
              val reservaDTO : ReservaDTO = reserva.get
              val json = Json.obj("data" -> reservaDTO)
              Ok(json)
            }
            }).recover{
          case ex =>
            logger.error("Ocurrio un error en el servicio Logger", ex)
            InternalServerError("Ha ocurrido un error interno.")
        }
      }
  }

  def actualizarReserva() = Action.async(parse.json){

    request =>

      val validar = request.body.validate[ReservaDTO]

      validar.asEither match{
        case Left(value) => Future.successful(BadRequest(value.toString))
        case Right(value) => ActualizarReserva.actualizarReserva(value)
          .map(reserva => {
            if(reserva.isEmpty){
              NotFound("No se encontro la reserva")
            }else{
              val reservaDTO : ReservaDTO = reserva.get
              NotFound("No se encontro la reserva")
              val json = Json.obj("data" -> reservaDTO)
              Ok(json)
            }
          }).recover{
          case ex =>
            logger.error("Ocurrio un error en el servicio Logger", ex)
            InternalServerError("Ha ocurrido un error interno.")
        }
      }
  }

  def obtenerTodasReservas() = Action.async{
    ObtenerTodasReservas
      .obtenerTodasReservas.map(reservaOpt => {
        reservaOpt.map(reserva => {
          val listReservaDTO : List[ReservaDTO] = reserva : List[Reserva]
          val json = Json.obj("data" -> listReservaDTO)
          Ok(json)
        }).getOrElse(NotFound("No se encontro la reserva"))
      }).recover{
      case ex =>
        logger.error("Ocurrio un error en el servicio Logger", ex)
        InternalServerError("Ha ocurrido un error interno.")
    }
  }


}
