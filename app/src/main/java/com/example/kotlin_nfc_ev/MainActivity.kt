package com.example.kotlin_nfc_ev

import android.nfc.NfcAdapter
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dataStore = DataStoreUtil(this)
        val uid = dataStore.getID()
        val textView: TextView = findViewById(R.id.textID)
        textView.text = uid

        val nfcAdapter = NfcAdapter.getDefaultAdapter(this)
        if (nfcAdapter != null) {
            if (!nfcAdapter.isEnabled) {
                NFCDialog(this).showNFCDisabled()
            }
        } else{
            NFCDialog(this).showNFCUnsupported()
        }

        textView.doAfterTextChanged { dataStore.saveID(textView.text as String) }
    }

}
