package hackvision.unitednewbies.shelteralert

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import hackvision.unitednewbies.shelteralert.Activities.LoginActivity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this displays the image in a fading animation and triggers the login screen call on ending
        val view = findViewById<ImageView>(R.id.splash_screen)
        view.alpha = 0F
        view.animate().setDuration(3000).alpha(1F).withEndAction{
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            // sets the fading transition of the animation and doesn't return from the login screen onBackPress
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
            finish()
        }

    }

}