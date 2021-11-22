package com.kdn.presentation.ui.main.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.presentation.R
import com.kdn.presentation.databinding.FragmentMainFunBinding
import com.kdn.presentation.databinding.FragmentSetTimeAndOutputBinding
import com.kdn.presentation.ui.main.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SetTimeAndOutputFragment : Fragment() {
    private val viewModel by activityViewModels<MainViewmodel>()
    private lateinit var binding : FragmentSetTimeAndOutputBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_set_time_and_output,container,false)

        binding.fragment = this

        return binding.root
    }

    fun onclickSaveData(v : View){
        viewModel.saveOutPutData(binding.waterEditText.text.toString(),binding.timeEdittext.text.toString())
        findNavController().navigate(R.id.action_setTimeAndOutputFragment_to_mainFunFragment)
    }

}