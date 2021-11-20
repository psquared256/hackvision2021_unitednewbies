package hackvision.unitednewbies.shelteralert.Activities

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.widget.ArrayAdapter
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import hackvision.unitednewbies.shelteralert.R
import hackvision.unitednewbies.shelteralert.databinding.ActivityCheckinBinding

class CheckInActivity: AppCompatActivity() {

    lateinit var viewModel: CheckInActivity
    lateinit var binding : ActivityCheckinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCheckinBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val dd2 = resources.getStringArray(R.array.names)
        val arrayAdapter2 = ArrayAdapter(this, R.layout.dropdown_list_item, dd2)

        binding.names.setAdapter(arrayAdapter2)

       // supportActionBar?.title = "Questions"

        // progress bar
        val loading = LoadingDialog(this)
        loading.startLoading()
        val handler = Handler()
        handler.postDelayed({ loading.isDismiss() },2000)


        val submitBtn = findViewById<Button>(R.id.submitBtn)
        submitBtn.setOnClickListener{
            val intent = Intent(this, GuestProfileActivity::class.java)
            startActivity(intent)
        }
        // val qList = findViewById<RecyclerView>(R.id.qList)

        /*  viewModel = ViewModelProvider(this).get(CheckInViewModel::class.java)

          // setting an observer to respond to the live data
          viewModel.questions.observe(this, Observer {

              val linearLayoutManager = LinearLayoutManager(this)
              qList.layoutManager = linearLayoutManager

              val adapter = QuestionsAdapter(it){deleteQuestion(it)}
              qList.adapter = adapter
          })

          addQuestion()*/

    }

    private fun addQuestion(){
        /*val addBtn = findViewById<Button>(R.id.post_q)

        addBtn.setOnClickListener(){
            val newQuestion = findViewById<EditText>(R.id.newQuestion)
            // the new question is first added to the mutable list then reflected in the live data object
            viewModel.questionsList.add(newQuestion.text.toString())
            viewModel.questions.value = viewModel.questionsList

            val questionsPresenter = QuestionsController()
            questionsPresenter.addQuestionToDatabase(newQuestion.text.toString())

            newQuestion.setText("")
        }*/

    }

    private fun deleteQuestion(item: String){
        /* DatabaseRef.databaseQuestions.orderByKey().addListenerForSingleValueEvent(object: ValueEventListener {
             override fun onDataChange(dataSnapshot: DataSnapshot) {
                 val snapshotIterator = dataSnapshot.children
                 val iterator: Iterator<DataSnapshot> = snapshotIterator.iterator()
                 while (iterator.hasNext()) {
                     iterator.next().let {
                         if (it.value.toString() == item) {
                             it.key?.let { DatabaseRef.databaseQuestions.child(it).removeValue() }
                             Snackbar.make(findViewById<Button>(R.id.post_q), "Question has been deleted", Snackbar.LENGTH_SHORT).show()
                         }
                     }
                 }
             }

             override fun onCancelled(databaseError: DatabaseError) {}
         })
         viewModel.questionsList.remove(item)
         viewModel.questions.value = viewModel.questionsList*/
    }

}
