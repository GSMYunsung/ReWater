package com.kdn.presentation.ui.setting.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.google.firebase.auth.FirebaseAuth
import com.kdn.presentation.R
import com.kdn.presentation.databinding.FragmentChooseTreeEndBinding
import dagger.hilt.android.AndroidEntryPoint

class ChooseTreeEndFragment : Fragment() {
    private lateinit var binding : FragmentChooseTreeEndBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_choose_tree_end,container,false)

        return binding.root
    }

}