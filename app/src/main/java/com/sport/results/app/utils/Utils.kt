package com.sport.results.app.utils

import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale


object Utils {
    fun getDateObjectFromString(
        stringDateTime: String,
        format: String = "MMM dd, yyyy h:mm:ss aa"
    ): Date {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.parse(stringDateTime)!!
    }

    fun getDateFromString(stringDateTime: String, format: String = "yyyy-MM-dd"): Date {
        val sdf = SimpleDateFormat(format, Locale.getDefault())
        return sdf.parse(stringDateTime)!!
    }


    fun getStringDate(date : Date): String{
        return  SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).format(date)
    }

    fun getStringTime(date : String): String{
        return  SimpleDateFormat("hh:mm aa", Locale.getDefault()).format(getDateObjectFromString(date))
    }

    val dateComparator = Comparator<String> { dateString, nextDateString -> //            if(dateString == "No Date"){
        val date = Utils.getDateFromString(dateString)
        val nextDate = Utils.getDateFromString(nextDateString)
        date.compareTo(nextDate) * -1
    }
}