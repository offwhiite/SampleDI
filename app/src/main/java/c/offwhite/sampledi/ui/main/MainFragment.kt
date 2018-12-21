package c.offwhite.sampledi.ui.main

import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import c.offwhite.sampledi.R
import c.offwhite.sampledi.application.ShowNovelListUseCase
import c.offwhite.sampledi.databinding.MainFragmentBinding
import kotlinx.android.synthetic.main.main_activity.*

/**
 * メイン画面
 */
class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    private lateinit var binding : MainFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // レイアウトをinflateする
        binding = DataBindingUtil.inflate<MainFragmentBinding>(inflater, R.layout.main_fragment, container, false)

        // LiveDataとxmlをbindする
        binding.setLifecycleOwner(this)

        // inflateしたViewを返却する
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // viewModel作成
        viewModel = ViewModelProviders
            .of(this, MainViewModel.Factory(ShowNovelListUseCase()))
            .get(MainViewModel::class.java)

        // 生成したviewModelをbindする
        binding.mainViewModel = viewModel

        viewModel.onCreate()
    }

}
