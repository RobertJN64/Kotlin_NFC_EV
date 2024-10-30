package com.example.kotlin_nfc_ev

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.provider.Settings

class NFCDialog(private var context: Context) {
    private var dialogBuilder: AlertDialog.Builder = AlertDialog.Builder(context)

    fun showNFCDisabled() {
        dialogBuilder.setMessage(R.string.nfc_disabled)
        .setCancelable(false)

        // positive button text and action
        .setPositiveButton(R.string.dialog_yes) { dialog, _ ->
            dialog.dismiss()
            val intent = Intent(Settings.ACTION_NFC_SETTINGS)
            context.startActivity(intent)
        }

            // negative button text and action
        .setNegativeButton(R.string.dialog_no) { dialog, _ ->
            dialog.cancel()
        }

        show()
    }


    fun showNFCUnsupported() {
        dialogBuilder.setMessage(R.string.nfc_unsupported)
        .setCancelable(false)

        // positive button text and action
        .setPositiveButton(R.string.dialog_yes) { dialog, _ ->
            dialog.dismiss()
        }

        show()
    }

    private fun show() {
        val alert = dialogBuilder.create()
        alert.setTitle("NFC")
        alert.show()
    }
}