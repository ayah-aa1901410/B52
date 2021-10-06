package com.cmps312.myapplication.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.cmps312.myapplication.model.Stadium


@Composable
fun StadiumList(stadiums: List<Stadium>) {
    LazyColumn { items(stadiums) {StadiumCard(stadium = it) }
    }
}

@Composable
fun StadiumCard(stadium: Stadium) {
    val imageId = LocalContext.current.resources.getIdentifier(
        stadium.imageName,
        "drawable",
        LocalContext.current.packageName)
    Card(elevation = 10.dp, backgroundColor = Color.LightGray, modifier = Modifier.padding(10.dp)) {
        Row(modifier = Modifier.padding(15.dp), verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = "World Cup Stadium ${stadium.name}",
                modifier = Modifier
                    .weight(3f)
                    .padding(horizontal = 10.dp)
                    .clip(RoundedCornerShape(10.dp)),
            )
            Column(modifier = Modifier.weight(3f)) {
                Text(text = "Name : ${stadium.name}")
                Text(text = "City : ${stadium.city}")
                Text(text = "Status : ${stadium.status}")
                Text(text = "Capacity : ${stadium.seatingCapacity}")

            }
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun PreviewStadiumList() {
//    val stadiums = listOf<Stadium>(
//        Stadium("Al-Gharafa", "Doha", "Completed",
//            "al_gharafa", 400000),
//        Stadium("Al-Gharafa", "Doha", "Completed",
//            "al_gharafa", 400000),
//        Stadium("Al-Gharafa", "Doha", "Completed",
//            "al_gharafa", 400000),
//        Stadium("Al-Gharafa", "Doha", "Completed",
//            "al_gharafa", 400000)
//    )
//    StadiumList(stadiums)
//}
























