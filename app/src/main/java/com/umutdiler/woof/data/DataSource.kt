package com.umutdiler.woof.data

import com.umutdiler.woof.R

object DataSource {
    fun loadDogs(): List<Dog> {
        return listOf<Dog>(
            Dog(
                image = R.drawable.bella,
                name = "Buddy",
                age = 5,
                hobbies = R.string.dog_description_1
            ),
            Dog(
                image = R.drawable.faye,
                name = "Molly",
                age = 3,
                hobbies = R.string.dog_description_2
            ),
            Dog(
                image = R.drawable.frankie,
                name = "Max",
                age = 2,
                hobbies =R.string.dog_description_3
            ),
            Dog(
                image = R.drawable.koda,
                name = "Daisy",
                age = 4,
                hobbies = R.string.dog_description_4
            ),
            Dog(
                image = R.drawable.leroy,
                name = "Rocky",
                age = 6,
                hobbies = R.string.dog_description_5
            ),
            Dog(
                image = R.drawable.lola,
                name = "Lucy",
                age = 1,
                hobbies = R.string.dog_description_6
            ),
            Dog(
                image = R.drawable.moana,
                name = "Bailey",
                age = 7,
                hobbies = R.string.dog_description_7
            ),
            Dog(
                image = R.drawable.nox,
                name = "Duke",
                age = 8,
                hobbies = R.string.dog_description_8
            ),
            Dog(
                image = R.drawable.tzeitel,
                name = "Luna",
                age = 9,
                hobbies = R.string.dog_description_9
            ),

            )


    }
}