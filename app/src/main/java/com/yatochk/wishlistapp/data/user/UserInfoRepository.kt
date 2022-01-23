package com.yatochk.wishlistapp.data.user

import android.content.SharedPreferences
import com.yatochk.wishlistapp.utils.WISH_LIST_PREFIX
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private val sharedPreferences: SharedPreferences
) {

    companion object {
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