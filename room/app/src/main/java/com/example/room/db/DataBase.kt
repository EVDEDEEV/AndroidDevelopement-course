package com.example.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.room.db.Categories
import com.example.room.db.CategoriesDAO
import com.example.room.db.Products
import com.example.room.db.ProductsDAO

@Database(entities = [Categories::class, Products::class],version = 1)

abstract class Database : RoomDatabase() {

    abstract val productsDAO : ProductsDAO
    abstract val categoriesDAO : CategoriesDAO


    companion object{
        @Volatile
        private var INSTANCE : com.example.room.Database? = null
        fun getInstance(context: Context):com.example.room.Database{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        com.example.room.Database::class.java,
                        "database"
                    ).build()
                }
                return instance
            }
        }

    }
}
