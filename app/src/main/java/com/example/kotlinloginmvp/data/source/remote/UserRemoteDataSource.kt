package com.example.kotlinloginmvp.data.source.remote

import com.example.kotlinloginmvp.data.model.User
import com.example.kotlinloginmvp.data.source.UserDataSource
import com.example.kotlinloginmvp.data.source.UserDataSource.Remote

class UserRemoteDataSource : Remote {
    companion object {
        val USER_NAME : String = "vanh1200"
        val PASSWORD : String = "conlaumoinoi"
        val MESS_LOGIN_FAILED : String = "login failed!"
    }

    override fun checkLogin(user : User, callback: UserDataSource.LoginCallback) {
        if(user.userName == USER_NAME && user.password == PASSWORD){
            callback.onLoginSuccessfully(user)
        } else{
            callback.onLoginFailed(MESS_LOGIN_FAILED)
        }
    }
}
