package com.example.myapppathway2

import android.provider.CalendarContract
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MyApp(
    names: List<String> = listOf(
        "world",
        "compose",
        "Android",
        "Kotlin",
        "Jet pack",
        "Xml",
        "modify",
        "Compare",
        "compose",
        "bob",
        "Dummy",
        "Sammy"
    )
) {
    // Group names by their first letter and sort the groups
    val groupedAndSortedNames = names.groupBy { it.first().uppercaseChar() }
        .toSortedMap()

    Surface(
        modifier = Modifier.fillMaxSize(),
        color = MaterialTheme.colorScheme.background
    ) {
        LazyColumn {
            groupedAndSortedNames.forEach { (letter, namesGroup) ->
                stickyHeader {
                    Text(
                        text = letter.toString(),
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(MaterialTheme.colorScheme.primary)
                            .padding(26.dp),
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp,
                        style = MaterialTheme.typography.labelLarge.copy(
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                    )
                }

                items(namesGroup) { name ->
                    Greeting(name = name)
                }
            }
        }
    }
}
