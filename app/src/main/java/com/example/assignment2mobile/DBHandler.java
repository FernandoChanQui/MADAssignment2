
package com.example.assignment2mobile;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "locations.db";
    private static final String TABLE_LOCATIONS = "locations";

    // Column names
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_ADDRESS = "address";
    private static final String COLUMN_LATITUDE = "latitude";
    private static final String COLUMN_LONGITUDE = "longitude";

    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // Create locations table
        String CREATE_LOCATIONS_TABLE = "CREATE TABLE " + TABLE_LOCATIONS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + COLUMN_ADDRESS + " TEXT,"
                + COLUMN_LATITUDE + " REAL,"
                + COLUMN_LONGITUDE + " REAL" + ")";
        db.execSQL(CREATE_LOCATIONS_TABLE);

        // Insert initial data
        insertInitialLocations(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_LOCATIONS);
        onCreate(db);
    }

    // Add initial locations
    private void insertInitialLocations(SQLiteDatabase db) {

            insertLocation(db, "CN Tower", 43.642566, -79.387057);
            insertLocation(db, "Toronto Eaton Centre", 43.654438, -79.380692);
            insertLocation(db, "Royal Ontario Museum", 43.667710, -79.394777);
            insertLocation(db, "High Park", 43.653225, -79.463652);
            insertLocation(db, "Scarborough Bluffs", 43.713177, -79.237985);
            insertLocation(db, "Distillery District", 43.650313, -79.359553);
            insertLocation(db, "Casa Loma", 43.678009, -79.409438);
            insertLocation(db, "Toronto Islands", 43.6205, -79.3799);
            insertLocation(db, "Kensington Market", 43.654332, -79.400191);
            insertLocation(db, "St. Lawrence Market", 43.649097, -79.371929);
            insertLocation(db, "Queen’s Park", 43.662891, -79.395656);
            insertLocation(db, "Yonge-Dundas Square", 43.656095, -79.380213);
            insertLocation(db, "Humber Bay Park", 43.6223, -79.4829);
            insertLocation(db, "Nathan Phillips Square", 43.6525, -79.3849);
            insertLocation(db, "Riverdale Park", 43.6699, -79.3586);
            insertLocation(db, "Toronto Zoo", 43.8177, -79.1859);
            insertLocation(db, "Woodbine Beach", 43.6684, -79.3031);
            insertLocation(db, "University of Toronto", 43.6629, -79.3957);
            insertLocation(db, "Rogers Centre", 43.6414, -79.3894);
            insertLocation(db, "Ontario Science Centre", 43.7165, -79.3381);
            insertLocation(db, "Billy Bishop Airport", 43.6287, -79.3967);
            insertLocation(db, "Fort York", 43.6374, -79.4034);
            insertLocation(db, "Ripley’s Aquarium", 43.6424, -79.3863);
            insertLocation(db, "Leslieville", 43.6663, -79.3415);
            insertLocation(db, "Liberty Village", 43.6393, -79.4206);
            insertLocation(db, "Trinity Bellwoods Park", 43.6465, -79.4175);
            insertLocation(db, "Scarborough Town Centre", 43.7765, -79.2577);
            insertLocation(db, "Fairview Mall", 43.7787, -79.3446);
            insertLocation(db, "Bayview Village", 43.7695, -79.3859);
            insertLocation(db, "Yorkdale Shopping Centre", 43.7256, -79.4522);
            insertLocation(db, "Islington Village", 43.6526, -79.5326);
            insertLocation(db, "The Beaches", 43.6765, -79.2936);
            insertLocation(db, "Little Italy", 43.6545, -79.4164);
            insertLocation(db, "Greektown", 43.6796, -79.3476);
            insertLocation(db, "Bloor-Yorkville", 43.6713, -79.3885);
            insertLocation(db, "Etobicoke", 43.7001, -79.5163);
            insertLocation(db, "Markham", 43.8561, -79.3370);
            insertLocation(db, "Richmond Hill", 43.8787, -79.4403);
            insertLocation(db, "Vaughan", 43.8372, -79.5083);
            insertLocation(db, "Newmarket", 44.0568, -79.4584);
            insertLocation(db, "Brampton", 43.7315, -79.7624);
            insertLocation(db, "Mississauga", 43.5890, -79.6441);
            insertLocation(db, "Square One Shopping Centre", 43.5934, -79.6437);
            insertLocation(db, "Streetsville", 43.5891, -79.7117);
            insertLocation(db, "Port Credit", 43.5554, -79.5857);
            insertLocation(db, "Oakville", 43.4501, -79.6829);
            insertLocation(db, "Burlington", 43.3255, -79.799);
            insertLocation(db, "Milton", 43.5183, -79.8771);
            insertLocation(db, "Georgetown", 43.6466, -79.9213);
            insertLocation(db, "Aurora", 43.9955, -79.4663);
            insertLocation(db, "King City", 43.9288, -79.5239);
            insertLocation(db, "Ajax", 43.8502, -79.0204);
            insertLocation(db, "Whitby", 43.8971, -78.9420);
            insertLocation(db, "Oshawa", 43.8971, -78.8658);
            insertLocation(db, "Pickering", 43.8384, -79.0869);
            insertLocation(db, "Stouffville", 43.9701, -79.2442);
            insertLocation(db, "Uxbridge", 44.1093, -79.1206);
            insertLocation(db, "Caledon", 43.8555, -80.0254);
            insertLocation(db, "Lakeview", 43.5818, -79.5654);
            insertLocation(db, "Mimico", 43.6143, -79.4985);
            insertLocation(db, "Lambton", 43.6654, -79.4862);
            insertLocation(db, "Mount Pleasant", 43.7136, -79.3807);
            insertLocation(db, "Leslieville", 43.6667, -79.3411);
            insertLocation(db, "Chinatown", 43.6537, -79.3983);
            insertLocation(db, "Leaside", 43.7047, -79.3673);
            insertLocation(db, "Thornhill", 43.8131, -79.4227);
            insertLocation(db, "Bloor West Village", 43.6507, -79.4758);
            insertLocation(db, "Moss Park", 43.6544, -79.3703);
            insertLocation(db, "The Annex", 43.6703, -79.4042);
            insertLocation(db, "Riverdale", 43.6656, -79.3505);
            insertLocation(db, "Forest Hill", 43.6936, -79.4168);
            insertLocation(db, "Rosedale", 43.6785, -79.3761);
            insertLocation(db, "Harbourfront", 43.6408, -79.3821);
            insertLocation(db, "Lawrence Park", 43.7274, -79.4024);
            insertLocation(db, "Danforth", 43.6779, -79.3483);
            insertLocation(db, "Yorkville", 43.6714, -79.3934);
            insertLocation(db, "The Junction", 43.6651, -79.4729);
            insertLocation(db, "Birch Cliff", 43.6927, -79.2711);
            insertLocation(db, "Cliffside", 43.7112, -79.2518);
            insertLocation(db, "Guildwood", 43.7502, -79.2108);
            insertLocation(db, "Dovercourt Village", 43.6634, -79.4291);
            insertLocation(db, "Exhibition Place", 43.6338, -79.4183);
            insertLocation(db, "North York", 43.7615, -79.4111);
            insertLocation(db, "Leslie Street Spit", 43.6387, -79.3497);
            insertLocation(db, "Corso Italia", 43.6761, -79.4449);
            insertLocation(db, "Hillcrest Village", 43.7864, -79.3555);
            insertLocation(db, "Sunnybrook Park", 43.7243, -79.3635);
            insertLocation(db, "Eglinton West", 43.7008, -79.4367);
            insertLocation(db, "The Danforth", 43.6796, -79.3484);
            insertLocation(db, "Sherway Gardens", 43.6106, -79.5563);
            insertLocation(db, "Sunnybrook Health Sciences Centre", 43.7239, -79.3746);
            insertLocation(db, "York University", 43.7735, -79.5019);
            insertLocation(db, "Scarborough Town Centre", 43.7755, -79.2577);
            insertLocation(db, "Toronto Botanical Garden", 43.7348, -79.3639);
            insertLocation(db, "Toronto Premium Outlets", 43.5617, -79.8536);
            insertLocation(db, "Toronto Public Library - Reference Library", 43.6704, -79.3851);
            insertLocation(db, "The Don Valley Brick Works", 43.6848, -79.3643);
            insertLocation(db, "Nathan Phillips Square", 43.6525, -79.3840);
            insertLocation(db, "Ontario Place", 43.6293, -79.4145);
            insertLocation(db, "The Aga Khan Museum", 43.7259, -79.3320);




    }

    // Helper method to insert a single location
    private void insertLocation(SQLiteDatabase db, String address, double latitude, double longitude) {
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);
        db.insert(TABLE_LOCATIONS, null, values);
    }

    // Add a new location
    public void addLocation(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ADDRESS, address);
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);
        db.insert(TABLE_LOCATIONS, null, values);
        db.close();
    }

    // Query location by address
    public Cursor getLocationByAddress(String address) {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.query(TABLE_LOCATIONS, new String[]{COLUMN_LATITUDE, COLUMN_LONGITUDE},
                COLUMN_ADDRESS + "=?", new String[]{address},
                null, null, null);
    }

    // Update location by address
    public boolean updateLocationByAddress(String address, double latitude, double longitude) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_LATITUDE, latitude);
        values.put(COLUMN_LONGITUDE, longitude);

        int rowsAffected = db.update(TABLE_LOCATIONS, values, COLUMN_ADDRESS + "=?", new String[]{address});
        db.close();

        return rowsAffected > 0;
    }

    // Delete location by address
    public boolean deleteLocationByAddress(String address) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowsDeleted = db.delete(TABLE_LOCATIONS, COLUMN_ADDRESS + "=?", new String[]{address});
        db.close();

        return rowsDeleted > 0;
    }
}
