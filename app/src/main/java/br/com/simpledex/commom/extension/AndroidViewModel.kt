package br.com.simpledex.commom.extension

import android.app.Application
import androidx.lifecycle.AndroidViewModel

fun AndroidViewModel.getString(res: Int): String {
    return getApplication<Application>().applicationContext.getString(res)
}
