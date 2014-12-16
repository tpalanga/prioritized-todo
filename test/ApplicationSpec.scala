import controllers.Todo
import models.{TodoItemsService, TodoItems, TodoItem, TodoCategory}
import org.specs2.runner._
import org.junit.runner._
import play.api.libs.json._
import org.specs2.mock.Mockito
import org.specs2.mutable.Specification
import org.mockito.Mockito._
import play.api.test._
import play.api.test.Helpers._
import TodoCategory._
import scala.concurrent.Future

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 * For more information, consult the wiki.
 */
@RunWith(classOf[JUnitRunner])
class ApplicationSpec extends Specification with Mockito {

  "Application" should {

    "send 404 on a bad request" in new WithApplication{
      route(FakeRequest(GET, "/boum")) must beNone
    }

    "serve assets" in new WithApplication{
      val jsAsset = route(FakeRequest(GET, "/assets/javascripts/app.js")).get
      status(jsAsset) must equalTo(OK)
      contentType(jsAsset) must beSome.which(_ == "application/javascript")
      contentAsString(jsAsset) must contain ("angular.module('prioTodo'")
    }

    "render the index page" in new WithApplication{
      val home = route(FakeRequest(GET, "/")).get

      status(home) must equalTo(OK)
      contentType(home) must beSome.which(_ == "text/html")
      contentAsString(home) must contain ("Prioritized Todo")
    }

    "render the api/todos page" in new WithApplication{
      val getGroceries = TodoItem("Get groceries", B, 1)
      val finishProject = TodoItem("Finish project", A, 2)
      val testItems = List(getGroceries, finishProject)

      val mockTodoItemsObject = mock[TodoItemsService]
      when(mockTodoItemsObject.all).thenReturn(Future.successful(testItems))
      val todoController = new Todo(mockTodoItemsObject)

      val result = todoController.list(FakeRequest())

      status(result) must equalTo(OK)
      contentType(result) must beSome.which(_ == "application/json")
      contentAsJson(result) must be_==(Json.toJson(testItems))
    }

    "read Json Enums" in {
        val json = """{"title":"Reply important email","category":"A","priority":1}"""
        val todoItem = Json.parse(json).as[TodoItem]
        todoItem.category must be(A)
    }

    "read Json Enums wrong value" in {
      val json = """"N""""
      val jsResult = TodoCategory.enumReads.reads(Json.parse(json))
      jsResult must beAnInstanceOf[JsError]
    }

    "read Json Enums bad json type" in {
      val json = """true"""
      val jsResult = TodoCategory.enumReads.reads(Json.parse(json))
      jsResult must beAnInstanceOf[JsError]
    }

  }
}
