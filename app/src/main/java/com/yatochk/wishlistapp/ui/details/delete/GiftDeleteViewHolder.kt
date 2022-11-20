package com.yatochk.wishlistapp.ui.details.delete

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.yatochk.wishlistapp.databinding.ItemGiftDeleteBinding

class GiftDeleteViewHolder(
    private val binding: ItemGiftDeleteBinding,
    private val listener: (View) -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    fun bindItem(item: GiftDeleteItem) {
        binding.deleteButton.setOnClickListener(listener)
    }

}