package com.kdn.presentation.ui.setting.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kdn.presentation.R

class SettingViewmodel : ViewModel() {

    private val _isChecked = MutableLiveData<Boolean>()
    val isChecked : LiveData<Boolean> get() = _isChecked

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

    fun isChecked(checked : Boolean){
        this._isChecked.value = checked
    }

}