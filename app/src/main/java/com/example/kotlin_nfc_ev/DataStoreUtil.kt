package com.example.kotlin_nfc_ev

import android.content.Context
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences

class DataStoreUtil(context: Context) {
    private var prefs: SharedPreferences? = context.getSharedPreferences("com.example.kotlin_nfc_ev.prefs", MODE_PRIVATE)

    fun getID(): String {
        var uid = prefs!!.getString("uid", null)
        if (uid == null) {
            uid = "0012498765"
            this.saveID(uid)
        }
        return uid
    }

    fun saveID(uid: String) {
        val editor = prefs!!.edit()
        editor.putString("uid", uid)
        editor.apply()
    }
}