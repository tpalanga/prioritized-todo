package models

import play.api.libs.json.Json

/**
 * Created by tudor on 01/12/14.
 */

case class TodoItem(title: String, category: TodoCategory, priority: Int)

object LoginData {
  implicit val todoItemFormat = Json.format[TodoItem]
}