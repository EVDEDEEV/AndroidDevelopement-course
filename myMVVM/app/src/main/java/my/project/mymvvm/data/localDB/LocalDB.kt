package my.project.mymvvm.data.localDB

import androidx.room.Database
import androidx.room.RoomDatabase
import my.project.mymvvm.data.models.CategoriesModel

@Database(entities = [CategoriesModel::class], version = 1)
abstract class LocalDB: RoomDatabase() {
    abstract val categoriesDao: CategoriesDao

}