package com.ezlevup.recipeproviderreader.presentation

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.ezlevup.recipeproviderreader.presentation.home.HomeScreen

@Composable
fun MyApp(

) {
    HomeScreen()
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyApp()
}
