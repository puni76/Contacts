package com.example.myapppathway2

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }
    val extraPadding by animateDpAsState(
        targetValue = if (expanded) 78.dp else 0.dp,
        animationSpec = tween(durationMillis = 2000), label = "done"
    )
    val extraPadding2 by animateDpAsState(
        targetValue = if (expanded) 28.dp else 0.dp,
        animationSpec = spring(),
        label = "done"
    )

    val arrowIcon = if (expanded) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown

    Surface(
        modifier = Modifier.padding(horizontal = 8.dp, vertical = 8.dp),
        color = MaterialTheme.colorScheme.onBackground
    ) {
        Row(
            modifier = Modifier.padding(24.dp)
        ) {
            Column(
                modifier = modifier
                    .weight(1f)
                    .padding(bottom = extraPadding, start =extraPadding2 )
            ) {
                Text(
                    text = "Hello ",
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.bodyMedium
                )
            }
            Spacer(modifier = Modifier.width(16.dp))
            OutlinedButton(
                onClick = {
                    expanded = !expanded
                }
            ) {
                Text(
                    text = if(expanded) "Show Less" else "Show More",
                )
                Icon(
                    imageVector = arrowIcon,
                    contentDescription = "Toggle",
                    modifier = Modifier
                        .size(24.dp)
                        .clickable { expanded = !expanded }
                )
            }

        }
    }
}