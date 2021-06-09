package com.ooftf.basic.armor;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * @author ooftf
 * @email 994749769@qq.com
 * @date 9/9/2019
 */
public class ParamViewModelFactory extends ViewModelProvider.NewInstanceFactory {
    Object[] param;
    Class[] paramClass;

    /**
     * @param param
     */
    public ParamViewModelFactory(Object... param) {
        this.param = param;
    }

    /**
     * @param param
     */
    public ParamViewModelFactory(Class[] paramClass, Object[] param) {
        this.param = param;
        this.paramClass = paramClass;
    }

    @NonNull
    @Override
    public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
        try {
            return getConstructor(modelClass).newInstance(param);
        } catch (IllegalAccessException | InstantiationException | InvocationTargetException | NoSuchMethodException e) {
            throw new CreateViewModelException("ParamViewModelFactory create " + modelClass.getName() + " error", e);
        }
    }

    private <T extends ViewModel> Constructor<T> getConstructor(@NonNull Class<T> modelClass) throws NoSuchMethodException {
        if(paramClass == null){
            try {
                return modelClass.getConstructor(paramClass);
            } catch (NoSuchMethodException e) {
                return (Constructor<T>) modelClass.getConstructors()[0];
            }
        }else{
            return (Constructor<T>) modelClass.getConstructors()[0];
        }
    }

    static class CreateViewModelException extends RuntimeException {

        public CreateViewModelException(String message, Throwable cause) {
            super(message, cause);
        }
    }
}
