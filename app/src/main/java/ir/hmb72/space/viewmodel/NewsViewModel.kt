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
import ir.hmb72.space.data.repository.NewsRepository
import ir.hmb72.space.utils.ALL
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(private val rep: NewsRepository) : ViewModel() {

    private var _newsListData = MutableLiveData<List<PlanetModel>>()
    val newsList: LiveData<List<PlanetModel>> = _newsListData


    fun getListNews() = viewModelScope.launch {

        _newsListData.value = rep.getDataList().listNews
    }
}