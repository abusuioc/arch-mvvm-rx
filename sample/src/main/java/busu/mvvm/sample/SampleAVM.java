package busu.mvvm.sample;

import android.app.Application;
import android.support.annotation.NonNull;

import busu.mvvm.activity.ActivityViewModel;

/**
 * Created by adrianbusuioc on 6/7/17.
 */

public class SampleAVM extends ActivityViewModel<SampleActivity> {
    public SampleAVM(@NonNull Application application) {
        super(application);
    }
}
