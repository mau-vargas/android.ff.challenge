package com.ff.challenge.library.base.presentation.extension

import android.content.Context
import android.content.Intent
import android.net.ConnectivityManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import kotlin.reflect.KProperty1

inline fun <reified T : AppCompatActivity> Context.startActivity(
    vararg params: Pair<KProperty1<out Any?, Any?>, Any?>
) {
    val extras = params.map { it.first.name to it.second }.toTypedArray()
    val intent = Intent(this, T::class.java)
    intent.putExtras(bundleOf(*extras))
    startActivity(intent)
}

fun ConnectivityManager.isNetworkAvailable() = activeNetworkInfo?.isConnected == true