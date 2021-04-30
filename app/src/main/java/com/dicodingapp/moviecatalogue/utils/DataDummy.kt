package com.dicodingapp.moviecatalogue.utils

import android.app.Activity
import com.dicodingapp.moviecatalogue.data.GenresEntity
import com.dicodingapp.moviecatalogue.data.MovieEntity

object DataDummy {

    fun generateDummyMovie(activity: Activity): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        val listGenresEntity = ArrayList<GenresEntity>()
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("10749", "Romance"))
        listGenresEntity.add(GenresEntity("10402", "Music"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "332562",
                "A Star Is Born",
                "2018-10-03",
                "Released",
                "",
                7.5,
                activity.resources.getIdentifier(
                    "poster_a_start_is_born",
                    "drawable",
                    activity.packageName
                ),
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "399579",
                "Alita: Battle Angel",
                "2019-01-31",
                "Released",
                "An angel falls. A warrior rises.",
                7.2,
                activity.resources.getIdentifier("poster_alita", "drawable", activity.packageName),
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("14", "Fantasy"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "297802",
                "Aquaman",
                "2018-12-07",
                "Released",
                "Home Is Calling",
                6.9,
                activity.resources.getIdentifier(
                    "poster_aquaman",
                    "drawable",
                    activity.packageName
                ),
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("10402", "Music"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "424694",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Released",
                "Fearless lives forever",
                8.0,
                activity.resources.getIdentifier(
                    "poster_bohemian",
                    "drawable",
                    activity.packageName
                ),
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("80", "Crime"))
        listGenresEntity.add(GenresEntity("53", "Thriller"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "438650",
                "Cold Pursuit",
                "2019-02-07",
                "Released",
                "Meet Nels Coxman. Citizen of the Year.",
                5.7,
                activity.resources.getIdentifier(
                    "poster_cold_persuit",
                    "drawable",
                    activity.packageName
                ),
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("18", "Drama"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "480530",
                "Creed II",
                "2018-11-21",
                "Released",
                "There's More to Lose than a Title",
                6.9,
                activity.resources.getIdentifier("poster_creed", "drawable", activity.packageName),
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("18", "Drama"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "338952",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Released",
                "Fate of One. Future of All.",
                6.9,
                activity.resources.getIdentifier("poster_crimes", "drawable", activity.packageName),
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("53", "Thriller"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "450465",
                "Glass",
                "2019-01-16",
                "Released",
                "You Cannot Contain What You Are",
                6.7,
                activity.resources.getIdentifier("poster_glass", "drawable", activity.packageName),
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("16", "Animation"))
        listGenresEntity.add(GenresEntity("10751", "Family"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "10191",
                "How to Train Your Dragon",
                "2010-03-10",
                "Released",
                "One adventure will change two worlds",
                7.8,
                activity.resources.getIdentifier(
                    "poster_how_to_train",
                    "drawable",
                    activity.packageName
                ),
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father"
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "299536",
                "Avengers: Infinity War",
                "2018-04-25",
                "Released",
                "An entire universe. Once and for all.",
                8.3,
                activity.resources.getIdentifier(
                    "poster_infinity_war",
                    "drawable",
                    activity.packageName
                ),
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "457136",
                "Mary Queen of Scots",
                "2018-12-07",
                "Released",
                "Bow to No One",
                6.6,
                activity.resources.getIdentifier(
                    "poster_marry_queen",
                    "drawable",
                    activity.packageName
                ),
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("28", "Action"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "450001",
                "Master Z: Ip Man Legacy",
                "2018-12-20",
                "Released",
                "",
                6.0,
                activity.resources.getIdentifier(
                    "poster_master_z",
                    "drawable",
                    activity.packageName
                ),
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "428078",
                "Mortal Engines",
                "2018-11-27",
                "Released",
                "Some scars never heal",
                6.1,
                activity.resources.getIdentifier(
                    "poster_mortal_engines",
                    "drawable",
                    activity.packageName
                ),
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("27", "Horror"))
        listGenresEntity.add(GenresEntity("10752", "War"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "438799",
                "Overlord",
                "2018-11-01",
                "Released",
                "Stop the unstoppable",
                6.7,
                activity.resources.getIdentifier(
                    "poster_overlord",
                    "drawable",
                    activity.packageName
                ),
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("10751", "Family"))
        listGenresEntity.add(GenresEntity("16", "Animation"))
        listGenresEntity.add(GenresEntity("35", "Comedy"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "82690",
                "Wreck-It Ralph",
                "2012-11-01",
                "Released",
                "The story of a regular guy just looking for a little wreck-ognition.",
                7.3,
                activity.resources.getIdentifier("poster_ralph", "drawable", activity.packageName),
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("53", "Thriller"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "375588",
                "Robin Hood",
                "2018-11-21",
                "Released",
                "The legend you know. The story you don't.",
                5.9,
                activity.resources.getIdentifier(
                    "poster_robin_hood",
                    "drawable",
                    activity.packageName
                ),
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("53", "Thriller"))
        listGenresEntity.add(GenresEntity("9648", "Mystery"))
        listGenresEntity.add(GenresEntity("18", "Drama"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "452832",
                "Serenity",
                "2019-01-24",
                "Released",
                "On Plymouth Island, no one ever dies… unless you break the rules",
                5.4,
                activity.resources.getIdentifier(
                    "poster_serenity",
                    "drawable",
                    activity.packageName
                ),
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("28", "Action"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "557",
                "Spider-Man",
                "2002-05-01",
                "Released",
                "Go for the ultimate spin.",
                7.2,
                activity.resources.getIdentifier(
                    "poster_spiderman",
                    "drawable",
                    activity.packageName
                ),
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man."
            )
        )

        listGenresEntity.clear()
        listGenresEntity.add(GenresEntity("10752", "War"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        movies.add(
            MovieEntity(
                listGenresEntity,
                "505954",
                "T-34",
                "2018-12-27",
                "Released",
                "Fast And Furious On Tanks",
                6.9,
                activity.resources.getIdentifier("poster_t34", "drawable", activity.packageName),
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles."
            )
        )

        return movies
    }
}