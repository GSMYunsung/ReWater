package com.kdn.presentation.ui.main.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.google.firebase.database.ChildEventListener
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


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main_fun,container,false)

        updateSetting()

        return binding.root
    }

    fun updateSetting(){
        viewModel.getPlantStateInfo().addChildEventListener(
            object : ChildEventListener{
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                    val data : SaveDataClass? = snapshot.getValue(SaveDataClass::class.java)

                        binding.values =SaveDataClass(
                            data!!.Ieast_temperature
                            ,data!!.alarm_o_clock
                            ,data!!.alram_minutes
                            ,data!!.battery
                            ,data!!.current_humidity
                            ,data!!.desired_humidity
                            ,data!!.if_output
                            ,data!!.maximum_temperature
                            ,data!!.output
                            ,data!!.output_time
                            ,data!!.size
                            ,data!!.tree
                            ,data!!.volume
                        )
                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {

                    val data : SaveDataClass? = snapshot.getValue(SaveDataClass::class.java)

                    Log.d("change!",data.toString())

                    binding.values =SaveDataClass(
                        data!!.Ieast_temperature
                        ,data!!.alarm_o_clock
                        ,data!!.alram_minutes
                        ,data!!.battery
                        ,data!!.current_humidity
                        ,data!!.desired_humidity
                        ,data!!.if_output
                        ,data!!.maximum_temperature
                        ,data!!.output
                        ,data!!.output_time
                        ,data!!.size
                        ,data!!.tree
                        ,data!!.volume
                    )


                }

                override fun onChildRemoved(snapshot: DataSnapshot) {
                    //값이 삭제될때?
                }

                override fun onChildMoved(snapshot: DataSnapshot, previousChildName: String?) {

                }

                override fun onCancelled(error: DatabaseError) {

                }

            }
        )
    }
}