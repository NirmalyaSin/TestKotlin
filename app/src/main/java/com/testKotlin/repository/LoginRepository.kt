package com.testKotlin.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dataClass.LoginResponse
import com.testKotlin.MainActivity
import com.testKotlin.retrofit.RetrofitClient
import com.utils.CustomProgressDialog
import com.utils.Prefs
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.regex.Pattern

class LoginRepository() {
    val loginErrorMessage = MutableLiveData<String>()
    private var customProgressDialog: CustomProgressDialog? = null
    private var activity: MainActivity? = null


    fun validateCredentials(
        activity: MainActivity,
        emailID: String,
        password: String
    ): LiveData<String> {
        this.activity = activity;
        customProgressDialog = CustomProgressDialog(this.activity)
        if (isEmailValid(emailID)) {
            if (password.length < 8 && !isPasswordValid(password)) {
                loginErrorMessage.value = "Invalid Password"
            } else {
                login(emailID, password)
            }
        } else {
            loginErrorMessage.value = "Invalid Email"
        }
        return loginErrorMessage
    }

    private fun login(emailID: String, password: String) {
        customProgressDialog!!.show()
        var call: Observable<*>? = null
        call = RetrofitClient.getClient(true).login(emailID, password)
        call!!.subscribeOn(Schedulers.computation())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { trendsResponse: Any? -> onLoginSuccess(trendsResponse as LoginResponse?) }
            ) { throwable: Any? -> onLoginError() }

    }

    private fun onLoginSuccess(loginResponse: LoginResponse?) {
        customProgressDialog!!.dismiss()
        if (loginResponse!!.token != "") {
            loginErrorMessage.value = loginResponse.token!!
            Prefs.getInstance().setString("token", loginResponse.token)
        }
    }

    private fun onLoginError() {
        customProgressDialog!!.dismiss()
        loginErrorMessage.value = "Login Unsuccessful"
    }

    fun isEmailValid(email: String): Boolean {
        val expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$"
        val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }

    fun isPasswordValid(password: String): Boolean {
        /* val expression = "^(?=.*[0-9])(?=.*[A-Z])(?=.*[@#\$%^&+=!])(?=\\\\S+\$).{4,}\$";
         val pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE)
         val matcher = pattern.matcher(password)*/
        return true
    }

}