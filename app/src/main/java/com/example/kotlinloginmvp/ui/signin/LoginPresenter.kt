package com.example.kotlinloginmvp.ui.signin

import com.example.kotlinloginmvp.data.model.User
import com.example.kotlinloginmvp.data.repository.UserRepository
import com.example.kotlinloginmvp.data.source.UserDataSource

class LoginPresenter(
    val repository: UserRepository,
    val view: LoginContract.View
) : LoginContract.Presenter {

    init {
        view.presenter = this
    }

    override fun start() {

    }

    override fun login(userName: String, password: String) {
        repository.checkLogin(User(userName, password), object : UserDataSource.LoginCallback {
            override fun onLoginSuccessfully(user: User) {
                view.onLoginSuccessfully(user)
            }

            override fun onLoginFailed(error: String) {
                view.onLoginFailed(error)
            }
        })
    }
}
