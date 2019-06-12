package com.example.sellme;

        import android.os.Bundle;
        import android.support.annotation.NonNull;
        import android.support.annotation.Nullable;
        import android.support.v4.app.Fragment;
        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.ListView;

        import java.util.ArrayList;

public class FragmentTwo extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_two,container,false);
        ArrayList<Cars> cars = new ArrayList<Cars>();
        cars.add(new Cars(R.drawable.car,"item two"));
        cars.add(new Cars(R.drawable.car,"item two"));
        cars.add(new Cars(R.drawable.car,"item three"));
        cars.add(new Cars(R.drawable.car,"item four"));
        cars.add(new Cars(R.drawable.car,"item five"));
        cars.add(new Cars(R.drawable.car,"item Seven"));
        cars.add(new Cars(R.drawable.car,"item eight"));
        cars.add(new Cars(R.drawable.car,"item nine"));
        cars.add(new Cars(R.drawable.car,"item ten"));


        ListView listView = (ListView)view.findViewById(R.id.listid2);
        CarAdapter adapter = new CarAdapter(getActivity(),cars);
        listView.setAdapter(adapter);
        return view ;
    }
}
