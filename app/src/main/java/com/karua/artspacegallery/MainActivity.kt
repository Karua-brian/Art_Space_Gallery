package com.karua.artspacegallery

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontFamily
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

    var currentImage by remember { mutableStateOf(0) }
    var currentTexts by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
                .padding(start = 40.dp, top = 200.dp, end = 40.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        )
        {
            when (currentImage + 1) {
                1 -> ArtImage(
                    image = R.drawable.african_art_1,
                    contentDescription = R.string.art_1
                )

                2 -> ArtImage(
                    image = R.drawable.aris,
                    contentDescription = R.string.art_2
                )

                3 -> ArtImage(
                    image = R.drawable.africa_world_art,
                    contentDescription = R.string.art_3
                )

                4 -> ArtImage(
                    image = R.drawable.monalisa,
                    contentDescription = R.string.art_4
                )

                5 -> ArtImage(
                    image = R.drawable.tingatinga,
                    contentDescription = R.string.art_5
                )

                6 -> ArtImage(
                    image = R.drawable.african_potrait,
                    contentDescription = R.string.art_6
                )

                7 -> ArtImage(
                    image = R.drawable.african_women_dancers,
                    contentDescription = R.string.art_7
                )

                8 -> ArtImage(
                    image = R.drawable.the_anatomy_lesson,
                    contentDescription = R.string.art_8
                )

                9 -> ArtImage(
                    image = R.drawable.the_birth_of_venus,
                    contentDescription = R.string.art_9
                )

                10 -> ArtImage(
                    image = R.drawable.the_wisdom_tree,
                    contentDescription = R.string.art_10
                )

                11 -> ArtImage(
                    image = R.drawable._0240623_164442,
                    contentDescription = R.string.art_1
                )
            }
        }
        Column(
            modifier = Modifier
                .padding(start = 40.dp, top = 450.dp, end = 40.dp)
                .verticalScroll(rememberScrollState())
                .fillMaxWidth(),
            verticalArrangement = Arrangement.Center
        )
        {
            when (currentTexts + 1) {
                1 -> ArtTexts(
                    artTitle = R.string.art_1,
                    artist = R.string.art_artist_1,
                    year = R.string.year_1
                )

                2 -> ArtTexts(
                    artTitle = R.string.art_2,
                    artist = R.string.art_artist_2,
                    year = R.string.year_2
                )

                3 -> ArtTexts(
                    artTitle = R.string.art_3,
                    artist = R.string.art_artist_3,
                    year = R.string.year_3
                )

                4 -> ArtTexts(
                    artTitle = R.string.art_4,
                    artist = R.string.art_artist_4,
                    year = R.string.year_4
                )

                5 -> ArtTexts(
                    artTitle = R.string.art_5,
                    artist = R.string.art_artist_5,
                    year = R.string.year_5
                )

                6 -> ArtTexts(
                    artTitle = R.string.art_6,
                    artist = R.string.art_artist_6,
                    year = R.string.year_6
                )

                7 -> ArtTexts(
                    artTitle = R.string.art_7,
                    artist = R.string.art_artist_7,
                    year = R.string.year_7
                )

                8 -> ArtTexts(
                    artTitle = R.string.art_8,
                    artist = R.string.art_artist_8,
                    year = R.string.year_8
                )

                9 -> ArtTexts(
                    artTitle = R.string.art_9,
                    artist = R.string.art_artist_9,
                    year = R.string.year_9
                )

                10 -> ArtTexts(
                    artTitle = R.string.art_10,
                    artist = R.string.art_artist_10,
                    year = R.string.year_10
                )

                11 -> ArtTexts(
                    artTitle = R.string.art_1,
                    artist = R.string.art_artist_1,
                    year = R.string.year_1
                )

            }
        }


        fun nextState() {
            currentImage = (currentImage + 1) % 11
            currentTexts = ((currentTexts + 1) % 11)

        }

        fun previousState() {
            currentImage = (currentImage + 11 - 1) % 11
            currentTexts = (currentTexts + 11 - 1) % 11
        }
        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .padding(
                    bottom = 100.dp,
                    start = 40.dp,
                    end = 40.dp
                )
                .fillMaxWidth()
                .verticalScroll(rememberScrollState())
        ) {
            Button(
                onClick = { previousState() },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.previous_btn))
            }
            Spacer(modifier = Modifier
                .padding(horizontal = 16.dp))

            Button(
                onClick = { nextState() },
                modifier = Modifier.weight(1f)
            ) {
                Text(stringResource(R.string.next_btn))
            }


        }


}


    @Composable
    fun ArtImage(
        modifier: Modifier = Modifier,
        image: Int,
        contentDescription: Int,

    ) {
        Card (modifier = Modifier
            .shadow(elevation = 7.dp)
            .clip(shape = RoundedCornerShape(5.dp))) {
            Image(
                painter = painterResource(image),
                contentDescription = stringResource(contentDescription),
                modifier = Modifier
                    .height(400.dp)
                    .width(400.dp)
            )
        }
        Spacer(modifier = Modifier.padding(top = 20.dp))
    }
        @Composable
        fun ArtTexts(
            artTitle: Int,
            artist: Int,
            year: Int
        ) {

                Text(
                    stringResource(artTitle),
                    fontSize = 32.sp,
                    lineHeight = 40.sp,
                    fontFamily = FontFamily.Serif
                )
                Row {
                    Text(
                        stringResource(artist),
                        fontWeight = FontWeight.Bold,
                        lineHeight = 40.sp,
                        fontFamily = FontFamily.Serif,

                    )
                    Text(
                        stringResource(year),
                        lineHeight = 40.sp,
                    )
                }


    }


    @Preview(showBackground = true)
    @Composable
    fun ArtGallerySpacePreview() {
        ArtSpaceGalleryTheme {
            ArtSpaceGallery()
        }
    }