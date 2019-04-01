package com.example.kotlinloginmvp.data.source

import com.example.kotlinloginmvp.data.model.User

interface UserDataSource {
    interface Local

    interface Remote {
        fun checkLogin(user: User, callback: LoginCallback)
    }

    interface LoginCallback {
        fun onLoginSuccessfully(user: User)

        fun onLoginFailed(error: String)
    }
}
