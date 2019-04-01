package com.example.kotlinloginmvp.data.repository

import com.example.kotlinloginmvp.data.model.User
import com.example.kotlinloginmvp.data.source.UserDataSource
import com.example.kotlinloginmvp.data.source.local.UserLocalDataSource
import com.example.kotlinloginmvp.data.source.remote.UserRemoteDataSource

class UserRepository(
    val userLocalDataSource: UserLocalDataSource,
    val userRemoteDataSource: UserRemoteDataSource
) : UserDataSource.Local, UserDataSource.Remote {
    override fun checkLogin(user: User, callback: UserDataSource.LoginCallback) {
        userRemoteDataSource.checkLogin(user, callback)
    }
}
