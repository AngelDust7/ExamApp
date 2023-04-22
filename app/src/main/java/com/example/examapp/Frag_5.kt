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

class Frag_5 : Fragment() {
    var player = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.i_suss,
        R.raw.in_st_petersburg_to_drink,
        R.raw.voyage,
        R.raw.cabriolet,
        R.raw.red_currant,
        R.raw.www,
        R.raw.psychotherapeutic,
        R.raw.russian,
        R.raw.h_p_h,
        R.raw.exhibit,


        )

    private val listNameMusic = listOf(
        "i_Suss",
        "В Питере - пить",
        "Вояж",
        "Кабриолет",
        "Красная смородина",
        "WWW",
        "Психотерапевтическая.mp3",
        "Русский",
        "Ч.П.Х",
        "Экспонат",


        )


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_5, container, false)
        val listView = view.findViewById<ListView>(R.id.lisv_4)
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
        fun newInstance() = Frag_5()

    }
}