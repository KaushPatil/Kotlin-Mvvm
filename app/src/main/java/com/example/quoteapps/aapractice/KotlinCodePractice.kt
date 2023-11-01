package com.example.quoteapps.aapractice

import java.util.Arrays

/**
 * Print all Duplicates values from given list, without nested loop
 * Example:
 * Input: 1,5,2,1,3,9,5,8,3
 * Output: 1,5,1,3,5,3
 */

fun main() {
    println("Kotlin")



    var arr =  listOf(1,5,2,1,3,9,5,8,3)
    var duplicate = mutableListOf<Int>()
     print(arr.toString())

    for (item in arr)
    {
        if (duplicate.contains(item))
        {

        } else{
            duplicate.add(item)
        }
    }



}