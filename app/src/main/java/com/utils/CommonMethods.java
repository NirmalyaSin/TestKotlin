package com.utils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.KeyguardManager;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.graphics.Point;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.provider.Settings;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.testKotlin.R;

import java.lang.reflect.Type;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Debopam on 17-10-2017.
 */

public class CommonMethods {

    public static void makeToast(Context context, String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
    }

    /*public static void makeLog(String tag, String message) {
        if (!AppConstants.isAppLive) {
            Log.e(tag, message);
        }
    }*/


   /* public static void makeSnack(Activity activity, boolean disableViewClick, String message,
                                 final OnSnackbarDismissed onSnackbarDismissed) {
        if (disableViewClick)
            clickDisable(activity.findViewById(R.id.drawer_layout));
        Snackbar.Callback callback = new Snackbar.Callback() {
            @Override
            public void onDismissed(Snackbar snackbar, int event) {
                super.onDismissed(snackbar, event);
                try {
                    onSnackbarDismissed.onDismissed();
                } catch (Exception ignored) {
                }

            }
        };
        new SneakySnacks.Builder()
                .anchorView(activity.findViewById(R.id.drawer_layout)).
                backgroundColor(ContextCompat.getColor(activity, android.R.color.black)).
                textColor(ContextCompat.getColor(activity, android.R.color.white)).
                message(message)
                .context(activity)
                .duration(Snackbar.LENGTH_SHORT)
                .callBack(callback)
                .build()
                .show();
    }*/


   /* public static void makeSnack(Activity activity, boolean disableViewClick, String message) {
        if (disableViewClick)
            clickDisable(activity.findViewById(R.id.drawer_layout));
        new SneakySnacks.Builder()
                .anchorView(activity.findViewById(R.id.drawer_layout)).
                backgroundColor(ContextCompat.getColor(activity, android.R.color.black)).
                textColor(ContextCompat.getColor(activity, android.R.color.white)).
                message(message)
                .context(activity)
                .duration(Snackbar.LENGTH_SHORT)
                .build()
                .show();
    }*/

/*
    public static ArrayList<StateResponse> convertJson(ArrayList<StateResponse> states) {
        String json = "[\n" +
                "    {\n" +
                "        \"name\": \"Alabama\",\n" +
                "        \"abbreviation\": \"AL\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Alaska\",\n" +
                "        \"abbreviation\": \"AK\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"American Samoa\",\n" +
                "        \"abbreviation\": \"AS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Arizona\",\n" +
                "        \"abbreviation\": \"AZ\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Arkansas\",\n" +
                "        \"abbreviation\": \"AR\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"California\",\n" +
                "        \"abbreviation\": \"CA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Colorado\",\n" +
                "        \"abbreviation\": \"CO\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Connecticut\",\n" +
                "        \"abbreviation\": \"CT\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Delaware\",\n" +
                "        \"abbreviation\": \"DE\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"District Of Columbia\",\n" +
                "        \"abbreviation\": \"DC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Federated States Of Micronesia\",\n" +
                "        \"abbreviation\": \"FM\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Florida\",\n" +
                "        \"abbreviation\": \"FL\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Georgia\",\n" +
                "        \"abbreviation\": \"GA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Guam\",\n" +
                "        \"abbreviation\": \"GU\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Hawaii\",\n" +
                "        \"abbreviation\": \"HI\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Idaho\",\n" +
                "        \"abbreviation\": \"ID\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Illinois\",\n" +
                "        \"abbreviation\": \"IL\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Indiana\",\n" +
                "        \"abbreviation\": \"IN\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Iowa\",\n" +
                "        \"abbreviation\": \"IA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Kansas\",\n" +
                "        \"abbreviation\": \"KS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Kentucky\",\n" +
                "        \"abbreviation\": \"KY\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Louisiana\",\n" +
                "        \"abbreviation\": \"LA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Maine\",\n" +
                "        \"abbreviation\": \"ME\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Marshall Islands\",\n" +
                "        \"abbreviation\": \"MH\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Maryland\",\n" +
                "        \"abbreviation\": \"MD\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Massachusetts\",\n" +
                "        \"abbreviation\": \"MA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Michigan\",\n" +
                "        \"abbreviation\": \"MI\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Minnesota\",\n" +
                "        \"abbreviation\": \"MN\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Mississippi\",\n" +
                "        \"abbreviation\": \"MS\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Missouri\",\n" +
                "        \"abbreviation\": \"MO\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Montana\",\n" +
                "        \"abbreviation\": \"MT\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Nebraska\",\n" +
                "        \"abbreviation\": \"NE\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Nevada\",\n" +
                "        \"abbreviation\": \"NV\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"New Hampshire\",\n" +
                "        \"abbreviation\": \"NH\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"New Jersey\",\n" +
                "        \"abbreviation\": \"NJ\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"New Mexico\",\n" +
                "        \"abbreviation\": \"NM\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"New York\",\n" +
                "        \"abbreviation\": \"NY\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"North Carolina\",\n" +
                "        \"abbreviation\": \"NC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"North Dakota\",\n" +
                "        \"abbreviation\": \"ND\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Northern Mariana Islands\",\n" +
                "        \"abbreviation\": \"MP\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Ohio\",\n" +
                "        \"abbreviation\": \"OH\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Oklahoma\",\n" +
                "        \"abbreviation\": \"OK\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Oregon\",\n" +
                "        \"abbreviation\": \"OR\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Palau\",\n" +
                "        \"abbreviation\": \"PW\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Pennsylvania\",\n" +
                "        \"abbreviation\": \"PA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Puerto Rico\",\n" +
                "        \"abbreviation\": \"PR\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Rhode Island\",\n" +
                "        \"abbreviation\": \"RI\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"South Carolina\",\n" +
                "        \"abbreviation\": \"SC\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"South Dakota\",\n" +
                "        \"abbreviation\": \"SD\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Tennessee\",\n" +
                "        \"abbreviation\": \"TN\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Texas\",\n" +
                "        \"abbreviation\": \"TX\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Utah\",\n" +
                "        \"abbreviation\": \"UT\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Vermont\",\n" +
                "        \"abbreviation\": \"VT\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Virgin Islands\",\n" +
                "        \"abbreviation\": \"VI\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Virginia\",\n" +
                "        \"abbreviation\": \"VA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Washington\",\n" +
                "        \"abbreviation\": \"WA\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"West Virginia\",\n" +
                "        \"abbreviation\": \"WV\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Wisconsin\",\n" +
                "        \"abbreviation\": \"WI\"\n" +
                "    },\n" +
                "    {\n" +
                "        \"name\": \"Wyoming\",\n" +
                "        \"abbreviation\": \"WY\"\n" +
                "    }\n" +
                "]";

        Type collectionType = new TypeToken<ArrayList<StateResponse>>() {
        }.getType();
        ArrayList<StateResponse> enums = new Gson().fromJson(json, collectionType);
        return enums;
    }
*/


    public static boolean isDeviceScreenLocked(Context context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return isDeviceLocked(context);
        } else {
            return isPatternSet(context) || isPassOrPinSet(context);
        }
    }

    /**
     * @return true if pattern set, false if not (or if an issue when checking)
     */
    public static boolean isPatternSet(Context context) {
        ContentResolver cr = context.getContentResolver();
        try {
            int lockPatternEnable = Settings.Secure.getInt(cr, Settings.Secure.LOCK_PATTERN_ENABLED);
            return lockPatternEnable == 1;
        } catch (Settings.SettingNotFoundException e) {
            return false;
        }
    }

    /**
     * @return true if pass or pin set
     */
    public static boolean isPassOrPinSet(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE); //api 16+
        return keyguardManager.isKeyguardSecure();
    }

    /**
     * @return true if pass or pin or pattern locks screen
     */
    @TargetApi(23)
    public static boolean isDeviceLocked(Context context) {
        KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService(Context.KEYGUARD_SERVICE);
        //api 23+
        return keyguardManager.isDeviceSecure();
    }


    public static void hideSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showSoftKeyboard(Context context, View view) {
        InputMethodManager imm = (InputMethodManager) context
                .getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInputFromWindow(
                view.getApplicationWindowToken(),
                InputMethodManager.SHOW_FORCED, 0);
    }

    public static void clickDisable(View view) {
        view.setClickable(false);
        view.setEnabled(false);
        if (view instanceof ViewGroup) {
            ViewGroup group = (ViewGroup) view;
            for (int idx = 0; idx < group.getChildCount(); idx++) {
                clickDisable(group.getChildAt(idx));
            }
        }
    }

    public static boolean isNetworkOnline(Activity context) {
        try {
            ConnectivityManager cm = (ConnectivityManager) context
                    .getSystemService(Context.CONNECTIVITY_SERVICE);
            NetworkInfo netInfo = cm.getActiveNetworkInfo();
            if (netInfo != null && netInfo.isConnected()) {
                return true;
            }
//            makeSnack(context, false, context.getResources().getString(R.string.noInternet));
        } catch (Exception ignored) {
        }
        return false;
    }

    public static String convertToAppTime(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(serverFormat.parse(serverTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 25);
        SimpleDateFormat appFormat = new SimpleDateFormat("MM/dd/yyyy");
        appTime = appFormat.format(c.getTime());
        return appTime;
    }

    public static String convertToAppTimeDueDate(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(serverFormat.parse(serverTime));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        c.add(Calendar.DATE, 28);
        SimpleDateFormat appFormat = new SimpleDateFormat("MMM dd, yyyy");
        appTime = appFormat.format(c.getTime());
        return appTime;
    }

    public static Boolean checkAfterThirtyDays(String serverTime) {
        SimpleDateFormat serverFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar c = Calendar.getInstance();
        try {
            c.setTime(serverFormat.parse(serverTime));
            c.add(Calendar.DATE, 30);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Calendar current = Calendar.getInstance();
        return current.getTime().after(c.getTime());
    }

    public static String getCurrentDateTime() {
        String appTime = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat appFormat = new SimpleDateFormat("MMM dd, yyyy");
        appTime = appFormat.format(c.getTime());
        return appTime;
    }

    public static String getExperianAccountAge(String start_date, String end_date) {

        int difference_In_Years = 0;
        long diffrenceInMonths = 0;

        SimpleDateFormat startFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        SimpleDateFormat endFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        try {
            Date d1 = startFormat.parse(start_date);
            Date d2 = endFormat.parse(end_date);
            long difference_In_Time = d2.getTime() - d1.getTime();

            long yearMillis = 1000L * 60 * 60 * 24 * 365;

            difference_In_Years = (int) (difference_In_Time / yearMillis);
            difference_In_Time -= (difference_In_Years * yearMillis);

            long monthMillis = 1000L * 60 * 60 * 24 * 30;
            diffrenceInMonths = (int) (difference_In_Time / monthMillis);

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return difference_In_Years + " Years, " + diffrenceInMonths + " Months";
    }

    public static String getPasDueAccount(String dueDate) {
        String appTime = "";
        Calendar c = Calendar.getInstance();
        SimpleDateFormat appFormat = new SimpleDateFormat("MM/dd/yyyy");
        Calendar cdue = Calendar.getInstance();
        try {
            cdue.setTime(appFormat.parse(dueDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        if (c.getTime().after(cdue.getTime())) {
            return "Yes";
        } else
            return "No";
    }

    /* public static void openDropDownDialog(String dropdowndialogTitle, final ArrayList<String> spinnerListArray,
                                          boolean showSearch, Activity activity, final IMEdittext textView) {
        new DropDownContact(activity, dropdowndialogTitle, spinnerListArray, showSearch, new DropDownContact.onSpinClick() {
            @Override
            public void spinClicked(int position) {
                textView.setText(spinnerListArray.get(position));
            }
        });
    }

    public static void openDropDownDialog(Context mContext, String header, ArrayList<String> model,
                                          boolean showSearch, String buttonText, DropDownContact.OnSaveAddClick onSaveAddClick) {
        new DropDownContact(mContext, header, model, showSearch, buttonText, onSaveAddClick);
    }


    public static ModelMediaUploadRequest onCaptureImageResult(Activity activity, Intent data) {
        ModelMediaUploadRequest modelMediaUploadRequest = new ModelMediaUploadRequest();
        Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
        if (thumbnail != null) {
            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            thumbnail.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            byte[] imageInByte = stream.toByteArray();
            long lengthbmp = imageInByte.length;
            long sizeInMb = lengthbmp / (1024 * 1024);
            if (sizeInMb > (AppConstants.imageSizeLimit * 1024)) {
                makeSnack(activity, false, activity.getResources().getString(R.string.imagesize_limit) + " " + AppConstants.imageSizeLimit + " MB");
                return null;
            } else {
                File destination = null;
                try {
                    destination = new File(Environment.getExternalStorageDirectory(),
                            AppConstants.tempDirectory);
                    if (!destination.exists())
                        destination.mkdirs();
                    FileOutputStream fo;
                    String filename = "" + System.currentTimeMillis();
                    String path = destination.getAbsolutePath() + "/" + filename + ".jpg";
                    fo = new FileOutputStream(path);
                    fo.write(stream.toByteArray());
                    fo.close();
                    modelMediaUploadRequest.setBitmap(thumbnail);
                    modelMediaUploadRequest.setFileName(filename + ".jpg");
                    modelMediaUploadRequest.setFilePath(path);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return modelMediaUploadRequest;
    }

    public static ModelMediaUploadRequest onGalleryImageResult(Activity activity, Intent data) {
        ModelMediaUploadRequest modelMediaUploadRequest = null;
        if (data != null) {
            Uri imgUri = data.getData();
            String actualPath = ImageFilePath.getPath(activity, imgUri);
            String extension = actualPath.substring(actualPath.lastIndexOf('.') + 1);
            if (!(extension.equalsIgnoreCase("PNG") ||
                    extension.equalsIgnoreCase("jpg") ||
                    extension.equalsIgnoreCase("jpeg") ||
                    extension.equalsIgnoreCase("bmp"))) {
                CommonMethods.makeSnack(activity, false, activity.getResources().getString(R.string.invalid_file));
                return null;
            }
            File file = new File(actualPath);
            if (file != null && file.exists()) {
                double sizeInMb = (double) file.length() / (1024 * 1024);
                if (sizeInMb > AppConstants.imageSizeLimit) {
                    makeSnack(activity, false, activity.getResources().getString(R.string.imagesize_limit) + " " + AppConstants.imageSizeLimit + " MB");
                    return null;
                }
            } else return null;
            modelMediaUploadRequest = new ModelMediaUploadRequest();
            modelMediaUploadRequest.setFileName(actualPath.substring(actualPath.lastIndexOf('/') + 1));
            modelMediaUploadRequest.setFilePath(actualPath);
        }
        return modelMediaUploadRequest;
    }

    public static ModelMediaUploadRequest getPathFromUriForGaleryVideo(Activity activity, Intent data) {
        String actualPath = ImageFilePath.getPath(activity, data.getData());
        String extension = actualPath.substring(actualPath.lastIndexOf('.') + 1);
        if (!(extension.equalsIgnoreCase("mp4") ||
                extension.equalsIgnoreCase("3gp") ||
                extension.equalsIgnoreCase("wmv") ||
                extension.equalsIgnoreCase("mpeg") ||
                extension.equalsIgnoreCase("avi"))) {
            CommonMethods.makeSnack(activity, false, activity.getResources().getString(R.string.invalid_file));
            return null;
        }
        File file = new File(actualPath);
        // getsize
        MediaMetadataRetriever retriever = new MediaMetadataRetriever();
        retriever.setDataSource(activity, Uri.fromFile(file));
        String time = retriever.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
        long timeInMillisec = Long.parseLong(time);
        if (timeInMillisec > (AppConstants.videoTimeLimit * 60 * 1000)) {
            makeSnack(activity, false, activity.getResources().getString(R.string.videotime_limit) + " " + AppConstants.videoTimeLimit + " minute");
            return null;
        }
        ModelMediaUploadRequest modelMediaUploadRequest = new ModelMediaUploadRequest();
        modelMediaUploadRequest.setFileName(actualPath.substring(actualPath.lastIndexOf('/') + 1));
        modelMediaUploadRequest.setFilePath(actualPath);
        return modelMediaUploadRequest;
    }


    public static String convertToServerTime(String appTime) throws ParseException {
        String serverTime = "";
        SimpleDateFormat appFormat = new SimpleDateFormat(AppConstants.appFormat);
        Date appDate = null;
        try {
            appDate = appFormat.parse(appTime);
        } catch (ParseException ex) {
            appFormat = new SimpleDateFormat("dd/MM/yyyy");
            appDate = appFormat.parse(appTime);
        }
        SimpleDateFormat serverFormat = new SimpleDateFormat(AppConstants.serverFormat);
        serverTime = serverFormat.format(appDate);
        return serverTime;
    }

    public static String convertToAppTime(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat(AppConstants.serverFormat);
        Date appDate = serverFormat.parse(serverTime);
        SimpleDateFormat appFormat = new SimpleDateFormat(AppConstants.appFormat);
        appTime = appFormat.format(appDate);
        return appTime;
    }

    public static String convertToEventDate(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat(AppConstants.serverFormat);
        Date appDate = serverFormat.parse(serverTime);
        SimpleDateFormat appFormat = new SimpleDateFormat("MMMM dd, yyyy");
        appTime = appFormat.format(appDate);
        return appTime;
    }

    public static String convertToEventTime(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat("HH:mm:ss");
        Date appDate = serverFormat.parse(serverTime);
        SimpleDateFormat appFormat = new SimpleDateFormat("h:mm a");
        appTime = appFormat.format(appDate);
        return appTime;
    }

    public static String convertVendorOpenTime(String openTime, String closeTime) {
        try {
            String timeSplits[] = openTime.split(Pattern.quote(":"));
            Calendar calopen = Calendar.getInstance();
            calopen.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSplits[0]));
            calopen.set(Calendar.MINUTE, Integer.parseInt(timeSplits[1]));
            calopen.set(Calendar.SECOND, 0);
            timeSplits = closeTime.split(Pattern.quote(":"));
            Calendar calclose = Calendar.getInstance();
            calclose.set(Calendar.HOUR_OF_DAY, Integer.parseInt(timeSplits[0]));
            calclose.set(Calendar.MINUTE, Integer.parseInt(timeSplits[1]));
            calclose.set(Calendar.SECOND, 0);
            if (calclose.getTime().before(calopen.getTime())) {
                calclose.add(Calendar.DAY_OF_MONTH, 1);
            }
            Calendar calNow = Calendar.getInstance();
            if (calNow.getTimeInMillis() > calopen.getTimeInMillis()
                    && calNow.getTimeInMillis() < calclose.getTimeInMillis())
                return "now";
            else {
                return openTime.substring(0, openTime.lastIndexOf(":")) + " - " +
                        closeTime.substring(0, closeTime.lastIndexOf(":"));
            }
        } catch (Exception ex) {
            return openTime + " - " + closeTime;
        }
    }

    public static Calendar calendarMinTime(String appDateString) {
        try {
            SimpleDateFormat appFormatDate = new SimpleDateFormat(AppConstants.appFormat);
            Calendar cal = Calendar.getInstance();
            Date currentDate = cal.getTime();
            String currentDateString = appFormatDate.format(currentDate);
            if (appDateString.equals(currentDateString)) {
                int oldDay = cal.get(Calendar.DAY_OF_MONTH);
                cal.add(Calendar.HOUR_OF_DAY, 2);
                int newDay = cal.get(Calendar.DAY_OF_MONTH);
                if (newDay > oldDay) {
                    // It is next day
                    return null;
                } else {
                    // It is same day
                    return cal;
                }
            }
        } catch (Exception ex) {
            return null;
        }
        return null;
    }


    public static boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }
*/
    /*public static void setUserData(Data user) {
        Prefs.getInstance().setString(Prefs.PREFS_KEY_USER, new Gson().toJson(user));
    }*/

    public static boolean isValidEmail(String email) {

        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

   /* public static void getScreenWidth(Activity activity) {
        Display display = activity.getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        AppConstants.screenWidth = size.x;
        AppConstants.screenHeight = size.y;
    }*/

    /*public static Data getUserData() {
        return new Gson().fromJson(Prefs.getInstance().getString(Prefs.PREFS_KEY_USER), Data.class);
    }*/

    public static void hideKeyboard(Activity activity) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        //Find the currently focused view, so we can grab the correct window token from it.
        View view = activity.getCurrentFocus();
        //If no view currently has focus, create a new one, just so we can grab a window token from it
        if (view == null) {
            view = new View(activity);
        }
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    public static void switchActivity(Activity activity, Activity toActivity
            , boolean isFinish) {
        activity.startActivity(new Intent(activity, toActivity.getClass()));
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        if (isFinish)
            activity.finish();
    }

    public static void switchActivity(Activity activity, Intent intent
            , boolean isFinish) {
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
        if (isFinish)
            activity.finishAffinity();
    }

    public static void switchActivity(Activity activity, Intent intent, int requestCode) {
        activity.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static void switchActivity(Activity activity, Fragment fragment, Intent intent, int requestCode) {
        fragment.startActivityForResult(intent, requestCode);
        activity.overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
    }

    public static String getLogDate() {
        String date = "";
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy' 'HH:mm:ss");
        date = sdf.format(new Date());
        return date;
    }

    public static String convertFromServerTime(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        Date appDate = serverFormat.parse(serverTime);
        SimpleDateFormat appFormat = new SimpleDateFormat("MM/dd/yyyy");
        appTime = appFormat.format(appDate);
        return appTime;
    }

    public static String convertFromServerTimedate(String serverTime) throws ParseException {
        String appTime = "";
        SimpleDateFormat serverFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS+hh:mm");
        Date appDate = serverFormat.parse(serverTime);
        SimpleDateFormat appFormat = new SimpleDateFormat("MMM dd, yyyy");
        appTime = appFormat.format(appDate);
        return appTime;
    }

    public static String decimalFormat(int number) {
        DecimalFormat formatter = new DecimalFormat("#,###,###");
        String yourFormattedString = formatter.format(number);
        return yourFormattedString;
    }
}
