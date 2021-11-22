package com.kdn.presentation.ui.setting.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.firebase.database.ChildEventListener
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.kdn.module.usecase.GetPlantStateUseCase
import com.kdn.presentation.R
import com.kdn.presentation.SaveDataClass
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewmodel @Inject constructor(
    private val PostPlantStateUseCase: GetPlantStateUseCase
) : ViewModel() {

    private val _isChecked = MutableLiveData<Boolean>()
    val isChecked : LiveData<Boolean> get() = _isChecked

    private val _plantEntity = MutableLiveData<Map<String,String>>()
    val plantEntity : LiveData<Map<String,String>> get() = _plantEntity

    private val _selectTreeText = MutableLiveData<String>()
    val selectTreeText : LiveData<String> get() = _selectTreeText

    private val _selectTreeSizeText = MutableLiveData<String>()
    val selectTreeSizeText : LiveData<String> get() = _selectTreeSizeText

    fun getLastClickTextId(id : Int){
        when(id){
            R.id.etc_textview -> _selectTreeText.value = "기타"
            R.id.ginkgo_textView -> _selectTreeText.value = "은행나무"
            R.id.zelkova_textView -> _selectTreeText.value = "느티나무"
            R.id.maple_textView -> _selectTreeText.value = "단풍나무"
            R.id.kind_of_oak_textView -> _selectTreeText.value = "참나무"
            R.id.pine_textView -> _selectTreeText.value = "소나무"
            R.id.oak_textView -> _selectTreeText.value = "상수리나무"
            R.id.camellia_textView -> _selectTreeText.value = "동백나무"
            R.id.cypress_textView -> _selectTreeText.value = "편백나무"
        }
    }


    fun getTreeSizeTextId(id : Int){
        when(id){
            R.id.s_size_button -> _selectTreeSizeText.value = "소"
            R.id.m_size_button -> _selectTreeSizeText.value = "중"
            R.id.b_size_button -> _selectTreeSizeText.value = "대"
        }
    }

    fun getPlantStateInfo() = PostPlantStateUseCase.getPlantState()

    fun getSetting(){
        getPlantStateInfo().addChildEventListener(
            object : ChildEventListener {
                override fun onChildAdded(snapshot: DataSnapshot, previousChildName: String?) {

                    val data : SaveDataClass? = snapshot.getValue(SaveDataClass::class.java)

                    writeNewMYPlant(
                        data!!.Ieast_temperature,
                        data!!.alarm_o_clock,
                        data!!.alram_minutes,
                        data!!.battery,
                        data!!.current_humidity,
                        data!!.desired_humidity,
                        data!!.if_output,
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

    fun writeNewMYPlant(
        Ieast_temperature : String,
        alarm_o_clock : String,
        alram_minutes : String,
        battery : String,
        current_humidity : String,
        desired_humidity : String ,
        if_output : Boolean,
        maximum_temperature : String,
        output : String,
        output_time : String,
        volume : String) {

        val post = SaveDataClass(
            _selectTreeSizeText.value!!,
            selectTreeText.value!!,
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

        PostPlantStateUseCase.getPlantState().updateChildren(childUpdates)
    }

    fun isChecked(checked : Boolean){
        this._isChecked.value = checked
    }

}