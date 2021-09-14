package com.ceiba.factoryimplementation.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.ceiba.factoryimplementation.R

fun ImageView.showImage(urlFoto : String? = null ) {
    if (urlFoto.isNullOrEmpty()) { return }
    Glide
        .with(context)
        .load(urlFoto)
        .dontAnimate()
        .diskCacheStrategy(DiskCacheStrategy.NONE)
        .placeholder(R.drawable.ic_android_24dp)
        .skipMemoryCache(true)
        .centerCrop()
        .into(this)
}