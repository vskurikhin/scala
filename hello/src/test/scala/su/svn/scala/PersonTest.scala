package su.svn.scala

import java.time.LocalDate

import org.junit.Assert
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{BeforeAndAfterEach, FunSuite}

@RunWith(classOf[JUnitRunner])
class PersonTest extends FunSuite {

  test("Person") {
    Thread.sleep(500)
    val person = new Person()
    Assert.assertEquals(None, person.firstName)
    Assert.assertEquals(None, person.secondName)
    Assert.assertEquals(None, person.surName)
    Assert.assertEquals(None, person.sex)
    Assert.assertEquals(None, person.birthDate)
    Assert.assertEquals(None, person.address)
    person.firstName = "First"
    person.secondName = "Second"
    person.surName= "Surname"
    person.sex = "male"
    person.birthDate = LocalDate.of(1976,4,13)
    person.address = Address("City", "State", "Zip")
    Assert.assertEquals(Some("First"), person.firstName)
    Assert.assertEquals(Some("Second"), person.secondName)
    Assert.assertEquals(Some("Surname"), person.surName)
    Assert.assertEquals(Some("male"), person.sex)
    println(person)
  }
}
