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

class Frag_6 : Fragment() {
    var player = false
    var trek = 0
    private val listMusic = listOf(
        R.raw.thirty_minutes,
        R.raw.gay_boy,
        R.raw.why_me,
        R.raw.they_wont_catch_up_with_us,
        R.raw.robot,
        R.raw.im_out_of_mind,
        R.raw.im_not_your_first,
        R.raw.all_the_things_she_said,
        R.raw.all_about_us,
        R.raw.dont_believe_dont_be_afraid_dont_ask,


        )

    private val listNameMusic = listOf(
        "30 минут",
        "Мальчик - гей",
        "Зачем я",
        "Нас не догонят",
        "Робот",
        "Я сошла с ума",
        "Я твоя не первая",
        "All the things she said",
        "All about us",
        "Не верь, не бойся, не проси",


        )


    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_frag_6, container, false)
        val listView = view.findViewById<ListView>(R.id.lisv_5)
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
        fun newInstance() = Frag_6()

    }
}