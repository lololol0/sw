package com.example.sw

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import android.widget.Button
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.list_item.*

class MainActivity : AppCompatActivity() {

    private val moviesList = mutableListOf(
        Movie("Raising Arizona", 1987, "@drawable/heighten_527_crop_2725_4096_0_0_q90_545231_29310cbb9a3b2a08bf77a2b11"),
        Movie("Vampire's Kiss", 1988, "@drawable/heighten_527_crop_2725_4096_0_0_q90_545231_29310cbb9a3b2a08bf77a2b11"),
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)

        recyclerView.apply {
            layoutManager = object : LinearLayoutManager(this@MainActivity) {
                override fun canScrollVertically(): Boolean {
                    return false
                }
            }
            adapter = ListAdapter(moviesList)
        }

        val swipeToDeleteCallback = object : SwipeToDeleteCallback() {
            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                moviesList.add(moviesList[position])
                moviesList.removeAt(position)
                recyclerView.adapter?.notifyItemRemoved(position)
            }
        }

        val itemTouchHelper = ItemTouchHelper(swipeToDeleteCallback)

        itemTouchHelper.attachToRecyclerView(recyclerView)

        // обработчик кнопок
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {



            moviesList.add(moviesList[0])
            moviesList.removeAt(0)
            motionLayout.transitionToState(R.id.end)
//            motionLayout.transitionToState(R.id.end)





            recyclerView.adapter?.notifyItemRemoved(0)
            motionLayout.progress = 0F
            motionLayout.transitionToState(R.id.start)
//            motionLayout.transitionToState(R.id.start)


        }
    }
}

