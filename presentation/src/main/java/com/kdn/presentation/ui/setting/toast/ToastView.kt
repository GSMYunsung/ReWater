package com.kdn.presentation.ui.setting.toast

import android.content.Context
import android.content.res.Resources
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.kdn.presentation.R
import com.kdn.presentation.databinding.ToastItemBinding

object ToastView {
    fun createToast(context: Context, message: String): Toast? {
        val inflater = LayoutInflater.from(context)
        val binding: ToastItemBinding =
            DataBindingUtil.inflate(inflater, R.layout.toast_item, null, false)

        binding.toastTextview.text = message

        return Toast(context).apply {
            setGravity( Gravity.CENTER, 0, 16.toPx())
            duration = Toast.LENGTH_LONG
            view = binding.root
        }
    }

    private fun Int.toPx(): Int = (this * Resources.getSystem().displayMetrics.density).toInt()
}