package com.yatochk.wishlistapp.di

import com.google.firebase.firestore.FirebaseFirestore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
class FirebaseModule {

    @Provides
    fun bindFirestore(): FirebaseFirestore {
        return FirebaseFirestore.getInstance()
    }
}