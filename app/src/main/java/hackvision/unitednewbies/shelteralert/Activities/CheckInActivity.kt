package hackvision.unitednewbies.shelteralert.Activities

import android.content.ContentValues.TAG
import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.storage.FirebaseStorage
import hackvision.unitednewbies.shelteralert.R
import hackvision.unitednewbies.shelteralert.databinding.ActivityCheckinBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.File

class CheckInActivity: AppCompatActivity() {

    lateinit var binding : ActivityCheckinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // to set the drop down menu UI widget
        val dd2 = resources.getStringArray(R.array.names)
        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_list_item, dd2)

        binding.names.setAdapter(arrayAdapter2)

       // supportActionBar?.title = "Questions"

        // progress bar: concurrency for better performance and visibility of system status
        val loading = LoadingDialog(this)
        loading.startLoading()
        val handler = Handler()
        handler.postDelayed({ loading.isDismiss() },2000)

        val name = binding.names.text.toString()

        val submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener{

            val intent = Intent(this, GuestProfileActivity::class.java).run{
                putExtra("name", name)
            }
            startActivity(intent)
        }

        val searchBtn = findViewById<ImageView>(R.id.search_btn)
        searchBtn.setOnClickListener{
            binding.img.setImageResource(R.drawable.person)

            // to retrive the image based on the guest from firebase storage
            /*Log.i(name, TAG)
            // search the database for the guests name list and call its image from the storage
            val storageRef = FirebaseStorage.getInstance("gs://shelteralertapp.appspot.com/").reference.child("$name.jpg")
            val localFile = File.createTempFile("tempImg", "jpg")
            storageRef.getFile(localFile)

            // changing dispatcher context to handle the view elements

            val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
            binding.img.setImageBitmap(bitmap)*/

        }

    }

    override fun onBackPressed() {
        Toast.makeText(this, "You've logged out", Toast.LENGTH_SHORT).show()
        super.onBackPressed()
    }



}
