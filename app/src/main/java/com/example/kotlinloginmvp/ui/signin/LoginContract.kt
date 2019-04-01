package com.example.kotlinloginmvp.ui.signin

import com.example.kotlinloginmvp.base.BasePresenter
import com.example.kotlinloginmvp.base.BaseView
import com.example.kotlinloginmvp.data.model.User

interface LoginContract {
    interface View : BaseView<Presenter> {
        fun onLoginSuccessfully(user : User)

        fun onLoginFailed(error: String)
    }

    interface Presenter : BasePresenter {
        fun login(userName: String, password: String)
    }
}
