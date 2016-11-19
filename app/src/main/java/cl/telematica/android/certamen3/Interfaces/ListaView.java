package cl.telematica.android.certamen3.Interfaces;

import java.util.List;

import cl.telematica.android.certamen3.Feed;

/**
 * Created by Luchiin on 18-11-2016.
 */

public interface ListaView {
    void createMyRecyclerView(ListaView listaView);

    List<Feed> getFeeds(String result);
}
