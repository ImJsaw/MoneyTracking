package com.jsaw.moneyTracking.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.jsaw.moneyTracking.PreviewCost
import com.jsaw.moneyTracking.PreviewMoneyFlow

class PreviewAdapter(fa: FragmentActivity?) : FragmentStateAdapter(fa!!) {
    private val totalPage = 4
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> PreviewCost()
            1 -> PreviewMoneyFlow()
            else -> PreviewMoneyFlow()
        }
    }

    override fun getItemCount(): Int {
        return totalPage
    }
}
