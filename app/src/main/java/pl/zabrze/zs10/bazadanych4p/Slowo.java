package pl.zabrze.zs10.bazadanych4p;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "slowa")
public class Slowo {

    @ColumnInfo(name = "id")
    @PrimaryKey(autoGenerate = true)
    private int idSlowa;

    @ColumnInfo(name = "nazwa")
    private String nazwa;

    @Ignore
    public Slowo() {
    }

    public Slowo(String nazwa) {
        this.idSlowa =0;
        this.nazwa = nazwa;
    }

    public String getNazwa() {
        return nazwa;
    }

    public int getIdSlowa() {
        return idSlowa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public void setIdSlowa(int idSlowa) {
        this.idSlowa = idSlowa;
    }

    @Override
    public String toString() {
        return "Slowo{" +
                "idSlowa=" + idSlowa +
                ", nazwa='" + nazwa + '\'' +
                '}';
    }
}
