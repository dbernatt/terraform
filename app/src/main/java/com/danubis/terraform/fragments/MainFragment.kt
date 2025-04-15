package com.danubis.terraform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danubis.terraform.R
import com.google.android.material.button.MaterialButton

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val buttonOpenCamera = view.findViewById<MaterialButton>(R.id.buttonOpenCamera)

        buttonOpenCamera.setOnTouchListener { v, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    v.animate().scaleX(0.7f).scaleY(0.7f).setDuration(200).start()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(200)
                        .withEndAction {
                            v.performClick()
                        }.start()
                    true
                }
                MotionEvent.ACTION_CANCEL -> {
                    v.animate().scaleX(1f).scaleY(1f).setDuration(200).start()
                    true
                }
                else -> false
            }
        }
        buttonOpenCamera.setOnClickListener {
            // Navigate after animation ends
            findNavController().navigate(R.id.action_mainFragment_to_cameraFragment)
        }

        return view
    }
}