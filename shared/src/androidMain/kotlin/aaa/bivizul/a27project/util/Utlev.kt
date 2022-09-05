package aaa.bivizul.a27project.util

import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import java.text.SimpleDateFormat
import java.util.*
import kotlin.contracts.contract

actual fun getLevegesmm(): String {
    val manufactured = android.os.Build.MANUFACTURER
    val model = android.os.Build.MODEL
    return "$manufactured $model"
}

actual fun getLevegessim(contextAny: Any): String {
    val context = contextAny as Context
//    val context = A27PApp.appContext
    val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    return telephonyManager.simCountryIso
}

actual fun getLevegesid(contextAny: Any): String {
//    val pref = apppref()
    val context = contextAny as Context
    val pref = context.getSharedPreferences("apppref",Context.MODE_PRIVATE)
    var spliskaid = pref.getString("spliska", "noSpliska") ?: "noSpliska"
    if (spliskaid == "noSpliska") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        spliskaid = datetime + randomNum
        pref.edit().putString("spliska", spliskaid).apply()
    }
    return spliskaid
}

actual fun getLevegesl() = Locale.getDefault().language

actual fun getLevegest(): String {
    val timeZone = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var zone = "00:00"
    if (timeZone.length > 3) {
        zone = timeZone.substring(3)
    }
    return zone
}

actual fun getLevegedia(contextAny: Any) {
    val context = contextAny as Context
//    val activity = MainActivity.activity
    AlertDialog.Builder(context).apply {
        setTitle("Error")
        setMessage("Please reboot app")
        setPositiveButton("Quit") { _, _ ->
//            activity.finish()
            System.exit(0)
        }
        setCancelable(true)
    }.create().show()
}

actual fun checkLevegenet(contextAny: Any): Boolean {
    val context = contextAny as Context
//    val context = A27PApp.appContext
    val connectivityManager =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
    val networkInfo = connectivityManager.activeNetworkInfo
    return networkInfo != null && networkInfo.isConnected
}


