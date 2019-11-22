package com.ypw.jetpackarchitecture

import android.annotation.SuppressLint
import android.content.Context
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import androidx.annotation.RequiresPermission
import androidx.core.content.ContextCompat
import java.io.BufferedReader
import java.io.FileReader
import kotlin.text.Typography.tm
import androidx.core.content.ContextCompat.getSystemService


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getDeviceInfo(this);
    }

    fun getDeviceInfo(context: Context): String? {
        if (ContextCompat.checkSelfPermission(
                this,
                "android.permission.READ_PHONE_STATE"
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            try {
                val json = org.json.JSONObject()
                val tm = context
                    .getSystemService(Context.TELEPHONY_SERVICE) as android.telephony.TelephonyManager
                var device_id = tm.deviceId
                val wifi = context.getSystemService(Context.WIFI_SERVICE) as android.net.wifi.WifiManager
                val mac = wifi.connectionInfo.macAddress
                json.put("mac", mac)
                if (TextUtils.isEmpty(device_id)) {
                    device_id = mac
                }
                if (TextUtils.isEmpty(device_id)) {
                    device_id = android.provider.Settings.Secure.getString(
                        context.contentResolver,
                        android.provider.Settings.Secure.ANDROID_ID
                    )
                }
                json.put("device_id", device_id)
                Log.e("MainActivity", json.toString() + "-------------")
                return json.toString()
            } catch (e: Exception) {
                e.printStackTrace()
                Log.e("MainActivity", "-------------" + e.message)
            }
        }
        return null
    }
}

