package pl.zabrze.zs10.bazadanych4p;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface SlowoDAO {

    @Insert
    public void dodajSlowo(Slowo slowo);

    @Delete
    public void usunSlowo(Slowo slowo);

    @Query("Delete from slowa")
    public void usunWszystko();

    @Update
    public void aktualizujSlowo(Slowo slowo);

    @Query("select * from slowa")
    public List<Slowo> zwrocWszystkieSlowa();

    @Query("select * from slowa where id= :idPrzekazane")
    public Slowo zwrocSlowoOId(int idPrzekazane);

}
