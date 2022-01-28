package com.yatochk.wishlistapp.ui.user.gifts

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlist.common.utils.lifecycleLaunch
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.databinding.FragmentGiftListBinding
import com.yatochk.wishlistapp.domain.GetUserWishListUseCase
import com.yatochk.wishlistapp.domain.RemoveUserGiftUseCase
import com.yatochk.wishlistapp.ui.base.GiftsFragment
import com.yatochk.wishlistapp.ui.user.add.CreateGiftFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class UserGiftsFragment : GiftsFragment<FragmentGiftListBinding>() {

    companion object {
        fun newInstance() = UserGiftsFragment()
    }

    @Inject
    lateinit var getUserWishListUseCase: GetUserWishListUseCase

    @Inject
    lateinit var removeUserGiftUseCase: RemoveUserGiftUseCase

    private val adapter: GiftAdapter by lazy {
        GiftAdapter(layoutInflater, ::onGiftLinkClick)
    }

    override fun getViewBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentGiftListBinding {
        return FragmentGiftListBinding.inflate(layoutInflater, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding?.apply {
            setupRecycler()
            buttonAddGift.setOnClickListener {
                onClickAddGift()
            }
        }
        lifecycleLaunch {
            getUserWishListUseCase.get().collect {
                adapter.submitList(it)
            }
        }
    }

    private fun onClickAddGift() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.contentFragment, CreateGiftFragment.newInstance())
            .commitAllowingStateLoss()
    }

    private fun FragmentGiftListBinding.setupRecycler() {
        recyclerGifts.adapter = adapter
        recyclerGifts.layoutManager = LinearLayoutManager(context)
    }

}