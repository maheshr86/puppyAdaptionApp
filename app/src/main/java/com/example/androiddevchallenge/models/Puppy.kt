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
package com.example.androiddevchallenge.models

import androidx.compose.ui.graphics.Color
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.ui.theme.lightBlue
import com.example.androiddevchallenge.ui.theme.lightPink

data class Puppy(
    val id: Int,
    val name: String,
    val image: Int,
    val genderType: String,
    val age: String,
    val breed: String,
    val background: Color,
    val hometown: String,
    val isFavorite:Boolean
)
/**
 * Static data
 */

val puppiesData = listOf(
    Puppy(1, "Bella", R.drawable.labroder, "♂️", "8 months", "Labrador", lightBlue, "Tokyo",true),
    Puppy(2, "Ulrica", R.drawable.corgi, "♀️", "2 years", "Corgi", lightPink, "Osaka",false),
    Puppy(3, "Kaala", R.drawable.dalmatian, "♂️", "9 months", "Dalmatian", lightBlue, "Bengaluru",false),
    Puppy(4, "Chicoo", R.drawable.greyhound, "♀️", "2 months", "Greyhound", lightPink, "London",true),
    Puppy(5, "Maru", R.drawable.bulldog, "♂️", "1 year", "Bulldog", lightBlue, "New York",false),
    Puppy(6, "Coco", R.drawable.french_bulldog, "♂️", "3 years", "French Bulldog", lightBlue, "Paris",true)
)
