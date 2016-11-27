package com.micheal_yan.simplelogindemo.util;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

/**
 * 管理所有的Activity
 *
 * @author Micheal-Yan
 */
public class ActivityCollector {

    //用于存放Activity的集合
    public static List<Activity> activities = new ArrayList<>();

    /**
     * 向集合中添加Activity
     *
     * @param activity 需要添加的Activity
     */
    public static void addActivity(Activity activity) {
        activities.add(activity);
    }

    /**
     * 从集合中移除Activity
     *
     * @param activity 需要移除的Activity
     */
    public static void removeActivity(Activity activity) {
        activities.remove(activity);
    }

    /**
     * 结束所有正在运行的Activity
     */
    public static void finishAll() {
        for (Activity activity : activities) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
    }
}
