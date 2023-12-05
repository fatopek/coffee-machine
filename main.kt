package machine

import kotlin.system.exitProcess

class Machine(var water: Int, var milk: Int, var beans: Int, var cups: Int, var money: Int) {
    fun change(input: String) {
        when(input) {
            "buy" -> {
                fun count(waterIn: Int, milkIn: Int, beansIn: Int, moneyIn: Int) {
                    if (this.water >= waterIn && this.milk >= milkIn && this.beans >= beansIn && this.cups >= 1) {
                        this.water -= waterIn
                        this.milk -= milkIn
                        this.beans -= beansIn
                        this.money += moneyIn
                        this.cups -= 1
                        println("I have enough resources, making you a coffee!")
                    } else return println("Sorry, not enough ingredients!")
                }
                println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:")
                when (readln()) {
                    "1" -> count(250, 0, 16, 4)
                    "2" -> count(350, 75, 20, 7)
                    "3" -> count(200, 100, 12, 6)
                    "back" -> return
                }
            }
            "fill" -> {
                println("Write how many ml of water you want to add:")
                this.water += readln().toInt()
                println("Write how many ml of milk you want to add:")
                this.milk += readln().toInt()
                println("Write how many grams of beans you want to add:")
                this.beans += readln().toInt()
                println("Write how many disposable cups you want to add:")
                this.cups += readln().toInt()
            }
            "take" -> {
                println("I gave you ${this.money}")
                this.money = 0
            }
            "remaining" -> println("""
                The coffee machine has:
                ${this.water} ml of water
                ${this.milk} ml of milk
                ${this.beans} g of coffee beans
                ${this.cups} disposable cups
                $${this.money} of money
            """.trimIndent())
            "exit" -> exitProcess(0)
        }
    }
}

fun main() {
    val machine = Machine(400, 540, 120, 9, 550)
    while (true) {
        println("Write action (buy, fill, take, remaining, exit):")
        machine.change(readln())
        }
    }
