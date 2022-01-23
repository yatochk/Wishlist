package com.yatochk.wishlistapp.data

import android.content.SharedPreferences
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
        private const val WISH_LIST_PREFIX = "wishlist-"
        private const val USER_NAME_KEY = "user_name"
    }

    fun setUserName(userName: String) {
        sharedPreferences.edit()
            .putString(USER_NAME_KEY, userName)
            .apply()
    }

    fun getUserInfo(): UserInfo {
        val name = sharedPreferences.getString(USER_NAME_KEY, null)
        return UserInfo(name, WISH_LIST_PREFIX + name)
    }

}