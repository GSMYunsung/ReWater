package com.kdn.presentation.ui.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.kdn.presentation.R
import com.kdn.presentation.SaveDataClass
import com.kdn.presentation.databinding.FragmentChooseTreeBinding
import com.kdn.presentation.databinding.FragmentMainFunBinding
import com.kdn.presentation.ui.setting.viewmodel.MainViewmodel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFunFragment : Fragment() {
    private lateinit var binding : FragmentMainFunBinding
    private val viewModel by activityViewModels<MainViewmodel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        basicSetting()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_fun,container,false)

        return binding.root
    }

    fun basicSetting(){
        viewModel.getPlantStateInfo().addListenerForSingleValueEvent(
            object : ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {
                    val data : SaveDataClass = snapshot.getValue(SaveDataClass.class)


                }

                override fun onCancelled(error: DatabaseError) {
                    TODO("Not yet implemented")
                }

            }
        )
    }
}