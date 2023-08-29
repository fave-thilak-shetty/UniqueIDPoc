package com.example.uniqueidpoc

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.example.uniqueidpoc.databinding.ActivityMainBinding
import java.util.UUID



class MainActivity : AppCompatActivity() {

    private val model: UniqueIdViewModel by viewModels()
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Button Click", "onCreate")
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        Log.d("Button Click", "onCreate")
        val nameObserver = Observer<String> { newName ->
            // Update the UI, in this case, a TextView.
            binding.textID.text = newName
        }

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.
        model.currentID.observe(this, nameObserver)

    }

    override fun onResume() {
        super.onResume()
        Log.d("Button Click", "onResume")
        binding.btnID.setOnClickListener {
            Log.d("Button Click", "Button is clicked!")
            val id = getUniquePsuedoID()
            Log.d("Unique Pseudo ID", "$id")
            model.currentID.setValue(id.toString())
        }
    }


}