package net.kodra.myapp3;

import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;

public class MainActivityPresenter {

    private final FragmentManager mFragmentManager;

    MainActivityPresenter(FragmentManager pFragmentManager) {
        mFragmentManager = pFragmentManager;
    }

    void onCreate() {
        switchToFragmentA();
    }

    private void switchToFragmentA() {
        FragmentA fragmentA = (FragmentA) mFragmentManager.findFragmentByTag(FragmentA.TAG);
        if (fragmentA == null) {
            fragmentA = new FragmentA();
            fragmentA.setFragmentCallback(new FragmentACallback());
            mFragmentManager.beginTransaction()
                    .replace(R.id.activity_main_container, fragmentA, FragmentA.TAG)
                    .commit();
        }
    }

    private void switchToFragmentB() {
        FragmentB fragmentB = (FragmentB) mFragmentManager.findFragmentByTag(FragmentB.TAG);
        if (fragmentB == null) {
            fragmentB = new FragmentB();
            fragmentB.setFragmentCallback(new FragmentBCallback());
            mFragmentManager.beginTransaction()
                    .replace(R.id.activity_main_container, fragmentB, FragmentB.TAG)
                    .commit();
        }
    }


    class FragmentACallback implements FragmentA.FragmentCallback {
        @Override
        public void onButtonClick() {
            switchToFragmentB();
        }

        @Override
        public void onNextButtonClick(Context pActivityContext) {
            Intent intent = new Intent(pActivityContext, OtherActivity.class);
            pActivityContext.startActivity(intent);
        }
    }


    class FragmentBCallback implements FragmentB.FragmentCallback {
        @Override
        public void onButtonClick() {
            switchToFragmentA();
        }

        @Override
        public void onNextButtonClick(Context pActivityContext) {
            Intent intent = new Intent(pActivityContext, OtherActivity.class);
            pActivityContext.startActivity(intent);
        }
    }

}
