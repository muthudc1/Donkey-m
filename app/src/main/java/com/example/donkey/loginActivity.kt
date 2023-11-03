package com.example.donkey

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.widget.Toast
import com.example.donkey.Api.AuthService
import com.example.donkey.Api.LoginRequest
import com.example.donkey.Api.LoginResponse
import com.example.donkey.Api.retrofit
import com.example.donkey.databinding.ActivityLoginBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.net.ssl.SSLSessionBindingEvent


class loginActivity : AppCompatActivity() {

    lateinit var binding : ActivityLoginBinding
    lateinit  var authService : AuthService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        authService = retrofit.create(AuthService::class.java)

        binding.signinPage.setOnClickListener {
            startActivity(Intent(this@loginActivity, signupActivity::class.java))
        }

        binding.textView6.movementMethod = LinkMovementMethod.getInstance()

        binding.button.setOnClickListener {

            var phone = binding.editTextText3.text.toString()
            var password = binding.idPassword.text.toString()

            var logReq = LoginRequest()

            logReq.phone = phone
            logReq.password = password
            logReq.devicetoken = "hguygvyygygy8"

            authService.login(logReq).enqueue(object : Callback<LoginResponse> {

                override fun onResponse(
                    call: Call<LoginResponse>,
                    response: Response<LoginResponse>
                ) {
                    if (response.isSuccessful) {

                        // Replace these lines with your actual login logic


                        val token = response.body()?.data!!.token
                        val name = response.body()?.data!!.name.toString()
                        val userId =
                            response.body()?.data!!.userId.toString() // The user ID obtained after a successful login
//                  sharedPrefsManager.saveUserId(userId)


                        Toast.makeText(
                            this@loginActivity,
                            "Login success  " + name,
                            Toast.LENGTH_SHORT
                        ).show()
                        // Handle a successful login, save the token, and navigate to the next screen
                        val intent = Intent(this@loginActivity, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        // Handle login failure

                        // Handle other status codes or generic error message
                        Toast.makeText(
                            this@loginActivity,
                            "An error occurred. Please try again.",
                            Toast.LENGTH_SHORT
                        ).show()

                    }
                }

                override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                    // Handle network or API call failure
                    Toast.makeText(this@loginActivity, "api failed", Toast.LENGTH_SHORT).show()
                }
            })
        }
        }
    }



