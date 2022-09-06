package aaa.bivizul.a27project.android.ui

import aaa.bivizul.a27project.navigation.LevNavGraph
import aaa.bivizul.a27project.ui.leverages.theme.A27ProjectTheme
import aaa.bivizul.a27project.util.checkLevegenet
import aaa.bivizul.a27project.util.getLevegedia
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if (checkLevegenet(this)) {
            setContent {
                A27ProjectTheme() {
                    LevNavGraph()

                }
            }
        } else {
            getLevegedia(this, this)
        }
    }
}
