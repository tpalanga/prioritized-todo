package models

import models.TodoCategory._

import play.api.libs.json.{JsValue, Json}

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

/**
 * Created by tudor on 01/12/14.
 */

case class TodoItem(title: String, category: TodoCategory, priority: Int)

object TodoItem {
  implicit val todoItemFormat = Json.format[TodoItem]

  implicit def orderingByPriority[T <: TodoItem]: Ordering[T] =
    Ordering.by(x => (x.category.toString, x.priority, x.title))

}

trait TodoItemsService {
  def all: Future[List[TodoItem]]
}

object TodoItems extends TodoItemsService {

  val getGroceries = TodoItem("Get groceries", B, 1)
  val finishProject = TodoItem("Finish project", A, 2)
  val checkTwitter = TodoItem("Check twitter", C, 1)
  val replyImportantEmail = TodoItem("Reply important email", A, 1)
  val cookDinner = TodoItem("Cook dinner", B, 2)
  val chooseWine = TodoItem("Choose wine", B, 3)

  val testItems = List(getGroceries, finishProject, checkTwitter, replyImportantEmail, cookDinner, chooseWine)

  def all: Future[List[TodoItem]] =
    Future {
      testItems.sorted
    }

}