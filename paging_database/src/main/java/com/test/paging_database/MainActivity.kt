package com.test.paging_database

import android.os.Bundle
import android.view.KeyEvent
import android.view.inputmethod.EditorInfo
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.ItemTouchHelper.*
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var viewModel: CheeseViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = CheeseAdapter()
        cheeseList.adapter = adapter

        viewModel = ViewModelProvider(
            this,
            ViewModelFactory(this.application)
        ).get(CheeseViewModel::class.java)
        viewModel.allCheeses.observe(this, Observer(adapter::submitList))
        initAddButtonListener()
        initSwipeToDelete()
    }

    private fun initAddButtonListener() {
        addButton.setOnClickListener {
            addCheese()
        }
        inputText.setOnEditorActionListener { _, actionId, _ ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                addCheese()
                return@setOnEditorActionListener true
            } else {
                false
            }
        }
        inputText.setOnKeyListener { _, keyCode, action ->
            if (action.keyCode == KeyEvent.ACTION_DOWN && keyCode == KeyEvent.KEYCODE_ENTER) {
                addCheese()
                return@setOnKeyListener true
            } else {
                false
            }
        }
    }

    private fun addCheese() {
        val newCheese = inputText.text.trim()
        if (newCheese.isNotEmpty()) {
            viewModel.insert(newCheese)
            inputText.setText("")
        }
    }

    private fun initSwipeToDelete() {
        ItemTouchHelper(object : ItemTouchHelper.Callback() {
            override fun getMovementFlags(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder
            ): Int = makeMovementFlags(UP or DOWN, LEFT or RIGHT)

            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean = true

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                (viewHolder as CheeseViewHolder).cheese?.let {
                    viewModel.remove(it)
                }
            }
        }).attachToRecyclerView(cheeseList)
    }
}
