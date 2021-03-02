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
package com.example.androiddevchallenge.ui.puppies
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.models.puppiesData
import com.example.androiddevchallenge.ui.component.PuppyImage
import com.example.androiddevchallenge.ui.component.PuppyInfo
import com.example.androiddevchallenge.ui.theme.shapes

@Composable
fun PuppyListContent(navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(id = R.string.adopt_a_puppy))
                }
            )
        },
        content = {
            PuppyList(
                puppies = puppiesData,
                Modifier.fillMaxWidth()
            ) {
                navController.navigate("detail/$it")
            }
        }
    )
}

@Composable
fun PuppyList(puppies: List<Puppy>, modifier: Modifier = Modifier, onClickListener: (catId: Int) -> Unit) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        items(items = puppies) { puppy ->
            PuppyCard(puppy, onClickListener)
        }
    }
}

@Composable
fun PuppyCard(puppy: Puppy, onClickListener: (catId: Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClickListener(puppy.id) },
        elevation = 8.dp
    ) {
        Row(
            modifier = Modifier
                .background(Color.Transparent, shape = shapes.medium)
                .size(150.dp)
                .semantics(mergeDescendants = true) {}
        ) {
            PuppyImage(
                puppy = puppy,
                modifier = Modifier
                    .background(puppy.background, shape = CircleShape)
                    .fillMaxHeight()
                    .width(150.dp)
            )
            PuppyInfo(puppy = puppy)
        }
    }
}
