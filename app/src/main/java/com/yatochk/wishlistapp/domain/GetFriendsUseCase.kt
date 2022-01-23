package com.yatochk.wishlistapp.domain

import androidx.lifecycle.LiveData
import com.yatochk.wishlistapp.data.friends.Friend
import com.yatochk.wishlistapp.data.friends.FriendsListRepository
import com.yatochk.wishlistapp.data.user.UserInfoRepository
import com.yatochk.wishlistapp.utils.map
import javax.inject.Inject

class GetFriendsUseCase @Inject constructor(
    private val friendsRepository: FriendsListRepository,
    private val userInfoRepository: UserInfoRepository
) {

    fun get(): LiveData<List<Friend>> {
        return friendsRepository.getAllFriends().map { friends ->
            friends.filter { it.name != userInfoRepository.getUserInfo().name }
        }
    }

}