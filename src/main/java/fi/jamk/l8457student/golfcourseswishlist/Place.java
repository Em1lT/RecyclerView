package fi.jamk.l8457student.golfcourseswishlist;

import android.content.Context;

public class Place {
    public String name;
    public String imageName;

    public int getImageResourceId(Context context) {
        return context.getResources().getIdentifier(this.imageName, "drawable", context.getPackageName());
    }
}