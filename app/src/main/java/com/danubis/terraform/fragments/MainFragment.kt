package com.danubis.terraform.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.danubis.terraform.R

class MainFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        val buttonOpenCamera = view.findViewById<Button>(R.id.buttonOpenCamera)

        buttonOpenCamera.setOnClickListener {
            findNavController().navigate(R.id.action_mainFragment_to_cameraFragment)
        }

        return view
    }
}