package com.yatochk.wishlistapp.ui.user.add

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import com.yatochk.wishlist.common.ui.BaseFragment
import com.yatochk.wishlist.common.utils.loadImage
import com.yatochk.wishlist.gifts.api.gift.data.Gift
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.databinding.FragmentGiftAddBinding
import com.yatochk.wishlistapp.domain.AddUserGiftUseCase
import com.yatochk.wishlistapp.ui.user.gifts.UserGiftsFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class CreateGiftFragment : BaseFragment<FragmentGiftAddBinding>() {

    companion object {
        fun newInstance() = CreateGiftFragment()
    }

    @Inject
    lateinit var addUserGiftUseCase: AddUserGiftUseCase

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGiftAddBinding {
        return FragmentGiftAddBinding.inflate(inflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            listenButton()
            listenImageUrl()
        }
    }

    private fun FragmentGiftAddBinding.listenButton() {
        createGift.setOnClickListener {
            val gift = Gift(
                name = editTextName.text.toString(),
                description = editTextDescription.text.toString(),
                link = editTextLink.text.toString(),
                imageUrl = editTextImageLink.text.toString(),
                price = editTextPrice.text.toString()
            )
            addUserGiftUseCase.add(gift)
            parentFragmentManager.beginTransaction()
                .replace(R.id.contentFragment, UserGiftsFragment())
                .commitAllowingStateLoss()
        }
    }

    private fun FragmentGiftAddBinding.listenImageUrl() {
        editTextImageLink.addTextChangedListener(afterTextChanged = {
            imageGift.loadImage(it.toString())
        })
    }

}