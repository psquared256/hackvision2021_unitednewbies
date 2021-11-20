package hackvision.unitednewbies.shelteralert.Activities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import hackvision.unitednewbies.shelteralert.R

class DialogFragment(): BottomSheetDialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_dialog, container, false)

        // to simply display the list of errors from the Profile creating and login screens
        //val errorMsg = view.findViewById<TextView>(R.id.textView)
        // errorMsg.text = message
        return view
    }
}