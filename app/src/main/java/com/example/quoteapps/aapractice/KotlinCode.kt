package com.example.quoteapps.aapractice


fun main() {

//    reverseString()
//    findDuplicates()
//    findSameInTwoArray()
//    sortString()
//    findMinMax()
//    findSecondMax()
//    MultiplesOf3()

//    roundSum(15,12,8)

//    println(factorial(6))
}

fun areStringsSimilar(str1: String, str2: String){
    // Check if the lengths are different
    if (str1.length != str2.length) {
        println("The strings have the same length")
    } else{
        println("The strings have the different  length")
    }

    // Convert strings to character arrays for comparison
    val charArray1 = str1.toCharArray()
    val charArray2 = str2.toCharArray()

    // Sort the character arrays
    charArray1.sort()
    charArray2.sort()

    // Compare the sorted character arrays
    if( charArray1.contentEquals(charArray2)){
        println("The strings contain the same characters.")
    } else{
        println("The strings contain the different characters.")
    }
}














fun factorial(num: Int): Int {
    var fact: Int =1
    fact = if (num == 0) {
        fact * 1
    } else {
        num * factorial(num - 1)
    }

//    for (i in 1.. num){
//        fact *= i
//    }

 return fact

}

fun roundSum(num1: Int, num2: Int, num3: Int) {
    val sum = roundOf(num1) + roundOf(num2) + roundOf(num3)
    println("Sum of = $sum")
}

fun roundOf(num: Int): Int {
    var roundNum = 0
    val rem = num % 10
    roundNum = if (rem >= 5) {
        (num + 10) - rem;
    } else {
        num - rem
    }
    println(roundNum)
    return roundNum
}

fun MultiplesOf3() {
    var list = mutableListOf<Int>()
    for (i in 3..100 step 3) {
        list.add(i)
    }

    for (item in list) {
        println(item)
    }
}

fun findSecondMax() {
    val numbers = arrayOf(10, 20, 30, 40, 80, 70, 90, 99)
    var max = numbers[0]
    var secondMax = numbers[0]
    for (item in numbers) {
        if (item > max) {
            secondMax = max
            max = item
        } else if (item > secondMax) {
            secondMax = item
        }
    }

    println("First Max $max")
    println("Second Max $secondMax")
}

fun findMinMax() {

    val numbers = intArrayOf(45, 23, 87, 13, 63)
    var min: Int = numbers[0]
    var max: Int = numbers[0]
    for (item in numbers) {
        if (item > max) {
            max = item
        } else if (item < min) {
            min = item
        }
    }

    println("Max $max")
    println("Min $min")

}

fun sortString() {
    val str = "trik3 al1 time2"
    val stringList = str.split(" ")
    val sorted = stringList.sorted()
    for (item in sorted) {
        item.substring(0, item.length - 1)
        print(item.substring(0, item.length - 1))
    }

}

fun findSameInTwoArray() {

    val array1 = arrayOf(1, 2, 3, 4, 5)
    val array2 = arrayOf(2, 4, 6, 8, 10)

    for (item1 in array1) {
        for (item2 in array2) {
            if (item1 == item2) {
                println(item1)
            }
        }
    }

}

fun reverseString() {
    println("Kotlin Coding")
    val str = "I Love Java"
    println(str)
    val stringList = str.split(" ")
    val reversed = str.reversed()
    println(reversed)
    for (i in stringList.size - 1 downTo 0) {
        print(stringList[i])
        print(" ")
    }
}

fun findDuplicates() {
    val inputString = "2,2,2,5,1,1,1,1,2,2,2,7,9,6,5,5"
    val elements = inputString.split(",").map { it.toInt() }
    val frequencyMap = mutableMapOf<Int, Int>()

    // Count occurrences of each element
    for (element in elements) {
        if (frequencyMap.containsKey(element)) {
            frequencyMap[element] = frequencyMap[element]!! + 1
        } else {
            frequencyMap[element] = 1
        }
    }

    // Find duplicates
    val duplicates = mutableListOf<Int>()
    for ((element, frequency) in frequencyMap) {
        if (frequency > 1) {
            duplicates.add(element)
        }
    }

    if (duplicates.isNotEmpty()) {
        println("Duplicates found: $duplicates")
    } else {
        println("No duplicates found.")
    }
}