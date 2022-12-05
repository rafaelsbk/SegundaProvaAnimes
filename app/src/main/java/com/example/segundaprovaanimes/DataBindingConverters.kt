package com.example.segundaprovaanimes

import android.text.TextUtils
import androidx.databinding.InverseMethod

class DataBindingConverters {
    companion object {
        @InverseMethod("convertIntegerToString")
        @JvmStatic
        fun convertStringToInteger(value: String): Int {
            if (TextUtils.isEmpty(value) || !TextUtils.isDigitsOnly(value)) {
                return 0
            }
            return value.toInt()
        }

        @JvmStatic
        fun convertIntegerToString(value: Int?): String {
            return value?.toString() ?: ""
        }
    }
}