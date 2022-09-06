package aaa.bivizul.a27project.android.ui

import aaa.bivizul.a27project.navigation.LevNavGraph
import aaa.bivizul.a27project.ui.theme.A27ProjectTheme
import aaa.bivizul.a27project.ui.widget.BackImage
import aaa.bivizul.a27project.util.checkLevegenet
import aaa.bivizul.a27project.util.getLevegedia
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkLevegenet(this)) {
            setContent {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
                ) {
                    A27ProjectTheme {
                        BackImage()
                        LevNavGraph()
                    }
                }
            }
        } else {
            getLevegedia(this, this)
        }
    }
}
