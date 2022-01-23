package com.yatochk.wishlistapp.ui.gift.list

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlistapp.R
import com.yatochk.wishlistapp.data.WishListRepository
import com.yatochk.wishlistapp.databinding.FragmentGiftListBinding
import com.yatochk.wishlistapp.ui.BaseFragment
import com.yatochk.wishlistapp.ui.gift.add.AddGiftFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GiftsFragment : BaseFragment<FragmentGiftListBinding>() {

    @Inject
    lateinit var repository: WishListRepository

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
        repository.getWishList("wishlist-alexey").observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        binding?.apply {
            setupRecycler()
            buttonAddGift.setOnClickListener {
                onClickAddGift()
            }
        }
    }

    private fun onClickAddGift() {
        parentFragmentManager.beginTransaction()
            .replace(R.id.fragment, AddGiftFragment())
            .commitAllowingStateLoss()
    }

    private fun onGiftLinkClick(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun FragmentGiftListBinding.setupRecycler() {
        recyclerGifts.adapter = adapter
        recyclerGifts.layoutManager = LinearLayoutManager(context)
    }

}