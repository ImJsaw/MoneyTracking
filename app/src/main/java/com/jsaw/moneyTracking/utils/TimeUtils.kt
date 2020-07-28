package com.jsaw.moneyTracking.utils

import java.text.SimpleDateFormat
import java.util.*

class TimeUtils{
    companion object{
        //set a initial day to calc date
        var FIRST_DAY: Calendar = Calendar.getInstance()
        var LAST_DAY: Calendar = Calendar.getInstance()
        const val DAYS_OF_TIME =  73413; //((LAST_DAY_OF_TIME.getTimeInMillis() - FIRST_DAY_OF_TIME.getTimeInMillis()) / (24 * 60 * 60 * 1000));
        init{
            FIRST_DAY.set(1990, Calendar.JANUARY, 1)
            LAST_DAY.set(2100, Calendar.DECEMBER, 31)
        }

        /**
         * Get the position in the ViewPager for a given day
         *
         * @param day
         * @return the position or 0 if day is null
         */
        fun getPositionForDay(day: Calendar?): Int {
            if (day != null)
                return ((day.timeInMillis - FIRST_DAY.timeInMillis) / 86400000).toInt() //(24 * 60 * 60 * 1000))
            return 0
        }

        /**
         * Get the day for a given position in the ViewPager
         *
         * @param position
         * @return the day
         */
        fun getDayFromPosition(position: Int): Calendar {
            var pos : Int
            if(position < 0){
                pos = 0
            }
            pos = position
            val cal = Calendar.getInstance()
            cal.timeInMillis = FIRST_DAY.timeInMillis
            cal.add(Calendar.DAY_OF_YEAR, pos)
            return cal
        }

        /**
         * get formatted date from timeInMillis
         */
        fun getFormattedDate(date: Long?): String {
            val pattern = "yyyy-MM-dd"
            var simpleDateFormat: SimpleDateFormat? = null
            try {
                simpleDateFormat = SimpleDateFormat(pattern, Locale.getDefault())
            } catch (e: java.lang.IllegalArgumentException) {
                print(e)
            }
            if (simpleDateFormat != null) {
                return simpleDateFormat.format(Date(date!!))
            }
            return "Date format NULL exception"
        }

        /**
         * get formatted date from position
         */
        fun getDateStringFromPos(position: Int): String {
            return getFormattedDate(getDayFromPosition(position).timeInMillis)
        }
    }

}