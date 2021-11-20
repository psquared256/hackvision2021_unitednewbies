package hackvision.unitednewbies.shelteralert.Activities

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import android.os.Handler
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.snackbar.Snackbar
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import com.google.firebase.storage.FirebaseStorage
import hackvision.unitednewbies.shelteralert.Adapters.ListAdapter
import hackvision.unitednewbies.shelteralert.R
import hackvision.unitednewbies.shelteralert.databinding.ActivityCheckinBinding
import java.io.File

class GuestProfileActivity: AppCompatActivity() {

    lateinit var viewModel: ListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)
        val guestName = intent.getStringExtra("name")

        val name = findViewById<TextView>(R.id.guest_name)
        name.text= guestName
        // call its img from the firebase storage

        val createBtn = findViewById<Button>(R.id.create_btn)
        val contactBtn = findViewById<Button>(R.id.contact_btn)
        contactBtn.setOnClickListener{
            val errorDialog = DialogFragment()
            errorDialog.show(supportFragmentManager, "TAG")
        }

        // to get the image of the guest from firebase storage
       /* val storageRef = FirebaseStorage.getInstance("gs://shelteralertapp.appspot.com/").reference.child("$name.jpg")
        val localFile = File.createTempFile("tempImg", "jpg")
        storageRef.getFile(localFile)

        // changing dispatcher context to handle the view elements

        val bitmap = BitmapFactory.decodeFile(localFile.absolutePath)
        val img = findViewById<ImageView>(R.id.img)
        img.setImageBitmap(bitmap)*/

        // recycler view to generate the list row views
        val list = findViewById<RecyclerView>(R.id.list_view)

        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)

        // setting an observer to respond to the live data
        viewModel.checks.observe(this, Observer {

            val linearLayoutManager = LinearLayoutManager(this)
            list.layoutManager = linearLayoutManager

            val adapter = ListAdapter(it){deleteQuestion(it)}
            list.adapter = adapter
        })

        //addQuestion()

    }

    /*private fun addQuestion(){
        val addBtn = findViewById<Button>(R.id.q)

        addBtn.setOnClickListener(){
            val newQuestion = findViewById<EditText>(R.id.newEntry)
            // the new question is first added to the mutable list then reflected in the live data object
            viewModel.checksList.add(newQuestion.text.toString())
            viewModel.checks.value = viewModel.checksList

            val checksPresenter = QuestionsController()
            checksPresenter.addQuestionToDatabase(newQuestion.text.toString())

            newEntry.setText("")
        }

    }*/


    private fun deleteQuestion(item: String){
        FirebaseDatabase.getInstance("https://shelteralertapp-default-rtdb.firebaseio.com/")
            .getReference("SafetyChecks").orderByKey().addListenerForSingleValueEvent(object:
            ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                val snapshotIterator = dataSnapshot.children
                val iterator: Iterator<DataSnapshot> = snapshotIterator.iterator()
                while (iterator.hasNext()) {
                    iterator.next().let {
                        if (it.value.toString() == item) {
                            it.key?.let { FirebaseDatabase.getInstance("https://shelteralertapp-default-rtdb.firebaseio.com/")
                                .getReference("SafetyChecks").child(it).removeValue() }
                            Snackbar.make(findViewById<Button>(R.id.q), "The check alert has been deleted", Snackbar.LENGTH_SHORT).show()
                        }
                    }
                }
            }

            override fun onCancelled(databaseError: DatabaseError) {}
        })
        viewModel.checksList.remove(item)
        viewModel.checks.value = viewModel.checksList
    }


}
