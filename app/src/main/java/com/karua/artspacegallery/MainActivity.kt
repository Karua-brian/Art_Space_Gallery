package com.karua.artspacegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.karua.artspacegallery.ui.theme.ArtSpaceGalleryTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ArtSpaceGalleryTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    ArtSpaceGallery()
                }
                }
            }
        }
    }

@Composable
    fun ArtSpaceGallery(modifier: Modifier = Modifier) {

    var currentState by remember { mutableStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 40.dp)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        when (currentState + 1) {
            1 -> ArtSpaceLayout(
                image = R.drawable.african_art_1,
                contentDescription = R.string.art_1,
                artTitle = R.string.art_1,
                artist = R.string.art_artist_1,
                year = R.string.year_1,
            )

            2 -> ArtSpaceLayout(
                image = R.drawable.aris,
                contentDescription = R.string.art_2,
                artTitle = R.string.art_2,
                artist = R.string.art_artist_2,
                year = R.string.year_2
            )

            3 -> ArtSpaceLayout(
                image = R.drawable.africa_world_art,
                contentDescription = R.string.art_3,
                artTitle = R.string.art_3,
                artist = R.string.art_artist_3,
                year = R.string.year_3,
            )

            4 -> ArtSpaceLayout(
                image = R.drawable.monalisa,
                contentDescription = R.string.art_4,
                artTitle = R.string.art_4,
                artist = R.string.art_artist_4,
                year = R.string.year_4,
            )

            5 -> ArtSpaceLayout(
                image = R.drawable.tingatinga,
                contentDescription = R.string.art_5,
                artTitle = R.string.art_5,
                artist = R.string.art_artist_5,
                year = R.string.year_5
            )

            6 -> ArtSpaceLayout(
                image = R.drawable.african_potrait,
                contentDescription = R.string.art_6,
                artTitle = R.string.art_6,
                artist = R.string.art_artist_6,
                year = R.string.year_6
            )

            7 -> ArtSpaceLayout(
                image = R.drawable.african_women_dancers,
                contentDescription = R.string.art_7,
                artTitle = R.string.art_7,
                artist = R.string.art_artist_7,
                year = R.string.year_7
            )

            8 -> ArtSpaceLayout(
                image = R.drawable.the_anatomy_lesson,
                contentDescription = R.string.art_8,
                artTitle = R.string.art_8,
                artist = R.string.art_artist_8,
                year = R.string.year_8
            )

            9 -> ArtSpaceLayout(
                image = R.drawable.the_birth_of_venus,
                contentDescription = R.string.art_9,
                artTitle = R.string.art_9,
                artist = R.string.art_artist_9,
                year = R.string.year_9
            )

            10 -> ArtSpaceLayout(
                image = R.drawable.the_wisdom_tree,
                contentDescription = R.string.art_10,
                artTitle = R.string.art_10,
                artist = R.string.art_artist_10,
                year = R.string.year_10
            )


        }
        fun nextState() {

            currentState = (currentState + 1) % 10
        }

        fun previousState() {
            currentState = (currentState + 10 - 1) % 10
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()


        ) {
            Button(onClick = { previousState() }) {
                Text(stringResource(R.string.previous_btn))
            }
            Spacer(modifier = Modifier.padding(horizontal = 16.dp))

            Button(onClick = { nextState() }) {
                Text(stringResource(R.string.next_btn))
            }


        }

    }

}

    @Composable
    fun ArtSpaceLayout(
        modifier: Modifier = Modifier,
        image: Int,
        contentDescription: Int,
        artTitle: Int,
        artist: Int,
        year: Int
    ) {
        Image(
            painter = painterResource(image),
            contentDescription = stringResource(contentDescription),
            modifier = Modifier
                .size(400.dp)
        )
        Spacer(modifier = Modifier.padding(top = 40.dp))
        Column(modifier = Modifier.fillMaxWidth()) {
            Text(
                stringResource(artTitle),
                fontSize = 32.sp,
                lineHeight = 40.sp,
            )
            Row {
                Text(
                    stringResource(artist),
                    fontWeight = FontWeight.Bold,
                    lineHeight = 40.sp,
                )
                Text(stringResource(year),
                    lineHeight = 40.sp,)
            }
        }
        Spacer(modifier = Modifier.padding(top = 12.dp))


    }

    @Preview(showBackground = true)
    @Composable
    fun ArtGallerySpacePreview() {
        ArtSpaceGalleryTheme {
            ArtSpaceGallery()
        }
    }