import java.util.*

fun main() {
    var continuePlaying = true
    while (continuePlaying) {
        // Start the Game
        val hangman = HangMan()
        val category = hangman.startGame()

        // Select a random word
        //var word = hangman.randomWord(category)
        var word = "mountain lion"
        // Initialize variables
        var errors = 0
        var finalGuess = ""
        val copyWord = word

        for (i in word.indices) {
            when (word[i]) {
                ' ' -> finalGuess += " "
                else -> finalGuess += "-"
            }
        }

        while (continuePlaying) {
            hangman.hangman(errors)
            println(finalGuess)
            println("please guess a letter: ")
            val guess: String = readln().lowercase()

            if (word.contains(guess)) {
                println("Correct!")
                while (true) {
                    val index = word.indexOf(guess)
                    if (index == -1) {
                        break
                    }

                    finalGuess = finalGuess.substring(0, index) + guess + finalGuess.substring(index + 1)

                    word = word.substring(0, index) + "*" + word.substring(index + 1)
                }

                if (copyWord == finalGuess) {
                    println("Congratulation you won!  Care to try again? ")
                    println("The correct word was: $copyWord")
                    continuePlaying = false
                }
            } else {
                println("Wrong!")
                errors++

                if (errors == 6) {
                    hangman.hangman(6)
                    println("Sorry you have lost the game.  If you're done hanging around, try again.")
                    println("The correct word was: $copyWord")
                    continuePlaying = false
                }
            }
        }
        print("Would you like to start a new game (y/n)?")
        val nextgame: String = readln().lowercase()
        when (nextgame) {
            "y" -> continuePlaying = true
            "yes" -> continuePlaying = true
        }
    }
}

class HangMan() {

    fun startGame(): Int {
        println("Welcome to the Game of Hangman!")
        println("Please select a category, 1 for animals or 2 for colors: ")
        val myObj = Scanner(System.`in`)
        return myObj.nextInt()
    }

    fun randomWord(difficulty: Int): String {
        val wordList1 = arrayOf(
            "dog", "cat", "duck", "rabbit", "cow", "horse", "fish", "turtle",
            "porpoise", "whale", "narwhal", "mountain lion"
        )
        val wordList2 = arrayOf(
            "red", "green", "blue", "purple", "pink", "orange", "yellow", "white",
            "black", "violet", "gray", "brown"
        )
        return if (difficulty == 1) {
            wordList1[Random().nextInt(wordList1.size)]
        } else {
            wordList2[Random().nextInt(wordList2.size)]
        }
    }

    fun hangman(errors: Int) {
        when (errors) {
            0 -> {
                println("  +---+")
                println("      |")
                println("      |")
                println("      |")
                println("      |")
                println("      |")
                println("=========")
            }

            1 -> {
                println("  +---+")
                println("  0   |")
                println("      |")
                println("      |")
                println("      |")
                println("      |")
                println("=========")
            }

            2 -> {
                println("  +---+")
                println("  0   |")
                println("  |   |")
                println("  |   |")
                println("      |")
                println("      |")
                println("=========")
            }

            3 -> {
                println("  +---+")
                println("  0   |")
                println("\\/|   |")
                println("  |   |")
                println("      |")
                println("      |")
                println("=========")
            }

            4 -> {
                println("  +---+")
                println("  0   |")
                println("\\/|\\/ |")
                println("  |   |")
                println("      |")
                println("      |")
                println("=========")
            }

            5 -> {
                println("  +---+")
                println("  0   |")
                println("\\/|\\/ |")
                println("  |   |")
                println(" /    |")
                println("/     |")
                println("=========")
            }

            6 -> {
                println("  +---+")
                println("  0   |")
                println("\\/|\\/ |")
                println("  |   |")
                println(" / \\  |")
                println("/   \\ |")
                println("=========")
            }
        }
    }
}