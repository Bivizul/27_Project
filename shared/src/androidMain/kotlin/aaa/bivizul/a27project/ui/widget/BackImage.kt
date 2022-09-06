package aaa.bivizul.a27project.ui.widget

import android.graphics.drawable.Drawable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.drawable.toBitmap
import coil.ImageLoader
import coil.request.ImageRequest

@Composable
@Suppress("ACTUAL_FUNCTION_WITH_DEFAULT_ARGUMENTS")
actual inline fun BackImage(
    modifier: Modifier = Modifier,
    url: String,

)  {
    Box(modifier = modifier.fillMaxSize()){
        var image by remember { mutableStateOf<Drawable?>(null) }
        val request = ImageRequest.Builder(LocalContext.current)
            .data(url)
            .target { drawable ->
                image = drawable
            }
            .build()
        ImageLoader(LocalContext.current).enqueue(request)
    }
}
