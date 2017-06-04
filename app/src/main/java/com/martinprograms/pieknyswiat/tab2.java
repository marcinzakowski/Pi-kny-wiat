package com.martinprograms.pieknyswiat;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import static com.martinprograms.pieknyswiat.tab1.doublearray;


public class tab2 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(com.martinprograms.pieknyswiat.R.layout.tab2, container, false);

        ListView listView = (ListView) view.findViewById(com.martinprograms.pieknyswiat.R.id.listviewid);
        ArrayAdapter<String> listviewadapter = new ArrayAdapter<>(
                getActivity(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)
        );
        listView.setAdapter(listviewadapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(getActivity(), AnotherActivity.class); //wysypuje się apka podczas tego, chyba coś nie działa xD, pewnie nie można uruchomić nowego activity z fragmentu, naprawię to później ;)

                intent.putExtra(AnotherActivity.EXTRA_MESSAGE, getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)[position]);
                if (position == 0) {
                    intent.putExtra("LATITUDE", doublearray[0]);
                    intent.putExtra("LONGITUDE", doublearray[1]);
                } else {
                    intent.putExtra("LATITUDE", doublearray[(2 * position) - 2]);
                    intent.putExtra("LONGITUDE", doublearray[(2 * position - 1)]);
                }
                intent.putExtra("OPIS", position);
                startActivity(intent);
            }
        });

        return view;
    }

}
