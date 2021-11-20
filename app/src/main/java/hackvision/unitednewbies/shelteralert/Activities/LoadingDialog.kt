package hackvision.unitednewbies.shelteralert.Activities

import android.app.Activity
import android.app.AlertDialog
import hackvision.unitednewbies.shelteralert.R


class LoadingDialog(private val targetActivity: Activity) {
    private lateinit var isdialog: AlertDialog

    fun startLoading(){
        // instantiate the view
        val inflater = targetActivity.layoutInflater
        val dialogView = inflater.inflate(R.layout.loading_item,null)

        // set the Dialog
        val builder = AlertDialog.Builder(targetActivity)
        builder.setView(dialogView)
        builder.setCancelable(false)
        isdialog = builder.create()
        isdialog.show()
    }

    fun isDismiss(){
        isdialog.dismiss()
    }
}