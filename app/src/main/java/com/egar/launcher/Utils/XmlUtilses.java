package com.egar.launcher.Utils;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.XmlResourceParser;

import com.egar.launcher.Bean.WitheApp;

import java.util.ArrayList;

/**
 * Created by ybf on 2019/4/12.
 */
public class XmlUtilses {
    public static String TAG = "XmlUtilses";

    public static ArrayList<WitheApp> getXmlList(Context mContext, int xmlid) throws Exception {
        Resources res = mContext.getResources();
        XmlResourceParser xmlResourceParser = res.getXml(xmlid);
        ArrayList<WitheApp> list = null;
        if (xmlResourceParser == null) return null;
        WitheApp app = null;
        int root = xmlResourceParser.getEventType();
        while (root != XmlResourceParser.END_DOCUMENT) {
            switch (root) {
                case XmlResourceParser.START_DOCUMENT:
                    list = new ArrayList<WitheApp>();
                    break;
                case XmlResourceParser.START_TAG:
                    if ("AppInfo".equals(xmlResourceParser.getName())) {
                        app = new WitheApp();

                    } else if ("ActivityName".equals(xmlResourceParser.getName())) {
                        String name = xmlResourceParser.nextText();
                        app.setActivityName(name);
                    } else if ("Drawable".equals(xmlResourceParser.getName())) {
                        String Drawablename = xmlResourceParser.nextText();
                        app.setDrawable(Drawablename);
                    } else if ("Title".equals(xmlResourceParser.getName())) {
                        String Title = xmlResourceParser.nextText();
                        app.setTitle(Title);
                    } else if ("Type".equals(xmlResourceParser.getName())) {
                        int type = new Integer(xmlResourceParser.nextText());
                        app.setType(type);
                    }
                    break;
                case XmlResourceParser.END_TAG:
                    if ("AppInfo".equals(xmlResourceParser.getName())) {
                        list.add(app);
                        app = null;
                    }
                    break;
            }
            root = xmlResourceParser.next();
        }
        LogUtil.i(TAG, "list size =" + list.size());
        return list;
    }
}
