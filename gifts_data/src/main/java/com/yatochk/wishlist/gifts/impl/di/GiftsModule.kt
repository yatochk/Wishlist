package com.yatochk.wishlist.gifts.impl.di

import com.google.gson.Gson
import com.yatochk.wishlist.gifts.api.gift.data.GiftsRepository
import com.yatochk.wishlist.gifts.api.wishlists.data.WishListRepository
import com.yatochk.wishlist.gifts.impl.gifts.GiftsRepositoryImpl
import com.yatochk.wishlist.gifts.impl.wishlists.WishListRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@Module
@InstallIn(ActivityComponent::class)
internal class GiftsModule {

    @Provides
    fun provideWishlistsRepository(
        impl: WishListRepositoryImpl
    ): WishListRepository = impl

    @Provides
    fun provideGiftsRepository(
        impl: GiftsRepositoryImpl
    ): GiftsRepository = impl

    @Provides
    fun provideGson(): Gson {
        return Gson()
    }
}