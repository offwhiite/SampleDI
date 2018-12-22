package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import c.offwhite.sampledi.application.ShowNovelListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class MainViewModel constructor(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModel() {

    // 小説タイトル
    val title: MutableLiveData<String> = MutableLiveData()

    // 作者
    val writer: MutableLiveData<String> = MutableLiveData()

    // あらすじ
    val story: MutableLiveData<String> = MutableLiveData()

    fun onCreate() = GlobalScope.launch {
        val novelList = showNovelListUseCase.getNovelList("")

        // タイトル設定
        title.postValue(novelList[0].title)
        // 作者
        writer.postValue(novelList[0].writer)
        // あらすじ
        story.postValue(novelList[0].story)
    }

    class Factory(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(showNovelListUseCase) as T
        }
    }
}
