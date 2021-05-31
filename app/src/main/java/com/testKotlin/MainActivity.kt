package com.testKotlin

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.testKotlin.databinding.ActivityMainBinding
import com.testKotlin.viewModel.LoginViewModel

class MainActivity : BaseActivity() {

    var binding: ActivityMainBinding? = null
   lateinit var loginViewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        showTopbar(this, "Login", false)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)
        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setClick()
    }

    private fun setClick() {
        binding!!.etEmail.setText("eve.holt@reqres.in")
        binding!!.etPassword.setText("cityslicka")
        binding?.btLogin?.setOnClickListener {
            loginViewModel?.loginValidate(this,
                binding!!.etEmail.text.toString(),
                binding!!.etPassword.text.toString()
            )!!.observe(this, {
                Toast.makeText(this, it, Toast.LENGTH_LONG).show()
            })
        }
    }

    /* fun main() = runBlocking { // this: CoroutineScope
         launch(Dispatchers.IO) { doWorld() }
         println("Hello")


     }*/

    // this is your first suspending function
    /* suspend fun doWorld() {
         delay(1000L)
         println("World!")
     }*/


    // Concurrently executes both sections
    /* suspend fun doWorld() = coroutineScope { // this: CoroutineScope
         launch(Dispatchers.IO) {
             delay(2000L)
             println("World 2")
         }
         launch() {
             delay(1000L)
             println("World 1")
         }

         launch(Dispatchers.Main) {

         }
         println("Hello")

        *//* val data = async(Dispatchers.IO) { // <- extension on current scope
               }
             withContext(Dispatchers.Main) {
                    doSomeWork()
                    val result = data.await()
                    display(result)
                }*//*
    }*/
}