package net.kodra.myapp1;


import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FragmentB extends Fragment {

    public static final String TAG = FragmentB.class.getSimpleName();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = (Button) view.findViewById(R.id.fragment_b_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switchToFragmentA();
            }
        });
    }

    private void switchToFragmentA() {
        FragmentA fragmentA = (FragmentA) getFragmentManager().findFragmentByTag(FragmentA.TAG);
        if (fragmentA == null) {
            fragmentA = new FragmentA();
            getFragmentManager().beginTransaction()
                    .replace(R.id.activity_main_container, fragmentA, FragmentA.TAG)
                    .commit();
        }
    }

}
