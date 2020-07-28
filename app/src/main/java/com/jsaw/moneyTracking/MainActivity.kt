package com.jsaw.moneyTracking

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayoutMediator
import com.google.android.material.tabs.TabLayoutMediator.TabConfigurationStrategy
import com.jsaw.moneyTracking.adapter.DatePagerAdapter
import com.jsaw.moneyTracking.adapter.PreviewAdapter
import com.jsaw.moneyTracking.utils.TimeUtils
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        previewPager.adapter = PreviewAdapter(this)

        TabLayoutMediator(tabLayout, previewPager, true,
            TabConfigurationStrategy { tab, position -> tab.setText( getTabText(position)) }).attach()

        detailPager.adapter = DatePagerAdapter(this)


        detailPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                dateView.text = TimeUtils.getDateStringFromPos(position)
            }
        })
    }

    private fun getTabText(index : Int) : String{
        when(index){
            0 -> return "花費總覽"
            1 -> return "現金流量"
            2 -> return "預算"
            3 -> return "帳戶"
        }
        return ""
    }


}