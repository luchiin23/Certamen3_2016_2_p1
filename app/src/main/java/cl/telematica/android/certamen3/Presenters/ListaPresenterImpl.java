package cl.telematica.android.certamen3.Presenters;

import cl.telematica.android.certamen3.Interfaces.ListaPresenter;
import cl.telematica.android.certamen3.Interfaces.ListaView;
import cl.telematica.android.certamen3.Models.ListaModelImpl;

/**
 * Created by Luchiin on 18-11-2016.
 */

public class ListaPresenterImpl implements ListaPresenter{
    private ListaView view;
    private ListaModelImpl model;
    private String res;

    //metodos de presentador
    public ListaPresenterImpl(ListaView view){
        this.view=view;
        model=new ListaModelImpl();
    }

    public void crear(ListaView view){
        model.createMyRecView(view);
    }

    public boolean lista(String result){
        model.getFeeds(this.res);
        return Boolean.parseBoolean(res);
    }

}
