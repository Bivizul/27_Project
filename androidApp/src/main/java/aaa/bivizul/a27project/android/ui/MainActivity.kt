package aaa.bivizul.a27project.android.ui

import aaa.bivizul.a27project.android.ui.navigation.NavGraph
import aaa.bivizul.a27project.ui.theme.A27ProjectTheme
import aaa.bivizul.a27project.util.checkLevegenet
import aaa.bivizul.a27project.util.getLevegedia
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (checkLevegenet(this)) {
            setContent {
                A27ProjectTheme() {
                    NavGraph()
                }
            }
        } else {
            getLevegedia(this, this)
        }
    }
}
