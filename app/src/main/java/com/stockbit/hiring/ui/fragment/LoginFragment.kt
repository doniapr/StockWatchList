package com.stockbit.hiring.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stockbit.common.base.BaseFragment
import com.stockbit.common.base.BaseViewModel
import com.stockbit.hiring.ui.viewmodel.LoginViewModel
import com.stockbit.hiring.databinding.FragmentLoginBinding
import org.koin.android.viewmodel.ext.android.sharedViewModel

class LoginFragment : BaseFragment() {
    private val viewModel : LoginViewModel by sharedViewModel()

    private lateinit var binding: FragmentLoginBinding
    override fun getViewModel(): BaseViewModel {
        return viewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            viewModel.login(binding.edtUsername.text.toString())
        }
    }
}