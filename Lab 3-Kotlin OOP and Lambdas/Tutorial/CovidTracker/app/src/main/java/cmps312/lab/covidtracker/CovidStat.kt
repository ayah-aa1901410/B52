package cmps312.lab.covidtracker

import kotlinx.serialization.Serializable

@Serializable
data class CovidStat(
    var id: Int?,
    var country: List<String>?)