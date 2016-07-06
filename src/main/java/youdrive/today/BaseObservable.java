package youdrive.today;

import rx.Observable.OnSubscribe;
import rx.Subscriber;
import youdrive.today.listeners.RequestListener;
import youdrive.today.response.BaseResponse;

public class BaseObservable {

    /* renamed from: youdrive.today.BaseObservable.1 */
    static class C17321 implements OnSubscribe<BaseResponse> {
        final /* synthetic */ RequestListener val$listener;

        C17321(RequestListener requestListener) {
            this.val$listener = requestListener;
        }

        public void call(Subscriber<? super BaseResponse> subscriber) {
            subscriber.onNext(this.val$listener.onRequest());
            subscriber.onCompleted();
        }
    }

//    public static Observable<BaseResponse> ApiCall(RequestListener listener) {
//        return Observable.create(new C17321(listener)).retry(3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }

//    public static Observable<BaseResponse> ApiIntervalCall(RequestListener listener, int interval) {
//        return Observable.interval((long) interval, TimeUnit.SECONDS).map(BaseObservable$$Lambda$1.lambdaFactory$(listener)).retry(3).subscribeOn(Schedulers.newThread()).observeOn(AndroidSchedulers.mainThread());
//    }
}
