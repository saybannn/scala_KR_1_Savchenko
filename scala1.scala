object Main {
  def main(args: Array[String]): Unit = {
    val ListOfNumbers = List(4, 2, 7, 1, 7, 3, 8, 5, 4, 9)

    val maxNumber = ListOfNumbers.max   // min and max
    val minNumber = ListOfNumbers.min

    val filteredList = ListOfNumbers.filter(_ < 5)   // filter

    val ifFindNine = ListOfNumbers.find(_ == 9)   // find
    val existsGreaterThanTen = ListOfNumbers.exists(_ >= 10)   // exists

    val isEmptyString = "".isEmpty   // isEmpty

    val firstInList = ListOfNumbers.head   // head
    val lastInList = ListOfNumbers.tail   // tail

    var sum = 0
    for (number <- ListOfNumbers) {
      sum += number
    }
    println(sum)


    var product = 1
    for (number <- ListOfNumbers) {
      product *= number
    }
    println(product)


    val Average = if (ListOfNumbers.nonEmpty) sum.toDouble / ListOfNumbers.length else 0.0
    println(Average)

    println(ListOfNumbers)   // Вивід і пошук
    for (number <- ListOfNumbers) {
      if (number == 1)
        println(s"Found number 1")
    }


    println(s"Max: $maxNumber, Min: $minNumber")
    println(s"$filteredList")
    println(s"$ifFindNine")
    println(s"$existsGreaterThanTen")
    println(s"$isEmptyString")
    println(s"$firstInList, $lastInList")


    println() //////////////////////////////////////////////////////////////////////////////////////////////


    class Address(val street: String, val city: String, val zipCode: String) {
      override def toString: String = s"$street, $city, $zipCode"
    }

    class Human(val name: String, val age: Int, val address: Address) {
      override def toString: String = s"Name: $name, Age: $age, Address: $address"
      def greeting(): String = s"Hello, my name is $name, I am $age y.o.,and I live at ${address}."
    }

    ///////////////////////////////////////////

    val address = new Address("Nekrasova St.", "Kherson", "777")
    val Human1 = new Human("Ivan", 19, address)

    println(Human1.greeting())


    println() /////////////////////////////////////////////////////////////////////////////////////////////////


    class ListHuman {
      private var humans: List[Human] = List()

      def addHuman(name: String, age: Int, address: Address): Unit = {
        val newHuman = new Human(name, age, address)
        humans = newHuman :: humans
      }

      def deleteHuman(name: String): Unit = {
        humans = humans.filterNot(_.name == name)
      }

      def findByName(name: String): Option[Human] = {
        humans.find(_.name == name)
      }

      def filterByAge(minAge: Int, maxAge: Int): List[Human] = {
        humans.filter(human => human.age >= minAge && human.age <= maxAge)
      }

      def printHumans(): Unit = {
        humans.foreach(println)
      }
    }

    ///////////////////////////////

    val listHuman = new ListHuman()

    val address1 = new Address("Pivnichna", "Kherson", "12345")
    val address2 = new Address("Pivdenna", "Kherson", "67890")

    listHuman.addHuman("Muhammad", 25, address1)
    listHuman.addHuman("Ivan", 18, address2)
    listHuman.addHuman("Charlie", 22, address1)

    println("All humans:")
    listHuman.printHumans()
    println()

    listHuman.deleteHuman("Muhammad")
    listHuman.printHumans()
    println()

    val foundHuman = listHuman.findByName("Charlie")
    foundHuman.foreach(println)
    println()

    val filteredHumans = listHuman.filterByAge(20, 25)
    filteredHumans.foreach(println)
  }
}
