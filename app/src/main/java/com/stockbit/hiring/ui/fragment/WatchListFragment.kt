package com.stockbit.hiring.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.R
import com.stockbit.hiring.databinding.FragmentLoginBinding
import com.stockbit.hiring.databinding.FragmentWatchListBinding
import com.stockbit.hiring.ui.viewmodel.WatchListViewModel
import org.koin.android.viewmodel.ext.android.viewModel

class WatchListFragment : BaseFragment() {
    private val viewModel: WatchListViewModel by viewModel()
    private lateinit var binding: FragmentWatchListBinding
    private val watchAdapter = WatchAdapter()

    override fun getViewModel(): BaseViewModel {
        return viewModel
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWatchListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getData()

        with(binding.rvWatchList) {
            layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            adapter = watchAdapter
        }

        viewModel.watchList.observe(viewLifecycleOwner, {
            if (it?.data != null) {
                watchAdapter.setData(it.data)
            }
        })
    }
}