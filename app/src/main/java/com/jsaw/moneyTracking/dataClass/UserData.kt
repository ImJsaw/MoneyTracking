package com.jsaw.moneyTracking.dataClass

data class UserData (val userName : String, val dayData : Array<DayData>) {

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as UserData

        if (userName != other.userName) return false
        if (!dayData.contentEquals(other.dayData)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = userName.hashCode()
        result = 31 * result + dayData.contentHashCode()
        return result
    }

}
