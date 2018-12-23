package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import c.offwhite.sampledi.application.ShowNovelListUseCase
import c.offwhite.sampledi.domain.NovelIntroduction
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * メイン画面のViewModel
 */
class MainViewModel constructor(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModel() {

    // 小説リスト
    val novelList = MutableLiveData<List<NovelIntroduction>>()

    // onCreate時に呼び出す想定
    fun onCreate() = GlobalScope.launch {
        val novel = showNovelListUseCase.getNovelList("")
        novelList.postValue(novel)
    }

    // ViewModel()にDIする場合はFactoryクラスを作成する必要がある。
    class Factory(private val showNovelListUseCase: ShowNovelListUseCase) : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(showNovelListUseCase) as T
        }
    }
}
