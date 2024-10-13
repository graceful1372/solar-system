package ir.hmb72.space.data.repository

import  ir.hmb72.space.data.offline_data.home.HomeList
import javax.inject.Inject

class HomeRepository @Inject constructor(private val homeList: HomeList){
    fun getDataList() = homeList

}