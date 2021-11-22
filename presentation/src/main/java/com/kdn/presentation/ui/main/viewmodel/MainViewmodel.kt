package com.kdn.presentation.ui.main.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.kdn.module.usecase.GetPlantStateUseCase
import com.kdn.presentation.SaveDataClass
import com.kdn.presentation.ui.setting.toast.ToastView
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewmodel @Inject constructor(
    private val getPlantStateUseCase: GetPlantStateUseCase
) : ViewModel() {

    private val _water = MutableLiveData<String>()
    val water : LiveData<String> get() = _water

    private val _time = MutableLiveData<String>()
    val time : LiveData<String> get() = _time

    fun getPlantStateInfo() = getPlantStateUseCase.getPlantState()

    fun saveOutPutData(water : String, time : String){
       this._water.value = water
       this._time.value = time

        getSetting()
    }

    fun writeNewMYPlant(
        size : String,
        tree : String,
        Ieast_temperature : String,
        alarm_o_clock : String,
        alram_minutes : String,
        battery : String,
        current_humidity : String,
        desired_humidity : String,
        if_output : Boolean,
        maximum_temperature : String,
        volume : String) {

        val post = SaveDataClass(
            size,
            tree,
            Ieast_temperature,
            alarm_o_clock,
            alram_minutes,
            battery,
            current_humidity,
            desired_humidity,
            if_output,
            maximum_temperature,
            water.value!!,
            time.value!!,
            volume)

        val postValues = post.toMap()

        val childUpdates = hashMapOf<String, Any>(
            "/AppData" to postValues
        )

        getPlantStateUseCase.getPlantState().updateChildren(childUpdates)
    }

    fun outPutWater(
        size : String,
        tree : String,
        Ieast_temperature : String,
        alarm_o_clock : String,
        alram_minutes : String,
        battery : String,
        current_humidity : String,
        desired_humidity : String,
        if_output : Boolean = true,
        maximum_temperature : String,
        output : String,
        output_time : String,
        volume : String) {

        val post = SaveDataClass(
            size,
            tree,
            Ieast_temperature,
            alarm_o_clock,
            alram_minutes,
            battery,
            current_humidity,
            desired_humidity,
            if_output,
            maximum_temperature,
            output,
            output_time,
            volume)

        val postValues = post.toMap()

        val childUpdates = hashMapOf<String, Any>(
            "/AppData" to postValues
        )

        getPlantStateUseCase.getPlantState().updateChildren(childUpdates)
    }

    fun setWaterSetting(){

        getPlantStateInfo().addChildEventListener(
            object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                    val data : SaveDataClass? = snapshot.getValue(SaveDataClass::class.java)

                    Log.d("afsdasdf","DFSafddffad")

                    outPutWater(
                        data!!.size,
                        data!!.tree,
                        data!!.Ieast_temperature,
                        data!!.alarm_o_clock,
                        data!!.alram_minutes,
                        data!!.battery,
                        data!!.current_humidity,
                        data!!.desired_humidity,
                        true,
                        data!!.maximum_temperature,
                        data!!.output,
                        data!!.output_time,
                        data!!.volume)


                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {


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

    fun getSetting(){
        getPlantStateInfo().addChildEventListener(
            object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                    val data : SaveDataClass? = snapshot.getValue(SaveDataClass::class.java)

                    writeNewMYPlant(
                        data!!.size,
                        data!!.tree,
                        data!!.Ieast_temperature,
                        data!!.alarm_o_clock,
                        data!!.alram_minutes,
                        data!!.battery,
                        data!!.current_humidity,
                        data!!.desired_humidity,
                        data!!.if_output,
                        data!!.maximum_temperature,
                        data!!.volume)


                }

                override fun onChildChanged(snapshot: DataSnapshot, previousChildName: String?) {


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