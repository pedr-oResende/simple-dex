package br.com.simpledex.data.remote.util.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferencesWrapper(context: Context) {

    fun putString(key: String, value: String?) {
        save(key, value)
    }

    fun putInt(key: String, value: Int) {
        save(key, value)
    }

    fun putBoolean(key: String, value: Boolean) {
        save(key, value)
    }

    fun putLong(key: String, value: Long) {
        save(key, value)
    }

    fun getString(key: String?, valueDefault: String? = ""): String? {
        return sharedPreferences?.getString(key, valueDefault)
    }

    fun getBoolean(key: String?, valueDefault: Boolean = false): Boolean? {
        return sharedPreferences?.getBoolean(key, valueDefault)
    }

    fun getInt(key: String?, valueDefault: Int = 0): Int? {
        return sharedPreferences?.getInt(key, valueDefault)
    }

    fun getLong(key: String?): Long? {
        return sharedPreferences?.getLong(key, 0)
    }

    private fun save(key: String, value: String?) {
        val editor = sharedPreferences?.edit()
        editor?.putString(key, value)?.apply()
    }

    private fun save(key: String, value: Boolean) {
        val editor = sharedPreferences?.edit()
        editor?.putBoolean(key, value)?.apply()
    }

    private fun save(key: String, value: Int) {
        val editor = sharedPreferences?.edit()
        editor?.putInt(key, value)?.apply()
    }

    private fun save(key: String, value: Long) {
        val editor = sharedPreferences?.edit()
        editor?.putLong(key, value)?.apply()
    }

    fun clearPreferences() {
        sharedPreferences?.edit()?.clear()?.apply()
    }

    companion object {
        private var preferencesWrapper: PreferencesWrapper? = null
        private var sharedPreferences: SharedPreferences? = null
        fun initPreferences(context: Context) {
            if (preferencesWrapper == null) {
                preferencesWrapper = PreferencesWrapper(context.applicationContext)
            }
        }

        fun getInstance(): PreferencesWrapper? {
            checkNotNull(preferencesWrapper) {
                "Preferences Wrapper wasn't initialized. " +
                        "Call initPreferences(Context context) to initialize this."
            }
            return preferencesWrapper
        }
    }

    init {
        sharedPreferences = context.getSharedPreferences(context.packageName, Context.MODE_PRIVATE)
    }
}