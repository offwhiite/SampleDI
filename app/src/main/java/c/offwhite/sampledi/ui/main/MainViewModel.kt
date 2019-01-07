package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import c.offwhite.novel.domain.NovelIntroduction
import c.offwhite.sampledi.application.ShowNovelListUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * メイン画面のViewModel
 */
class MainViewModel constructor(
    private val router: MainRouter,
    private val showNovelListUseCase: ShowNovelListUseCase
) : ViewModel() {

    // intent用のパラメータ
    val NCODE = "ncode"

    // 小説リスト
    val novelList = MutableLiveData<List<NovelIntroduction>>()

    // itemタップ時のリスナー
    val onItemTapListener = object : NovelListAdapter.OnItemClickListener {
        override fun onItemClick(ncode: String) {
            router.translateViewer(ncode)
        }
    }


    // onCreate時に呼び出す想定
    fun onCreate() = GlobalScope.launch {
        val novel = showNovelListUseCase.getNovelList("")
        novelList.postValue(novel)
    }

    // ViewModel()にDIする場合はFactoryクラスを作成する必要がある。
    class Factory(private val router: MainRouter, private val showNovelListUseCase: ShowNovelListUseCase) :
        ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return MainViewModel(router, showNovelListUseCase) as T
        }
    }

}
