package com.example.kotlinloginmvp.ui.signin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.example.kotlinloginmvp.R
import com.example.kotlinloginmvp.R.id
import com.example.kotlinloginmvp.data.model.User
import com.example.kotlinloginmvp.data.repository.UserRepository
import com.example.kotlinloginmvp.data.source.local.UserLocalDataSource
import com.example.kotlinloginmvp.data.source.remote.UserRemoteDataSource
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity(), View.OnClickListener, LoginContract.View {

    override lateinit var presenter: LoginContract.Presenter

    override fun onLoginSuccessfully(user: User) {
        Toast.makeText(this, user.userName, Toast.LENGTH_SHORT).show()
    }

    override fun onLoginFailed(error: String) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show()
    }


    override fun onClick(v: View?) {
        when (v?.id) {
            id.buttonLogin -> handleLogin()
        }
    }

    private fun handleLogin() {
        presenter.login(editUserName.text.toString(), editPassword.text.toString())
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        presenter = LoginPresenter(UserRepository(UserLocalDataSource(), UserRemoteDataSource()), this)
        initViews()
    }

    private fun initViews() {
        buttonLogin.setOnClickListener(this)
    }
}
