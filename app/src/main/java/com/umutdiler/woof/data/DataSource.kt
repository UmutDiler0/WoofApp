package com.umutdiler.woof.data

import com.umutdiler.woof.R

object DataSource {
    fun loadDogs(): List<Dog> {
        return listOf<Dog>(
            Dog(
                image = R.drawable.bella,
                name = "Buddy",
                age = 5,
                hobbies = "Playing fetch"
            ),
            Dog(
                image = R.drawable.faye,
                name = "Molly",
                age = 3,
                hobbies = "Chasing squirrels"
            ),
            Dog(
                image = R.drawable.frankie,
                name = "Max",
                age = 2,
                hobbies = "Running in the park"
            ),
            Dog(
                image = R.drawable.koda,
                name = "Daisy",
                age = 4,
                hobbies = "Cuddling"
            ),
            Dog(
                image = R.drawable.leroy,
                name = "Rocky",
                age = 6,
                hobbies = "Playing tug-of-war"
            ),
            Dog(
                image = R.drawable.lola,
                name = "Lucy",
                age = 1,
                hobbies = "Chewing shoes"
            ),
            Dog(
                image = R.drawable.moana,
                name = "Bailey",
                age = 7,
                hobbies = "Digging holes"
            ),
            Dog(
                image = R.drawable.nox,
                name = "Duke",
                age = 8,
                hobbies = "Barking at the mailman"
            ),
            Dog(
                image = R.drawable.tzeitel,
                name = "Luna",
                age = 9,
                hobbies = "Chasing the mailman"
            ),

            )


    }
}