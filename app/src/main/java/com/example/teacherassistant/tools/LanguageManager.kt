package com.example.teacherassistant.tools

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Build
import android.preference.PreferenceManager
import java.util.*

class LanguageManager {
    companion object{
        private fun updateRes(context: Context, language: String): Context{
            val locale = Locale(language)
            Locale.setDefault(locale)
            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
            return context.createConfigurationContext(configuration)
        }
        fun setLanguage(context: Context, language: String, input: Int): String {
            return updateRes(context,language).getString(input)
        }
    }
}