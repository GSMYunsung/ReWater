package com.kdn.presentation.ui.setting.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.kdn.presentation.R
import com.kdn.presentation.databinding.FragmentChooseTreeBinding
import com.kdn.presentation.databinding.FragmentChooseTreeSizeBinding
import com.kdn.presentation.ui.setting.toast.ToastView
import com.kdn.presentation.ui.setting.viewmodel.SettingViewmodel
import dagger.hilt.android.AndroidEntryPoint

class ChooseTreeSizeFragment : Fragment() {
    private val viewModel by activityViewModels<SettingViewmodel>()

    private lateinit var binding : FragmentChooseTreeSizeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel.isChecked(false)

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_tree_size,container,false)

        binding.fragment = this

        viewModel.isChecked.observe(this,{ it->

            if(viewModel.isChecked.value == true)
                binding.nextButton.setTextColor(resources.getColor(R.color.black))
        })

        return binding.root
    }

    fun onClick(v : View){

        if(viewModel.isChecked.value == true)
        {
            viewModel.getTreeSizeTextId(binding.treeSizeRadioGroup.checkedRadioButtonId)
            findNavController().navigate(R.id.action_chooseTreeSizeFragment_to_chooseTreeEndFragment2)
        }
        else ToastView.createToast(requireContext(), "먼저 사이즈를 선택해주세요")?.show()
    }

    fun isButtonTrue(v : View){
        viewModel.isChecked(true)
    }

}