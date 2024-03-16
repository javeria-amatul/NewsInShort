package com.javeria.newsinshort.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.javeria.newsinshort.data.repository.remote.entity.Article
import com.javeria.newsinshort.data.repository.remote.entity.NewsResponse
import com.javeria.newsinshort.data.repository.remote.entity.Source
import com.javeria.newsinshort.ui.theme.Purple40
import org.jetbrains.annotations.Async

@Composable
fun Loader() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        CircularProgressIndicator(
            modifier = Modifier
                .size(60.dp)
                .padding(10.dp),
            color = Purple40
        )
    }
}

@Composable
fun NewsList(newsResponse: NewsResponse) {
    LazyColumn {
        items(newsResponse.articles) { article ->
            NormalTextComponent(article.title)
        }
    }
}

@Composable
fun NormalTextComponent(textValue: String) {
    Text(
        modifier = Modifier
            .fillMaxWidth()
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(8.dp),
        style = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Normal),
        text = textValue
    )
}

@Composable
fun NewRowComponent(page: Int, article: Article) {
    NormalTextComponent(article.title)
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//            .padding(8.dp)
//            .background(Color.White)
//    ) {
//        AsyncImage(
//            modifier = Modifier
//                .fillMaxSize()
//                .height(240.dp),
//            model = article.url,
//            contentDescription = "",
//            contentScale = ContentScale.Crop
//        )
//    }
}

@Preview(showBackground = true)
@Composable
fun PreviewNewRowComponent() {
    NewRowComponent(
        1,
        Article(
            title = "Dow Jones Today: Nasdaq, Bitcoin Slump; Adobe Tumbles on Weak Outlook - Investopedia",
            author = "Colin Laidley",
            source = Source(id = null, name = "Investopedia"),
            publishedAt = "2024-03-15T14:03:23Z",
            url = "https://www.investopedia.com/dow-jones-today-03152024-8609585"
        )
    )
}

