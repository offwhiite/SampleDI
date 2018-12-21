package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.ViewModel
import c.offwhite.sampledi.application.ShowNovelListUseCase

class MainViewModel constructor(val showNovelListUseCase: ShowNovelListUseCase) : ViewModel() {

    fun onCreate() {

    }
}
