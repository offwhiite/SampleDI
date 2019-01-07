package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import c.offwhite.sampledi.R
import c.offwhite.sampledi.application.ShowNovelListUseCase
import c.offwhite.sampledi.databinding.MainFragmentBinding

/**
 * メイン画面
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    // ViewModel
    private lateinit var viewModel: MainViewModel

    // binding
    private lateinit var binding: MainFragmentBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // レイアウトをinflateする
        binding = DataBindingUtil.inflate(inflater, R.layout.main_fragment, container, false)

        // LiveDataとxmlをbindする
        binding.setLifecycleOwner(this)

        // inflateしたViewを返却する
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // viewModel作成
        viewModel = ViewModelProviders
            .of(this, MainViewModel.Factory(MainRouter(context!!), ShowNovelListUseCase()))
            .get(MainViewModel::class.java)

        // 生成したviewModelをbindする
        binding.viewModel = viewModel

        // 横向き
        val manager = LinearLayoutManager(context)
        manager.orientation = LinearLayoutManager.HORIZONTAL
        binding.recyclerView.layoutManager = manager

        // adapter設定
        binding.recyclerView.adapter = NovelListAdapter(viewModel.onItemTapListener)


        viewModel.onCreate()
    }

}
