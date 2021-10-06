package cmps312.lab.fromjavatokotlin
//
//    //output on the screen
//    println("Welcome to kotlin world")
//
//    //you can call java code from koltin
//    System.out.println("Welcome to Kotlin from Java Method")
//
//    //variable declarations
//
//    //constant , type inference
//    //final int x = 100;
//    //int x
////    x = 10
//    val x = 100
//
//    var y = 1000
//
//    //var or val
//
//    y = 90
//    println(y)
//    //variable
//
//    //annoying thing in java and c++
//    //nullity
////    final String name = null
////
////      String lastname;
////      lastname = null;
//
////    val and var
//
////    if(name!=null)
//    val name: String? = "Hello"
//
//    val textlength = name?.length;
//    var textlength2 = name!!.length   // throw nullpointerexpection if name == null
//
//    println(textlength)
//    println(textlength2)
//
//java code not kotlin
//    int age = 22;
//    String gender = 'Male';
//    double height = 3.3;
//
//    System.out.printf("Age = %d , Gender = %s and Height = %.1f" , age, gender, height)
//    System.out.println("Age = " + age + " Gender" + gender + " Height " +  height);

// JAVA code
//    int grade = 50;
//    String pass = grade > 60 ? "Pass " : "Fail";

//val grade = 70
//val status = if(grade > 60) "Pass" else "Fail"
//
//println(status)
//
////Bits Operations && (and) , || (or) , >> << ^
//
//if((grade > 60) or (grade < 80))
//println("between 60 and 80")
//
////instanceof is a
//if(grade is Int){
//    println("$grade is an Integer")
//}
//
//if(grade in 60..80)
//println("between 60 and 80")
//
//val names = listOf("abdulahi" , 12 , 15, "aisha", "asma")
//if(12 in names)
//println(" found inside the list")

// 10 or 4 - excellent , 3 , very good , 2 , good  , otherwise - not good
//      kotlin
//java
//val score = 2;
//val message = when (score) {
//    !in 4..10 -> "Excellent"
//    3 -> "very good"
//    2 -> "good"
//    else -> "not good"
//}
//
//println(message)

//loops
//    for (int i=0; i < 10 ; i+=2)
//for (i in 1..100 step 2)
//println("Step -$i")
//
//val items = listOf<String>("Banana", "Orange", "Potato" , "Tomato")
//
//for(i in 100 downTo 1 step 2)
//println(i)
//
//for(i in 1 until 100)
//println(i)
//
//for(item in items){
//    println(item)
//}

//var numbers = listOf(1, null, 3, 4, 5, 6)  //immutable - unchangeable
//val numbers2 = mutableListOf(1, null, 3, 4, 5, 6)
//
//numbers = listOf(999,4,4,5,6,6)
//
//numbers2.add(null)
//print(numbers2)
//
//val items = listOf<String?>("Banana", null, "Strawberry", "peach", "kiraz mevsimi")
//print(items)
//for (item in items){
//    print(item?.length)
//}
/*
    //collection
    val numbers = mutableListOf(1, 2, 3, 4, 55, 67, 44, 12, 59)  //immutable - unchangeable
    //lambdas
    numbers.forEach { print("$it-") }
    println()

    val result = numbers.filter { it > 20 }
    println(result)

    val sum = numbers.reduce { acc, i -> acc + i }
    println(sum)

    val result2 = numbers.find { it == 550 }
    println("result $result2")

    val result3 = numbers
        .filter { it > 20 }
        .reduce { acc, i -> acc + i }

    println(result3)
 */