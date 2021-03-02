/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.ui.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Favorite
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.ui.theme.grayFont

@Composable
fun PuppyImage(puppy: Puppy, modifier: Modifier) {
    Image(
        painter = painterResource(id = puppy.image),
        contentDescription = puppy.name,
        modifier = modifier
    )
}

@Composable
fun PuppyInfo(puppy: Puppy) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Row {
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = puppy.genderType,
                color = grayFont,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 5.dp, end = 16.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = stringResource(R.string.label_favorite),
                Modifier.background(Color.Transparent, shape = CircleShape)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.CenterEnd)
                    .padding(top = 5.dp, end = 16.dp),
                tint = if(puppy.isFavorite)Color.Red else Color.LightGray,
            )
        }
        Text(
            text = puppy.breed,
            style = MaterialTheme.typography.body1,
            color = grayFont,
            modifier = Modifier.padding(bottom = 10.dp)
        )
    }
}

@Composable
fun PuppyInfoInDetails(puppy: Puppy) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 16.dp)
    ) {
        Row {
            Text(
                text = puppy.name,
                style = MaterialTheme.typography.h5,
                color = MaterialTheme.colors.onBackground,
                modifier = Modifier.padding(bottom = 10.dp)
            )
            Text(
                text = puppy.genderType,
                color = grayFont,
                style = MaterialTheme.typography.body1,
                textAlign = TextAlign.End,
                modifier = Modifier
                    .padding(top = 5.dp, end = 16.dp)
            )
            Icon(
                imageVector = Icons.Outlined.Favorite,
                contentDescription = stringResource(R.string.label_favorite),
                Modifier.background(Color.Transparent, shape = CircleShape)
                    .fillMaxWidth()
                    .wrapContentSize(Alignment.CenterEnd)
                    .padding(top = 5.dp, end = 16.dp),
                tint = Color.Red,

            )
        }
        Text(
            text = puppy.breed,
            style = MaterialTheme.typography.body1,
            color = grayFont,
            modifier = Modifier.padding(bottom = 10.dp)
        )

        Row(modifier = Modifier.padding(bottom = 10.dp)) {
            Text(
                text = ("${puppy.age} old from ${puppy.hometown}"),
                style = MaterialTheme.typography.body2,
                color = grayFont,
            )
        }
    }
}
