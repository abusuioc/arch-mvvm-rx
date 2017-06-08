package busu.mvvm.sample;

import android.os.Bundle;

import com.jakewharton.rxbinding.view.RxView;

import busu.mvvm.fragment.BaseMvvmFragment;
import busu.mvvm.fragment.RequiresFragmentViewModel;

@RequiresFragmentViewModel(DetailFVM.class)
public class DetailFragment extends BaseMvvmFragment<DetailFVM> {
    @Override
    protected int layoutId() {
        return R.layout.detail;
    }

    @Override
    protected void initFragment(Bundle savedInstanceState) {
        RxView.clicks(getView().findViewById(R.id.button)).subscribe(__ -> viewModel().inRequestColor());

        viewModel().outColorToApply()
                .compose(bindToLifecycle())
                .subscribe(color -> applyColorToTheButton(color));
    }

    @Override
    protected void saveInstanceState(Bundle outState) {

    }

    private void applyColorToTheButton(int color) {
        getView().findViewById(R.id.button).setBackgroundColor(color);
    }
}
