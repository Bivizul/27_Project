package aaa.bivizul.a27project.android.util

import aaa.bivizul.a27project.android.MainActivity
import android.content.Context
import android.content.SharedPreferences

fun apppref():SharedPreferences{
    val activity = MainActivity.activity
    val apppref = activity.getSharedPreferences("apppref",Context.MODE_PRIVATE)
    return apppref
}
