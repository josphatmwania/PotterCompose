package com.josphat.pottercompose.db.converters

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.google.gson.Gson


@ProvidedTypeConverter
class Converters(private val gson: Gson) {
    @TypeConverter
    fun listToJsonString(value: List<String>? : String? = Gson().toJson(value))

    @TypeConverter
    fun jsonStringToList(value: String?) = Gson().fromJson(value, Array<String>::class.java).toList()

    @TypeConverter
    fun fromContributor(str: Wand): String {
        return Gson().toJson(str)
    }

    @TypeConverter
    fun toContributor(str: String): Wand {
        return Gson().fromJson(str, object : TypeToken<Wand>() {}.type)
    }

}