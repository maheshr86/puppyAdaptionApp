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
package com.example.androiddevchallenge.ui.puppydetail

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.navigate
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.models.Puppy
import com.example.androiddevchallenge.models.puppiesData
import com.example.androiddevchallenge.ui.component.PuppyImage
import com.example.androiddevchallenge.ui.component.PuppyInfoInDetails
import com.example.androiddevchallenge.ui.theme.MyTheme

@Composable
fun PuppyDetailsContent(puppyId: Int, navController: NavController) {
    puppiesData.find { it.id == puppyId }?.let {
        PuppyDetails(it, navController = navController)
    }
}

@Composable
private fun Up(navController: NavController) {
    IconButton(
        onClick = { navController.navigate("puppies") },
        modifier = Modifier
            .size(36.dp)
            .wrapContentWidth(),
    ) {
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = stringResource(R.string.label_back)
        )
    }
}
@Composable
fun PuppyDetails(puppy: Puppy, navController: NavController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(puppy.name)
                },
                navigationIcon = { Up(navController = navController) }
            )
        },
        content = {

            val context = LocalContext.current

            Column {
                PuppyImage(
                    puppy = puppy,
                    modifier = Modifier
                        .height(450.dp)
                        .fillMaxWidth()
                        .background(puppy.background, shape = CircleShape)
                )
                PuppyInfoInDetails(puppy = puppy)

                Row(modifier = Modifier.fillMaxHeight(), verticalAlignment = Alignment.Bottom) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(100.dp)
                            .padding(24.dp),
                        onClick = {
                            Toast.makeText(context, R.string.thanks_adopt_me, Toast.LENGTH_SHORT).show()
                        }
                    ) {
                        Text(text = stringResource(id = R.string.adopt_me))
                    }
                }
            }
        }
    )
}

//region Previewers
@Preview("Light Theme", widthDp = 360, heightDp = 640)
@Composable
fun LightPreview() {
    MyTheme {
        PuppyDetails(puppiesData[0], navController = NavController(LocalContext.current))
    }
}

@Preview("Dark Theme", widthDp = 360, heightDp = 640)
@Composable
fun DarkPreview() {
    MyTheme(darkTheme = true) {
        PuppyDetails(puppiesData[0], navController = NavController(LocalContext.current))
    }
}
//endregion
