package com.yatochk.wishlistapp.login.impl.domain

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.yatochk.wishlist.common.utils.WISH_LIST_PREFIX
import com.yatochk.wishlist.gifts.api.wishlists.data.WishListRepository
import com.yatochk.wishlistapp.login.api.data.UserInfo
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.*
import javax.inject.Inject

class LoginUseCase @Inject constructor(
    private val userInfoRepository: UserInfoRepository,
    private val wishListRepository: WishListRepository,
    private val firebaseAuth: FirebaseAuth
) {

    fun checkLogin(): Flow<Boolean> {
        return flow {
            val loggedIn = userInfoRepository.userInfo != null && firebaseAuth.currentUser != null
            emit(loggedIn)
        }
    }

    fun login(name: String, email: String, password: String): Flow<Boolean> {
        return callbackFlow {
            var subscription: Task<AuthResult>? =
                firebaseAuth.signInWithEmailAndPassword(email, password)
                    .addOnCompleteListener {
                        trySend(it.isSuccessful)
                    }
                    .addOnCanceledListener {
                        trySend(false)
                    }
            awaitClose { subscription = null }
        }.flatMapConcat {
            wishListRepository.getAllWishLists().map { list ->
                val hasUser = list.any { it.userName == name }
                if (hasUser) {
                    userInfoRepository.userInfo = UserInfo(name, WISH_LIST_PREFIX + name)
                }
                hasUser && it
            }
        }
    }
}