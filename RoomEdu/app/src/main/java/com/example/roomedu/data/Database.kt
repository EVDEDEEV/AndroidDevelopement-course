package com.example.roomedu.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.roomedu.models.CategoryModel
import com.example.roomedu.models.ProductModel

@Database(entities = [CategoryModel::class, ProductModel::class],version = 1)

abstract class Database : RoomDatabase() {

    abstract val productDAO : ProductDao
    abstract val categoryDAO : CategoryDao

    companion object{
        @Volatile
        private var INSTANCE : com.example.roomedu.data.Database? = null
        fun getInstance(context: Context):com.example.roomedu.data.Database{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.example.roomedu.data.Database::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }

    }
}