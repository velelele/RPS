package com.example.alculation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = listOf<Button>(
            findViewById(Choise.ROCK.resourceId),
            findViewById(Choise.SCISSORS.resourceId),
            findViewById(Choise.PAPER.resourceId)
        )
        buttons.forEach { button ->
            button.setOnClickListener(this)
        }
    }

    override fun onClick(view: View?) {
        val button = view as? Button
        button ?: return
        val choise: Choise? = Choise.values().find { it.resourceId == button.id }
        val intent = Intent(this, SecondActivity::class.java).apply {
            val bundle = Bundle().apply {
                choise ?: return
                putInt(Choise::class.java.simpleName, choise.ordinal)
            }
            putExtras(bundle)
        }
        startActivity(intent)
    }
}