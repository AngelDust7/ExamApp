package com.example.examapp

import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.content.ContextCompat
import com.example.examapp.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val fragList = listOf(
        Frag_1.newInstance(),
        Frag_2.newInstance(),
        Frag_3.newInstance(),
        Frag_4.newInstance(),
        Frag_5.newInstance(),
        Frag_6.newInstance(),
    )

    private val fragText = listOf(
        "Info",
        "Король и Шут",
        "Цой",
        "Руки Вверх",
        "Ленинград",
        "Тату",
    )
    private val fragIcon = listOf(
        R.drawable.info,
        R.drawable.music,
        R.drawable.music,
        R.drawable.music,
        R.drawable.music,
        R.drawable.music,
    )

    lateinit var bind: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)

        val adapter = Viewpageraddapter(this, fragList)
        bind.vp2.adapter = adapter
        TabLayoutMediator(bind.idtabl, bind.vp2){
                tab, pos ->
            tab.text = fragText[pos]
            tab.icon = ContextCompat.getDrawable(this, fragIcon[pos])
        }.attach()
    }
}