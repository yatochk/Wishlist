package com.yatochk.wishlistapp.login.di

import com.yatochk.wishlistapp.login.api.navigation.LoginRouter
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

}