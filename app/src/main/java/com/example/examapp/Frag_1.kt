package com.example.examapp

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

class Frag_1 : Fragment() {
    var player = false
    var trek = 0

//    private val listMusic = listOf(
//
//
//    )

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_frag_1, container, false)

        // Inflate the layout for this fragment


//        var sPref: SharedPreferences? = null
//        sPref = requireContext().getSharedPreferences("TABLE", Context.MODE_PRIVATE)
//        trek = sPref?.getInt("trek", 0)!!
//        val editor = sPref?.edit()
//        val view = inflater.inflate(R.layout.fragment_frag_1, container, false)
//        val bmusic = view.findViewById<Button>(R.id.batonmusic)
//        val textTrack = view.findViewById<TextView>(R.id.countTrack_TW)
//        textTrack.text = "Играет трек номер ${trek}"


//        var mediaPlayer = MediaPlayer.create(context, listMusic[trek])

//        bmusic.setOnClickListener{
//            if (!player) {
//                mediaPlayer.start()
//                player = true
//
//                textTrack.text = "Играет трек номер ${trek}"
//                editor?.putInt("trek", trek)
//                editor?.apply()
//
//                trek += 1
//                if (trek > 1) trek = 0
//            } else {
//                mediaPlayer.stop()
//                player = false
//                mediaPlayer = MediaPlayer.create(context, listMusic[trek])
//            }
//        }
        return view
    }

    companion object {

        @JvmStatic
        fun newInstance() = Frag_1()

    }
}