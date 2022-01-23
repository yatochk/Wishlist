package com.yatochk.wishlistapp.ui

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.yatochk.wishlistapp.data.WishListRepository
import com.yatochk.wishlistapp.databinding.ActivityMainBinding
import com.yatochk.wishlistapp.ui.gift.GiftAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var repository: WishListRepository

    private val adapter: GiftAdapter by lazy {
        GiftAdapter(layoutInflater, ::onGiftLinkClick)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.setupRecycler()
        repository.getWishList("wishlist-alexey").observe(this) {
            adapter.submitList(it)
        }
    }

    private fun onGiftLinkClick(url: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.data = Uri.parse(url)
        startActivity(intent)
    }

    private fun ActivityMainBinding.setupRecycler() {
        recyclerGifts.adapter = adapter
        recyclerGifts.layoutManager = LinearLayoutManager(this@MainActivity)
    }

}