package cmps312.lab.books.model

open class Book(var name: String, var author: String, var yearOfPublication: Int) {
    override fun toString(): String {
        return """
            Name : $name
            Author : $author
            Year Of Publication : $yearOfPublication
        """
    }
}

//we call the super constuctor
//ctrl + alt + L
//cmnd + option + L

class PaperBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var publisher: String,
    var isbn: String
) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
            ${super.toString()}
            publisher : $publisher
            isbn : $isbn
        """.trimIndent()
    }

}

class AudioBook(
    name: String,
    author: String,
    yearOfPublication: Int,
    var size: Int,
    var length: Int,
    var artistName: String,
) : Book(name, author, yearOfPublication) {

    override fun toString(): String {
        return """
            ${super.toString()}
            size : $size
            length : $length,
            artistName : $artistName,
        """.trimIndent()
    }

}

fun main() {
    val paperBook1 =
        PaperBook("The loard of the rings V1", "J.R.R", 1954, "Oriely", "JJ-12-333-44-55");
    val paperBook2 =
        PaperBook("The loard of the rings V2", "J.R.R", 1954, "Oriely", "JJ-12-333-44-55");
    val paperBook3 =
        PaperBook("The loard of the rings V3", "J.R.R", 1954, "Oriely", "JJ-12-333-44-55");

    val audioBook1 =
        AudioBook("The loard of the rings V1", "J.R.R", 1954, 12, 300, "Ahlam Abdonada");
    val audioBook2 =
        AudioBook("The loard of the rings V2", "J.R.R", 1954, 11, 200, "Ahlam Abdonada");
    val audioBook3 =
        AudioBook("The loard of the rings V3", "J.R.R", 1954, 16, 400, "Ahlam Abdonada");



    val books = listOf<Book>(paperBook1, audioBook1, paperBook2, paperBook3, audioBook2, audioBook3)

    //normal if length of the book <=200
    //otherwise we display long
    for (book in books) {
        println(book)
        if (book is AudioBook)
            if (book.length > 200)
                println("A very long bbok")
            else println("Normal Book")

    }

    books.forEach { book ->
        println(book)
        if (book is AudioBook)
            if (book.length > 200)
                println("A very long bbok")
            else println("Normal Book")

    }


}