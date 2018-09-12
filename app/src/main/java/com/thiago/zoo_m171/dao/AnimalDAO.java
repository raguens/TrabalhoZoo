package com.matheus.zoo_m171.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.matheus.zoo_m171.Model.Animal;
import com.matheus.zoo_m171.Model.Categoria;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by android on 06/09/2018.
 */

public class AnimalDAO {

    public static void inserir(Context contexto, Animal animal){
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getWritableDatabase();

        ContentValues valores = new ContentValues();
        valores.put("nome", animal.getNome());
        valores.put("idade", animal.getIdade());
        valores.put("codCategoria", animal.getCategoria().getId());

        banco.insert("animais", null, valores);

    }

    public static List<Animal> getAnimais(Context contexto){
        List<Animal> listaDeAnimais = new ArrayList<>();
        Conexao conn = new Conexao(contexto);
        SQLiteDatabase banco = conn.getReadableDatabase();
        Cursor tabela = banco.rawQuery
                ("SELECT * FROM animais", null);
        if ( tabela.getCount() > 0 ){
            tabela.moveToFirst();
            do {
                Categoria cat = new Categoria();
                cat.setId( tabela.getInt(3));

                Animal animal = new Animal();
                animal.setId( tabela.getInt(0) );
                animal.setNome( tabela.getString(1) );
                animal.setIdade( tabela.getDouble(2) );
                animal.setCategoria( cat );

                listaDeAnimais.add( animal );

            }while ( tabela.moveToNext() );
        }

        return listaDeAnimais;
    }

}
