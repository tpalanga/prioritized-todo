import models.TodoCategory._
import models.{TodoItem, TodoItems}
import org.specs2.mutable._
import org.specs2.runner._
import org.junit.runner._
import play.api.libs.json.Json

import play.api.test._
import play.api.test.Helpers._

/**
 * add your integration spec here.
 * An integration test will fire up a whole play application in a real (or headless) browser
 */
@RunWith(classOf[JUnitRunner])
class IntegrationSpec extends Specification {

  "Application" should {

    "work from within a browser" in new WithBrowser(FIREFOX.newInstance()) {

      browser.goTo("http://localhost:" + port)

      browser.pageSource must contain("Prioritized Todo")
    }

    "load todo list" in new WithBrowser {

      val getGroceries = TodoItem("Get groceries", B, 1)

      browser.goTo("http://localhost:" + port + "/api/todos")

      browser.pageSource must contain(Json.toJson(getGroceries).toString())
    }
  }
}
