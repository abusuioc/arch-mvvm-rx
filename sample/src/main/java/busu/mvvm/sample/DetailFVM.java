package busu.mvvm.sample;

import android.app.Application;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import java.util.Random;

import busu.mvvm.fragment.FragmentViewModel;
import rx.Observable;
import rx.subjects.BehaviorSubject;
import rx.subjects.PublishSubject;

public class DetailFVM extends FragmentViewModel<DetailFragment> {

    private Random mGenerator = new Random();

    final private int[] COLORS = new int[]{Color.CYAN, Color.WHITE, Color.GREEN, Color.YELLOW, Color.MAGENTA};

    public DetailFVM(@NonNull Application application, @Nullable Bundle arguments) {
        super(application, arguments);

        //connections input->output
        requestColor.
                compose(bindToLifecycle()).
                map(__ -> mGenerator.nextInt(COLORS.length)).
                map(index -> COLORS[index]).
                subscribe(colorGenerated);

        applyColor.
                compose(bindToLifecycle()).
                subscribe(colorToApply);
    }

    //inputs
    final private PublishSubject<Void> requestColor = PublishSubject.create();

    public void inRequestColor() {
        requestColor.onNext(null);
    }

    final private PublishSubject<Integer> applyColor = PublishSubject.create();

    public void inApplyColor(int color) {
        applyColor.onNext(color);
    }

    //outputs
    final private BehaviorSubject<Integer> colorGenerated = BehaviorSubject.create();

    public Observable<Integer> outGeneratedColor() {
        return colorGenerated.asObservable();
    }

    final private BehaviorSubject<Integer> colorToApply = BehaviorSubject.create();

    public Observable<Integer> outColorToApply() {
        return colorToApply.asObservable();
    }
}
