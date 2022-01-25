package com.yatochk.wishlistapp.data.user

import android.content.SharedPreferences
import javax.inject.Inject

class TokenRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        private const val TOKEN_KEY = "token"
    }

    fun setToken(token: String) {
        sharedPreferences.edit()
            .putString(TOKEN_KEY, token)
            .apply()
    }

    fun getToken(): String {
        return sharedPreferences.getString(TOKEN_KEY, null).orEmpty()
    }

}