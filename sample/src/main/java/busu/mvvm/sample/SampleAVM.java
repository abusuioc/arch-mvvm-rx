package busu.mvvm.sample;

import android.app.Application;
import android.support.annotation.NonNull;

import busu.mvvm.activity.ActivityViewModel;

public class SampleAVM extends ActivityViewModel<SampleActivity> {
    public SampleAVM(@NonNull Application application) {
        super(application);
    }
}
