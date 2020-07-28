package com.jsaw.moneyTracking

import com.jsaw.moneyTracking.dataClass.MoneyFlowType
import com.jsaw.moneyTracking.dataClass.SingleData

object DataService {
    val groups = listOf<SingleData>(
        SingleData(MoneyFlowType.Pay, "test1"),
        SingleData(MoneyFlowType.Pay, "test2"),
        SingleData(MoneyFlowType.Pay, "test3")

        )
}