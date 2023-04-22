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


class Frag_2 : Fragment() {
    var player = false
    var trek = 0
    private val listMusic = listOf(

        R.raw.a_dead_anarchist,
        R.raw.a_stone_on_the_head,
        R.raw.forester,
        R.raw.i_will_jump_off_a_cliff,
        R.raw.the_cursed_old_house,
        R.raw.the_dance_of_the_evil_genius,
        R.raw.the_fool_and_the_lightning,
        R.raw.the_king_and_the_jester,
        R.raw.the_sorcerer_is_doll,
        R.raw.the_witchand_the_donkey,

    )

    private val listNameMusic = listOf(

        "Мертвый Анархист",
        "Камнем по голове",
        "Лесник",
        "Прыгну со скалы",
        "Проклятый старый дом",
        "Танец злобного гения",
        "Дурак и молния",
        "Ром",
        "Кукла колдуна",
        "Ведьма и осёл",

    )


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_2, container, false)
        val listView = view.findViewById<ListView>(R.id.lisv)
        val bStop = view.findViewById<Button>(R.id.button5)
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
        fun newInstance() = Frag_2()

    }
}