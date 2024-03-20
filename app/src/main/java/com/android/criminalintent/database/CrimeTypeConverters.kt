package com.android.criminalintent.database

import androidx.room.TypeConverter
import java.util.Date

class CrimeTypeConverters {
    @TypeConverter
    fun fromDate(date: Date): Long {
        return date.time
    }

    @TypeConverter
    fun toDate(milliSecondEpoch:Long): Date {
        return Date(milliSecondEpoch)
    }
}