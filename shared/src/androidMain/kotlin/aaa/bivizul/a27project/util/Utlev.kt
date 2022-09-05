package aaa.bivizul.a27project.util

import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.net.ConnectivityManager
import android.telephony.TelephonyManager
import android.util.Log
import java.text.SimpleDateFormat
import java.util.*
import kotlin.contracts.contract

actual fun getLevegesmm(): String {
    val manufactured = android.os.Build.MANUFACTURER
    val model = android.os.Build.MODEL
    Log.e("qwer", "MM : $manufactured $model")
    return "$manufactured $model"
}

actual fun getLevegessim(contextAny: Any): String {
    val context = contextAny as Context
    val telephonyManager = context.getSystemService(Context.TELEPHONY_SERVICE) as TelephonyManager
    Log.e("qwer", "sim : ${telephonyManager.simCountryIso}")
    return telephonyManager.simCountryIso
}

actual fun getLevegesid(contextAny: Any): String {
//    val pref = apppref()
    val context = contextAny as Context
    val pref = context.getSharedPreferences("apppref", Context.MODE_PRIVATE)
    var levegesid = pref.getString("spliska", "noSpliska") ?: "noSpliska"
    if (levegesid == "noSpliska") {
        val dateNow = Date()
        val simpleDateFormat = SimpleDateFormat("yyMMddhhmmssMs")
        val datetime = simpleDateFormat.format(dateNow)
        val randomNum = (10000 until 100000).random()
        levegesid = datetime + randomNum
        pref.edit().putString("spliska", levegesid).apply()
    }
    Log.e("qwer", "id : $levegesid")
    return levegesid
}

actual fun getLevegesl(): String {
    Log.e("qwer", "L : ${Locale.getDefault().language}")
    return Locale.getDefault().language
}

actual fun getLevegest(): String {
    val timeZone = TimeZone.getDefault().getDisplayName(false, TimeZone.SHORT)
    var zone = "00:00"
    if (timeZone.length > 3) {
        zone = timeZone.substring(3)
    }
    Log.e("qwer", "t : $zone")
    return zone
}

actual fun getLevegedia(contextAny: Any, activityAny: Any) {
    val context = contextAny as Context
    val activity = activityAny as Activity
    AlertDialog.Builder(context).apply {
        setTitle("Error")
        setMessage("Please reboot app")
        setPositiveButton("Quit") { _, _ ->
            activity.finish()
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


