package com.testKotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testKotlin.MainActivity
import com.testKotlin.repository.LoginRepository

open class LoginViewModel : ViewModel() {
    private var activity: MainActivity? = null

    private var loginRepository: LoginRepository

    init {
        loginRepository = LoginRepository()
    }

    fun loginValidate(activity: MainActivity, email: String, password: String): LiveData<String> {
        this.activity = activity;
        return loginRepository.validateCredentials(this.activity!!,email, password)
    }
}