package com.martinprograms.pieknyswiat;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnInfoWindowClickListener;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;


public class tab1 extends Fragment implements OnMapReadyCallback {
    public static double[] doublearray = new double[54]; //30 miejsc
    GoogleMap mGoogleMap;
    MapView mMapView;
    View mView;
    int aPosition;

    public tab1() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mView = inflater.inflate(com.martinprograms.pieknyswiat.R.layout.tab1, container, false);
        return mView;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        mMapView = (MapView) mView.findViewById(com.martinprograms.pieknyswiat.R.id.map);
        if (mMapView != null) {
            mMapView.onCreate(null);
            mMapView.onResume();
            mMapView.getMapAsync(this);
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        MapsInitializer.initialize(getContext());
        mGoogleMap = googleMap;
        googleMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);


        // mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(52.231818, 21.006001)).title("Palac Kultury i Nauki")); //.snippet("test2")
        //  mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(52.248048, 21.015267)).title("Zamek Krolewski"));
        //  mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(52.250641, 21.010023)).title("Barbakan Warszawski"));

        //próba zautomatyzowania dodawania markerów na podstawie tablicy:
        //        double[] doublearray = new double[61]; //30 miejsc
        doublearray[0] = 52.250641;
        doublearray[1] = 21.010039;
        doublearray[2] = 52.248854;
        doublearray[3] = 21.013600;
        doublearray[4] = 52.241868;
        doublearray[5] = 21.028716;
        doublearray[6] = 52.253099;
        doublearray[7] = 20.971479;
        doublearray[8] = 52.228609;
        doublearray[9] = 21.008595;
        doublearray[10] = 52.240999;
        doublearray[11] = 21.011255;
        doublearray[12] = 52.242454;
        doublearray[13] = 21.016042;
        doublearray[14] = 52.247226;
        doublearray[15] = 21.013370;
        doublearray[16] = 52.246178;
        doublearray[17] = 21.014315;
        doublearray[18] = 52.254197;
        doublearray[19] = 21.011287;
        doublearray[20] = 52.249376;
        doublearray[21] = 20.993178;
        doublearray[22] = 52.232317;
        doublearray[23] = 20.981154;
        doublearray[24] = 52.242584;
        doublearray[25] = 21.024466;
        doublearray[26] = 52.231673;
        doublearray[27] = 21.005841;
        doublearray[28] = 52.243161;
        doublearray[29] = 21.016602;
        doublearray[30] = 52.215041;
        doublearray[31] = 21.035793;
        doublearray[32] = 52.165195;
        doublearray[33] = 21.090508;
        doublearray[34] = 52.213166;
        doublearray[35] = 21.027632;
        doublearray[36] = 52.248056;
        doublearray[37] = 21.013889;
        doublearray[38] = 52.214691;
        doublearray[39] = 21.028115;
        doublearray[40] = 52.249789;
        doublearray[41] = 21.012148;
        doublearray[42] = 52.249617;
        doublearray[43] = 21.011853;
        doublearray[44] = 52.239489;
        doublearray[45] = 21.045780;
        doublearray[46] = 52.247205;
        doublearray[47] = 21.012802;
        doublearray[48] = 52.258129;
        doublearray[49] = 21.021576;
        doublearray[50] = 52.247984;
        doublearray[51] = 21.015241;
        doublearray[52] = 52.219664;
        doublearray[53] = 21.030786;

        int j = 1;

        for (int i = 0; i < (2 * ((getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)).length)) - 2; i++) { //i < (getResources().getStringArray(R.array.Planets)).length, może x2 wtedy bedzie ok, bo sa 2 wspolrzedne do jednej lokalizacji


            if (i == 0) {
                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(doublearray[i], doublearray[i + 1])).title(getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)[i]));
            } else {
                mGoogleMap.addMarker(new MarkerOptions().position(new LatLng(doublearray[i + 1], doublearray[i + 2])).title(getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)[j]));
                i = i + 1;
                j = j + 1;

            }
        }

        CameraPosition pos1 = CameraPosition.builder().target(new LatLng(52.231818, 21.006001)).bearing(0).tilt(45).build();
        googleMap.moveCamera(CameraUpdateFactory.newCameraPosition(pos1));
        mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(12.0f));

        mGoogleMap.setOnInfoWindowClickListener(new OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                String tytul = marker.getTitle();
                double target1 = marker.getPosition().latitude;
                double target2 = marker.getPosition().longitude;
                for(int i = 0; i < getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets).length; i++)
                    if(getResources().getStringArray(com.martinprograms.pieknyswiat.R.array.Planets)[i].contains(tytul))
                        aPosition = i;
                Intent intent = new Intent(getActivity(), AnotherActivity.class); //wysypuje się apka podczas tego, chyba coś nie działa xD, pewnie nie można uruchomić nowego activity z fragmentu, naprawię to później ;)
                intent.putExtra(AnotherActivity.EXTRA_MESSAGE, tytul);
                intent.putExtra("OPIS", aPosition);
                intent.putExtra("LATITUDE", target1);
                intent.putExtra("LONGITUDE", target2);
                startActivity(intent);
            }
        });


    }
}