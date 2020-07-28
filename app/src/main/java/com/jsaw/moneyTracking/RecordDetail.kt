package com.jsaw.moneyTracking

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.jsaw.moneyTracking.utils.TimeUtils
import kotlinx.android.synthetic.main.fragment_detail.*

class RecordDetail() : Fragment() {

    private lateinit var curDate : String

    companion object{
        fun newInst(date: Long): RecordDetail? {
            val fragmentFirst = RecordDetail()
            val args = Bundle()
            args.putLong("date", date)
            fragmentFirst.arguments = args
            return fragmentFirst
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        flushListView()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        //get cur page date
        arguments?.getLong("date",TimeUtils.FIRST_DAY.timeInMillis).let {
            curDate = TimeUtils.getFormattedDate(it)
        }
    }

    private fun flushListView(){
        detailList.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, DataService.groups)
    }
}