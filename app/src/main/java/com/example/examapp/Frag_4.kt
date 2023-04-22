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

class Frag_4 : Fragment() {
    var player = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.i_am_eighteen_already,
        R.raw.alyosha,
        R.raw.my_baby,
        R.raw.he_is_kissing_you,
        R.raw.last_kiss,
        R.raw.student,
        R.raw.someone_else_is_lips,
        R.raw.i_will_not_give_you_to_anyone,
        R.raw.ataman,
        R.raw.ten_years,


        )

    private val listNameMusic = listOf(
        "18 мне уже",
        "Алеша",
        "Моя крошка",
        "Он тебя целует",
        "Последний поцелуй",
        "Студент",
        "Чужие губы",
        "Никому тебя не отдам",
        "Атаман",
        "10 лет",


        )


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_4, container, false)
        val listView = view.findViewById<ListView>(R.id.lisv_3)
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
        fun newInstance() = Frag_4()

    }
}