package su.svn.scala

import java.time.LocalDate
import java.util.UUID

case class Address(city: String, state: String, zip: String) {
  override def toString: String = s"Address($city, $state, $zip)"
}

class Person(private val _id: UUID = UUID.randomUUID()) {
  private var _firstName: Option[String] = None
  private var _secondName: Option[String] = None
  private var _surName: Option[String] = None
  private var _sex: Option[String] = None
  private var _birthDate: Option[LocalDate] = None
  private var _address: Option[Address] = None

  def id: UUID = _id
  def firstName: Option[String] = _firstName
  def firstName_= (s: String): Unit = _firstName = Option(s)
  def surName: Option[String] = _surName
  def surName_= (s: String): Unit = _surName = Option(s)
  def secondName: Option[String] = _secondName
  def secondName_= (s: String): Unit = _secondName = Option(s)
  def sex: Option[String] = _sex
  def sex_= (s: String): Unit = _sex = Option(s)
  def birthDate: Option[LocalDate] = _birthDate
  def birthDate_= (l: LocalDate): Unit = _birthDate = Option(l)
  def address: Option[Address] = _address
  def address_= (a: Address): Unit = _address = Option(a)

  override def clone(): Person = {
    val person = new Person(this.id)
    person.firstName = this.firstName.orNull
    person.surName = this.surName.orNull
    person.secondName = this.secondName.orNull
    person.sex = this.sex.orNull
    person.birthDate = this.birthDate.orNull
    person.address = this.address.map(a => Address(a.city, a.state, a.zip)).orNull
    person
  }

  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        firstName == that.firstName &&
        surName == that.surName &&
        secondName == that.secondName &&
        sex == that.sex &&
        birthDate == that.birthDate &&
        address == that.address
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(firstName, secondName, surName, sex, birthDate, address)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Person($id, $firstName, $surName, $sex, $secondName, $birthDate, $address)"
}
