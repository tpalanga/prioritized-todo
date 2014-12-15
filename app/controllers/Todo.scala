package controllers

import models.TodoItems
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by tudor on 15/12/14.
 */
object Todo extends Controller  {
  def list = Action async {
    for {
      list <- TodoItems.all
    } yield Ok(Json.toJson(list))
  }
}
