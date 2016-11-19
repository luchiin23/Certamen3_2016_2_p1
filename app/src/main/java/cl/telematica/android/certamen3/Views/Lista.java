package cl.telematica.android.certamen3.Views;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import cl.telematica.android.certamen3.Feed;
import cl.telematica.android.certamen3.Interfaces.ListaPresenter;
import cl.telematica.android.certamen3.Interfaces.ListaView;
import cl.telematica.android.certamen3.Models.DBClass;
import cl.telematica.android.certamen3.MyAsyncTaskExecutor;
import cl.telematica.android.certamen3.Presenters.ListaPresenterImpl;
import cl.telematica.android.certamen3.R;

public class Lista extends AppCompatActivity implements ListaView{

    private ListaPresenter p;
    private RecyclerView mRecyclerView;
    private DBClass myDB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.Lista);

        createMyRecyclerView(this);
        MyAsyncTaskExecutor.getInstance().executeMyAsynctask(this, mRecyclerView);

        p=new ListaPresenterImpl(this);
        myDB= new DBClass(this);
    }

    @Override
    public void createMyRecyclerView(ListaView listaView) {
        p.crear(this);
    }

    public List<Feed> getFeeds(String result) {
        p.lista(result);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            /**
             * You should manage the action to show the favorite items saved by the user
             */
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}