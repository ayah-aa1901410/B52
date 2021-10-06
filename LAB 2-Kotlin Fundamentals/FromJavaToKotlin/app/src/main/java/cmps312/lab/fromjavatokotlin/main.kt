package cmps312.lab.fromjavatokotlin

data class Person(var name : String , val age : Int , val gender : Char = 'F')

fun main() {

    val person = Person("Ahlam", 22 )
    person.name = "Asmaa"
    println(person.name)
    println(person.age)
    println(person)

    val sum = add3(22,2,2,22)
    //println(sum)

}

fun add(a: Int, b: Int): Int {
    return a + b
}

fun add2(a: Int, b: Int) = a + b

fun add3(vararg numbers:Int) = numbers.reduce { acc, i -> acc+i }
