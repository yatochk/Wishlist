package com.yatochk.wishlistapp.login.impl.data

import android.content.SharedPreferences
import com.yatochk.wishlist.common.utils.WISH_LIST_PREFIX
import com.yatochk.wishlistapp.login.api.data.UserInfo
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import javax.inject.Inject

internal class UserInfoRepositoryImpl @Inject constructor(
    private val sharedPreferences: SharedPreferences
) : UserInfoRepository {

    companion object {
        private const val USER_NAME_KEY = "user_name"
    }

    override var userInfo: UserInfo?
        get() {
            val name = sharedPreferences.getString(USER_NAME_KEY, null)
            name ?: return null
            return UserInfo(name, WISH_LIST_PREFIX + name)
        }
        set(value) {
            sharedPreferences.edit()
                .putString(USER_NAME_KEY, value?.name)
                .apply()
        }

}