package com.yatochk.wishlistapp.login.impl.di

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import com.yatochk.wishlistapp.login.api.data.UserInfoRepository
import com.yatochk.wishlistapp.login.api.navigation.LoginRouter
import com.yatochk.wishlistapp.login.impl.data.UserInfoRepositoryImpl
import com.yatochk.wishlistapp.login.impl.navigation.LoginRouterImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
internal class LoginModule {

    @Provides
    fun provideLoginRouter(
        impl: LoginRouterImpl
    ): LoginRouter = impl

    @Provides
    fun provideUserInfoRepository(
        impl: UserInfoRepositoryImpl
    ): UserInfoRepository = impl

    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return Firebase.auth
    }

}