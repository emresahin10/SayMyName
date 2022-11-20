package com.emresahin.saymyname

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Text
import com.emresahin.saymyname.ui.theme.SayMyNameTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SayMyNameTheme {
                Text(text = "Say My Name")
            }
        }
    }
}
