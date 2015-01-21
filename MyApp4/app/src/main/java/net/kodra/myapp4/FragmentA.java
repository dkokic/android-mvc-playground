package net.kodra.myapp4;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.io.Serializable;

public class FragmentA extends Fragment {

    public static final String TAG = FragmentA.class.getSimpleName();

    interface FragmentCallback {
        void onButtonClick();

        void onNextButtonClick(Context pActivityContext);
    }

    FragmentCallback mFragmentCallback;

    void setFragmentCallback(FragmentCallback pFragmentCallback) {
        mFragmentCallback = pFragmentCallback;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

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
                mFragmentCallback.onButtonClick();
            }
        });
        Button nextButton = (Button) view.findViewById(R.id.fragment_a_button_next);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mFragmentCallback.onNextButtonClick(getActivity());
            }
        });
    }

}
