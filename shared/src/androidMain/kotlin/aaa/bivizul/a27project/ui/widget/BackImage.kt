package aaa.bivizul.a27project.ui.widget

import aaa.bivizul.a27project.util.Levconst.BACK_H
import aaa.bivizul.a27project.util.Levconst.BACK_V
import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import coil.compose.AsyncImage

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun BackImage(
    modifier: Modifier = Modifier,
) {

    val orientation = LocalConfiguration.current.orientation
    val imageBack = when (orientation) {
        Configuration.ORIENTATION_PORTRAIT -> BACK_V
        else -> BACK_H
    }
    AsyncImage(
        model = imageBack,
        contentDescription = null,
        modifier = modifier.fillMaxSize(),
        contentScale = ContentScale.Crop
    )
}
