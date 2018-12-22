package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import c.offwhite.sampledi.application.ShowNovelListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel constructor(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModel() {

    val title: MutableLiveData<String> = MutableLiveData()

    fun onCreate() = GlobalScope.launch {
        val novelList = showNovelListUseCase.getNovelList("")
        title.postValue(novelList[0].title)
    }

    class Factory(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(showNovelListUseCase) as T
        }
    }
}
