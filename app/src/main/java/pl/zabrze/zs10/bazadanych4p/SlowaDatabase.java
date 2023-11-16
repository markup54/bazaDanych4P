package pl.zabrze.zs10.bazadanych4p;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Slowo.class}, version = 1, exportSchema = false)
public abstract class SlowaDatabase extends RoomDatabase {
    public abstract SlowoDAO getSlowaDAO();

}
