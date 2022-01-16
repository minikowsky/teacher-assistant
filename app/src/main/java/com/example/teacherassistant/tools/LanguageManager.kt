package com.example.teacherassistant.tools

import android.content.Context
import android.content.SharedPreferences
import android.content.res.Resources
import android.os.Build
import android.preference.PreferenceManager
import java.util.*

class LanguageManager {
    companion object{
        private val SELECTED_LANGUAGE: String = "Locale.Helper.Selected.Language"
        fun updateRes(context: Context,language: String): Context{
            val locale = Locale(language)
            Locale.setDefault(locale)
            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            configuration.setLayoutDirection(locale)
            return context.createConfigurationContext(configuration)
        }
        fun updateResLegacy(context: Context, language: String): Context{
            val locale = Locale(language)
            Locale.setDefault(locale)
            val resources = context.resources
            val configuration = context.resources.configuration
            configuration.setLocale(locale)
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                configuration.setLayoutDirection(locale)
            }
            resources.updateConfiguration(configuration,resources.displayMetrics)
            return context
        }
        fun setLanguage(context: Context, language: String, input: Int): String {
            return if( Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                updateRes(context,language).getString(input)
            } else {
                updateRes(context,language).getString(input)
            }
        }
    }
}