package models

/**
 * Created by tudor on 01/12/14.
 */
sealed trait TodoCategory { def name: String }
case object A extends TodoCategory { val name = "A" }
case object B extends TodoCategory { val name = "B" }
case object C extends TodoCategory { val name = "C" }