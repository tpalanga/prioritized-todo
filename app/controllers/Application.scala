package controllers

import models.TodoItems
import play.api.libs.json.Json
import play.api.mvc._
import scala.concurrent.ExecutionContext.Implicits.global

object Application extends Controller {

  def index = Action {
    Ok(views.html.index("Your new application is ready."))
  }

  def list = Action async {
    TodoItems.all.map(list => Ok(Json.toJson(list)))
  }

}