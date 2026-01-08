package com.ezlevup.recipeproviderreader.presentation.home

import android.annotation.SuppressLint
import android.net.Uri
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.ezlevup.recipeproviderreader.presentation.components.Greeting

@SuppressLint("Range")
@Composable
fun HomeScreen() {
    val context = LocalContext.current
    val contentResolver = context.contentResolver
    var bookmarks by remember { mutableStateOf<List<String>>(emptyList()) }
    val uri = Uri.parse("content://com.survivalcoding.gangnam2kriandroidstudy.provider/bookmarks")

    LaunchedEffect(key1 = uri) {
        try {
            val cursor = contentResolver.query(uri, arrayOf("title"), null, null, null)
            val newBookmarks = mutableListOf<String>()
            cursor?.use {
                while (it.moveToNext()) {
                    val title = it.getString(it.getColumnIndex("title"))
                    newBookmarks.add(title)
                }
            }
            bookmarks = newBookmarks
        } catch (e: Exception) {
            // Handle exceptions, e.g., provider not found
            e.printStackTrace()
        }
    }

    LazyColumn {
        item {
            Greeting("Android")
        }
        items(bookmarks) { bookmark ->
            Text(text = bookmark)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}
