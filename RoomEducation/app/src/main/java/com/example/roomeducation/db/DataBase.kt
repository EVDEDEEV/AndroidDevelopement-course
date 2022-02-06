package com.example.roomeducation.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [Categories::class, Products::class],version = 1)

abstract class Database : RoomDatabase() {

    abstract val productsDAO : ProductsDAO
    abstract val categoriesDAO : CategoriesDAO


    companion object{
        @Volatile
        private var INSTANCE : com.example.roomeducation.db.Database? = null
        fun getInstance(context: Context):com.example.roomeducation.db.Database{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.example.roomeducation.db.Database::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }

    }
}