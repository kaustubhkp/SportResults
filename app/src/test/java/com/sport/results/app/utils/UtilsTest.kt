package com.sport.results.app.utils

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.text.SimpleDateFormat
import java.util.Locale

class UtilsTest {

    @Test
    fun testGetDateObjectFromString() {
        val dateString = "May 9, 2020 8:09:03 PM"
        val expectedFormat = "MMM dd, yyyy h:mm:ss aa"
        val expectedDate = SimpleDateFormat(expectedFormat, Locale.US).parse(dateString)
        val actualDate = Utils.getDateObjectFromString(dateString, expectedFormat)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testGetDateFromString() {
        val dateString = "2022-01-27"
        val expectedFormat = "yyyy-MM-dd"
        val expectedDate = SimpleDateFormat(expectedFormat, Locale.US).parse(dateString)
        val actualDate = Utils.getDateFromString(dateString, expectedFormat)
        assertEquals(expectedDate, actualDate)
    }

    @Test
    fun testGetStringDate() {
        val date = SimpleDateFormat("yyyy-MM-dd", Locale.US).parse("2022-01-27")
        val expectedDateString = "2022-01-27"
        val actualDateString = Utils.getStringDate(date!!)
        assertEquals(expectedDateString, actualDateString)
    }

    @Test
    fun testGetStringTime() {
        val dateString = "May 9, 2020 8:09:03 PM"
        val expectedTimeString = SimpleDateFormat("hh:mm aa", Locale.getDefault())
            .format(SimpleDateFormat("MMM dd, yyyy h:mm:ss aa", Locale.US).parse(dateString)!!)
        val actualTimeString = Utils.getStringTime(dateString)
        assertEquals(expectedTimeString, actualTimeString)
    }

    @Test
    fun testDateComparator() {
        val dateString1 = "2022-01-27"
        val dateString2 = "2022-01-28"
        val result = Utils.dateComparator.compare(dateString1, dateString2)
        assertEquals(1, result)
    }
}