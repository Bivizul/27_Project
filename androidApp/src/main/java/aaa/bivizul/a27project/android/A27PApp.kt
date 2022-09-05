package aaa.bivizul.a27project.android

import android.app.Application
import android.content.Context
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class A27PApp : Application() {

    override fun onCreate() {
        super.onCreate()
        A27PApp.appContext = applicationContext

        startKoin {
            androidContext(this@A27PApp)
        }
    }



    companion object {
        lateinit  var appContext: Context
    }

}