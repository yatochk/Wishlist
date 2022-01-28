package com.yatochk.wishlistapp.login.impl.di

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

}