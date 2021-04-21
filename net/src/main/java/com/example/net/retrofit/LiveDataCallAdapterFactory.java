package com.example.net.retrofit;

import androidx.lifecycle.LiveData;



import java.lang.annotation.Annotation;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import retrofit2.CallAdapter;
import retrofit2.Retrofit;


public class LiveDataCallAdapterFactory extends CallAdapter.Factory {

    public static LiveDataCallAdapterFactory create(){
        return new LiveDataCallAdapterFactory();
    }

    @Override
    public CallAdapter<?, ?> get(Type returnType, Annotation[] annotations, Retrofit retrofit) {
        Class<?> rawType=  getRawType(returnType);
        if (rawType != LiveData.class ){
            return null;
        }
        Type parameterUpperBound = getParameterUpperBound(0, (ParameterizedType)returnType);
        Class<?> rawObservableType = getRawType(parameterUpperBound);
        if (rawObservableType != BaseRespEntity.class){
            throw new IllegalArgumentException("parameter type is wrong...");
        }
        return new LiveDataCallAdapter<>(rawObservableType);
    }
}
