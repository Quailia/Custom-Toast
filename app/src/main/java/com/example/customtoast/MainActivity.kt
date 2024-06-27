package com.example.customtoast

import android.os.Bundle
import android.view.Gravity
import android.widget.LinearLayout
import android.view.LayoutInflater
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.customtoast.R.id.constraint_layout
import com.example.customtoast.R.id.wrapper
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val toastMessages = arrayOf("\"Each day provides its own gifts.\" —Marcus Aurelius", "\"You become what you believe.\" —Oprah Winfrey", "\"You can if you think you can.\" —George Reeves", "\"We will fail when we fail to try.\" —Rosa Parks", "\"Fall seven times, stand up eight.\" —Japanese Proverb", "\"Light tomorrow with today.\" —Elizabeth Barrett")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val buttonShowToast: Button = findViewById(R.id.btn)
        buttonShowToast.setOnClickListener {
            showCustomToast(getRandomMessage())
        }
    }

    private fun getRandomMessage(): String {
        val randomMsgIndex = Random.nextInt(toastMessages.size)
        return toastMessages[randomMsgIndex]
    }

    private fun showCustomToast(message: String) {
        val inflater: LayoutInflater = layoutInflater
        val layout: View = inflater.inflate(R.layout.custom_toast, findViewById(R.id.wrapper))

        val textView: TextView = layout.findViewById(R.id.toast)
        textView.text = message

        val toast = Toast(applicationContext)
        toast.duration = Toast.LENGTH_SHORT
        toast.view = layout
        toast.setGravity(Gravity.BOTTOM, 0, 100)
        toast.show()
    }
}