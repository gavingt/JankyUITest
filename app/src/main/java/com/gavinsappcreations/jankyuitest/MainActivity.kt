package com.gavinsappcreations.jankyuitest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {

    var alertDialog: AlertDialog? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        
        findViewById<Button>(R.id.button_open_alert_dialog).setOnClickListener{
            val dialogBuilder = AlertDialog.Builder(this)

            dialogBuilder.setMessage("Example AlertDialog")
                .setPositiveButton("Proceed") {
                        dialog, id ->
                }
                .setNegativeButton("Cancel") {
                        dialog, id -> dialog.cancel()
                }

            alertDialog = dialogBuilder.create()
            alertDialog?.setTitle("AlertDialogExample")
            alertDialog?.show()
        }


        findViewById<Button>(R.id.button_intent).setOnClickListener{
            val intent = Intent(Intent.ACTION_DIAL)
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            startActivity(intent)
        }
    }

    override fun onStop() {
        super.onStop()
        alertDialog?.dismiss()
    }
}
