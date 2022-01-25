package com.yatochk.wishlistapp.data.user

import android.content.SharedPreferences
import com.google.firebase.auth.FirebaseAuth
import com.yatochk.wishlistapp.utils.WISH_LIST_PREFIX
import javax.inject.Inject

class UserInfoRepository @Inject constructor(
    private val firebaseAuth: FirebaseAuth,
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
        val photo = firebaseAuth.currentUser?.photoUrl.toString()
        return UserInfo(
            name,
            WISH_LIST_PREFIX + name,
            photo
        )
    }

}