package com.jsaw.moneyTracking.dataClass

enum class MoneyFlowType (val string: String){
    Pay("支出"),
    Income("收入"),
    Transfer("轉帳")
}