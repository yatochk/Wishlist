package com.yatochk.wishlistapp.ui.details

import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.ui.details.header.GiftHeaderItem
import com.yatochk.wishlistapp.ui.details.link.GiftLinkItem
import com.yatochk.wishlistapp.ui.details.reservation.GiftReservationItem

class GetGiftDetailsUseCase(
    private val gift: Gift?
) {

    fun getDetailsItems(): List<Any> {
        gift ?: return emptyList()
        val items = arrayListOf<Any>()
        items.addHeaderItem(gift)
        items.addLinkItem(gift)
        items.addReservationItem()
        return items
    }

    private fun ArrayList<Any>.addHeaderItem(gift: Gift) {
        if (gift.name.isNotBlank() || gift.description.isNotBlank()) {
            add(
                GiftHeaderItem(
                    name = gift.name,
                    description = gift.description
                )
            )
        }
    }

    private fun ArrayList<Any>.addLinkItem(gift: Gift) {
        if (gift.price.isNotBlank() || gift.link.isNotBlank()) {
            add(
                GiftLinkItem(
                    price = gift.price,
                    link = gift.link
                )
            )
        }
    }

    private fun ArrayList<Any>.addReservationItem() {
        add(
            GiftReservationItem(
                isReserved = false
            )
        )
    }

}