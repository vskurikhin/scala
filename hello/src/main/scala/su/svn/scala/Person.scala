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

  def id = _id
  def firstName = _firstName
  def firstName_= (s: String) = _firstName = Option(s)
  def surName = _surName
  def surName_= (s: String) = _surName = Option(s)
  def secondName = _secondName
  def secondName_= (s: String) = _secondName = Option(s)
  def sex = _sex
  def sex_= (s: String) = _sex = Option(s)
  def birthDate = _birthDate
  def birthDate_= (l: LocalDate) = _birthDate = Option(l)
  def address = _address
  def address_= (a: Address) = _address = Option(a)

  def canEqual(other: Any): Boolean = other.isInstanceOf[Person]

  override def equals(other: Any): Boolean = other match {
    case that: Person =>
      (that canEqual this) &&
        id == that.id &&
        firstName == that.firstName &&
        surName == that.surName &&
        secondName == that.secondName &&
        sex == that.sex &&
        birthDate == that.birthDate &&
        address == that.address
    case _ => false
  }

  override def hashCode(): Int = {
    val state = Seq(id, firstName, secondName, surName, sex, birthDate, address)
    state.map(_.hashCode()).foldLeft(0)((a, b) => 31 * a + b)
  }

  override def toString = s"Person($id, $firstName, $surName, $sex, $secondName, $birthDate, $address)"
}
