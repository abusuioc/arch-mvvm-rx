package busu.mvvm.sample;

import android.os.Bundle;
import android.support.annotation.Nullable;

import busu.mvvm.activity.BaseMvvmActivity;
import busu.mvvm.activity.RequiresActivityViewModel;

@RequiresActivityViewModel(SampleAVM.class)
public class SampleActivity extends BaseMvvmActivity<SampleAVM> {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        final DetailFragment fragment1 = new DetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frg1, fragment1, null)
                .commitNow();

        final DetailFragment fragment2 = new DetailFragment();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.frg2, fragment2, null)
                .commitNow();

        doTheWiring(fragment1, fragment2);
    }

    /**
     * Output from one fragment generated color goes as an input to the other's fragment apply color to its button.
     * The activity controls the wiring.
     *
     * @param frg1
     * @param frg2
     */
    private void doTheWiring(DetailFragment frg1, DetailFragment frg2) {
        frg1.viewModel()
                .outGeneratedColor()
                .compose(bindToLifecycle())
                .subscribe(color -> frg2.viewModel()
                        .inApplyColor(color));
        frg2.viewModel()
                .outGeneratedColor()
                .compose(bindToLifecycle())
                .subscribe(color -> frg1.viewModel()
                        .inApplyColor(color));
    }
}
