package hackvision.unitednewbies.shelteralert.Activities

import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import hackvision.unitednewbies.shelteralert.R
import hackvision.unitednewbies.shelteralert.databinding.ActivityCheckinBinding

class GuestProfileActivity: AppCompatActivity() {

    lateinit var viewModel: CheckInActivity
    lateinit var binding : ActivityCheckinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_checkin)
        val errorDialog = DialogFragment()
        errorDialog.show(supportFragmentManager, "TAG")
    }


}
