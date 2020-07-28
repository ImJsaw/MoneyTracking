package com.jsaw.moneyTracking.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jsaw.moneyTracking.RecordDetail
import com.jsaw.moneyTracking.utils.TimeUtils

class DatePagerAdapter(fa: FragmentActivity?) : FragmentStateAdapter(fa!!) {

    override fun getItemCount(): Int {
        return TimeUtils.DAYS_OF_TIME
    }

    override fun createFragment(position: Int): Fragment {
        val timeForPos = TimeUtils.getDayFromPosition(position).timeInMillis
        return RecordDetail.newInst(timeForPos) as Fragment
    }

}