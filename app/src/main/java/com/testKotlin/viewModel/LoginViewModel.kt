package com.testKotlin.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.testKotlin.view.LoginActivity
import com.testKotlin.repository.LoginRepository

open class LoginViewModel : ViewModel() {
    private var activity: LoginActivity? = null

    private var loginRepository: LoginRepository

    init {
        loginRepository = LoginRepository()
    }

    fun loginValidate(activity: LoginActivity, email: String, password: String): LiveData<String> {
        this.activity = activity
        return loginRepository.validateCredentials(this.activity!!,email, password)
    }
}