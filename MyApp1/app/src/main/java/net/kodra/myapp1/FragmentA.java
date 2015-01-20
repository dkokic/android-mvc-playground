package net.kodra.myapp1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentA extends Fragment {

    public static final String TAG = FragmentA.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = (Button) view.findViewById(R.id.fragment_a_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToFragmentB();
            }
        });
    }

    private void switchToFragmentB() {
        FragmentB fragmentB = (FragmentB) getFragmentManager().findFragmentByTag(FragmentB.TAG);
        if (fragmentB == null) {
            fragmentB = new FragmentB();
            getFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_container, fragmentB, FragmentB.TAG)
                    .commit();
        }
    }

}
