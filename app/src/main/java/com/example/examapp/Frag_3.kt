package com.example.examapp

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast

class Frag_3 : Fragment() {
    var player = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.we_will_continue_to_act,
        R.raw.a_star_named_the_sun,
        R.raw.the_stars_will_stay_here,
        R.raw.red_and_yellow_days,
        R.raw.night,
        R.raw.sad,
        R.raw.the_last_hero,
        R.raw.pine_trees_on_the_seashore,
        R.raw.dance,
        R.raw.movies,


        )

    private val listNameMusic = listOf(
        "Дальше действовать будем мы",
        "Звезда по имени Солнце",
        "Звёзды останутся здесь",
        "Красно-жёлтые дни",
        "Ночь",
        "Печаль",
        "Последний герой",
        "Сосны на морском берегу",
        "Танец",
        "Фильмы",


        )


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_3, container, false)
        val listView = view.findViewById<ListView>(R.id.lisv_2)
        val bStop = view.findViewById<Button>(R.id.button)
        val bContinue = view.findViewById<Button>(R.id.ContinueBth)



        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, listNameMusic)
        listView.adapter = adapter
        var mediaPlayer = MediaPlayer()
        bStop.setOnClickListener {
            if (player == false) {
                mediaPlayer.pause()
                player = true
            }
            else {
                bContinue.setOnClickListener {
                    mediaPlayer.start()
                    player = false
                }
            }
        }



        listView.setOnItemClickListener { adapterView, viewl, i, l ->
            mediaPlayer.stop()
            mediaPlayer = MediaPlayer.create(context, listMusic[i])
            mediaPlayer.start()
            Toast.makeText(requireContext(), "выбран ${listNameMusic[i]}", Toast.LENGTH_LONG).show()
        }


        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Frag_3()

    }
}