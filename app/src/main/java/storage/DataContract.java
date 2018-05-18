package storage;

import android.content.ContentUris;
import android.net.Uri;
import android.provider.BaseColumns;

/**
 * Created by OMAR on 06/04/2017.
 */
public final class DataContract implements BaseColumns {

	/*Content Provider*/
	public static final String AUTHORITY = "com.omar.bonappetit";
	public static final String DATABASE_NAME = "db";
	public static final String DATABASE_TABLE_NAME = "users";
	public static final int DATABASE_VERSION = 1;
	public static final Uri DATA_URI = Uri.parse("content://" + AUTHORITY + "/" + DATABASE_TABLE_NAME);

	/*Database Columns Name*/
	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_FAVORITE = "favorite";
	public static final String COLUMN_TS = "timestamp";


	/*Database Columns Index*/
	public static final int POSITION_ID = 0;
	public static final int POSITION_NAME = 1;
	public static final int POSITION_FAVORITE = 9;
	public static final int POSITION_TS = 10;

	// create Uri with appended string to it to match "*"
	public static Uri appendToUri(String path) {
		return DATA_URI.buildUpon().appendPath(path).build();
	}

	// create Uri with appended string to it to match "#"
	public static Uri appendToUri(long id) {
		return ContentUris.withAppendedId(DATA_URI, id);
	}

	public static String getIdFromUri(Uri uri) {
		return String.valueOf(ContentUris.parseId(uri));
	}
}

/*
https://www.google.com.eg/search?q=icon+food+png&espv=2&source=lnms&tbm=isch&sa=X&ved=0ahUKEwipxZTNj5PTAhVGvxQKHVADCFwQ_AUIBigB&biw=1536&bih=758#tbm=isch&q=food+icon+png+flat&imgrc=_
 */
