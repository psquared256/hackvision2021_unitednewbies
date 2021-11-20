package hackvision.unitednewbies.shelteralert.Activities



class LoginController (){

}
/*
class LoginController(private var iLoginView: ILoginView) : ILoginController {
    override fun onLogin(username: String, password: String) {
        val login = ShelterManager(id, username, password)

        // to check if the input is valid from the model login class
        if (login.isDataValid) {
            loginCheck(username, password)
        }
        else{
            iLoginView.onLoginResult("Login failed", login.errorMsg)
        }
    }

    // to match the credentials entered by the user for a signin
    private fun loginCheck(username: String, password: String){

        DatabaseRef.databaseUsers.child(username).get().addOnSuccessListener {
            if (it.exists()) {
                if (it.child("password").value == password) {
                    PrimaryKey.currentUser = username
                    iLoginView.onLoginResult("Login Successful", null)

                } else {
                    iLoginView.onLoginResult("Login failed","Incorrect password")
                }

            } else {
                iLoginView.onLoginResult("Login failed", "User doesn't exist create a new Account")
            }
        }

    }

}*/