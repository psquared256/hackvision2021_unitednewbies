package hackvision.unitednewbies.shelteralert.Activities

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

import com.google.firebase.database.*


class ListViewModel : ViewModel() {

    val checksList = mutableListOf<String>()
    val checks: MutableLiveData<List<String>> by lazy{
        MutableLiveData<List<String>>()
    }

    private var queryValueListener: ValueEventListener? = object : ValueEventListener {
        override fun onDataChange(dataSnapshot: DataSnapshot) {
            val snapshotIterator = dataSnapshot.children
            val iterator: Iterator<DataSnapshot> = snapshotIterator.iterator()
            while (iterator.hasNext()) {
                val temp = iterator.next().value.toString()
                Log.i("value of question got", temp)
                checksList.add(temp)
                checks.value = checksList
            }
        }

        override fun onCancelled(databaseError: DatabaseError) {}
    }


    init {
       // to load the previous questions
        val query: Query = FirebaseDatabase.getInstance("https://shelteralertapp-default-rtdb.firebaseio.com/")
            .getReference("SafetyChecks").orderByKey()
        queryValueListener?.let { query.addListenerForSingleValueEvent(it) }
       // Log.i("what is retrieved", q)
    }



}
