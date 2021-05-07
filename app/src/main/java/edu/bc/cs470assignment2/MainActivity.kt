package edu.bc.cs470assignment2

import android.media.MediaPlayer
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import edu.bc.cs470assignment2.databinding.ActivityMainBinding
import timber.log.Timber

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayer: MediaPlayer
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding =
            DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)

        mediaPlayer = MediaPlayer.create(this, R.raw.jeopardy_theme_song)
        mediaPlayer.isLooping = true
        mediaPlayer.start()

        var second = 0
        // NOTE:
        // you should not create timer in activity. the following is to demonstrate the Timer class only,
        val timer = Timer("MainActivity Timer")
        timer.startTimer {
            second++

            binding.progressCircular.progress = second.toFloat()
            Timber.i("one second.")
        }

    }

}