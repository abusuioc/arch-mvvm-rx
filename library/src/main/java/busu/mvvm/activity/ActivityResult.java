package busu.mvvm.activity;

import android.content.Intent;
import android.support.annotation.Nullable;

import com.google.auto.value.AutoValue;

/**
 * Created by adrianbusuioc on 3/9/17.
 */

@AutoValue
public abstract class ActivityResult {
    public abstract int requestCode();

    public abstract int resultCode();

    public abstract
    @Nullable
    Intent intent();

    public static ActivityResult create(int requestCode, int resultCode, @Nullable Intent data) {
        return new AutoValue_ActivityResult(requestCode, resultCode, data);
    }
}
