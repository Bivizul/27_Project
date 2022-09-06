package aaa.bivizul.a27project.android

import aaa.bivizul.a27project.util.Levconst.ONESIGNAL_APP_ID
import android.app.Application
import com.onesignal.OneSignal

class A27PApp : Application() {

    override fun onCreate() {
        super.onCreate()

        OneSignal.setLogLevel(OneSignal.LOG_LEVEL.VERBOSE, OneSignal.LOG_LEVEL.NONE)
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
}