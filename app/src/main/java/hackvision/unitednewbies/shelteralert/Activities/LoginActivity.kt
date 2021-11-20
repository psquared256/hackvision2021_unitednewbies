package hackvision.unitednewbies.shelteralert.Activities

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.database.FirebaseDatabase
import hackvision.unitednewbies.shelteralert.Model.ShelterManager
import hackvision.unitednewbies.shelteralert.R

class LoginActivity : AppCompatActivity(){//}, ILoginView {

   // internal lateinit var loginPresenter: LoginController
    private lateinit var loginBtn : Button
    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText
    private lateinit var sId: TextInputEditText

    /*override fun onLoginResult(message: String, errorMsg: String?) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        if (errorMsg != null) {
            //val errorDialog = BottomSheetErrorDialog(errorMsg)
            //errorDialog.show(supportFragmentManager, "TAG")
        }
        else{
            // val intent = Intent(this, CheckInActivity::class.java)
            //startActivity(intent)
        }

    }*/


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //loginPresenter = LoginController(this)

       /* val databaseUsers = FirebaseDatabase.getInstance("https://shelteralertapp-default-rtdb.firebaseio.com/")
            .getReference("ShelterManagers")
        for (x in 1..5){
            val shelterManager = ShelterManager(x, "username"+x.toString(), "password"+x.toString())
            databaseUsers.child(x.toString()).setValue(shelterManager)
            Log.i("entry made"+x.toString(), "entry made")
        }*/

        findView()
        onClickListeners()

    }

    private fun findView(){

        loginBtn = findViewById(R.id.loginBtn)
        username = findViewById(R.id.loginUsername)
        password = findViewById(R.id.loginPassword)
        sId = findViewById(R.id.sId)



    }

    private fun onClickListeners(){

        loginBtn.setOnClickListener(){
           // loginPresenter.onLogin(username.text.toString(), password.text.toString())
          loginCheck()
        }
    }

    fun loginCheck(){
        FirebaseDatabase.getInstance("https://shelteralertapp-default-rtdb.firebaseio.com/")
            .getReference("ShelterManagers").child(sId.text.toString()).get().addOnSuccessListener {
            if (it.exists()) {
                if (it.child("password").value == password.text.toString() && it.child("username").value == username.text.toString()) {
                    //iLoginView.onLoginResult("Login Successful", null)
                    Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                    val intent = Intent(this, CheckInActivity::class.java)
                    startActivity(intent)
                } else {
                    //iLoginView.onLoginResult("Login failed","Incorrect password")
                    Toast.makeText(this, "InCorrect Credentials", Toast.LENGTH_SHORT).show()
                }

            } else {
                // iLoginView.onLoginResult("Login failed", "User doesn't exist create a new Account")
                Toast.makeText(this, "Manager does not exist, please Contact supervisors", Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun onBackPressed() {
        // to not return to the home page after the logout is performed
    }


}