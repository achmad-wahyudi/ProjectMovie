package com.dicodingapp.moviecatalogue.utils

import com.dicodingapp.moviecatalogue.data.*

object DataDummy {

    fun generateDummyMovie(): List<MovieEntity> {

        val movies = ArrayList<MovieEntity>()

        var listGenresEntity = ArrayList<GenresEntity>()
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("10749", "Romance"))
        listGenresEntity.add(GenresEntity("10402", "Music"))

        var listCastEntity = ArrayList<CastEntity>()
        listCastEntity.add(
            CastEntity(
                "51329",
                "Bradley Cooper",
                "Jackson Maine",
                "/DPnessSsWqVXRbKm93PtMjB4Us.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "237405",
                "Lady Gaga",
                "Ally Campana",
                "/asB6CImOsNGA5i9HHt2FFCtP2QJ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "16431",
                "Sam Elliott",
                "Bobby Maine",
                "/1K2IvGXFbKsgkExuUsRvy4F0c9e.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "57906",
                "Andrew Dice Clay",
                "Lorenzo Campana",
                "/kq6APbPUbx0Mzoh6mK7k8Xoiw5m.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "21660",
                "Rafi Gavron",
                "Rez Gavron",
                "/avCWoO9fLwEhbT6cvu0TJcSj49g.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1560244",
                "Anthony Ramos",
                "Ramon",
                "/ityTHqIXFT3laID4j4ptlnc84zq.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "332562",
                "A Star Is Born",
                "2018-10-03",
                "Released",
                "",
                7.5,
                "poster_a_start_is_born",
                "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
                "/mnDvPokXpvsdPcWSjNRPhiiLOKu.jpg",
                listCastEntity,
                36000000,
                433888866
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "973667",
                "Rosa Salazar",
                "Alita",
                "/pc2tCeB99HtmrghAoPKksZkbzUU.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "27319",
                "Christoph Waltz",
                "Dr. Dyson Ido",
                "/2Hhztd4mUEV9Y25rfkXDwzL9QI9.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "6161",
                "Jennifer Connelly",
                "Chiren",
                "/egh1eOHuYgeoqdlLQgaXMl6cPOm.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "399579",
                "Alita: Battle Angel",
                "2019-01-31",
                "Released",
                "An angel falls. A warrior rises.",
                7.2,
                "poster_alita",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "/8RKBHHRqOMOLh5qW3sS6TSFTd8h.jpg",
                listCastEntity,
                170000000,
                404852543
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("14", "Fantasy"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "117642",
                "Jason Momoa",
                "Arthur Curry / Aquaman",
                "/6dEFBpZH8C8OijsynkSajQT99Pb.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "55085",
                "Amber Heard",
                "Mera",
                "/1cb5mGzGB6Sj2JPkWt9W16B19Bf.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "5293",
                "Willem Dafoe",
                "Nuidis Vulko",
                "/ui8e4sgZAwMPi3hzEO53jyBJF9B.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "297802",
                "Aquaman",
                "2018-12-07",
                "Released",
                "Home Is Calling",
                6.9,
                "poster_aquaman",
                "When Alita awakens with no memory of who she is in a future world she does not recognize, she is taken in by Ido, a compassionate doctor who realizes that somewhere in this abandoned cyborg shell is the heart and soul of a young woman with an extraordinary past.",
                "/9QusGjxcYvfPD1THg6oW3RLeNn7.jpg",
                listCastEntity,
                160000000,
                1148461807
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("10402", "Music"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "17838",
                "Rami Malek",
                "Freddie Mercury",
                "/2OuFzCbMibXGouG79tG1U4BLPbe.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1220123",
                "Gwilym Lee",
                "Brian May",
                "/bHSmjJLJyrg5Q0tC0W2FFreuOnO.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1452045",
                "Ben Hardy",
                "Roger Taylor",
                "/s8UEIomgY5AaEmPHkcPAScp68Fw.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "424694",
                "Bohemian Rhapsody",
                "2018-10-24",
                "Released",
                "Fearless lives forever",
                8.0,
                "poster_bohemian",
                "Singer Freddie Mercury, guitarist Brian May, drummer Roger Taylor and bass guitarist John Deacon take the music world by storm when they form the rock 'n' roll band Queen in 1970. Hit songs become instant classics. When Mercury's increasingly wild lifestyle starts to spiral out of control, Queen soon faces its greatest challenge yet – finding a way to keep the band together amid the success and excess.",
                "/jNUpYq2jRSwQM89vST9yQZelMSu.jpg",
                listCastEntity,
                52000000,
                894027543
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("80", "Crime"))
        listGenresEntity.add(GenresEntity("53", "Thriller"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "3896",
                "Liam Neeson",
                "Nels Coxman",
                "/jrf9LaTFWfLA5DBhFWENFsWh4Y9.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "4784",
                "Laura Dern",
                "Grace Coxman",
                "/2Ryt0SsExqWrLTzBu6sZcbLwoDJ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "4730",
                "Emmy Rossum",
                "Kim Dash",
                "/aJ8bzA1WJOBFx0Ppdo1fLMiNxLh.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "438650",
                "Cold Pursuit",
                "2019-02-07",
                "Released",
                "Meet Nels Coxman. Citizen of the Year.",
                5.7,
                "poster_cold_persuit",
                "The quiet family life of Nels Coxman, a snowplow driver, is upended after his son's murder. Nels begins a vengeful hunt for Viking, the drug lord he holds responsible for the killing, eliminating Viking's associates one by one. As Nels draws closer to Viking, his actions bring even more unexpected and violent consequences, as he proves that revenge is all in the execution.",
                "/aiM3XxYE2JvW1vJ4AC6cI1RjAoT.jpg",
                listCastEntity,
                60000000,
                76419755
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("18", "Drama"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "135651",
                "Michael B. Jordan",
                "Adonis Creed",
                "/w9cvmBtFc0oV66UGokJgv9fGRZ3.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "16483",
                "Sylvester Stallone",
                "Robert \"Rocky\" Balboa Sr.",
                "/qDRGPAcQoW8Wuig9bvoLpHwf1gU.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "480530",
                "Creed II",
                "2018-11-21",
                "Released",
                "There's More to Lose than a Title",
                6.9,
                "poster_creed",
                "Between personal obligations and training for his next big fight against an opponent with ties to his family's past, Adonis Creed is up against the challenge of his life.",
                "/9il7qNbeYnPMYlutsVYDsj4hRyb.jpg",
                listCastEntity,
                50000000,
                214215889
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("18", "Drama"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "37632",
                "Eddie Redmayne",
                "Newt Scamander",
                "/fSvG7qzoBBnJUmgtIuMgrK3EQPN.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "338952",
                "Fantastic Beasts: The Crimes of Grindelwald",
                "2018-11-14",
                "Released",
                "Fate of One. Future of All.",
                6.9,
                "poster_crimes",
                "Gellert Grindelwald has escaped imprisonment and has begun gathering followers to his cause—elevating wizards above all non-magical beings. The only one capable of putting a stop to him is the wizard he once called his closest friend, Albus Dumbledore. However, Dumbledore will need to seek help from the wizard who had thwarted Grindelwald once before, his former student Newt Scamander, who agrees to help, unaware of the dangers that lie ahead. Lines are drawn as love and loyalty are tested, even among the truest friends and family, in an increasingly divided wizarding world.",
                "/qrtRKRzoNkf5vemO9tJ2Y4DrHxQ.jpg",
                listCastEntity,
                200000000,
                653355901
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("53", "Thriller"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "5530",
                "James McAvoy",
                "Patricia",
                "/vB6qYlFXgONGVwwxWXE4gf0F8SQ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "62",
                "Bruce Willis",
                "David Dunn",
                "/caX3KtMU42EP3VLRFFBwqIIrch5.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1397778",
                "Anya Taylor-Joy",
                "Casey Cooke",
                "/9j48tPgy4Exrfx0gFm88Pp0rzr4.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "450465",
                "Glass",
                "2019-01-16",
                "Released",
                "You Cannot Contain What You Are",
                6.7,
                "poster_glass",
                "In a series of escalating encounters, former security guard David Dunn uses his supernatural abilities to track Kevin Wendell Crumb, a disturbed man who has twenty-four personalities. Meanwhile, the shadowy presence of Elijah Price emerges as an orchestrator who holds secrets critical to both men.",
                "/ngBFDOsx13sFXiMweDoL54XYknR.jpg",
                listCastEntity,
                20000000,
                246941965
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("16", "Animation"))
        listGenresEntity.add(GenresEntity("10751", "Family"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "449",
                "Jay Baruchel",
                "Hiccup  Horrendous Haddock III (voice)",
                "/hTg6RJMxpxcsYzmdre81TznDATZ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "17276",
                "Gerard Butler",
                "Stoick the Vast (voice)",
                "/eJn92Loeq9GzKJVkCaVEQejIq2Z.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "24264",
                "Craig Ferguson",
                "Gobber the Belch (voice)",
                "/mBxNrOxdQeM7bVBveE47Syj9ES6.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "10191",
                "How to Train Your Dragon",
                "2010-03-10",
                "Released",
                "One adventure will change two worlds",
                7.8,
                "poster_how_to_train",
                "As the son of a Viking leader on the cusp of manhood, shy Hiccup Horrendous Haddock III faces a rite of passage: he must kill a dragon to prove his warrior mettle. But after downing a feared dragon, he realizes that he no longer wants to destroy it, and instead befriends the beast – which he names Toothless – much to the chagrin of his warrior father",
                "/kxklJL1v8MYEU5xdU6W5VvmBwVz.jpg",
                listCastEntity,
                165000000,
                494878759
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "3223",
                "Robert Downey Jr.",
                "Tony Stark",
                "/5qHNjhtjMD4YWH3UP0rm4tKwxCL.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "74568",
                "Chris Hemsworth",
                "Thor Odinson",
                "/jpurJ9jAcLCYjgHHfYF32m3zJYm.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "16828",
                "Chris Evans",
                "Steve Rogers",
                "/3bOGNsHlrswhyW79uvIHH1V43JI.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "299536",
                "Avengers: Infinity War",
                "2018-04-25",
                "Released",
                "An entire universe. Once and for all.",
                8.3,
                "poster_infinity_war",
                "As the Avengers and their allies have continued to protect the world from threats too large for any one hero to handle, a new danger has emerged from the cosmic shadows: Thanos. A despot of intergalactic infamy, his goal is to collect all six Infinity Stones, artifacts of unimaginable power, and use them to inflict his twisted will on all of reality. Everything the Avengers have fought for has led up to this moment - the fate of Earth and existence itself has never been more uncertain.",
                "/lmZFxXgJE3vgrciwuDib0N8CfQo.jpg",
                listCastEntity,
                300000000,
                2046239637
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "36592",
                "Saoirse Ronan",
                "Mary Stuart",
                "/4plcgNpHArZUTiYqgpQdGw4PZdT.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "234352",
                "Margot Robbie",
                "Queen Elizabeth I",
                "/euDPyqLnuwaWMHajcU3oZ9uZezR.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1334638",
                "Jack Lowden",
                "Henry Darnley",
                "/5bW2477C2Rc4tCpCjyKFITMXOAt.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "457136",
                "Mary Queen of Scots",
                "2018-12-07",
                "Released",
                "Bow to No One",
                6.6,
                "poster_marry_queen",
                "In 1561, Mary Stuart, widow of the King of France, returns to Scotland, reclaims her rightful throne and menaces the future of Queen Elizabeth I as ruler of England, because she has a legitimate claim to the English throne. Betrayals, rebellions, conspiracies and their own life choices imperil both Queens. They experience the bitter cost of power, until their tragic fate is finally fulfilled.",
                "/iv5N169nQIzrS0pZ8MBEiemTtVt.jpg",
                listCastEntity,
                25000000,
                37807625
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("28", "Action"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1183808",
                "Zhang Jin",
                "Cheung Tin-Chi",
                "/2i6nREFIyRYvIWxCBgWiarsGC1t.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "543530",
                "Dave Bautista",
                "Owen Davidson",
                "/ymn6iQBJbQZN6BYI60YJDXVP4gF.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1185787",
                "Liu Yan",
                "Julia",
                "/iTimJWpWDGmnnPs13v7Fgy2mIpL.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "450001",
                "Master Z: Ip Man Legacy",
                "2018-12-20",
                "Released",
                "",
                6.0,
                "poster_master_z",
                "Following his defeat by Master Ip, Cheung Tin Chi tries to make a life with his young son in Hong Kong, waiting tables at a bar that caters to expats. But it's not long before the mix of foreigners, money, and triad leaders draw him once again to the fight.",
                "/grtVFGJ4ts0nDAPpc1JWbBoVKTu.jpg",
                listCastEntity,
                0,
                21832649
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "586286",
                "Hera Hilmar",
                "Hester Shaw",
                "/hUgQJYayUWt3zON9COn0f7RVJxF.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "118616",
                "Robert Sheehan",
                "Tom Natsworthy",
                "/2rum1TvJyB13RMERueiH1MrBmjZ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1331",
                "Hugo Weaving",
                "Thaddeus Valentine",
                "/bCZZmy45zZPsXZHQjeln04TedNt.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "428078",
                "Mortal Engines",
                "2018-11-27",
                "Released",
                "Some scars never heal",
                6.1,
                "poster_mortal_engines",
                "Many thousands of years in the future, Earth’s cities roam the globe on huge wheels, devouring each other in a struggle for ever diminishing resources. On one of these massive traction cities, the old London, Tom Natsworthy has an unexpected encounter with a mysterious young woman from the wastelands who will change the course of his life forever.",
                "/rm2oMykm5nX6SzXFr7TGHkO6r8Z.jpg",
                listCastEntity,
                100000000,
                83672673
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("27", "Horror"))
        listGenresEntity.add(GenresEntity("10752", "War"))
        listGenresEntity.add(GenresEntity("878", "Science Fiction"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1700784",
                "Mathilde Ollivier",
                "Chloe",
                "/nMTR0qUQI7VY6ae0KEAEXsThYpR.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1607522",
                "Private First Class Edward Boyce",
                "Chloe",
                "/5XiNuuKsuG2cApzPJuHv1YC2CGn.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "986808",
                "Wyatt Russell",
                "Corporal Lewis Ford",
                "/f759e6y7uhobWRCmD0O21cBmjBA.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "438799",
                "Overlord",
                "2018-11-01",
                "Released",
                "Stop the unstoppable",
                6.7,
                "poster_overlord",
                "France, June 1944. On the eve of D-Day, some American paratroopers fall behind enemy lines after their aircraft crashes while on a mission to destroy a radio tower in a small village near the beaches of Normandy. After reaching their target, the surviving paratroopers realise that, in addition to fighting the Nazi troops that patrol the village, they also must fight against something else.",
                "/sHNC8hjAu4ZKXYhG3cp8ghRZ02B.jpg",
                listCastEntity,
                38000000,
                41657844
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("10751", "Family"))
        listGenresEntity.add(GenresEntity("16", "Animation"))
        listGenresEntity.add(GenresEntity("35", "Comedy"))
        listGenresEntity.add(GenresEntity("12", "Adventure"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "4764",
                "John C. Reilly",
                "Wreck-It Ralph (voice)",
                "/iDQ8w4qcxU3le5ZWoCKpHs1QNok.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "7404",
                "Sarah Silverman",
                "Vanellope von Schweetz (voice)",
                "/g5G711XyVokJm2RoItpkaHa8mkQ.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "58737",
                "Jack McBrayer",
                "Fix-It Felix (voice)",
                "/cbr26xDPEiOuYQxggtCPbu5xhDU.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "82690",
                "Wreck-It Ralph",
                "2012-11-01",
                "Released",
                "The story of a regular guy just looking for a little wreck-ognition.",
                7.3,
                "poster_ralph",
                "Wreck-It Ralph is the 9-foot-tall, 643-pound villain of an arcade video game named Fix-It Felix Jr., in which the game's titular hero fixes buildings that Ralph destroys. Wanting to prove he can be a good guy and not just a villain, Ralph escapes his game and lands in Hero's Duty, a first-person shooter where he helps the game's hero battle against alien invaders. He later enters Sugar Rush, a kart racing game set on tracks made of candies, cookies and other sweets. There, Ralph meets Vanellope von Schweetz who has learned that her game is faced with a dire threat that could affect the entire arcade, and one that Ralph may have inadvertently started.",
                "/ziC23LkMYj8gToQQYQGWSGJCLNF.jpg",
                listCastEntity,
                165000000,
                471222889
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("12", "Adventure"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("53", "Thriller"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1303037",
                "Taron Egerton",
                "Robin of Loxley",
                "/vzacIvSHfkZ6gNYyBFwG7vq4yDO.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "134",
                "Jamie Foxx",
                "Yahya",
                "/hPwCMEq6jLAidsXAX5BfoYgIfg2.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "77335",
                "Ben Mendelsohn",
                "Sheriff of Nottingham",
                "/pA9mu9D2IolVA0v2Yo0tJm6uUyI.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "375588",
                "Robin Hood",
                "2018-11-21",
                "Released",
                "The legend you know. The story you don't.",
                5.9,
                "poster_robin_hood",
                "A war-hardened Crusader and his Moorish commander mount an audacious revolt against the corrupt English crown.",
                "/zSJT1sKGRKcmP4I9b8dIOuepw6I.jpg",
                listCastEntity,
                100000000,
                86493046
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("53", "Thriller"))
        listGenresEntity.add(GenresEntity("9648", "Mystery"))
        listGenresEntity.add(GenresEntity("18", "Drama"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "10297",
                "Matthew McConaughey",
                "Baker Dill",
                "/wJiGedOCZhwMx9DezY8uwbNxmAY.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1813",
                "Anne Hathaway",
                "Karen Zariakas",
                "/tLelKoPNiyJCSEtQTz1FGv4TLGc.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "76512",
                "Jason Clarke",
                "Frank Zariakas",
                "/quH4y2dto3UAgZOfaM0QriyRLPN.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "452832",
                "Serenity",
                "2019-01-24",
                "Released",
                "On Plymouth Island, no one ever dies… unless you break the rules",
                5.4,
                "poster_serenity",
                "The quiet life of Baker Dill, a fishing boat captain who lives on the isolated Plymouth Island, where he spends his days obsessed with capturing an elusive tuna while fighting his personal demons, is interrupted when someone from his past comes to him searching for help.",
                "/ridcUDnFumpMB5AAsIvFafTSx5i.jpg",
                listCastEntity,
                25000000,
                14454622
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("14", "Fantasy"))
        listGenresEntity.add(GenresEntity("28", "Action"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "2219",
                "Tobey Maguire",
                "Peter Parker / Spider-Man",
                "/ncF4HivY2W6SQW5dEP3N3I4mfT0.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "5293",
                "Willem Dafoe",
                "Norman Osborn / Green Goblin",
                "/ui8e4sgZAwMPi3hzEO53jyBJF9B.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "205",
                "Kirsten Dunst",
                "Mary Jane Watson",
                "/5dI5s8Oq2Ook5PFzTWMW6DCXVjm.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "557",
                "Spider-Man",
                "2002-05-01",
                "Released",
                "Go for the ultimate spin.",
                7.2,
                "poster_spiderman",
                "After being bitten by a genetically altered spider, nerdy high school student Peter Parker is endowed with amazing powers to become the Amazing superhero known as Spider-Man.",
                "/muth4OYamXf41G2evdrLEg8d3om.jpg",
                listCastEntity,
                139000000,
                821708551
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("10752", "War"))
        listGenresEntity.add(GenresEntity("28", "Action"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("36", "History"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1631759",
                "Alexander Petrov",
                "Nikolay Ivushkin",
                "/2lMDBpx3F7pVzgXHhik9G2XbiK9.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1429670",
                "Victor Dobronravov",
                "Vasilenok",
                "/2bF7r6maALCa6cAn9NmFMXylCum.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1633339",
                "Irina Starshenbaum",
                "Anya Yartseva",
                "/pMeneYaFRT4u08zUwmfvpo49Wo7.jpg"
            )
        )

        movies.add(
            MovieEntity(
                listGenresEntity,
                "505954",
                "T-34",
                "2018-12-27",
                "Released",
                "Fast And Furious On Tanks",
                6.9,
                "poster_t34",
                "In 1944, a courageous group of Russian soldiers managed to escape from German captivity in a half-destroyed legendary T-34 tank. Those were the times of unforgettable bravery, fierce fighting, unbreakable love, and legendary miracles.",
                "/3QVSM3DYxvov57j25vxDNJGHUpQ.jpg",
                listCastEntity,
                8000000,
                36220872
            )
        )

        return movies
    }

    fun generateDummyTvShow(): List<TvShowEntity> {

        val tvShow = ArrayList<TvShowEntity>()

        var listGenresEntity = ArrayList<GenresEntity>()
        listGenresEntity.add(GenresEntity("80", "Crime"))
        listGenresEntity.add(GenresEntity("18", "Drama"))
        listGenresEntity.add(GenresEntity("9648", "Mystery"))
        listGenresEntity.add(GenresEntity("10759", "Action & Adventure"))

        var listCastEntity = ArrayList<CastEntity>()
        listCastEntity.add(
            CastEntity(
                "76110",
                "Stephen Amell",
                "Oliver Queen / Green Arrow",
                "/gN8cpnUaPIzWhVufahmzV0dwOgp.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "116774",
                "David Ramsey",
                "John Diggle / Spartan",
                "/bZWO7WfBYI8iojTFozzqN2X3RWL.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "55775",
                "Katie Cassidy",
                "Laurel Lance / Black Canary",
                "/mcRo6KyzYOE7prr01mTd5b2TstI.jpg"
            )
        )

        var tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2012-10-10",
            "10",
            "1973846",
            "Fadeout",
            "After eight seasons, and the launch of countless superheroes, the series wraps up the story of the Green Arrow.",
            "8",
            "/x2uJkULqhVhosfjlqTknZtv1QyZ.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/vNnLAKmoczRlNarxyGrrw0KSOeX.jpg",
                "2012-10-10",
                listGenresEntity,
                "1412",
                "2020-01-28",
                tvShowLastEpisodeEntity,
                "Arrow",
                170,
                8,
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "poster_arrow",
                "Ended",
                "Heroes fall. Legends rise.",
                "Scripted",
                6.6,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("10765", "Sci-Fi & Fantasy"))
        listGenresEntity.add(GenresEntity("35", "Comedy"))
        listGenresEntity.add(GenresEntity("18", "Drama"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Diane Guerrero",
                "Crazy Jane",
                "/5LXvRYdxKLWROAD2KDSXzRNNSdE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "April Bowlby",
                "Rita Farr / Elasti-Woman",
                "/c5Yk2tqApmbmKXHoPbYQauXssED.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Joivan Wade",
                "Victor Stone / Cyborg",
                "/7tPro9hPR54m3zbLIfypsDDUDCI.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2020-08-06",
            "9",
            "2354685",
            "Wax Patrol",
            "Before the Doom Patrol can answer a call to save the world from The Candlemaker in the season finale, they must first battle long-forgotten imaginary friends.",
            "2",
            "/nlI6o5l04ovzy7W3YNWTokwMuwN.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/b7unxzWSFfj7i6UVmuPixxxXFOF.jpg",
                "2019-02-15",
                listGenresEntity,
                "79501",
                "2020-08-06",
                tvShowLastEpisodeEntity,
                "Doom Patrol",
                24,
                2,
                "The Doom Patrol’s members each suffered horrible accidents that gave them superhuman abilities — but also left them scarred and disfigured. Traumatized and downtrodden, the team found purpose through The Chief, who brought them together to investigate the weirdest phenomena in existence — and to protect Earth from what they find.",
                "poster_doom_patrol",
                "Returning Series",
                "",
                "Scripted",
                7.6,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()

        listCastEntity = ArrayList()

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2020-04-29",
            "10",
            "2710571",
            "Episode 10",
            "",
            "1",
            "",
        )

        tvShow.add(
            TvShowEntity(
                "/vNnLAKmoczRlNarxyGrrw0KSOeX.jpg",
                "2012-11-30",
                listGenresEntity,
                "1180111",
                "2020-04-29",
                tvShowLastEpisodeEntity,
                "Dragon Ball Absalon",
                15,
                1,
                "The series begins twelve years after Goku is seen leaving on Shenron not at the end of Dragon Ball GT, and diverges entirely into its own plot from there, on an alternate timeline from the one which shows Goku Jr. fighting Vegeta Jr. at the World Martial Arts Tournament. In this series, Majuub has reached new levels of power, and has honed the techniques taught to him by Goku. We also see Gotenks finally mature, and Vegeta more powerful than ever.Each character will bring forth their own set of capabilities and purpose, winning fights and being relevant, in order to create an environment that emphasizes teamwork as well as individual worth for each character. In this series, the main set of villains are Saiyans, with abilities highly similar to the Saiyans that we are familiar with. These new Saiyans are more powerful than any threat the Z Fighters have ever faced, but after twelve years of intensive training, our heroes will not be easily defeated .",
                "poster_dragon_ball",
                "Returning Series",
                "",
                "Scripted",
                5.3,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("10765", "Action & Adventure"))
        listGenresEntity.add(GenresEntity("35", "Animation"))
        listGenresEntity.add(GenresEntity("18", "Comedy"))
        listGenresEntity.add(GenresEntity("18", "Sci-Fi & Fantasy"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2019-09-29",
            "51",
            "23546852",
            "Dearest Friends",
            "Using the power of all seven Dragon Slayers, Natsu unleashes one final, soulful attack on Acnologia. One year later, Lucy reveals everything that has happened since the battle.",
            "8",
            "/sOzVgRsIjisBMQUxeMjnw1oF40w.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/fANxNeH9JCXPrzNEfriGu1Y95dF.jpg",
                "2009-10-12",
                listGenresEntity,
                "462612",
                "2019-09-29",
                tvShowLastEpisodeEntity,
                "Fairy Tail",
                328,
                8,
                "Lucy is a 17-year-old girl, who wants to be a full-fledged mage. One day when visiting Harujion Town, she meets Natsu, a young man who gets sick easily by any type of transportation. But Natsu isn't just any ordinary kid, he's a member of one of the world's most infamous mage guilds: Fairy Tail.",
                "poster_fairytail",
                "Ended",
                "Fairy Tail",
                "Scripted",
                7.8,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Animation"))
        listGenresEntity.add(GenresEntity("18", "Comedy"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2021-04-18",
            "17",
            "2354685",
            "Young Parent Trap",
            "Lois and Peter are mistaken for \"young parents\" by another couple at Stewie's school and invited to live in a millennial apartment complex, leaving Meg and Chris home alone.",
            "19",
            "/vrFQu444wbvu5LuFRU2yxuHPvdO.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/eyO5b3b3wgfiyuIKQMAyekh40A2.jpg",
                "1999-01-31",
                listGenresEntity,
                "462613",
                "2021-04-18",
                tvShowLastEpisodeEntity,
                "Fairy Tail",
                368,
                21,
                "Sick, twisted, politically incorrect and Freakin' Sweet animated series featuring the adventures of the dysfunctional Griffin family. Bumbling Peter and long-suffering Lois have three kids. Stewie (a brilliant but sadistic baby bent on killing his mother and taking over the world), Meg (the oldest, and is the most unpopular girl in town) and Chris (the middle kid, he's not very bright but has a passion for movies). The final member of the family is Brian - a talking dog and much more than a pet, he keeps Stewie in check whilst sipping Martinis and sorting through his own life issues.",
                "poster_family_guy",
                "Returning Series",
                "Parental Discretion Advised, that's how you know it's good",
                "Scripted",
                7.0,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Drama"))
        listGenresEntity.add(GenresEntity("18", "Sci-Fi & Fantasy"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2021-04-13",
            "7",
            "2354685",
            "Growing Pains",
            "When a mysterious ice powered enemy frames Frost for a brutal crime, she must find a way to clear her name; Barry and Iris have a surprise houseguest, and Joe continues to deal with Kristen Kramer.",
            "7",
            "/5kD6fRLorx0dPdvgs7v2i45ZPvp.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/z59kJfcElR9eHO9rJbWp4qWMuee.jpg",
                "2014-10-07",
                listGenresEntity,
                "607354",
                "2021-04-13",
                tvShowLastEpisodeEntity,
                "The Flash",
                151,
                7,
                "After a particle accelerator causes a freak storm, CSI Investigator Barry Allen is struck by lightning and falls into a coma. Months later he awakens with the power of super speed, granting him the ability to move through Central City like an unseen guardian angel. Though initially excited by his newfound powers, Barry is shocked to discover he is not the only \\\"meta-human\\\" who was created in the wake of the accelerator explosion -- and not everyone is using their new powers for good. Barry partners with S.T.A.R. Labs and dedicates his life to protect the innocent. For now, only a few close friends and associates know that Barry is literally the fastest man alive, but it won't be long before the world learns what Barry Allen has become...The Flash.",
                "poster_flash",
                "Returning Series",
                "The fastest man alive.",
                "Scripted",
                7.7,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Drama"))
        listGenresEntity.add(GenresEntity("18", "Family"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2020-04-26",
            "22",
            "2354685",
            "The Mountain",
            "Miles is forced to examine his lack of faith more than ever before when the God Account sends him his sister, Ali, as a friend suggestion on the eve of her cancer surgery.",
            "2",
            "/8kOvTqjKTs3K56B90wDRwjesS72.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/vcw31JewR0wuX3RZ8x3Khdptsih.jpg",
                "2018-09-30",
                listGenresEntity,
                "607355",
                "2020-04-26",
                tvShowLastEpisodeEntity,
                "God Friended Me",
                42,
                2,
                "A self-proclaimed \\\"pesky atheist\\\" is encouraged to help strangers by someone claiming to be God who friends him on Facebook.",
                "poster_god",
                "Canceled",
                "",
                "Scripted",
                8.1,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Drama"))
        listGenresEntity.add(GenresEntity("18", "Family"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2019-04-25",
            "21",
            "2354685",
            "Legend of Dark Knight: The Beginning...",
            "The series flash-forwards 10 years into the future, as Bruce is set to return to Gotham for the opening of the new Wayne Tower. A series of crimes leads Gordon to believe Penguin and The Riddler are up to their old tricks. However, when Bullock is framed for a murder, Gordon begins to piece together an even more sinister plot targeting the city, and a new figure emerges from the shadows to be the hero Gotham desperately needs.",
            "5",
            "/x5yBjV3yqO2og0tBPAE1OdZ8fqC.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/7QSM3AsgWXctWBm7OFov9dGdZgt.jpg",
                "2014-09-22",
                listGenresEntity,
                "607356",
                "2019-04-25",
                tvShowLastEpisodeEntity,
                "Gotham",
                100,
                5,
                "A self-proclaimed \\\"pesky atheist\\\" is encouraged to help strangers by someone claiming to be God who friends him on Facebook.",
                "poster_gotham",
                "Ended",
                "Before Batman, there was Gotham.",
                "Scripted",
                7.5,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Drama"))
        listGenresEntity.add(GenresEntity("18", "Family"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2018-09-07",
            "10",
            "2354685",
            "A Duel of Iron",
            "In the season finale, Iron Fists collide as the fate of New York City hangs in the balance.",
            "2",
            "/aV32cXbvB44RKgNNec0dwQ5CQP4.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/xHCfWGlxwbtMeeOnTvxUCZRGnkk.jpg",
                "2017-03-17",
                listGenresEntity,
                "607357",
                "2018-09-07",
                tvShowLastEpisodeEntity,
                "Marvel's Iron Fist",
                23,
                2,
                "Danny Rand resurfaces 15 years after being presumed dead. Now, with the power of the Iron Fist, he seeks to reclaim his past and fulfill his destiny.",
                "poster_iron_fist",
                "Canceled",
                "",
                "Scripted",
                6.6,
                listCastEntity
            )
        )

        listGenresEntity = ArrayList()
        listGenresEntity.add(GenresEntity("35", "Drama"))
        listGenresEntity.add(GenresEntity("18", "Family"))

        listCastEntity = ArrayList()
        listCastEntity.add(
            CastEntity(
                "1010157",
                "Tetsuya Kakihara",
                "Natsu Dragneel (voice)",
                "/uogW9g7uqEdB1nbShhjp6NSXeue.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "112371",
                "Aya Hirano",
                "Rūshi Hātofiria (voice)",
                "/aDe9MO0iwWvTBviXxv6axAAHGlE.jpg"
            )
        )
        listCastEntity.add(
            CastEntity(
                "1376875",
                "Rie Kugimiya",
                "Happī (voice)",
                "/5uxG4tsx8vCfxI8yr1RoeDkrsDg.jpg"
            )
        )

        tvShowLastEpisodeEntity = TvShowLastEpisodeEntity(
            "2017-03-23",
            "500",
            "2354685",
            "Hidden Leaf Story, The Perfect Day for a Wedding, Part 7: The Message",
            "Naruto had once lived a lonely existence, ostracized by everyone. But Iruka's words and his very presence have supported Naruto to this day. As Naruto's wedding nears, Iruka begins to lose sight of what he was to Naruto, and is unsure of what to say for his message.",
            "20",
            "/1swhNPNh16f1B6ZqEAmCg7mkWSn.jpg",
        )

        tvShow.add(
            TvShowEntity(
                "/dTFnU3EQB79aDM4HnUj06Y9Xbq1.jpg",
                "2007-02-15",
                listGenresEntity,
                "607358",
                "2017-03-23",
                tvShowLastEpisodeEntity,
                "Naruto Shippūden",
                500,
                20,
                "Naruto Shippuuden is the continuation of the original animated TV series Naruto.The story revolves around an older and slightly more matured Uzumaki Naruto and his quest to save his friend Uchiha Sasuke from the grips of the snake-like Shinobi, Orochimaru. After 2 and a half years Naruto finally returns to his village of Konoha, and sets about putting his ambitions to work, though it will not be easy, as He has amassed a few (more dangerous) enemies, in the likes of the shinobi organization; Akatsuki.",
                "poster_naruto_shipudden",
                "Ended",
                "",
                "Scripted",
                8.6,
                listCastEntity
            )
        )

        return tvShow
    }
}