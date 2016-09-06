package br.com.fiap.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import br.com.fiap.model.Livro;

/**
 * Created by RM30222 on 05/09/2016.
 */
public class LivrosDao {

    private final String TABELA_LIVROS = "livros";
    private final String[] COLUMNS = {"id", "titulo", "autor"};

    private MySQLiteHelper dbHelper;

    public LivrosDao(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void add(Livro livro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues valores = new ContentValues();



        valores.put(COLUMNS[1], livro.getTitulo());
        valores.put(COLUMNS[2], livro.getAutor());

        db.insert(TABELA_LIVROS, null, valores);

        db.close();
    }

    public Livro get(int id) {

        Livro livro = new Livro();

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(
                TABELA_LIVROS, // nome da tabela
                COLUMNS, // colunas
                "id = ?", // select
                new String[]{String.valueOf(id)}, // argumentos do select
                null, // group by
                null, // having
                null, // order by
                null // limit
        );

        if(cursor != null) {
            cursor.moveToFirst();
            livro.setId(cursor.getInt(0));
            livro.setTitulo(cursor.getString(1));
            livro.setAutor(cursor.getString(2));
        }

        return livro;
    }

    public List<Livro> getAll() {
        List<Livro> livros = new ArrayList<>();

        SQLiteDatabase db = dbHelper.getReadableDatabase();

        String query = "SELECT * FROM " + TABELA_LIVROS;
        Cursor cursor = db.rawQuery(query, null);


        if(cursor.moveToFirst()) {
            do {
                Livro livro = new Livro();
                livro.setId(cursor.getInt(cursor.getColumnIndex(COLUMNS[0])));
                livro.setTitulo(cursor.getString(cursor.getColumnIndex(COLUMNS[1])));
                livro.setAutor(cursor.getString(cursor.getColumnIndex(COLUMNS[2])));
                livros.add(livro);
            } while (cursor.moveToNext());

        }
        return livros;
    }

    public void update(Livro livro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put(COLUMNS[2], livro.getAutor());
        valores.put(COLUMNS[1], livro.getTitulo());

        db.update(TABELA_LIVROS,
                valores,
                COLUMNS[0] + " = ? ",
                new String[]{String.valueOf(livro.getId())}
        );
        db.close();
    }

    public void delete(Livro livro) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete(
                TABELA_LIVROS,
                COLUMNS[0] + " = ?",
                new String[] {String.valueOf(livro.getId())}
                );
        db.close();
    }
}
