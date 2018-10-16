package com.hanzo.github.ui.widget;

import android.content.Context;
import android.support.annotation.NonNull;

import com.hanzo.github.AppData;
import com.hanzo.github.R;
import com.hanzo.github.util.PrefUtils;
import com.hanzo.github.util.StarWishesHelper;
import com.hanzo.github.util.StringUtils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * Created by ThirtyDegreesRay on 2018/2/2 14:09:39
 */

public class NewYearWishesDialog extends StarWishesDialog {

    public NewYearWishesDialog(@NonNull Context context) {
        super(context);
    }

    @Override
    protected boolean isStarWishesTipable() {
        return isAreaEnable() && isNewYearWishesTipEnable() && isDateEnable();
    }

    @Override
    protected String getContent() {
        String message = isStarred() ? getString(R.string.new_year_wishes)
                : getString(R.string.new_year_wishes_with_star);
        String user = AppData.INSTANCE.getLoggedUser().getName();
        user = StringUtils.isBlank(user) ? AppData.INSTANCE.getLoggedUser().getLogin() : user;
        message = String.format(message, user, StarWishesHelper.getInstalledDays());
        return message;
    }

    @Override
    protected boolean ignoreStarred() {
        return true;
    }

    @Override
    protected void showStarWishes() {
        super.showStarWishes();
        PrefUtils.set(PrefUtils.NEW_YEAR_WISHES_TIP_ENABLE, false);
    }

    private boolean isNewYearWishesTipEnable(){
        return PrefUtils.isnewYearWishesTipEnable();
    }

    private boolean isDateEnable(){
        try {
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);
            Date startTime = format.parse("2018-02-15 00:00:00");
            Date endTime = format.parse("2018-02-22 23:59:59");
            long curTime = System.currentTimeMillis();
            return curTime >= startTime.getTime() && curTime <= endTime.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return true;
    }

    private boolean isAreaEnable(){
        Locale defaultLocal = AppData.INSTANCE.getSystemDefaultLocal();
        return defaultLocal.getLanguage().equals("zh");
    }

}
