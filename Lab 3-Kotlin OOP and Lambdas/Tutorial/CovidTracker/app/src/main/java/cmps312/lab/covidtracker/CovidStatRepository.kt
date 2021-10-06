package cmps312.lab.covidtracker

import kotlinx.serialization.decodeFromString
import kotlinx.serialization.json.Json
import java.io.File

object CovidStatRepository {
    var covidStats = listOf<CovidStat>()

    init {
        //read from the file as text
        val data = File("data/covid-data.json").readText()

        //convert the text to covid objects
        covidStats = Json{ignoreUknownKeys = true}.decodeFromString(data)
        //extract some values
        //covidStats = Json { ignoreUnknownKeys = true }.decodeFromString(data)
    }

    fun totalCovidDeath() = covidStats.sumBy { it?.totalDeaths ?: 0 }
}

fun main() {
//    CovidStatRepository.covidStats.forEach { println(it.country) }
    println("Total Death  ${CovidStatRepository.totalCovidDeath()}")
}