package controllers

import models.{TodoItemsService, TodoItems}
import play.api.libs.json.Json
import play.api.mvc.{Action, Controller}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * Created by tudor on 15/12/14.
 */
class Todo(todoService: TodoItemsService)  extends Controller  {
  def list = Action async {
    for {
      list <- todoService.all
    } yield Ok(Json.toJson(list))
  }
}

object Todo extends Todo(TodoItems)