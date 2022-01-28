package com.yatochk.wishlistapp.login.impl.domain

import com.yatochk.wishlist.common.utils.WISH_LIST_PREFIX
import com.yatochk.wishlist.gifts.api.wishlists.data.WishListRepository
import com.yatochk.wishlistapp.login.api.data.UserInfo
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository,
    private val wishListRepository: WishListRepository
) {

    fun checkLogin(): Flow<Boolean> {
        return flow {
            emit(userInfoRepository.userInfo != null)
        }
    }

    fun login(name: String): Flow<Boolean> {
        return wishListRepository.getAllWishLists().map { list ->
            val hasUser = list.any { it.userName == name }
            if (hasUser) {
                userInfoRepository.userInfo = UserInfo(name, WISH_LIST_PREFIX + name)
            }
            hasUser
        }
    }

}