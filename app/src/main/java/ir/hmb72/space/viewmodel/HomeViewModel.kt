package ir.hmb72.space.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import ir.hmb72.space.data.model.home.PlanetModel
import ir.hmb72.space.data.repository.HomeRepository
import ir.hmb72.space.utils.COMETS
import ir.hmb72.space.utils.MOONS
import ir.hmb72.space.utils.PLANET
import ir.hmb72.space.utils.SATELLITES
import ir.hmb72.space.utils.STARS
import dagger.hilt.android.lifecycle.HiltViewModel
import ir.hmb72.space.utils.ALL
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val rep: HomeRepository) : ViewModel() {

    private var _homeListData = MutableLiveData<List<PlanetModel>>()
    val homeList: LiveData<List<PlanetModel>> = _homeListData
    fun getListDataHome(name: String) = viewModelScope.launch {

        val list = rep.getDataList()
        when (name) {
            ALL->_homeListData.value = list.combinedlist
            PLANET -> _homeListData.value = list.listPlanet
            STARS -> _homeListData.value = list.listStars
            SATELLITES -> _homeListData.value = list.listSatellite
            COMETS -> _homeListData.value = list.listComet
            MOONS -> _homeListData.value = list.listMoons

        }


    }

    fun getAllListDataHome() = viewModelScope.launch {

        _homeListData.value = rep.getDataList().combinedlist
    }  fun getNewsList() = viewModelScope.launch {

        _homeListData.value = rep.getDataList().listNews
    }
}