package hackvision.unitednewbies.shelteralert.Activities

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText
import hackvision.unitednewbies.shelteralert.R

class LoginActivity : AppCompatActivity(){//}, ILoginView {

   // internal lateinit var loginPresenter: LoginController
    private lateinit var loginBtn : Button
    private lateinit var username: TextInputEditText
    private lateinit var password: TextInputEditText

    /*override fun onLoginResult(message: String, errorMsg: String?) {

        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        if (errorMsg != null) {
            //val errorDialog = BottomSheetErrorDialog(errorMsg)
            //errorDialog.show(supportFragmentManager, "TAG")
        }
        else{
            // val intent = Intent(this, HomeActivity::class.java)
            //startActivity(intent)
        }

    }*/


    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        //loginPresenter = LoginController(this)

        findView()
        onClickListeners()

    }

    private fun findView(){

        loginBtn = findViewById(R.id.loginBtn)
        username = findViewById(R.id.loginUsername)
        password = findViewById(R.id.loginPassword)
    }

    private fun onClickListeners(){

        loginBtn.setOnClickListener(){
           // loginPresenter.onLogin(username.text.toString(), password.text.toString())
            val intent = Intent(this, CheckInActivity::class.java)
             startActivity(intent)
        }
    }

    override fun onBackPressed() {
        // to not return to the home page after the logout is performed
    }


}