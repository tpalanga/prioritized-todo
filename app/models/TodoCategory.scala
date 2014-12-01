package models

import play.api.libs.json.{Writes, Reads, Json, Format}
import utils.EnumUtils

/**
 * Created by tudor on 01/12/14.
 */
object TodoCategory extends Enumeration {
  type TodoCategory = Value
  val A = Value("A")
  val B = Value("B")
  val C = Value("C")

  implicit val enumReads: Reads[TodoCategory] = EnumUtils.enumReads(TodoCategory)
  implicit def enumWrites: Writes[TodoCategory] = EnumUtils.enumWrites
}