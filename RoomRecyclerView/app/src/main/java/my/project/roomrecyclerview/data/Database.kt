package my.project.roomrecyclerview.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.internal.synchronized
import my.project.roomrecyclerview.models.CategoryModel
import my.project.roomrecyclerview.models.ProductModel

@Database(entities = [CategoryModel::class, ProductModel::class], version = 1)
abstract class Database:RoomDatabase(){
    //Создаем переменные, которые наследуют интерфейсы управления БД
    abstract val productDao: ProductDao
    abstract val categoryDao: CategoryDao

    //Стандартный код для Room ?
    companion object {
        @Volatile
        private var INSTANCE: my.project.roomrecyclerview.data.Database? = null

        @OptIn(InternalCoroutinesApi::class)
        fun getInstance(context: Context): my.project.roomrecyclerview.data.Database {
            synchronized(this) {
                var instance = INSTANCE
                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        my.project.roomrecyclerview.data.Database::class.java,
                        "database").build()
                }
                return instance
            }


        }
    }
}
