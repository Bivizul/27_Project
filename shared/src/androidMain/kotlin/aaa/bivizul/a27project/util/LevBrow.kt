package aaa.bivizul.a27project.util

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import androidx.browser.customtabs.CustomTabsIntent

actual fun LevBrow(
    contextLevBro: Any,
    levBroS: String,
) {
    val context = contextLevBro as Context
    val package_name = "com.android.chrome"
    val activity = (context as? Activity)
    val builder = CustomTabsIntent.Builder()
        .setShowTitle(false)
        .setInstantAppsEnabled(true)
        .build()
    if (package_name != null) {
        builder.intent.setPackage(package_name)
        builder.launchUrl(context, Uri.parse(levBroS))
    } else {
        val i = Intent(Intent.ACTION_VIEW, Uri.parse(levBroS))
        activity?.startActivity(i)
    }
}
